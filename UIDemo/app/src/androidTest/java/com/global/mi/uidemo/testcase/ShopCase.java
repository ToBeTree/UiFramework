package com.global.mi.uidemo.testcase;

import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.Until;

import com.global.mi.uidemo.page.MainPage;
import com.global.mi.uidemo.page.ProductPage;
import com.global.mi.uidemo.page.VersionPage;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by wuyongqiang on 2018/5/29.
 */

@RunWith(AndroidJUnit4.class)
public class ShopCase {

    @Test
    public void addCart(){
        MainPage.clickProduct(2);
//        Until.newWindow();

        ProductPage.clickBuyBtn();
        VersionPage.clickReturnBtn();
    }

}
