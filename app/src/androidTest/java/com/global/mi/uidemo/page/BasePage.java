package com.global.mi.uidemo.page;

/**
 * Created by wuyongqiang on 2018/5/28.
 */

public class BasePage {

    public final static String DEPTH = "depth";
    public final static String RES = "res";
    public final static String CLAZZ = "clazz";
    public final static String DESC = "desc";
    public final static String TEXT = "text";
    public final static String PKG = "pkg";
    public static String cart;
    public static String mistore;
    public static String products;
    public static String discover;
    public static String user;

    public static String spliceSelector(String type, String value){
        if (RES.equals(type)){
            return type + "#" +value;
        }
        if (DEPTH.equals(type)){
            return type+"#"+value;
        }
        if (type==CLAZZ){
            return type + "#" +value;
        }
        if (type==DESC){

        }
        if (type==PKG){

        }
        if (type==TEXT){

        }

        return null;
    }

    public static String getToastValue(){

        return null;
    }

    public static String getCurrentWindowTitle(){

        return null;
    }
}
