package com.global.mi.uidemo.page;

import android.util.Log;

import com.global.mi.uidemo.uiautoutils.Action;
import com.global.mi.uidemo.uiautoutils.FindBy;

/**
 * Created by wuyongqiang on 2018/5/28.
 */

public class MainPage extends BasePage {
    public static String gallery;
    public static String PHONE_LIST = "product_image";
    @FindBy(res="product_image",description="明星产品")
    public static String PRODUCTS_LIST = spliceSelector(RES, "product_image");
    @FindBy(description = "更多配件按钮")
    public static String accessories;
    public static String more;

    public static void clickProduct() {
//        Action.click(PRODUCTS_LIST);
//        Action.waitNewWindow();

        Action.clickAndWaitNewWindow(PRODUCTS_LIST);
    }
    public static void clickProduct(int position) {
        if (position<=0){
            Log.i("MainPage","Element position must be >=1");
        }
        PRODUCTS_LIST = PRODUCTS_LIST + "&"+Integer.toString(position-1);
        Action.clickAndWaitNewWindow(PRODUCTS_LIST);
    }


}
