package com.global.mi.uidemo.page;

import com.global.mi.uidemo.uiautoutils.Action;

/**
 * Created by wuyongqiang on 2018/5/28.
 */

public class VersionPage extends ProductPage {
    public static String storge;
    public static String color;
    public static String price;
    public static String desc;
    public static String BTN_BUY;
    public static String BTN_RETURN = spliceSelector(DEPTH,"12"+"@"+"android.view.View"+"&"+"1");;
    public static String btn_protect;
    public static String protect_t_c;

    public static void clickReturnBtn(){
        Action.click(BTN_RETURN);
    }
}
