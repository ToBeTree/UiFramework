package com.global.mi.uidemo.page;

import com.global.mi.uidemo.uiautoutils.Action;

/**
 * Created by wuyongqiang on 2018/5/28.
 */

public class ProductPage extends BasePage {
    public static String BTN_RETURN = spliceSelector(DEPTH, "12" + "@" + "android.view.View" + "&" + "0");
    public static String BTN_BUY = spliceSelector(DEPTH, "12" + "@" + "android.view.View" + "&" + "3");
    public static String BTN_CART;
//    public static String BTN_BUY_INTERNAL;

    public static void clickBuyBtn() {
        Action.clickAndWaitNewWindow(BTN_BUY);
    }

    public static void clickReturnBtn(){
        Action.click(BTN_RETURN);
    }

    public static void clickInternalBuyBtn() {

    }

}
