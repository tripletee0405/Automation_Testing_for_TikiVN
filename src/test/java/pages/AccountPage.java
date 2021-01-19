package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends BasePage {

    @FindBy(xpath = "//div[@data-view-id ='header_header_account_container']")
    private WebElement loginDiv;
    @FindBy(xpath = "//p[text()='Đơn hàng của tôi']")
    private WebElement myOrderBtn;
    @FindBy(xpath = "//p[text()='Thông báo của tôi']")
    private WebElement myNotificationBtn;
    @FindBy(xpath = "//p[text()='Tài khoản của tôi']")
    private WebElement myAccountBtn;
    @FindBy(xpath = "//p[text()='Nhận xét sản phẩm đã mua']")
    private WebElement myCommentBtn;
    @FindBy(xpath = "//p[@title='Thông tin TikiNOW']")
    private WebElement tikiNowBtn;
    @FindBy(xpath = "//p[@title='Mã giảm giá']")
    private WebElement couponBtn;
    @FindBy(xpath = "//p[@title='Thông tin Tiki Xu']")
    private WebElement tikiCoinBtn;
    @FindBy(xpath = "//p[@title='Thông tin BookCare']")
    private WebElement bookCareBtn;
    @FindBy(xpath = "//label[text()='Họ tên']")
    private WebElement fullNameLabel;
    @FindBy(xpath = "//label[text()='Số điện thoại']")
    private WebElement telLabel;
    @FindBy(xpath = "//label[text()='Email']")
    private WebElement emailLabel;
    @FindBy(xpath = "//label[text()='Giới tính']")
    private WebElement genderLabel;
    @FindBy(xpath = "//label[text()='Ngày sinh']")
    private WebElement dobLabel;
    @FindBy(xpath = "//div[@class='social-item']//strong[text()='Zalo']")
    private WebElement zaloLabel;
    @FindBy(xpath = "//div[@class='social-item']//strong[text()='Facebook']")
    private WebElement FBLabel;
    @FindBy(xpath = "//div[@class='social-item']//strong[text()='Google']")
    private WebElement GGLabel;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void openDropdown() {
        getAction().moveToElement(loginDiv).perform();
        getWait().until(ExpectedConditions.visibilityOf(myOrderBtn));
    }

    public void waitLabel() {
        getWait().until(ExpectedConditions.visibilityOf(zaloLabel));
        getWait().until(ExpectedConditions.visibilityOf(FBLabel));
        getWait().until(ExpectedConditions.visibilityOf(GGLabel));
    }

    public void moveToAccount() {
        myAccountBtn.click();
    }

    public WebElement getMyOrderBtn() {
        return myOrderBtn;
    }

    public WebElement getMyNotificationBtn() {
        return myNotificationBtn;
    }

    public WebElement getMyAccountBtn() {
        return myAccountBtn;
    }

    public WebElement getMyCommentBtn() {
        return myCommentBtn;
    }

    public WebElement getTikiNowBtn() {
        return tikiNowBtn;
    }

    public WebElement getCouponBtn() {
        return couponBtn;
    }

    public WebElement getTikiCoinBtn() {
        return tikiCoinBtn;
    }

    public WebElement getBookCareBtn() {
        return bookCareBtn;
    }

    public WebElement getZaloLabel() {
        return zaloLabel;
    }

    public WebElement getFBLabel() {
        return FBLabel;
    }

    public WebElement getGGLabel() {
        return GGLabel;
    }
}
