package com.global.mi.uidemo.page;

import com.global.mi.uidemo.framework.FindBy;

public class UserPage extends MainPage {
    @FindBy(res = "usercentral_fragment_listheader_login_btn")
    public static String BTN_LOGIN;

    public static void clickLogin(){
        elementAction.click(BTN_LOGIN,true);
    }


    public static boolean isLogined(){
        return elementAction.isScreenOn(BTN_LOGIN);
    }
}
