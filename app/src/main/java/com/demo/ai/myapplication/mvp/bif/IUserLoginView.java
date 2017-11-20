package com.demo.ai.myapplication.mvp.bif;

import com.demo.ai.myapplication.mvp.bean.User;

/**
 * Created by chen on 2017/11/20.
 * Email：237142681@qq.com
 */

public interface IUserLoginView {
    void showWaitDialog();

    void closeWaitDialog();

    void clearEmail();

    void clearPassword();

    String getEmail();

    String getPassword();

    void JumpToNextActivity(User user);

    void setError(Throwable throwable);

}
