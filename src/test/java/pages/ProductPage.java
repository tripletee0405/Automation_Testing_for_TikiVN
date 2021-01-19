package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Tìm sản phẩm, danh mục hay thương hiệu mong muốn ...']")
    private WebElement inputSearch;
    @FindBy(xpath = "//button[@class='FormSearch__Button-sc-1fwg3wo-3 knOqgr']")
    private WebElement searchBtn;
    @FindBy(xpath = "//*[@id='__next']/div[1]/main/div[2]/div[1]/div[2]/div[1]/div[2]/a[1]")
    private WebElement firstProduct;
    @FindBy(xpath = "//h1[@itemprop='name']")
    private WebElement nameProduct;
    @FindBy(xpath = "//div[@class='container']/img")
    private WebElement imageProduct;
    @FindBy(xpath = "//span[@class='product-price__current-price']")
    private WebElement priceProduct;
    @FindBy(xpath = "//div[@class='QualityInput__Wrapper-sc-15mlmyf-0 iyaBQp']")
    private WebElement quantityProduct;
    @FindBy(xpath = "//button[text()='Chọn mua']")
    private WebElement submitBtn;
    @FindBy(xpath = "//div[@class='ProductSlide__Wrapper-sc-18ee076-0 bwVgyp']")
    private WebElement sameProduct;
    @FindBy(xpath = "//*[@id='__next']/div[1]/main/div[8]/div/div[1]/div[1]")
    private WebElement infoProduct;
    @FindBy(xpath = "//*[@id='__next']/div[1]/main/div[8]/div/div[1]/div[2]")
    private WebElement descriptionProduct;
    @FindBy(xpath = "//*[@id='__next']/div[1]/main/div[9]")
    private WebElement commentProduct;
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void searchIphone() {
        inputSearch.sendKeys("Iphone");
        searchBtn.click();
        getWait().until(ExpectedConditions.visibilityOf(firstProduct));
        firstProduct.click();
        getWait().until(ExpectedConditions.visibilityOf(nameProduct));
        getWait().until(ExpectedConditions.visibilityOf(imageProduct));
        getWait().until(ExpectedConditions.visibilityOf(priceProduct));
        getWait().until(ExpectedConditions.visibilityOf(quantityProduct));
        getWait().until(ExpectedConditions.visibilityOf(submitBtn));
        getWait().until(ExpectedConditions.visibilityOf(sameProduct));
        getWait().until(ExpectedConditions.visibilityOf(infoProduct));
        getWait().until(ExpectedConditions.visibilityOf(descriptionProduct));
        getWait().until(ExpectedConditions.visibilityOf(commentProduct));
    }

    public WebElement getNameProduct() {
        return nameProduct;
    }

    public WebElement getImageProduct() {
        return imageProduct;
    }

    public WebElement getPriceProduct() {
        return priceProduct;
    }

    public WebElement getQuantityProduct() {
        return quantityProduct;
    }

    public WebElement getSubmitBtn() {
        return submitBtn;
    }

    public WebElement getSameProduct() {
        return sameProduct;
    }

    public WebElement getInfoProduct() {
        return infoProduct;
    }

    public WebElement getDescriptionProduct() {
        return descriptionProduct;
    }

    public WebElement getCommentProduct() {
        return commentProduct;
    }
}
