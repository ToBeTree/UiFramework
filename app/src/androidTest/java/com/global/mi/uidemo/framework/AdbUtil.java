package com.global.mi.uidemo.framework;

import java.io.IOException;

public class AdbUtil {
    public static String execCmd(String cmd){
        return "";
    }

    public static int execCmdSilent(String cmd){
        int result=-1;

        try {
            Process p = Runtime.getRuntime().exec(cmd);
            result = p.waitFor();
//            result = p.exitValue(); 外部进程没有结束无法获取到退出吗,报错IllegalThreadStateException
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static String
}
