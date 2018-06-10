package com.global.mi.uidemo.uiautoutils;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;
import android.util.Log;

import java.util.List;

/**
 * Created by wuyongqiang on 2018/5/28.
 */

public class FindElement {

    public static UiDevice mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    public final static String PACKAGE_NAME = "com.mi.global.shop";

    public UiObject2 findElement(String selector){
        Log.i("findElement",selector);
        UiObject2 object2 = null;
        if (selector == null || selector == ""){
            Log.i("findElement","selector cannot be null or \"\"");
            return null;
        }
        String type = selector.split("#")[0];
        String value = selector.split("#")[1];
        switch (type){
            case "depth":
                int depth = Integer.parseInt(value.split("@")[0]);
                String clazz = value.split("@")[1];
                object2 = mDevice.wait(Until.findObject(By.depth(depth).clazz(clazz)),5000);
                break;
            case "res":
                object2 = mDevice.wait(Until.findObject(By.res(type,value)),5000);
                break;
        }

//        UiObject2 object2 = mDevice.wait(Until.findObject(By.res(PACKAGE_NAME,selector)),1000);
        if (object2 != null){
            return object2;
        }
        return null;
    }

    public List<UiObject2> findeElements(String selector){
        Log.i("findElements",selector);
        List<UiObject2> object2s = null;
        if (selector == null || selector == ""){
            Log.i("findElements","selector can't be null or \"\"");
            return null;
        }
        String type = selector.split("#")[0];
        String value = selector.split("#")[1];
        switch (type){
            case "depth":
                int depth = Integer.parseInt(value.split("@")[0]);
                String clazz = value.split("@")[1];
                object2s = mDevice.wait(Until.findObjects(By.depth(depth).clazz(clazz)),5000);
                break;
            case "res":
                object2s = mDevice.wait(Until.findObjects(By.res(PACKAGE_NAME,value)),5000);
                break;
        }
//        List<UiObject2> object2s = mDevice.wait(Until.findObjects(By.res(PACKAGE_NAME,selector)),1000);
        if (object2s != null){
            return object2s;
        }
        return null;
    }

//    public UiObject
}
