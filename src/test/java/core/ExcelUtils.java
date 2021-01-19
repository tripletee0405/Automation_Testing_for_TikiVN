package core;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelUtils {
    private static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;

    private static XSSFRow Row;

    public static Object[][] getTableArray(String FilePath, String SheetName, int startCol, int totalCols) throws Exception {

        String[][] tabArray = null;

        try {
            FileInputStream ExcelFile = new FileInputStream(FilePath);
            // Access the required test data sheet
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(SheetName);
            int startRow = 1;
            int ci, cj;
            int totalRows = ExcelWSheet.getLastRowNum();
            tabArray = new String[totalRows][totalCols];
            ci = 0;
            for (int i = startRow; i <= totalRows; i++, ci++) {
                cj = 0;
                for (int j = startCol; j < totalCols + startCol; j++, cj++) {
                    tabArray[ci][cj] = getCellData(i, j);
                    Cell = ExcelWSheet.getRow(i).getCell(j);
                    System.out.println("p:" + tabArray[ci][cj]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }
        return (tabArray);

    }

    public static String getCellData(int RowNum, int ColNum) throws Exception {
        try {
            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            String CellData = Cell.getStringCellValue();
            return CellData;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw (e);
        }
    }

    public static void writeExcel(int cellNum, int rowNum, String excelFilePath, String result) throws IOException {

        FileInputStream fileBefore = new FileInputStream(new File(excelFilePath));
        ExcelWBook = new XSSFWorkbook(fileBefore);
        ExcelWSheet = ExcelWBook.getSheetAt(0);

        org.apache.poi.ss.usermodel.Row row = ExcelWSheet.getRow(rowNum);
        org.apache.poi.ss.usermodel.Cell cell = row.getCell(cellNum);
        cell.setCellValue(result);
        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
            ExcelWBook.write(outputStream);
        }
    }
}
