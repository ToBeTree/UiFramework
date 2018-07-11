package com.global.mi.uidemo.page;

import com.global.mi.uidemo.framework.FindBy;
import com.global.mi.uidemo.page.BasePage;

public class LoginVersionPage extends BasePage {

    @FindBy(res = "btn_start_login")
    public static String BTN_START_LOGIN;
    @FindBy(res = "btn_reg")
    public static String BTN_REGISTER;
    @FindBy(res = "btn_fb")
    public static String BTN_FB;

    public static void clickBtnLogin(){
        elementAction.click(BTN_START_LOGIN);
    }


    public static void clickBtnReg(){
        elementAction.click(BTN_REGISTER);
    }

    public static void clickBtnFb(){
        elementAction.click(BTN_FB);
    }

}
