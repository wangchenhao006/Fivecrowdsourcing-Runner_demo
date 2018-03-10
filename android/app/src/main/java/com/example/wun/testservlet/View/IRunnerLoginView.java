package com.example.wun.testservlet.View;
import com.example.wun.testservlet.Bean.Runner;
/**
 * Created by WUN on 2018/2/18.
 */

public interface IRunnerLoginView {

    //获得用户名和密码
        String getUserName();

        String getPassword();


        void clearUserName();

        void clearPassword();

        //login是个耗时操作，我们需要给用户一个友好的提示，一般就是操作ProgressBar
        void showLoading();

        void hideLoading();

        //login成功或失败
        void toMainActivity(Runner runner);

        void showFailedError();

    }
