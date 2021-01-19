package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NotificationPage extends BasePage {

    @FindBy(xpath = "//div[@data-view-id ='hheader_header_account_container']")
    private WebElement loginDiv;
    @FindBy(xpath = "//p[text()='Thông báo của tôi']")
    private WebElement myNotificationBtn;
    @FindBy(xpath = "//li[@title ='Thông báo chung']")
    private WebElement generalNotification;
    @FindBy(xpath = "//li[@title ='Thông báo khuyến mãi']")
    private WebElement promotionNotification;
    @FindBy(xpath = "//li[@title ='Thông báo đơn hàng']")
    private WebElement orderNotification;
    @FindBy(xpath = "//li[@title ='Thông báo hệ thống']")
    private WebElement systemNotification;
    public NotificationPage(WebDriver driver) {
        super(driver);
    }

    public boolean countDropdown() {
        int xpathCount = driver.findElements(By.xpath("//div[@class='Userstyle__UserDropDown-sc-6e6am-5 cVRwHa toggler']/a")).size();
        if (xpathCount == 10)
            return true;
        return false;
    }

    public void moveToNotification() {
        myNotificationBtn.click();
        getWait().until(ExpectedConditions.visibilityOf(generalNotification));
    }

    public WebElement getGeneralNotification() {
        return generalNotification;
    }

    public WebElement getPromotionNotification() {
        return promotionNotification;
    }

    public WebElement getOrderNotification() {
        return orderNotification;
    }

    public WebElement getSystemNotification() {
        return systemNotification;
    }
}
