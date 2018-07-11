package com.global.mi.uidemo.page;

import android.os.SystemClock;
import android.support.test.uiautomator.Direction;

import com.global.mi.uidemo.framework.ToastListener;
import com.global.mi.uidemo.uiautoutils.Action;
import com.global.mi.uidemo.uiautoutils.ElementActions;

import static org.junit.Assert.assertEquals;

/**
 * Created by wuyongqiang on 2018/5/28.
 */

public class BasePage {

    public static String DEPTH;
    public static String RES;
    public static String CLAZZ;
    public static String DESC;
    public static String TEXT;
    public static String PKG;


    public static Action elementAction = new Action();


    public static boolean checkToastValue(String toast) {
        SystemClock.sleep(200);
        assertEquals(getToast(), toast);
        return false;
    }

    public static String getToast() {
        String toast = "";
        SystemClock.sleep(500);
        toast = ToastListener.getToastMessage();
        return toast;
    }

    public static void pressBack() {
        elementAction.pressBack();
    }

    public static boolean isScreenOn(String view){
        return elementAction.isScreenOn(view);
    }

    public static String getCurrentWindowTitle() {

        return null;
    }

    public static void takeScreenShot(String desription) {
        ElementActions.tackScreenShot(desription);
    }

//    public static void scrollView(String scroll_view,Direction direction, int numOfScroll){
//        elementAction.scrollObject(scroll_view,direction,numOfScroll);
//    }

    public static void setScrollViewUp(String scroll_view) {
        elementAction.scrollObject(scroll_view, Direction.UP);
    }

    public static void setScrollViewUp(String scroll_view,int numOfScroll) {
        elementAction.scrollObject(scroll_view, Direction.UP,numOfScroll);
    }

    public static void setScrollViewDown(String scroll_view) {
        elementAction.scrollObject(scroll_view, Direction.DOWN);
    }

    public static void setScrollViewDown(String scroll_view,int numOfScroll) {
        elementAction.scrollObject(scroll_view, Direction.DOWN,numOfScroll);
    }
}
