package com.sysco.Java_based_web_uI_automation.functions;

import com.sysco.Java_based_web_uI_automation.common.Constants;
import com.sysco.Java_based_web_uI_automation.pages.LoginPage;
import com.sysco.Java_based_web_uI_automation.pages.MyAccountPage;
import com.sysco.Java_based_web_uI_automation.utils.DriverSetUpUtil;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Rifad on 5/21/18.
 */
public class MyAccount {

    public static MyAccountPage myAccount = new MyAccountPage();

    public static void myAccountInvalidFunction(String email, String password) {
        myAccount.setLogin(email, password);
    }

    public static String emailAlert() {
        return myAccount.emailAlert();
    }

    public static void clearEmailAndPassword() {
        myAccount.clearEmailAndPassword();
    }

    public static String emptyAlert() {
        return myAccount.emptyAlert();
    }

    public static void myAccountValidFunction(String email, String password) {
        myAccount.setLogin(email, password);
    }

    //    public static String userNameValidation(){
//       return  myAccount.userName().replaceAll("HELLO, ","").replaceAll("!","");
//    }
    public static void navigateToCart() {
        myAccount.navigateToCart();
    }
    public static void clickRemoveLink() {
        myAccount.clickRemoveLink();
    }
    public static String isDisplayedZeroInCart() {
        return  myAccount.isDisplayedZeroInCart();
    }
    public static void MoveToProductCategory() {
        myAccount.MoveToProductCategory();
    }
    public static void clickRoyalLiqueur() {
        myAccount.clickRoyalLiqueur();
    }
    public static void clickAnItem() {
        myAccount.clickAnItem();
    }
    public static void clickAddToCartButton() {
        myAccount.clickAddToCartButton();
    }
    public static boolean isDisplayedPriceInPopUp() {
        return  myAccount.isDisplayedPriceInPopUp();
    }
    public static boolean isDisplayedNameInPopUP() {
        return  myAccount.isDisplayedNameInPopUP();
    }
    public static void clickCheckOut() {
        myAccount.clickCheckOut();
    }
    public static String isDisplayedOneInShoppingCart() {
        return  myAccount.isDisplayedOneInShoppingCart();
    }
    public static boolean isDisplayedPrice() {
        return myAccount.isDisplayedPrice();
    }
    public static boolean isDisplayedName() {
        return   myAccount.isDisplayedName();
    }
    public static void clickProceedToCheckOut() {
        myAccount.clickProceedToCheckOut();
    }
    public static String isDisplayedFirstName() {
        return  myAccount.isDisplayedFirstName();
    }
    public static String isDisplayedLastName() {
        return  myAccount.isDisplayedLastName();
    }
    public static String isDisplayedAddress() {
        return  myAccount.isDisplayedAddress();
    }

    public static String isDisplayedContactNumber() {
        return  myAccount.isDisplayedContactNumber();
    }

    public static void clearFirstName() {
        myAccount.clearFirstName();
    }
    public static void clearLastNameName() {
        myAccount.clearLastNameName();
    }
    public static void clearAddress1() {
        myAccount.clearAddress1();
    }
    public static void clearContactNumberName() {
        myAccount.clearContactNumberName();
    }
    public static void clickContinue() {
        myAccount.clickContinue();
    }
    public static String isDisplayedEmptyErrorFirstName() {
        return  myAccount.isDisplayedEmptyErrorFirstName();
    }
    public static String isDisplayedEmptyErrorLastName() {
        return  myAccount.isDisplayedEmptyErrorLastName();
    }
    public static String isDisplayedEmptyErrorAddress() {
        return  myAccount.isDisplayedEmptyErrorAddress();
    }

    public static String isDisplayedEmptyErrorContactNumber() {
        return  myAccount.isDisplayedEmptyErrorContactNumber();
    }
    public static void enterFirstName(String firstName)  {
        myAccount.enterFirstName(firstName);
    }

    public static void enterLastName(String lastName)  {
        myAccount.enterLastName(lastName);
    }

    public static void enterAddress1(String address1)  {

        myAccount.enterAddress1(address1);
    }

    public static void enterContactNumber(String contactNumber)  {
        myAccount.enterContactNumber(contactNumber);

    }
    public static void removePostCode() {
        myAccount.removePostCode();
    }
    public static void enterPostCode(String postCode){
        myAccount.enterPostCode(postCode);
    }
    public static String isDisplayedDeliveryOptions() {
        return  myAccount.isDisplayedDeliveryOptions();
    }
    public static void clickContinueInDeliveryOptions() {
        myAccount.clickContinueInDeliveryOptions();
    }
    public static void selectPayPalOption() {
        myAccount.selectPayPalOption();
    }
    public static void selectAgreement() {
        myAccount.selectAgreement();
    }
    public static void clickPurchase() {
        myAccount.clickPurchase();
    }
    public static String isDisplayedPayPalAccount() {
        return  myAccount.isDisplayedPayPalAccount();
    }
}

