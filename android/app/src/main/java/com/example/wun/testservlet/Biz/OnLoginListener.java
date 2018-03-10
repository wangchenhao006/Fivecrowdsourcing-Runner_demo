package com.example.wun.testservlet.Biz;
import  com.example.wun.testservlet.Bean.Runner;
/**
 * Created by WUN on 2018/2/18.
 */

public interface OnLoginListener {
    void loginSuccess(Runner runner);

    void loginFailed();
}
