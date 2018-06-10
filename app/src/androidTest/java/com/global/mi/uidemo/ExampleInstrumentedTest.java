package com.global.mi.uidemo;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;
import android.util.Log;

import com.global.mi.uidemo.uiautoutils.FindElement;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private UiDevice mDevice;
    final private String PACKAGE_NAME = "com.mi.global.shop";

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.global.mi.uidemo", appContext.getPackageName());
    }

    @Test
    public void startActivity(){
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
//        FindElement fd = new FindElement();
//        UiObject2 tabs = fd.findElement("icon");
//        tabs.click();
//        mDevice.pressHome();
//
//        Context context = InstrumentationRegistry.getContext();
//        Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.mi.global.shop");
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        context.startActivity(intent);
//        mDevice.wait(Until.hasObject(By.pkg(PACKAGE_NAME).depth(0)), 8000);
//        right_item_image
//        UiObject2 tab = mDevice.findObject(By.res(PACKAGE_NAME,"icon"))    ;
//        tab.click();
//        String pack = InstrumentationRegistry.getTargetContext().getPackageName();
//        List<UiObject2> tabs = mDevice.findObjects(By.res(PACKAGE_NAME,"icon"));
//        System.out.println(tabs.size());
//        tabs.get(3).click();
//
//        UiObject2 login = mDevice.wait(Until.findObject(By.res(PACKAGE_NAME,"usercentral_fragment_listheader_login_btn")),1000);
//        login.click();
//
//        UiObject2 sign = mDevice.wait(Until.findObject(By.res(PACKAGE_NAME,"btn_start_login")),1000);
//        sign.click();
//
//        UiObject2 login_with_uid = mDevice.wait(Until.findObject(By.res(PACKAGE_NAME,"login_with_email_or_id")),1000);
//        login_with_uid.click();
//
//        UiObject2 username = mDevice.wait(Until.findObject(By.res(PACKAGE_NAME,"et_account_name")),1000);
//        username.click();
//        username.setText("267262511");
//        UiObject2 password = mDevice.wait(Until.findObject(By.res(PACKAGE_NAME,"et_account_password")),1000);
//        password.click();
//        password.setText("gg111111");
//        UiObject2 btn_login = mDevice.findObject(By.res(PACKAGE_NAME,"btn_login"));
//        btn_login.click();
//        UiObject a = mDevice.findObject(new UiSelector());
//
//        List<UiObject2> products = mDevice.wait(Until.findObjects(By.res(PACKAGE_NAME,"product_image")),500);
//        Log.i("products" , ""+ products.size());
//        products.get(1).click();

//        UiObject2 cart = mDevice.wait(Until.findObject(By.text("Cart")),3000);
//        cart.click();
        List<UiObject2> buys = mDevice.wait(Until.findObjects(By.clazz("android.view.View").depth(12)),6000);
        Log.i("products buy","" + buys.size()+buys.toString());
        UiObject2 buy = buys.get(3);
//        buy.click();
        UiObject2 buy1 = mDevice.wait(Until.findObject(By.clazz("android.view.View").depth(12)),6000);
        Log.i("products buy","" + buy.toString());
        buy1.click();
//
//        UiObject2 btn_return = mDevice.wait(Until.findObject(By.depth(0)),2000);
//        btn_return.click();
//        UiObject2 unpaid = mDevice.wait(Until.findObject(By.text("Unpaid")),1000);
//        unpaid.click();

//        UiObject2 lotaly = mDevice.wait(Until.findObject(By.res(PACKAGE_NAME,"rl_loyalty")),1000);
//        lotaly.click();
//
//        UiObject2 token = mDevice.wait(Until.findObject(By.depth(18).clazz("android.view.View")),8000);
//        token.click();
////        UiObject2 coupons = mDevice.wait(Until.findObject(By.textContains("Invite")),9000);
////        coupons.click();
//        UiObject2 btn_return = mDevice.wait(Until.findObject(By.res(PACKAGE_NAME,"title_bar_back")),7000);
//        btn_return.click();


    }
}
