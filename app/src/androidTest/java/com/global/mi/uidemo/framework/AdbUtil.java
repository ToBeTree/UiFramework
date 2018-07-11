package com.global.mi.uidemo.framework;

import com.global.mi.uidemo.config.ConstDefs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AdbUtil {

    /**
     * 内部类 用来保存命令行执行的结果
     */
    private static class ExecResult {
        int resultCode;
        String resultContent;

        ExecResult(int resultCode, String resultContent) {
            this.resultCode = resultCode;
            this.resultContent = resultContent;
        }
    }

    public static String execCmd(String cmd) {
        return "";
    }

    public static ExecResult execCmdSilent(String cmd) {
        int code = -1;
        String content = "";
        String error;
        Process p = null;

        try {
            p = Runtime.getRuntime().exec(cmd);
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stderrReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            content = reader.readLine();
            while (content != null) {
                content = reader.readLine();
            }
            LogUtil.e(ConstDefs.TAG,"content"+content);
            while((error=stderrReader.readLine())!=null){
//                error = reader.readLine();
            }
            LogUtil.e(ConstDefs.TAG,"error"+error);

            code = p.waitFor();
//            result = p.exitValue(); 外部进程没有结束无法获取到退出吗,报错IllegalThreadStateException
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            assert p != null;
            p.destroy();
        }
        return new ExecResult(code, content);
    }

    public static void installAPP(String packageName) {

    }

    public static void unInstallApp(String packageName) {

    }

    public static void startPackage() {
        execCmdSilent("adb shell am start -n com.mi.global.shop/.activity.MainTabActivity");
    }

    public static boolean checkAppExists(String packageName) {
        ExecResult result = execCmdSilent("adb shell  pm list packages | " + packageName);
        LogUtil.i(ConstDefs.TAG, result.resultContent);
        return !"".equals(result.resultContent);
    }

    public static boolean checkWritePermission() {
        return false;
    }

    public static void setWritePermission() {

    }

}
