package com.global.mi.uidemo.page;

import com.global.mi.uidemo.config.ConstDefs;
import com.global.mi.uidemo.framework.FindBy;
import com.global.mi.uidemo.framework.LogUtil;

public class UserPage extends MainPage {
    @FindBy(res = "usercentral_fragment_listheader_login_btn")
    public static String BTN_LOGIN;
    @FindBy(res = "usercentral_fragment_quit_btn")
    public static String BTN_LOGOUT;
    @FindBy(res = "usercentral_fragment_listview")
    public static String LV_USER;

    public static void clickLogin(){
        setScrollViewUp(LV_USER,5);
        if (isScreenOn(BTN_LOGIN)){
            elementAction.click(BTN_LOGIN,true);
        }
    }


    public static boolean isLogined(){
        return elementAction.isScreenOn(BTN_LOGIN);
    }

    public static void clickLogout(){
        if (isLogined()){
            setScrollViewDown(LV_USER,5);
            LogUtil.i(ConstDefs.TAG,"Logout app");
            elementAction.click(BTN_LOGOUT);
        }
    }
}
