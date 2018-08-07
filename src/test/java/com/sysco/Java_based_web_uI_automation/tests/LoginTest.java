package com.sysco.Java_based_web_uI_automation.tests;


import com.sysco.Java_based_web_uI_automation.data.LoginData;
import com.sysco.Java_based_web_uI_automation.functions.Login;
import com.sysco.Java_based_web_uI_automation.utils.ExcelUtil;
import com.sysco.Java_based_web_uI_automation.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;


public class LoginTest extends TestBase {

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Login - ValidLogin");
    }

    @Test
    public void testLogin() throws Exception {

        // Sample way to retrive data from excel
        LoginData loginData = ExcelUtil.getLoginData("$as238l");

        //UI Automation  sample
        Login.loadLoginPage();

        Login.clickDay();

        Login.quiteDriver();

    }
}