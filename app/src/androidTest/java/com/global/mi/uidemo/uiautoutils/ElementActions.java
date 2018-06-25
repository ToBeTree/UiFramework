package com.global.mi.uidemo.uiautoutils;

import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.StaleObjectException;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import android.util.Log;

import com.global.mi.uidemo.config.ConstDefs;
import com.global.mi.uidemo.framework.DefaultRetryHandler;
import com.global.mi.uidemo.framework.RetryHandler;
import com.global.mi.uidemo.framework.RetryUtils;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by wuyongqiang on 2018/5/28.
 */

public class ElementActions {

    private final static UiDevice mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    //    public final static String PACKAGE_NAME = "com.mi.global.shop";
    private RetryHandler mRetryHandler;
    private static UiObject2 object2;
    private static List<UiObject2> object2s;
    private static String mSelector;


    public ElementActions() {
        setRetryHandler(new DefaultRetryHandler(this));
    }

    public void setRetryHandler(RetryHandler retryHandler) {
        mRetryHandler = retryHandler;
    }

    public static UiObject2 findElement(String selector) {
        Log.i("find Element by", selector);
        if (selector == null || selector == "") {
            Log.i(ConstDefs.TAG, "find element by selector can't be null or \"\"");
            return null;
        }

        String type = selector.split(ConstDefs.TYPE_OPERATOR)[0];
        String value = selector.split(ConstDefs.TYPE_OPERATOR)[1];

        switch (type){
            case ConstDefs.RES:
                object2 = mDevice.wait(Until.findObject(By.res(ConstDefs.PACKAGE_NAME,value)), ConstDefs.FIND_TIME_WAIT);
                break;
            case ConstDefs.CLAZZ:
                break;
            case ConstDefs.DEPTH:
                int depth = Integer.parseInt(value.split(ConstDefs.CLASS_OPERATOR)[0]);
                String clazz = value.split(ConstDefs.CLASS_OPERATOR)[1];
                object2 = mDevice.wait(Until.findObject(By.depth(depth).clazz(clazz)), 5000);
                break;
            case ConstDefs.TEXT:
                break;
            case ConstDefs.DESC:
                break;
        }
        if (object2 != null){
            return object2;
        }

        return null;
    }

    public static List<UiObject2> findElements(String selector) {
        Log.i("find Elements by", selector);
        if (selector == null || selector == "") {
            Log.i(ConstDefs.TAG, "find elements by selector can't be null or \"\"");
            return null;
        }
        String type = selector.split(ConstDefs.TYPE_OPERATOR)[0];
        String value = selector.split(ConstDefs.TYPE_OPERATOR)[1];

        switch (type){
            case ConstDefs.RES:
                object2s = mDevice.wait(Until.findObjects(By.res(ConstDefs.PACKAGE_NAME,value)), ConstDefs.FIND_TIME_WAIT);
                break;
            case ConstDefs.CLAZZ:
                break;
            case ConstDefs.DEPTH:
                int depth = Integer.parseInt(value.split(ConstDefs.CLASS_OPERATOR)[0]);
                String clazz = value.split(ConstDefs.CLASS_OPERATOR)[1];
                object2s = mDevice.wait(Until.findObjects(By.depth(depth).clazz(clazz)), 5000);
                break;
            case ConstDefs.TEXT:
                break;
            case ConstDefs.DESC:
                break;
        }
        if (object2s != null){
            return object2s;
        }

        return null;
    }

    public List<UiObject2> findElements(String selector, int a) {
        Log.i("find Elements by", selector);
        if (selector == null || selector == "") {
            Log.i("findElements", "selector can't be null or \"\"");
            return null;
        }
        String type = selector.split("#")[0];
        String value = selector.split("#")[1];
        switch (type) {
            case "depth":
                int depth = Integer.parseInt(value.split("@")[0]);
                String clazz = value.split("@")[1];
                object2s = mDevice.wait(Until.findObjects(By.depth(depth).clazz(clazz)), 5000);
                break;
            case "res":
                object2s = mDevice.wait(Until.findObjects(By.res(ConstDefs.PACKAGE_NAME, value)), 5000);
                break;
        }
//        List<UiObject2> object2s = mDevice.wait(Until.findObjects(By.res(PACKAGE_NAME,selector)),1000);
        if (object2s != null) {
            return object2s;
        }
        return null;
    }

    public static void click(String selector, Boolean wait) {

        if (selector.contains(ConstDefs.POSITION_OPERATOR)){
            String position = selector.split(ConstDefs.POSITION_OPERATOR)[1];
            selector = selector.split(ConstDefs.POSITION_OPERATOR)[0];
            object2 = findElements(selector).get(Integer.parseInt(position));
        }else {
            object2 = findElement(selector);
        }

        try {
            if (wait){
                object2.clickAndWait(Until.newWindow(),ConstDefs.WAI_NEW_WINDOW_TIME);
            }else{
                object2.click();
            }
        } catch (StaleObjectException stable) {
            attemptRetryOnException();
        } catch (NullPointerException nullPoint) {
            attemptRetryOnException();
        }
    }

    public static void click(String selector) {
        click(selector, false);

    }
    public static void clickAndWaitNewWindow(String selector){
        click(selector,true);
    }

    public static void attemptRetryOnException() {
        //TODO 需要增加异常重试机制
        Log.i(ConstDefs.TAG,"try get retry");
    }

    public static void pressBack(){
        mDevice.pressBack();
    }

    private Callable<Boolean> condition = new Callable<Boolean>() {
        @Override
        public Boolean call() throws Exception {
//            if (mSelector.contains(ConstDefs.POSITION_OPERATOR)) {
//                object2 = findElement(mSelector);
//            } else {
//                object2s = findElements(mSelector);
//            }
            //同时为null,则需要重新查找
            return !(object2s == null && object2 == null);
        }
    };


    public static void tackScreenShot(String description){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(SystemClock.currentThreadTimeMillis());
        String dateStr = calendar.get(Calendar.HOUR_OF_DAY)+"_"+calendar.get(Calendar.MINUTE)+"_"+calendar.get(Calendar.SECOND);
        File file = new File("/mnt/sdcard/"+dateStr+"_"+description+".jpg");
        Log.i(ConstDefs.TAG,"take screen shot in "+file.getPath());
        mDevice.takeScreenshot(file);
    }

}
