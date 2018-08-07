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
        ogmLoginPage.SetDay();
    }

}
