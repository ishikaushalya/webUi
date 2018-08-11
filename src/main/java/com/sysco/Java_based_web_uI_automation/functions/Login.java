package com.sysco.Java_based_web_uI_automation.functions;

import com.sysco.Java_based_web_uI_automation.common.Constants;
import com.sysco.Java_based_web_uI_automation.pages.LoginPage;
import com.sysco.Java_based_web_uI_automation.utils.DriverSetUpUtil;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Rifad on 5/21/18.
 */
public class Login  {

    public static LoginPage ogmLoginPage = new LoginPage();


    public static void loadLoginPage() {

        if (Constants.RUN_LOCALLY) {
            DriverSetUpUtil.setToRunLocally();
            DesiredCapabilities capabilities = null;
            ogmLoginPage.loadLoginPage(capabilities, Constants.APP_URL);
        } else {
            ogmLoginPage.loadLoginPage(DriverSetUpUtil.setToRunRemotely(Constants.APP_OS), Constants.APP_URL);
        }
    }


    public static void quiteDriver() {
        ogmLoginPage.quitDriver();
    }

    public static void loginToFtr() {

    }

    public static void clickDay(){
        ogmLoginPage.clickDay();
    }
    public static void dropMonth(){
        ogmLoginPage.dropMonth();
    }
    public static void dropYear(){
        ogmLoginPage.dropYear();
    }
    public static void setDay(){
        ogmLoginPage.dropYear();
    }
    public static void setMonth(){
        ogmLoginPage.setMonth();
    }
    public static void setYear(){
        ogmLoginPage.setYear();
    }
    public static void setEnter(){
        ogmLoginPage.setEnter();
    }
    public static void setCountry(){
        ogmLoginPage.setCountry();
    }
    public static void selectCountry(){
        ogmLoginPage.selectCountry();
    }

    public static void setBdayTwo(){
        ogmLoginPage.clickDay();
        ogmLoginPage.setDay();
        ogmLoginPage.dropMonth();
        ogmLoginPage.setMonth();
        ogmLoginPage.dropYear();
        ogmLoginPage.setYear2();
        ogmLoginPage.setEnter();
    }

    public static void setBdayOne(){
        ogmLoginPage.clickDay();
        ogmLoginPage.setDay();
        ogmLoginPage.dropMonth();
        ogmLoginPage.setMonth();
        ogmLoginPage.dropYear();
        ogmLoginPage.setYear();
        ogmLoginPage.setEnter();
    }
    public static String getErrorMessage(){
     return ogmLoginPage.errorEnteringMessage();
    }
    public static void clickMyAccount(){
        ogmLoginPage.clickMyAccount();
    }
}
