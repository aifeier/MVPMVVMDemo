package com.demo.ai.myapplication.mvp.bif;

/**
 * Created by chen on 2017/11/20.
 * Email：237142681@qq.com
 */

public interface IUserB {
    public void login(String email,String password,OnLoginListener loginListener);
}
