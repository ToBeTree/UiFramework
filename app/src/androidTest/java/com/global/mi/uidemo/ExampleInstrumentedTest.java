package com.global.mi.uidemo;

import android.app.Instrumentation;
import android.app.Notification;
import android.app.UiAutomation;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.Direction;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;


import com.global.mi.uidemo.config.ConstDefs;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.annotation.Target;
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
    String toastMessage;
    long toastOccurTime;

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.global.mi.uidemo", appContext.getPackageName());
    }

    @Before
    public void startMainActivityFromHomeScreen() {
//        initToastListener();
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Start from the home screen
//        mDevice.pressHome();

        // Wait for launcher
//        final String launcherPackage = getLauncherPackageName();
//        assertThat(launcherPackage, notNullValue());
//        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), LAUNCH_TIMEOUT);

        // Launch the blueprint app
        Context context = InstrumentationRegistry.getContext();
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(ConstDefs.PACKAGE_NAME);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);    // Clear out any previous instances
//        context.startActivity(intent);

        // Wait for the app to appear
        mDevice.wait(Until.hasObject(By.pkg(ConstDefs.PACKAGE_NAME).depth(0)), 5000);
    }

    @Test
    public void startActivity(){
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.pressBack();
        SystemClock.sleep(200);
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();

        instrumentation.getUiAutomation().setOnAccessibilityEventListener(new UiAutomation.OnAccessibilityEventListener() {
            @Override
            public void onAccessibilityEvent(AccessibilityEvent event) {
                //排除非通知事件
                if (event.getEventType() != AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED){
                    return;
                }
                Parcelable parcelable = event.getParcelableData();

                //如果排除下拉消息,则为其他通知消息,包括Toast
                if (!(parcelable instanceof Notification)){
                    toastMessage = (String) event.getText().get(0);
                    toastOccurTime = event.getEventTime();
                    Log.i(ConstDefs.TAG,toastMessage);
                }else {
                    Log.i(ConstDefs.TAG,event.getParcelableData().toString());
                }
            }
        });

        final long startTimeMillis = SystemClock.uptimeMillis();
        boolean isSuccessfulCatchToast;
        while (true) {
            long currentTimeMillis = SystemClock.uptimeMillis();
            long elapsedTimeMillis = currentTimeMillis - startTimeMillis;
            if (elapsedTimeMillis > 5000L) {
                Log.i("AAA", "超过5s未能捕获到预期Toast!");
                isSuccessfulCatchToast = false;
                break;
            }
            if (toastOccurTime > startTimeMillis) {
                isSuccessfulCatchToast = "密码不正确".equals(toastMessage);
                break;
            }
        }
    }
    @Test
    public void test(){
//        UiObject2 object2 = mDevice.findObject(By.res(ConstDefs.PACKAGE_NAME,"list"));
        UiObject2 object2 = mDevice.findObject(By.res("android:id/list"));
        object2.scroll(Direction.DOWN,20f);
    }
}
