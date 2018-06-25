package com.global.mi.uidemo.framework;

import android.os.SystemClock;
import android.util.Log;

import com.global.mi.uidemo.config.ConstDefs;

import org.junit.Before;

import java.util.concurrent.Callable;

public class RetryUtils {

    public static boolean waitCondition(Callable<Boolean> method, int timeoutInMs) {
        long endTime = SystemClock.currentThreadTimeMillis() + timeoutInMs;

        try {
            while (!method.call()) {
                if (SystemClock.currentThreadTimeMillis() > endTime) {
                    return false;
                }
                SystemClock.sleep(200);
            }
            return true;
        } catch (Exception e) {
            Log.i(ConstDefs.TAG, "wait for condition exception: " + e.toString());
            return false;
        }
    }

    public static boolean waitRetry(Callable<Boolean> method){
        waitCondition(method,5000);
        return false;
    }
}
