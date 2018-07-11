package com.global.mi.uidemo.testcase;

import com.global.mi.uidemo.page.MainPage;
import com.global.mi.uidemo.page.UserPage;
import com.global.mi.uidemo.page.LoginPage;
import com.global.mi.uidemo.page.LoginVersionPage;

import org.junit.Test;

public class LoginCase extends BaseCase {

    @Test
    public void loginWithAccount(){
        MainPage.setScrollViewUp();
        MainPage.clickUser();
        UserPage.clickLogin();
        LoginVersionPage.clickBtnLogin();
        LoginPage.selectPwdLogin();
        LoginPage.inputAccount("267262511");
        LoginPage.inputPwd("gg111111");
        LoginPage.clickLogin();

    }
}
