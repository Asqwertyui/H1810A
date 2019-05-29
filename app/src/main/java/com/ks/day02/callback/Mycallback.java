package com.ks.day02.callback;

import com.ks.day02.bean.Bean;

/**
 * Created by F0519 on 2019/5/29.
 */

public interface Mycallback {
    void OnSuccess(Bean bean);
    void OnFail(String msg);
}
