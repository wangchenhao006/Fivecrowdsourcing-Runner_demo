package com.example.wun.testservlet.Biz;

/**
 * Created by WUN on 2018/2/18.
 */

public interface IRunnerBiz {

        public void login(String username, String password, OnLoginListener loginListener);

}
