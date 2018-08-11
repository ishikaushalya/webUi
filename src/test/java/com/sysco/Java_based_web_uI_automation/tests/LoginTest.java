package com.sysco.Java_based_web_uI_automation.tests;


import com.sysco.Java_based_web_uI_automation.data.LoginData;
import com.sysco.Java_based_web_uI_automation.functions.Cart;
import com.sysco.Java_based_web_uI_automation.functions.Login;
import com.sysco.Java_based_web_uI_automation.functions.MyAccount;
import com.sysco.Java_based_web_uI_automation.pages.CartPage;
import com.sysco.Java_based_web_uI_automation.utils.ExcelUtil;
import com.sysco.Java_based_web_uI_automation.utils.TestBase;
import org.springframework.context.annotation.DependsOn;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;


public class LoginTest extends TestBase {

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Bundabergrum - Checkout");
    }

    @Test
    public void testLogin() throws Exception {

        SoftAssert softAssert = new SoftAssert();
        // Sample way to retrive data from excel
        LoginData loginData = ExcelUtil.getLoginData("$as238l");

        //UI Automation  sample
        Login.loadLoginPage();

        Login.setBdayTwo();
        softAssert.assertEquals(Login.getErrorMessage(), "Sorry, your age or location does not permit you to enter at this time.");
        Login.setBdayOne();
        Login.clickMyAccount();
        softAssert.assertAll();

        //  Login.quiteDriver();
    }

    @Test(description = "verify invalid email and password", dependsOnMethods = "testLogin")
    public void invaliedEmailPassward() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        MyAccount.myAccountInvalidFunction("bela", "a");
        softAssert.assertEquals(MyAccount.emailAlert(), "Please enter a valid email address. For example johndoe@domain.com.");
        MyAccount.clearEmailAndPassword();
        softAssert.assertAll();
    }

    @Test(description = "verify invalied email", dependsOnMethods = "testLogin")
    public void invaliedEmail() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        MyAccount.myAccountInvalidFunction("bela.com", "12345678");
        softAssert.assertEquals(MyAccount.emailAlert(), "Please enter a valid email address. For example johndoe@domain.com.");
        MyAccount.clearEmailAndPassword();
        softAssert.assertAll();
    }

    @Test(description = "verify empty credentials", dependsOnMethods = "testLogin")
    public void InvalidEmpty() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        MyAccount.myAccountInvalidFunction("", "");
        softAssert.assertEquals(MyAccount.emptyAlert(), "This is a required field.");
        MyAccount.clearEmailAndPassword();

        softAssert.assertAll();
    }

    @Test(description = "verify valid email and password", dependsOnMethods = "invaliedEmailPassward")
    public void valiedEmailPassward() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        MyAccount.myAccountValidFunction("williamjacob802@gmail.com", "12345678");
        softAssert.assertAll();
    }
//
//    @Test(description = "testing cart" , dependsOnMethods = "valiedEmailPassward")
//    public static void CheckOutOfAnItem() {
//        SoftAssert softAssert = new SoftAssert();
//
//        MyAccount.clickCheckOut();
//        softAssert.assertEquals(Cart.isDisplayedOneInShoppingCart(), "2", "Expected value does not displayed");
//        softAssert.assertTrue(Cart.isDisplayedPrice(), "expected price does not displayed");
//        softAssert.assertFalse(Cart.isDisplayedName(), "expected name does not displayed");
//        softAssert.assertAll();
//    }

//    @Test(description = "compare user name", dependsOnMethods = "invaliedEmailPassward")
//    public void userNameValidation() throws Exception {
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(MyAccount.userNameValidation(),"WILLIAM JACOB", "Displayed username is incorrect");
//
//        softAssert.assertAll();
//    }

    @Test(description = "remove item from cart" ,dependsOnMethods = "valiedEmailPassward")
    public void testRemoveItemsFromCart() throws Exception{
        SoftAssert softAssert = new SoftAssert();
        MyAccount.navigateToCart();
        MyAccount.clickRemoveLink();

        MyAccount.navigateToCart();
        softAssert.assertEquals(MyAccount.isDisplayedZeroInCart(),"0","Expected value does not displayed");
        softAssert.assertAll();
    }

    @Test(description = "add item to cart", dependsOnMethods = "testRemoveItemsFromCart")
    public static void testAddItemToCart() {

        MyAccount.MoveToProductCategory();
        MyAccount.clickRoyalLiqueur();
        MyAccount.clickAnItem();
        MyAccount.clickAddToCartButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(MyAccount.isDisplayedPriceInPopUp(), "expected price does not displayed");
        softAssert.assertFalse(MyAccount.isDisplayedNameInPopUP(), "expected name does not displayed");
        softAssert.assertAll();
    }

    @Test(description = "check out of an item",dependsOnMethods = "testAddItemToCart")
    public static void testCheckOutOfAnItem() {
        MyAccount.clickCheckOut();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(MyAccount.isDisplayedOneInShoppingCart(), "1", "Expected value does not displayed");
        softAssert.assertTrue(MyAccount.isDisplayedPrice(), "expected price does not displayed");
        softAssert.assertTrue(MyAccount.isDisplayedName(), "expected name does not displayed");
        softAssert.assertAll();
    }

    @Test(description = "test validation when proceed to checkout",dependsOnMethods = "testCheckOutOfAnItem")
    public static void testValidationsWhenProceedToCheckOut() {
        MyAccount.clickProceedToCheckOut();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(MyAccount.isDisplayedFirstName(),"william","expected name does not displayed");
        softAssert.assertEquals(MyAccount.isDisplayedLastName(),"jacob","expected name does not displayed");
        MyAccount.clearFirstName();
        MyAccount.clearLastNameName();
        MyAccount.clearAddress1();
        MyAccount.clearContactNumberName();
        MyAccount.clickContinue();
        softAssert.assertEquals(MyAccount.isDisplayedEmptyErrorFirstName(),"This is a required field.","expected value does not displayed");
        softAssert.assertEquals(MyAccount.isDisplayedEmptyErrorLastName(),"This is a required field.","expected value does not displayed");
        softAssert.assertEquals(MyAccount.isDisplayedEmptyErrorAddress(),"This is a required field.","expected value does not displayed");
        softAssert.assertEquals(MyAccount.isDisplayedEmptyErrorContactNumber(),"This is a required field.","expected value does not displayed");
        softAssert.assertAll();
    }
    @Test(description = "test continue in procedd to checkout",dependsOnMethods = "testValidationsWhenProceedToCheckOut")
    public static void testContinueInProceedToCheckOut() {
        MyAccount.enterFirstName("william");
        MyAccount.enterLastName("jacob");
        MyAccount.enterAddress1("Abc");
        MyAccount.enterContactNumber("42342423423");
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(MyAccount.isDisplayedFirstName(),"william","expected name does not displayed");
        softAssert.assertEquals(MyAccount.isDisplayedLastName(),"jacob","expected name does not displayed");
        softAssert.assertEquals(MyAccount.isDisplayedAddress(),"Abc","expected name does not displayed");
        softAssert.assertEquals(MyAccount.isDisplayedContactNumber(),"42342423423","expected name does not displayed");
        MyAccount.removePostCode();
        MyAccount.enterPostCode("2000");
        MyAccount.clickContinue();
        softAssert.assertEquals(MyAccount.isDisplayedDeliveryOptions(),"DELIVERY OPTIONS","expected name does not displayed");
        softAssert.assertAll();
    }
    @Test(description = "test Deliver opetions",dependsOnMethods = "testContinueInProceedToCheckOut")
    public static void testDeliveryOptions() {
        Cart.clickContinueInDeliveryOptions();
        Cart.selectPayPalOption();
        Cart.selectAgreement();
        Cart.clickPurchase();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(Cart.isDisplayedPayPalAccount(),"PayPal Guest Checkout","expected name does not displayed");
        softAssert.assertAll();
    }



}