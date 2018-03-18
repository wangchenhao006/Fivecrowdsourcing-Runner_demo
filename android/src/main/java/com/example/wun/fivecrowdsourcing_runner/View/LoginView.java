package com.example.wun.fivecrowdsourcing_runner.View;


import com.example.wun.fivecrowdsourcing_runner.Bean.Runner;

/**
 * Created by Administrator on 2018/2/13.
 */

public interface LoginView {
    /**
     * 登陆成功
     */
    void onSuccess(Runner runner);

    void onFailed();
}
