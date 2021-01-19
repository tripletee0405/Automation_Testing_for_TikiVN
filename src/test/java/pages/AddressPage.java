package pages;

import core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddressPage extends BasePage {

    @FindBy(xpath = "//span[text()='Bạn muốn giao hàng tới đâu?']")
    private WebElement quesBtn;

    @FindBy(xpath = "//p[text()='Địa chỉ giao hàng']")
    private WebElement titlePopup;

    @FindBy(xpath = "//input[@id='react-select-2-input']")
    private WebElement cityBtn;
    @FindBy(xpath = "//p[text()='Tỉnh/Thành phố']")
    private WebElement cityLabel;
    @FindBy(xpath = "(//div[@class='css-dvua67-singleValue'])[1]")
    private WebElement cityInputText;
    @FindBy(xpath = "//div[text()='Vui lòng chọn tỉnh/thành phố']")
    private WebElement cityDefaultValue;

    @FindBy(xpath = "//input[@id='react-select-3-input']")
    private WebElement districtBtn;
    @FindBy(xpath = "//p[text()='Quận/Huyện']")
    private WebElement districtLabel;
    @FindBy(xpath = "(//div[@class='css-dvua67-singleValue'])[2]")
    private WebElement districtInputText;
    @FindBy(xpath = "//div[text()='Vui lòng chọn quận/huyện']")
    private WebElement districtDefaultValue;

    @FindBy(xpath = "//input[@id='react-select-4-input']")
    private WebElement wardBtn;
    @FindBy(xpath = "//p[text()='Phường/Xã']")
    private WebElement wardLabel;
    @FindBy(xpath = "(//div[@class='css-dvua67-singleValue'])[3]")
    private WebElement wardInputText;
    @FindBy(xpath = "//div[text()='Vui lòng chọn phường/xã']")
    private WebElement wardDefaultValue;


    @FindBy(xpath = "//button[text()='GIAO ĐẾN ĐỊA CHỈ NÀY']")
    private WebElement submitBtn;

    @FindBy(xpath = "//span[text()='Phường Bách Khoa, Quận Hai Bà Trưng, Hà Nội']")
    private WebElement infoAddress;

    @FindBy(xpath = "//button[text()='bỏ qua']")
    private WebElement closeDialogBtn;

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getButtonSubmit() {
        return submitBtn;
    }

    public void submit() {
        submitBtn.click();
    }

    public void displayShippingAddressPopup(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        quesBtn.click();
        getWait().until(ExpectedConditions.visibilityOf(titlePopup));
        closeAlert(closeDialogBtn);
    }

    public boolean displayInput(WebElement lbl, WebElement combobox) {
        return lbl.isDisplayed() && combobox.isDisplayed();
    }

    public boolean checkCity(String cityValue) throws InterruptedException {
        getWait().until(ExpectedConditions.visibilityOf(cityBtn));
        cityBtn.sendKeys(cityValue);
        Thread.sleep(3000);
        cityBtn.sendKeys(Keys.ENTER);
        getWait().until(ExpectedConditions.visibilityOf(cityInputText));
        if (cityInputText.getText().equalsIgnoreCase(cityValue)) {
            if (districtBtn.isEnabled() && !wardBtn.isEnabled()) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDistrict(String districtValue) throws InterruptedException {
        getWait().until(ExpectedConditions.visibilityOf(districtBtn));
        districtBtn.sendKeys(districtValue);
        Thread.sleep(3000);
        districtBtn.sendKeys(Keys.ENTER);
        getWait().until(ExpectedConditions.visibilityOf(districtInputText));
        if (districtInputText.getText().equalsIgnoreCase(districtValue)) {
            if (districtBtn.isEnabled()) {
                return true;
            }
        }
        return false;
    }

    public boolean checkWard(String wardValue) throws InterruptedException {
        getWait().until(ExpectedConditions.visibilityOf(wardBtn));
        wardBtn.sendKeys(wardValue);
        Thread.sleep(3000);
        wardBtn.sendKeys(Keys.ENTER);
        getWait().until(ExpectedConditions.visibilityOf(wardInputText));
        if (wardInputText.isDisplayed()) {
            return true;
        }
        return false;
    }

    public boolean checkNavigate(String url) {
        getWait().until(ExpectedConditions.urlContains(url));
        getWait().until(ExpectedConditions.visibilityOf(infoAddress));
        return infoAddress.isDisplayed();
    }

    public WebElement getCityLabel() {
        return cityLabel;
    }

    public WebElement getCityDefaultValue() {
        return cityDefaultValue;
    }

    public WebElement getDistrictLabel() {
        return districtLabel;
    }

    public WebElement getDistrictChekLBL() {
        return districtDefaultValue;
    }

    public WebElement getWardLabel() {
        return wardLabel;
    }

    public WebElement getCommuneChekLBL() {
        return wardDefaultValue;
    }
}
