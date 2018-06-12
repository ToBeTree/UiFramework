package com.global.mi.uidemo.uiautoutils;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.StaleObjectException;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;
import android.util.Log;

import com.global.mi.uidemo.config.ConstDefs;
import com.global.mi.uidemo.framework.DefaultRetryHandler;
import com.global.mi.uidemo.framework.RetryHandler;

import java.util.List;

/**
 * Created by wuyongqiang on 2018/5/28.
 */

public class ElementActions {

    private static UiDevice mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
//    public final static String PACKAGE_NAME = "com.mi.global.shop";
    private RetryHandler mRetryHandler;


    public ElementActions(){
        setRetryHandler(new DefaultRetryHandler(this));
    }

    public void setRetryHandler(RetryHandler retryHandler){
        mRetryHandler = retryHandler;
    }

    public void actionRetry(){

    }

    public UiObject2 findElement(String selector){
        Log.i("findElement by",selector);

        return null;
    }

    public List<UiObject2> findElements(String selecotr){

        return null;
    }

    public List<UiObject2> findElements(String selector,int a){
        Log.i("findElements by",selector);
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
                object2s = mDevice.wait(Until.findObjects(By.res(ConstDefs.PACKAGE_NAME,value)),5000);
                break;
        }
//        List<UiObject2> object2s = mDevice.wait(Until.findObjects(By.res(PACKAGE_NAME,selector)),1000);
        if (object2s != null){
            return object2s;
        }
        return null;
    }

    public  void click(String selector,Boolean wait){
        UiObject2 object2 = findElement(selector);
        try {
            object2.click();
        }catch (StaleObjectException stable){
            attemptRetryOnException();
        }catch (NullPointerException nullPoint){
//            mRetryHandler.retry();
            attemptRetryOnException();
        }
    }
    public  void click(String selector){
        click(selector,false);

    }

    public static void attemptRetryOnException(){

    }

}
