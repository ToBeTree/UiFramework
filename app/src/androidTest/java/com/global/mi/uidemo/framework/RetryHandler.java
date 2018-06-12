package com.global.mi.uidemo.framework;

public interface RetryHandler {


    int getCurrentRetryCount();

    void retry(String selector);
}
