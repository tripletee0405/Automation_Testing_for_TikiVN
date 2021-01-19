package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage {
    @FindBy(xpath = "//div[text()='Tạo tài khoản']")
    private WebElement createrButton;
    @FindBy(xpath = "//h2[text()='Tạo tài khoản']")
    private WebElement titleCreate;
    // fullname
    @FindBy(xpath = "//label[text()='Họ tên']")
    private WebElement lblName;
    @FindBy(id = "full_name")
    private WebElement fullnameTextbox;
    //phone
    @FindBy(xpath = "//label[text()='SĐT']")
    private WebElement lblPhone;
    @FindBy(id = "phone_number")
    private WebElement phoneTextbox;
    //code otp
    @FindBy(xpath = "//div[text()='Gửi mã xác thực']")
    private WebElement sendCodebtn;
    @FindBy(xpath = "//label[text()='Mã xác thực']")
    private WebElement lblCode;
    @FindBy(id = "otp_code")
    private WebElement otpCodeTB;
    //email
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(xpath = "//label[@for='email']")
    private WebElement emaillbl;
    //password
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(xpath = "//label[@for='password']")
    private WebElement passwordlbl;
    //gender  Giới tính
    @FindBy(xpath = "//label[text()='Giới tính']")
    private WebElement lblGender;
    @FindBy(xpath = "//label[text()='Nam']")
    private WebElement radioMale;
    @FindBy(xpath = "//label[text()='Nữ']")
    private WebElement radioFemale;
    //birthday
    @FindBy(xpath = "//label[@for='birthday']")
    private WebElement birthdayLbl;
    @FindBy(xpath = "//div[text()='Ngày']")
    private WebElement dayBirth;
    @FindBy(xpath = "//div[text()='Tháng']")
    private WebElement monthBirth;
    @FindBy(xpath = "//div[text()='Năm']")
    private WebElement yearBirth;
    //button
    @FindBy(xpath = "(//button[text()='Tạo tài khoản'])[2]")
    private WebElement buttonRegister;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void moveToRegister() {
        createrButton.click();
        getWait().until(ExpectedConditions.visibilityOf(titleCreate));
    }

    public boolean checkGender() {
        return lblGender.isDisplayed() && radioFemale.isDisplayed() && radioMale.isDisplayed();
    }

    public boolean checkBirthday() {
        return birthdayLbl.isDisplayed() && dayBirth.isDisplayed() && monthBirth.isDisplayed() && yearBirth.isDisplayed();
    }

    public WebElement getCreaterButton() {
        return createrButton;
    }

    public WebElement getLblName() {
        return lblName;
    }

    public WebElement getFullnameTextbox() {
        return fullnameTextbox;
    }

    public WebElement getLblPhone() {
        return lblPhone;
    }

    public WebElement getPhoneTextbox() {
        return phoneTextbox;
    }

    public WebElement getSendCodebtn() {
        return sendCodebtn;
    }

    public WebElement getLblCode() {
        return lblCode;
    }

    public WebElement getOtpCodeTB() {
        return otpCodeTB;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getPasswordlbl() {
        return passwordlbl;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getEmaillbl() {
        return emaillbl;
    }
}
