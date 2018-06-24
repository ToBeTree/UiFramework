package com.global.mi.uidemo.page;

import android.os.SystemClock;

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

    public static String getCurrentWindowTitle() {

        return null;
    }

    public static void takeScreenShot(String desription) {
        ElementActions.tackScreenShot(desription);
    }
}
