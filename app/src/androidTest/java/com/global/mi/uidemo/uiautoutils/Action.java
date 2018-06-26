package com.global.mi.uidemo.uiautoutils;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.Direction;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;
import android.util.Log;

import com.global.mi.uidemo.config.ConstDefs;
import com.global.mi.uidemo.framework.LogUtil;

import java.util.List;

/**
 * Created by wuyongqiang on 2018/5/29.
 */

public class Action {

    private Common driver = new Common();

    private static UiDevice mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

    /**
     * 判断是否有&，如果有代表应该使用findElements。后面跟着的数据是指定list中的具体某个元素
     * wait为true时，需要等待新页面加载，为false时，直接点击
     **/
    private void click(UiObject2 object2, boolean wait) {
        if (object2 != null) {
            if (wait) {
                object2.clickAndWait(Until.newWindow(), ConstDefs.WAI_NEW_WINDOW_TIME);
            }else{
                object2.click();
            }
        } else {
            LogUtil.i("UiObject element can not be null");
        }

    }

    public void click(String selector) {
        click(selector, false);
    }

    public void click(String selector, boolean wait) {
//        if (selector.contains(ConstDefs.POSITION_OPERATOR)){
//            int position = Integer.parseInt(selector.split(ConstDefs.POSITION_OPERATOR)[1]);
//            selector = selector.split(ConstDefs.POSITION_OPERATOR)[0];
//        }

        UiObject2 object2 = driver.findElement(selector);
        click(object2, wait);

    }

    public void clickInList(String selector) {
        clickInList(selector, false);
    }

    public void clickInList(String selector, boolean wait) {

        int position = Integer.parseInt(selector.split(ConstDefs.POSITION_OPERATOR)[1]);
        selector = selector.split(ConstDefs.POSITION_OPERATOR)[0];

        UiObject2 object2 = driver.findElements(selector).get(position);
//        UiObject2 object2 = getObject2(selector);
        click(object2, wait);
    }

    public UiObject2 getObject2(String selector) {
        if (selector.contains(ConstDefs.POSITION_OPERATOR)) {
            int position = Integer.parseInt(selector.split(ConstDefs.POSITION_OPERATOR)[1]);
            selector = selector.split(ConstDefs.POSITION_OPERATOR)[0];
            return driver.findElements(selector).get(position);
        } else {
            return driver.findElement(selector);
        }
    }

    public void scrollObject(String selector, Direction direction) {
        UiObject2 object2 = getObject2(selector);
//        percent代表滚动的次数,每次滚动一屏
        object2.scroll(direction, 1f);
    }

    public void scrollObject(String selector, Direction direction, float num) {
        UiObject2 object2 = getObject2(selector);
//        percent代表滚动的次数,每次滚动一屏
        object2.scroll(direction, num);
    }


    public void pressBack() {
        mDevice.pressBack();
    }

}
