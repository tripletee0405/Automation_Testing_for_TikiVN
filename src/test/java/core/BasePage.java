package core;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private static final int TIMEOUT = 10;
    private static final int POLLING = 100;
    protected WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public Actions getAction() {
        return action;
    }

    public void setAction(Actions action) {
        this.action = action;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }

    public void closeAlert(WebElement close) {
        try {
            getWait().until(ExpectedConditions.visibilityOf(close));
            if (close.isDisplayed())
                close.click();
        } catch (TimeoutException e) {
        }
    }
}
