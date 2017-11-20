package com.demo.ai.myapplication.mvp.bif;

import com.demo.ai.myapplication.mvp.bean.User;

/**
 * Created by chen on 2017/11/20.
 * Email：237142681@qq.com
 */

public class UserB implements IUserB {

    @Override
    public void login(final String email, final String password, final OnLoginListener loginListener) {
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("cwf".equals(email) && "123456".equals(password)) {
                    User user = new User();
                    user.name = "cwf";
                    user.password = "123456";
                    loginListener.onSuccess(user);
                } else {
                    loginListener.onFail(new Throwable("用户名或密码错误"));
                }
            }
        }.start();
    }
}
