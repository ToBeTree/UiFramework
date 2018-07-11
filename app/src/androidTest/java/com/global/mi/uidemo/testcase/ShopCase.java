package com.global.mi.uidemo.testcase;

import android.support.test.runner.AndroidJUnit4;

import com.global.mi.uidemo.config.ConstDefs;
import com.global.mi.uidemo.framework.LogUtil;
import com.global.mi.uidemo.page.BasePage;
import com.global.mi.uidemo.page.MainPage;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by wuyongqiang on 2018/5/29.
 */

@RunWith(AndroidJUnit4.class)
public class ShopCase extends BaseCase{

    @Before
    public void init() throws Exception {
//        InitPage.setAllField(InstrumentationRegistry.getContext());
//        ToastListener.initToastListener(InstrumentationRegistry.getInstrumentation());
    }


    @Test
    public void addCart() throws Exception {
//        LogUtil.i(ConstDefs.TAG,Runtime.getRuntime().exec("adb logcat").waitFor()+"");
//        SystemClock.sleep(5000);
        LogUtil.e(ConstDefs.TAG,"start test");
        MainPage.setScrollViewDown();
//        MainPage.clickProduct(2);
//        BasePage.takeScreenShot("error");
//        BasePage.pressBack();
        MainPage.pressBack();
        BasePage.checkToastValue("Tap Back button again to exit");

//        ProductPage.clickBuyBtn();
//        VersionPage.clickReturnBtn();
    }

}
