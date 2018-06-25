package com.global.mi.uidemo.page;

import android.support.test.uiautomator.Direction;
import android.util.Log;

import com.global.mi.uidemo.config.ConstDefs;
import com.global.mi.uidemo.framework.FindBy;

/**
 * Created by wuyongqiang on 2018/5/28.
 */

public class MainPage extends BasePage {

    @FindBy(text = "Mi Store")
    public static String MI_STORE;
    @FindBy(text = "Products")
    public static String PRODUCTS;
    @FindBy(text = "Discover")
    public static String DISCOVER;
    @FindBy(text = "Account")
    public static String USER;
    @FindBy(res = "shopping_cart")
    public static String CART;
    @FindBy(res = "iv_title_icon")
    public static String PAGE_TITLE;
    @FindBy(clazz = "android.widget.ListView")
    public static String SCROLL_VIEW;

    public static void clickStore() {
        elementAction.click(MI_STORE);
    }

    public static void clickProduct() {
        elementAction.click(PRODUCTS);
    }

    public static void clickDiscover() {
        elementAction.click(DISCOVER);
    }

    public static void clickUser() {
        elementAction.click(USER);
    }

    public static void clickCart() {
        elementAction.click(CART);
    }

    public static boolean checkCurrentTabTitle(String title) {
        if ("".equals(title) || title == null) {
            Log.i(ConstDefs.TAG, "check page title can not be null");
            return false;
        }
        return title.equals(getCurrentTabTitle());
    }

    private static String getCurrentTabTitle() {
        return elementAction.getObject2(PAGE_TITLE).getText();
    }

    public static void setScrollViewUp() {
        elementAction.scrollObject(SCROLL_VIEW, Direction.UP);
    }

    public static void setScrollViewUp(int numOfSroll) {
        elementAction.scrollObject(SCROLL_VIEW, Direction.UP,numOfSroll);
    }

    public static void setScrollViewDown() {
        elementAction.scrollObject(SCROLL_VIEW, Direction.DOWN);
    }

    public static void setScrollViewDown(int numOfScroll) {
        elementAction.scrollObject(SCROLL_VIEW, Direction.DOWN,numOfScroll);
    }

}
