package com.example.wun.testservlet.Biz;
import  com.example.wun.testservlet.Bean.Runner;
import com.example.wun.testservlet.DataConfig;

/**
 * Created by WUN on 2018/2/18.
 */

public class RunnerBiz implements IRunnerBiz {
    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener)
    {
        //为了测试方便，这里使用模拟线程
        //new LoginThread(DataConfig.URL_Login, username, password).start();


        //模拟子线程耗时操作
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("wch".equals(username) && "123".equals(password))
                {
                    Runner user = new Runner();
                    user.setName(username);
                    user.setPassword(password);
                    loginListener.loginSuccess(user);
                } else
                {
                    loginListener.loginFailed();
                }
            }
        }.start();
    }
}
