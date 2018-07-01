package com.global.mi.uidemo.framework;

import android.app.Instrumentation;
import android.app.Notification;
import android.app.UiAutomation;
import android.os.Build;
import android.os.Parcelable;
import android.service.notification.NotificationListenerService;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

import com.global.mi.uidemo.config.ConstDefs;

public class ToastListener {

//        public static Instrumentation instrumentation;
        public static String toastMessage;
        public static long toastOccurTime;
        public static UiAutomation uiAutomation;

        public static void initToastListener(Instrumentation instrumentation) throws NoSuchFieldException, IllegalAccessException {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                Log.i(ConstDefs.TAG,"Android Version error");
            }
//            instrumentation = InstrumentationRegistry.getInstrumentation();
//            uiAutomation = (UiAutomation) UiDevice.class.getDeclaredField("mUiAutomationBridge").get(null);

            instrumentation.getUiAutomation().setOnAccessibilityEventListener(new UiAutomation.OnAccessibilityEventListener() {
                @Override
                public void onAccessibilityEvent(AccessibilityEvent event) {
                    //排除非通知事件
                    if (event.getEventType() != AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED){
                        return;
                    }
                    Parcelable parcelable = event.getParcelableData();

                    //获取消息来源
                    String sourcePackageName = (String) event.getPackageName();
                    //如果排除下拉消息,则为其他通知消息,包括Toast
                    if (!(parcelable instanceof Notification)){
                        toastMessage = (String) event.getText().get(0);
                        toastOccurTime = event.getEventTime();
                        LogUtil.i(ConstDefs.TAG,"Last Toast Message: "+toastMessage +"[Time: "+toastOccurTime+",Source: "+sourcePackageName +"]");

                    }else {
                        LogUtil.i(ConstDefs.TAG,event.getParcelableData().toString());
                    }
                }
            });
        }

        public static String getToastMessage(){
            return toastMessage;
        }
}
