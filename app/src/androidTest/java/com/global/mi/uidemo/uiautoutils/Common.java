package com.global.mi.uidemo.uiautoutils;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.util.Log;

import com.global.mi.uidemo.config.ConstDefs;

import java.util.List;

/**
 * Created by wuyongqiang on 2018/6/22.
 */

public class Common {

    private UiDevice mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

    private BySelector parseSelector(String selector){
        BySelector bySelector = null;
        Log.i(ConstDefs.TAG, selector);
        if (selector == null || selector == "") {
            Log.i(ConstDefs.TAG, "selector cannot be null or \"\"");
            return null;
        }
        String type = selector.split(ConstDefs.TYPE_OPERATOR)[0];
        String value = selector.split(ConstDefs.TYPE_OPERATOR)[1];
        switch (type){
            case "res":
                bySelector = By.res(ConstDefs.PACKAGE_NAME,value);
                break;
            case "depth":
                int depth = Integer.parseInt(value.split(ConstDefs.CLASS_OPERATOR)[1]);
                value = value.split(ConstDefs.CLASS_OPERATOR)[0];
                bySelector = By.depth(depth).clazz(value);
                break;
            case "text":
                bySelector = By.text(value);
                break;
            case "clazz":
                bySelector = By.clazz(value);
                break;
        }
        if (bySelector != null){
            return bySelector;
        }
        return null;
    }

    public UiObject2 findElement(String selector){
//        BySelector b = parseSelector(selector);
        UiObject2 object2 = mDevice.findObject(parseSelector(selector));
        if (object2 != null){
            return object2;
        }
        return null;
    }

    public List<UiObject2> findElements(String selector){
        List<UiObject2> object2s = mDevice.findObjects(parseSelector(selector));
        if (object2s != null){
            return object2s;
        }
        return null;
    }
}
