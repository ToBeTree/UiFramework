package com.global.mi.uidemo.framework;

public class UpdateWatcher extends SelectorWatcher {

    public UpdateWatcher(String[] conditions) {
        super(conditions);
    }

    @Override
    public void action() {
        //TODO 点击取消升级按钮,取消弹窗
    }
}
