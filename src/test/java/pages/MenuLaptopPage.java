package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MenuLaptopPage extends BasePage {

    @FindBy(xpath = "//span[text()='Laptop - Thiết bị IT']")
    private WebElement menuLaptop;
    @FindBy(xpath = "//h4[text()='Danh Mục Sản Phẩm']")
    private WebElement catProduct;
    @FindBy(xpath = "//h4[text()='Đánh giá']")
    private WebElement commentProduct;
    @FindBy(xpath = "//h4[text()='Thương hiệu']")
    private WebElement tradeMark;
    @FindBy(xpath = "//h4[text()='Nhà cung cấp']")
    private WebElement supplier;

    public MenuLaptopPage(WebDriver driver) {
        super(driver);
    }

    public void moveToLaptop() {
        menuLaptop.click();
        getWait().until(ExpectedConditions.visibilityOf(catProduct));
        getWait().until(ExpectedConditions.visibilityOf(commentProduct));
        getWait().until(ExpectedConditions.visibilityOf(tradeMark));
        getWait().until(ExpectedConditions.visibilityOf(supplier));
    }

    public WebElement getCatProduct() {
        return catProduct;
    }

    public WebElement getCommentProduct() {
        return commentProduct;
    }

    public WebElement getTradeMark() {
        return tradeMark;
    }

    public WebElement getSupplier() {
        return supplier;
    }
}
