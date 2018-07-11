package com.global.mi.uidemo.suite;


import com.global.mi.uidemo.testcase.LoginCase;
import com.global.mi.uidemo.testcase.ShopCase;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ShopCase.class, LoginCase.class})
public class ShopSuite {
    public void start(){

    }
}
