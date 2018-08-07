package com.sysco.Java_based_web_uI_automation.utils;

import com.syscolab.qe.core.excelUtils.ReadExcel;
import com.sysco.Java_based_web_uI_automation.data.LoginData;

/**
 * Created by Rifad on 3/6/18.
 */
public class ExcelUtil {


    public static LoginData getLoginData(String key) {
        Object loginObject = ReadExcel.getDataFromExcelSheet(key, System.getProperty("user.dir") + "/src/main/resources/testData/TestData.xls", 0, LoginData.class);
        LoginData loginData = (LoginData) loginObject;
        return loginData;
    }

}
