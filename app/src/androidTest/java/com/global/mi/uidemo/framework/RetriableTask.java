package com.global.mi.uidemo.framework;

import android.os.SystemClock;
import android.util.Log;

import com.global.mi.uidemo.config.ConstDefs;

import java.util.concurrent.Callable;

public class RetriableTask<T> implements Callable {

    private int mCurrentRetryTimeLeft;
    private int mTotalRetryTime;
    private int mTimeToWait;
    private Callable<T> mTask;

    public RetriableTask(Callable<T> task){
        this(ConstDefs.TOTALRETRYTIME,ConstDefs.TIMETOWAIT,task);
    }

    public RetriableTask(int totalRetryTime,int timeToWait, Callable<T> task){
        this.mTotalRetryTime = totalRetryTime;
        this.mTimeToWait = timeToWait;
        this.mTask = task;
        this.mCurrentRetryTimeLeft = totalRetryTime;
    }

    @Override
    public T call() throws Exception {
        while(mCurrentRetryTimeLeft<=mTotalRetryTime){
            try {
                return mTask.call();
            }catch (Exception e){
                mCurrentRetryTimeLeft--;
                SystemClock.sleep(mTimeToWait);
                Log.i(ConstDefs.TAG,"start find element");
            }
        }
        return null;
    }
}
