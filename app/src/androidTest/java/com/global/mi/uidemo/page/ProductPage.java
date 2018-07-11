package com.global.mi.uidemo.page;

import com.global.mi.uidemo.framework.FindBy;

/**
 * Created by wuyongqiang on 2018/5/28.
 */

public class ProductPage extends MainPage {
    public static String BTN_RETURN;
    @FindBy(depth = "12", clazz = "android.view.View", position = "3")
    public static String BTN_BUY;


    public static String BTN_CART;
//    public static String BTN_BUY_INTERNAL;

    public static void clickBuyBtn() {
//        Action.clickAndWaitNewWindow(BTN_BUY);
//        actions.click(BTN_BUY);
        elementAction.click(BTN_BUY);
    }

    public static void clickReturnBtn() {
//        Action.click(BTN_RETURN);
        elementAction.click(BTN_RETURN);
    }

    public static void clickInternalBuyBtn() {

    }



}
