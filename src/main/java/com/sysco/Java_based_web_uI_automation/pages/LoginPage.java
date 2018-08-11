package com.sysco.Java_based_web_uI_automation.pages;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

/**
 * Created by Rifad on 5/21/18.
 */
public class LoginPage {
    protected static SyscoLabUI syscoLabUIOgm;
    private By txtGoogleSearch = By.id("lst-ib");
    private By dropDate = By.id("age_select_day");
    private By dropMonth = By.id("age_select_month");
    private By dropYear = By.id("age_select_year");
    private By setDay = By.xpath("//*[@id=\"age_select_day\"]/option[11]");
    private By setMonth = By.xpath("//*[@id=\"age_select_month\"]/option[4]");
    private By setYear = By.xpath("//*[@id=\"age_select_year\"]/option[15]"); //1993
    private By setYear2= By.xpath("//*[@id=\"age_select_year\"]/option[2]"); //2003
    private By setEnter = By.id("age_confirm_btn");
    private By setCountry = By.id("age_select_country");
    private By selectCountry = By.xpath("//*[@id=\"age_select_country\"]/option[237]");
    private By errorEntering = By.xpath("//*[@id=\"age_missing_message\"]/span");
    private By myAccount = By.xpath("//*[@id=\"quick-access-list\"]/li[1]/ul/li[2]/ul");

    public static void loadLoginPage(Capabilities capabilities, String url) {
        syscoLabUIOgm = new SyscoLabWUI(capabilities);
        syscoLabUIOgm.navigateTo(url);
        syscoLabUIOgm.driver.manage().window().maximize();


    }
    public void quitDriver() {
        if (syscoLabUIOgm != null) {
            syscoLabUIOgm.quit();
        }
    }

    public void clickDay(){
        syscoLabUIOgm.click(dropDate);
    }
    public void dropMonth(){
        syscoLabUIOgm.click(dropMonth);
    }
    public void dropYear(){
        syscoLabUIOgm.click(dropYear);
    }
    public void setDay(){
        syscoLabUIOgm.click(setDay);
    }
    public void setMonth(){
        syscoLabUIOgm.click(setMonth);
    }
    public void setYear(){
        syscoLabUIOgm.click(setYear);
    }
    public void setEnter(){
        syscoLabUIOgm.click(setEnter);
    }
    public void setCountry(){
        syscoLabUIOgm.click(setCountry);
    }
    public  void selectCountry(){
        syscoLabUIOgm.click(selectCountry);
    }
     public void setYear2(){
        syscoLabUIOgm.click(setYear2);
   }
    public String errorEnteringMessage(){
        return syscoLabUIOgm.getText(errorEntering);
    }
    public void clickMyAccount(){
        syscoLabUIOgm.sleep(3);
        syscoLabUIOgm.click(myAccount);
    }

}
