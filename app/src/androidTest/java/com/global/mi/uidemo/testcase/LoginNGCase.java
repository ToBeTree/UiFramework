package com.global.mi.uidemo.testcase;

import android.util.Log;

import com.global.mi.uidemo.page.LoginPage;
import com.global.mi.uidemo.page.LoginVersionPage;
import com.global.mi.uidemo.page.UserPage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginNGCase {


    @BeforeClass
    public void init(){

    }


    @AfterClass
    public void tearDown(){

    }

    @BeforeMethod
    public void init_logout(){
        if (UserPage.isLogined()){
            UserPage.clickLogout();
        }
    }

    @AfterMethod
    public void tear_logout(){
        if (UserPage.isLogined()){
            UserPage.clickLogout();
        }
    }

    @Test
    public void loginWithPwd(){
        UserPage.clickLogin();
        LoginVersionPage.clickBtnLogin();
        LoginPage.inputAccount("18070513985");
        LoginPage.inputPwd("wyqxiaomi2");
        LoginPage.clickLogin();
        Assert.assertTrue(UserPage.isLogined());
    }

    @Test
    public void loginError(){

    }

    @Test
    public void loginWithPhone(){
        UserPage.clickLogin();
        LoginVersionPage.clickBtnLogin();
        LoginPage.selectPwdLogin();
        LoginPage.inputAccount("267262511");
        LoginPage.inputPwd("gg111111");
        LoginPage.clickLogin();
        Assert.assertTrue(UserPage.isLogined());
    }

}
