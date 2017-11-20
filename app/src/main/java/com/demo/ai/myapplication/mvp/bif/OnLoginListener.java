package com.demo.ai.myapplication.mvp.bif;

import com.demo.ai.myapplication.mvp.bean.User;

/**
 * Created by chen on 2017/11/20.
 * Email：237142681@qq.com
 */

public interface OnLoginListener {
    public void onSuccess(User user);

    public void onFail(Throwable throwable);
}
