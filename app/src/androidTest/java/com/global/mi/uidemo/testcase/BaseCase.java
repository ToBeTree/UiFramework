package com.global.mi.uidemo.testcase;

import android.support.test.InstrumentationRegistry;

import com.global.mi.uidemo.config.ConstDefs;
import com.global.mi.uidemo.framework.AdbUtil;
import com.global.mi.uidemo.framework.InitPage;
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
        AdbUtil.execCmdSilent("adb shell am start -n com.mi.global.shop/.activity.MainTabActivity");
//        AdbUtil.execCmdSilent("adb shell am start -n "+ ConstDefs.PACKAGE_NAME+"/"+ConstDefs.PACKAGE_NAME+".SplashActivity");
    }

}
