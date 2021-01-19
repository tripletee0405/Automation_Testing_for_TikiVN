package tests;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.io.IOException;

public class TestCase extends BaseTest implements ITestListener {

    private final int CELLNUM = 4;
    int i = 1;

    @Test(priority = 1)
    private void TC1() {
        LoginPage loginPage = new LoginPage(getDriver());
        RegisterPage registerPage = new RegisterPage(getDriver());
        loginPage.displayPopup("https://tiki.vn/");
        SoftAssert softAssert = new SoftAssert();

        if (loginPage.displayBoxLogin()) {
            softAssert.assertTrue(loginPage.verifyTextBoxAndLBL("Email / SĐT", "Nhập Email hoặc Số điện thoại", loginPage.getLabelEmail(), loginPage.getInputEmailTabLogin()), "Email login tab fail");
            softAssert.assertTrue(loginPage.verifyTextBoxAndLBL("Mật khẩu", "Mật khẩu từ 6 đến 32 ký tự", loginPage.getLabelPassword(), loginPage.getInputPasswordTabLogin()), "Password login tab fail");
            softAssert.assertTrue(loginPage.getLoginBtn().isDisplayed(), "Login button fail");
            softAssert.assertTrue(loginPage.getLoginFBBtn().isDisplayed(), "Login FB button fail");
            softAssert.assertTrue(loginPage.getLoginGGBtn().isDisplayed(), "Login Google button fail");
            softAssert.assertTrue(loginPage.getLoginZaloBtn().isDisplayed(), "Login Zalo button fail");

            registerPage.moveToRegister();

            softAssert.assertTrue(loginPage.verifyTextBoxAndLBL("Họ tên", "Nhập họ tên", registerPage.getLblName(), registerPage.getFullnameTextbox()), "Name fail");
            softAssert.assertTrue(loginPage.verifyTextBoxAndLBL("SĐT", "Nhập số điện thoại", registerPage.getLblPhone(), registerPage.getPhoneTextbox()), "Tel fail");
            softAssert.assertTrue(registerPage.getSendCodebtn().isDisplayed(), "button fail");
            softAssert.assertTrue(loginPage.verifyTextBoxAndLBL("Mã xác thực", "Nhập mã xác thực gửi tới số điện thoại trên", registerPage.getLblCode(), registerPage.getOtpCodeTB()), "OTP fail");
            softAssert.assertTrue(loginPage.verifyTextBoxAndLBL("Email", "Nhập email", registerPage.getEmaillbl(), registerPage.getEmail()), "Email register tab fail");
            softAssert.assertTrue(loginPage.verifyTextBoxAndLBL("Mật khẩu", "Mật khẩu từ 6 đến 32 ký tự", registerPage.getPasswordlbl(), registerPage.getPassword()), "Password register tab fail");
            softAssert.assertTrue(registerPage.checkBirthday(), "Dob fail");
            softAssert.assertTrue(registerPage.checkGender(), "Gender fail");
            softAssert.assertTrue(registerPage.getCreaterButton().isDisplayed(), "Create button fail");
        } else {
            softAssert.assertTrue(false, "Fail Display Popup");
        }
        softAssert.assertAll();
    }
//Hiện không còn khả dụng
//    @Test(priority = 2)
//    public void TC2() throws InterruptedException {
//        SoftAssert softAssert = new SoftAssert();
//
//        AddressPage addressPage = new AddressPage(getDriver());
//        addressPage.displayShippingAddressPopup("https://tiki.vn/");
//        softAssert.assertTrue(addressPage.displayInput(addressPage.getCityLabel(), addressPage.getCityDefaultValue()), "City label fail");
//        softAssert.assertTrue(addressPage.displayInput(addressPage.getDistrictLabel(), addressPage.getDistrictChekLBL()), "District label fail");
//        softAssert.assertTrue(addressPage.displayInput(addressPage.getWardLabel(), addressPage.getCommuneChekLBL()), "Ward label fail");
//        softAssert.assertTrue(addressPage.checkCity("Hà Nội"), "City fail");
//        softAssert.assertTrue(addressPage.checkDistrict("Quận Hai Bà Trưng"), "District fail");
//        softAssert.assertTrue(addressPage.checkWard("Phường Bách Khoa"), "Ward fail");
//        softAssert.assertTrue(addressPage.getButtonSubmit().isDisplayed(), "Bubmit button fail");
//        addressPage.submit();
//        softAssert.assertTrue(addressPage.checkNavigate("https://tiki.vn/"));
//        softAssert.assertAll();
//    }

    @Test(priority = 3)
    public void TC3() {
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = new LoginPage(getDriver());
        AccountPage accountPage = new AccountPage(getDriver());
        loginPage.login("https://tiki.vn/", "0877745111", "0Comatkhau##");

        accountPage.openDropdown();
        softAssert.assertTrue(accountPage.getMyOrderBtn().isDisplayed(), "Check Order fail");
        softAssert.assertTrue(accountPage.getMyNotificationBtn().isDisplayed(), "Check Notification fail");
        softAssert.assertTrue(accountPage.getMyAccountBtn().isDisplayed(), "Check account fail");
        softAssert.assertTrue(accountPage.getMyCommentBtn().isDisplayed(), "Check comment fail");
        softAssert.assertTrue(accountPage.getTikiNowBtn().isDisplayed(), "Check tikinow fail");
        softAssert.assertTrue(accountPage.getCouponBtn().isDisplayed(), "Check coupon fail");
        softAssert.assertTrue(accountPage.getTikiCoinBtn().isDisplayed(), "Check coin fail");
        softAssert.assertTrue(accountPage.getBookCareBtn().isDisplayed(), "Check bookcare fail");
        accountPage.moveToAccount();
        accountPage.waitLabel();
        softAssert.assertTrue(accountPage.getZaloLabel().isDisplayed(), "Zalo fail");
        softAssert.assertTrue(accountPage.getFBLabel().isDisplayed(), "FB fail");
        softAssert.assertTrue(accountPage.getGGLabel().isDisplayed(), "GG fail");
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void TC4() {
        SoftAssert softAssert = new SoftAssert();
        AccountPage accountPage = new AccountPage(getDriver());
        NotificationPage notificationPage = new NotificationPage(getDriver());
        getDriver().navigate().to("https://tiki.vn/");
        accountPage.openDropdown();
        notificationPage.moveToNotification();
        softAssert.assertTrue(notificationPage.countDropdown(), "Check fields fail");
        softAssert.assertTrue(notificationPage.getGeneralNotification().isDisplayed(), "general Notification fail");
        softAssert.assertTrue(notificationPage.getPromotionNotification().isDisplayed(), "promotion Notification fail");
        softAssert.assertTrue(notificationPage.getOrderNotification().isDisplayed(), "order Notification fail");
        softAssert.assertTrue(notificationPage.getSystemNotification().isDisplayed(), "system Notification fail");
        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void TC5() {
        SoftAssert softAssert = new SoftAssert();
        getDriver().navigate().to("https://tiki.vn/");
        ProductPage productPage = new ProductPage(getDriver());
        productPage.searchIphone();

        softAssert.assertTrue(productPage.getNameProduct().isDisplayed(), "Check name product fail");
        softAssert.assertTrue(productPage.getImageProduct().isDisplayed(), "Check image product fail");
        softAssert.assertTrue(productPage.getPriceProduct().isDisplayed(), "Check price product fail");
        softAssert.assertTrue(productPage.getQuantityProduct().isDisplayed(), "Check quantity product fail");
        softAssert.assertTrue(productPage.getSubmitBtn().isDisplayed(), "Check Buy button product fail");
        softAssert.assertTrue(productPage.getSameProduct().isDisplayed(), "Check same product fail");
        softAssert.assertTrue(productPage.getInfoProduct().isDisplayed(), "Check info product fail");
        softAssert.assertTrue(productPage.getDescriptionProduct().isDisplayed(), "Check description product fail");
        softAssert.assertTrue(productPage.getCommentProduct().isDisplayed(), "Check comment product fail");
        softAssert.assertAll();
    }

    @Test(priority = 6)
    public void TC6() {
        SoftAssert softAssert = new SoftAssert();
        getDriver().navigate().to("https://tiki.vn/");

        MenuLaptopPage menuLaptopPage = new MenuLaptopPage(getDriver());
        menuLaptopPage.moveToLaptop();
        softAssert.assertTrue(menuLaptopPage.getCatProduct().isDisplayed(), "Check category fail");
        softAssert.assertTrue(menuLaptopPage.getCommentProduct().isDisplayed(), "Check commnet fail");
        softAssert.assertTrue(menuLaptopPage.getTradeMark().isDisplayed(), "Check trademark fail");
        softAssert.assertTrue(menuLaptopPage.getSupplier().isDisplayed(), "Check supplier fail");
        softAssert.assertAll();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        try {
            ExcelUtils.writeExcel(CELLNUM, i++, "./data.xlsx", "pass");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            ExcelUtils.writeExcel(CELLNUM, i++, "./data.xlsx", "fail");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
