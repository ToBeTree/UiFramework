package com.global.mi.uidemo.testcase;

import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.util.Log;

import com.global.mi.uidemo.config.ConstDefs;
import com.global.mi.uidemo.framework.AdbUtil;
import com.global.mi.uidemo.framework.InitPage;
import com.global.mi.uidemo.framework.LogUtil;
import com.global.mi.uidemo.framework.ToastListener;

import org.junit.Before;
import org.junit.BeforeClass;

public class BaseCase {

    @BeforeClass
    public static void initEnv() throws Exception {
        InitPage.setAllField(InstrumentationRegistry.getContext());
        ToastListener.initToastListener(InstrumentationRegistry.getInstrumentation());
    }

    @Before
    public void startApp(){
        LogUtil.e(ConstDefs.TAG,"Before");
//        LogUtil.d(ConstDefs.TAG,AdbUtil.checkAppExists(ConstDefs.PACKAGE_NAME)+"");
//        AdbUtil.startPackage();
        AdbUtil.execCmdSilent("adb shell am start -n com.mi.global.shop/.activity.MainTabActivity");
    }

}
