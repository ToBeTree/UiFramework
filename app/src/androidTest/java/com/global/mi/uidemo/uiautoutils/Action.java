package com.global.mi.uidemo.uiautoutils;

import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;
import android.util.Log;

import java.util.List;

/**
 * Created by wuyongqiang on 2018/5/29.
 */

public class Action {

    public static ElementActions fd = new ElementActions();

    /**
     * 判断是否有&，如果有代表应该使用findElements。后面跟着的数据是指定list中的具体某个元素
     * wait为true时，需要等待新页面加载，为false时，直接点击
     **/
    public static void click(String selector,Boolean wait){
        UiObject2 object2;
        if(selector.contains("&")){
            Log.i("click",selector);
            int position = Integer.parseInt(selector.split("&")[1]);
            selector = selector.split("&")[0];
            List<UiObject2> object2s = fd.findElements(selector);
            object2 = object2s.get(position);
        }else {
            object2 = fd.findElement(selector);
        }
        if (wait){
            object2.clickAndWait(Until.newWindow(),5000);
        }else{
            object2.click();
        }
    }
    public static void click(String selector){
        click(selector,false);
    }

    public static void clickAndWaitNewWindow(String selector){
        click(selector,true);
    }

    public static void scroll(String selector, int direction){

    }
    public Action aa(){
        return this;
    }
}
