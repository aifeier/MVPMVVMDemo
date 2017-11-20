package com.demo.ai.myapplication.mvp.presenter;

import android.os.Handler;

import com.demo.ai.myapplication.mvp.bean.User;
import com.demo.ai.myapplication.mvp.bif.IUserB;
import com.demo.ai.myapplication.mvp.bif.IUserLoginView;
import com.demo.ai.myapplication.mvp.bif.OnLoginListener;
import com.demo.ai.myapplication.mvp.bif.UserB;


/**
 * Created by chen on 2017/11/20.
 * Email：237142681@qq.com
 */

public class UserLoginPresenter {
    private UserB userB;
    private IUserLoginView iUserLoginView;
    private Handler handler;

    public UserLoginPresenter(IUserLoginView userLoginView) {
        iUserLoginView = userLoginView;
        userB = new UserB();
        handler = new Handler();
    }

    public void login() {
        iUserLoginView.showWaitDialog();
        userB.login(iUserLoginView.getEmail(), iUserLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void onSuccess(final User user) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserLoginView.closeWaitDialog();
                        iUserLoginView.JumpToNextActivity(user);
                    }
                });
            }

            @Override
            public void onFail(final Throwable throwable) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserLoginView.closeWaitDialog();
                        iUserLoginView.clearPassword();
                        iUserLoginView.setError(throwable);
                    }
                });
            }
        });
    }
}
