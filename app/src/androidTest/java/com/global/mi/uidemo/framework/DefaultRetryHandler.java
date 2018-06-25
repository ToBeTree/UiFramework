package com.global.mi.uidemo.framework;

import android.util.Log;

import com.global.mi.uidemo.config.ConstDefs;
import com.global.mi.uidemo.uiautoutils.ElementActions;

public class DefaultRetryHandler implements RetryHandler {

    private int mCurrentRetryCount = 0;
    private ElementActions mActions;

    public DefaultRetryHandler(ElementActions actions) {
        mActions = actions;
    }

    @Override
    public int getCurrentRetryCount() {
        return mCurrentRetryCount;
    }

    @Override
    public void retry(String selector) {
        //TODO execute retry
        mCurrentRetryCount++;
        if (!hasRetryCount()) {
            try {
                throw new Exception();
            } catch (Exception e) {
                Log.i(ConstDefs.TAG, "retry time is out!");
                e.printStackTrace();
            }
        }

    }

    private boolean hasRetryCount() {
//        return mCurrentRetryCount <= ConstDefs.TotalRetryTime;
        return false;
    }
}
