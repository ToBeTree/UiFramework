package com.global.mi.uidemo.page;

import android.util.Log;

import com.global.mi.uidemo.config.ConstDefs;
import com.global.mi.uidemo.framework.FindBy;
import com.global.mi.uidemo.framework.LogUtil;
import com.global.mi.uidemo.uiautoutils.ElementActions;

public class StorePage extends MainPage {

    public static String gallery;
    public static String PHONE_LIST = "product_image";
    @FindBy(res = "product_image", description = "明星产品")
    public static String PRODUCTS_LIST;
    @FindBy(description = "更多配件按钮")
    public static String accessories;
    public static String more;

    public static void clickProduct() {
//        Action.click(PRODUCTS_LIST);
//        Action.waitNewWindow();
        elementAction.clickInList(PHONE_LIST, true);

    }

    public static void clickProduct(int position) {
        if (position <= 0) {
            LogUtil.i(ConstDefs.TAG,"Element position must be >=1");
        }
        PRODUCTS_LIST = PRODUCTS_LIST + "&" + Integer.toString(position - 1);
//        ElementActions.clickAndWaitNewWindow(PRODUCTS_LIST);
        elementAction.clickInList(PHONE_LIST, true);
    }
}
