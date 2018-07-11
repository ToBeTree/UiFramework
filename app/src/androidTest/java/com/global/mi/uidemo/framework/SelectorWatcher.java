package com.global.mi.uidemo.framework;

import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiWatcher;

import com.global.mi.uidemo.uiautoutils.Action;

public abstract class SelectorWatcher implements UiWatcher {

    private String[] conditions = null;
    private Action elementAction = new Action();


    public SelectorWatcher(String[] conditions){
            this.conditions = conditions;
    }

    @Override
    public boolean checkForCondition() {
        //监听意外弹窗
        for (String condition:conditions){
            if(condition!=null){
                UiObject2 object2 = elementAction.getObject2(condition);
                if(object2==null){
                    return false;
                }
            }
        }
        action();
        return true;
    }

    //监听到弹窗后执行action操作
    public abstract void action();

}
