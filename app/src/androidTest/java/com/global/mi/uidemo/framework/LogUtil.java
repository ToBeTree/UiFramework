package com.global.mi.uidemo.framework;

import android.os.Environment;
import android.os.SystemClock;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;

import de.mindpipe.android.logging.log4j.LogConfigurator;
public class LogUtil {
    private static final Logger logger = Logger.getLogger(LogUtil.class);
    private final static int level = 0;


    public static void setShow_log(boolean show_log) {
        LogUtil.show_log = show_log;
    }

    private static boolean show_log = true;



    static {
//        PropertyConfigurator.configure("log4j.properties");
        new LogUtil().initConfigure();
    }

    LogUtil(){
        //TODO
        initConfigure();
    }

    private void initConfigure(){
        LogConfigurator configurator = new LogConfigurator();

        //获取当前时间,格式:yyyy-MM-dd_HH_mm_ss
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
        Date time = new Date(SystemClock.currentThreadTimeMillis());
        format.format(time);
        //日志文件路径地址:SD卡下uiTest文件夹logs文件夹下
        String fileName = Environment.getExternalStorageDirectory()
                + File.separator + "uiTest" + File.separator + "logs"
                + File.separator  + "test.log";
        //设置文件名
        configurator.setFileName(fileName);
        //设置root日志输出级别 默认为DEBUG
        configurator.setRootLevel(Level.DEBUG);
        // 设置日志输出级别
        configurator.setLevel("org.apache", Level.INFO);
        //设置 输出到日志文件的文字格式 默认 %d %-5p [%c{2}]-[%L] %m%n
        configurator.setFilePattern("%-d{yyyy-MM-dd HH:mm:ss}  [ %t:%r ] - [ %p ]  %m%n");
        //设置输出到控制台的文字格式 默认%m%n
        configurator.setLogCatPattern("%-d{yyyy-MM-dd HH:mm:ss}  [ %t:%r ] - [ %p ]  %m%n");
        //设置总文件大小
        configurator.setMaxFileSize(1024 * 1024 * 5);
        //设置最大产生的文件个数
        configurator.setMaxBackupSize(1);
        //设置所有消息是否被立刻输出 默认为true,false 不输出
        configurator.setImmediateFlush(true);
        //是否本地控制台打印输出 默认为true,false不输出
        configurator.setUseLogCatAppender(true);
        //设置是否启用文件附加,默认为true.false为覆盖文件
        configurator.setUseFileAppender(true);
        //设置是否重置配置文件，默认为true
        configurator.setResetConfiguration(true);
        //是否显示内部初始化日志,默认为false
        configurator.setInternalDebugging(false);

        configurator.configure();
    }

    public static void v(String message) {
        if (show_log){
            logger.info(message);
        }
    }

    public static void d(String message) {

    }

    public static void i(String message) {
        if (show_log){
            logger.info(message);
        }
    }

    public static void w(String message) {

    }

    public static void e(String message) {

    }

    public static void a(String message) {

    }

}
