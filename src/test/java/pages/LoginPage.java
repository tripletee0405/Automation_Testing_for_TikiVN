package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    // navigate to login popup
    @FindBy(xpath = "//div[@data-view-id ='header_header_account_container']")
    private WebElement loginDiv;
    @FindBy(xpath = "//button[text() ='Đăng nhập']")
    private WebElement navigateToLoginPopup;
    // popup
    @FindBy(xpath = "//div[text() = 'Đăng nhập']")
    private WebElement loginTab;
    @FindBy(xpath = "//div[text() = 'Tạo tài khoản']")
    private WebElement registerTab;
    @FindBy(xpath = "//div[@class='UserModalstyle__Root-tngk37-0 lmVrvP']")
    private WebElement divPopup;
    // check input/label login tab
    @FindBy(xpath = "//input[@id='email']")
    private WebElement inputEmailTabLogin;
    @FindBy(xpath = "//label[@for='email']")
    private WebElement labelEmail;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPasswordTabLogin;
    @FindBy(xpath = "//label[@for='password']")
    private WebElement labelPassword;
    //check buttons login tab
    @FindBy(xpath = "//div[@style='padding-left: 75px;']/button[text()='Đăng nhập']")
    private WebElement loginBtn;
    @FindBy(xpath = "//div[@style='padding-left: 75px;']/button[text()='Đăng nhập bằng Facebook']")
    private WebElement loginFBBtn;
    @FindBy(xpath = "//div[@style='padding-left: 75px;']/button[text()='Đăng nhập bằng Google']")
    private WebElement loginGGBtn;
    @FindBy(xpath = "//div[@style='padding-left: 75px;']/button[text()='Đăng nhập bằng Zalo']")
    private WebElement loginZaloBtn;
    // check Close dialog
    @FindBy(xpath = "//button[text()='bỏ qua']")
    private WebElement closeDialogBtn;

    @FindBy(xpath = "//span[contains(text(),'Nguyen Dinh Tai')]")
    private WebElement wellcomeUser;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // display Popup
    public void displayPopup(String urlTiki) {
        driver.get(urlTiki);
        driver.manage().window().maximize();
        getAction().moveToElement(loginDiv).perform();
        navigateToLoginPopup.click();
        closeAlert(closeDialogBtn);
    }

    // check display Popup
    public boolean displayBoxLogin() {
        try {
            getWait().until(ExpectedConditions.visibilityOf(divPopup));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    // verify input/label
    public boolean verifyTextBoxAndLBL(String label, String placeHolder, WebElement elementLabel, WebElement input) {
        if (elementLabel.getText().equals(label) && input.isDisplayed()) {
            return input.getAttribute("placeholder").equals(placeHolder);
        }
        return false;
    }

    // login
    public void login(String urlTiki, String email, String password) {
        displayPopup(urlTiki);
        if (displayBoxLogin()) {
            inputEmailTabLogin.sendKeys(email);
            inputPasswordTabLogin.sendKeys(password);
            loginBtn.click();
            getWait().until(ExpectedConditions.visibilityOf(wellcomeUser));
        }
    }


    public WebElement getLoginBtn() {
        return loginBtn;
    }

    public WebElement getLoginFBBtn() {
        return loginFBBtn;
    }

    public WebElement getLoginGGBtn() {
        return loginGGBtn;
    }

    public WebElement getLoginZaloBtn() {
        return loginZaloBtn;
    }

    public WebElement getInputEmailTabLogin() {
        return inputEmailTabLogin;
    }

    public WebElement getLabelEmail() {
        return labelEmail;
    }

    public WebElement getInputPasswordTabLogin() {
        return inputPasswordTabLogin;
    }

    public WebElement getLabelPassword() {
        return labelPassword;
    }
}
