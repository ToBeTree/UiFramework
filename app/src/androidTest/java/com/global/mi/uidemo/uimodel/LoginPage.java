package com.global.mi.uidemo.uimodel;

import com.global.mi.uidemo.framework.FindBy;

public class LoginPage extends LoginVersionPage {

    @FindBy(res = "tv_area_code")
    public static String TV_AREA;
    @FindBy(res = "et_account_name")
    public static String TV_PHONE;
    @FindBy(res = "et_account_password")
    public static String TV_PASSWORD;
    @FindBy(res = "btn_forget_pwd")
    public static String BTN_FORGET;
    @FindBy(res = "btn_login")
    public static String BTN_SIGN;
    @FindBy(res = "login_with_email_or_id")
    public static String OTHER_MODEL;
    @FindBy(res = "message")
    public static String LOADING_MESSGE;

    public static void inputPhone(String phone){
        elementAction.setText(TV_PHONE,phone);
    }

    public static void inputPwd(String pwd){
        elementAction.setText(TV_PASSWORD,pwd);
    }

    public static void clickLogin(){
        elementAction.click(BTN_SIGN);
    }

    public static void clickOtherLogin(){
        elementAction.click(OTHER_MODEL);
    }

}
