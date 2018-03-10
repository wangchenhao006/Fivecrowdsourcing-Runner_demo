


package com.example.wun.testservlet.Presenter;
/**
 * Created by WUN on 2018/2/18.
 */

        import android.os.Handler;

        import com.example.wun.testservlet.R;
        import com.example.wun.testservlet.Bean.Runner;
        import  com.example.wun.testservlet.Biz.IRunnerBiz;
        import  com.example.wun.testservlet.Biz.OnLoginListener;
        import  com.example.wun.testservlet.Biz.RunnerBiz;
        import com.example.wun.testservlet.View.IRunnerLoginView;


/**
 * Created by zhy on 15/6/19.
 */
public class RunnerLoginPresenter
        {
    private IRunnerBiz runnerBiz;
    private IRunnerLoginView runnerLoginView;
    private Handler mHandler = new Handler();

    public RunnerLoginPresenter(IRunnerLoginView runnerLoginView)
    {
        this.runnerLoginView = runnerLoginView;
        this.runnerBiz = new RunnerBiz();
    }

    public void login()
    {
        runnerLoginView.showLoading();
        runnerBiz.login(runnerLoginView.getUserName(), runnerLoginView.getPassword(), new OnLoginListener()
        {
            @Override
            public void loginSuccess(final Runner runner)
            {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        runnerLoginView.toMainActivity(runner);
                        runnerLoginView.hideLoading();
                    }
                });

            }

            @Override
            public void loginFailed()
            {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        runnerLoginView.showFailedError();
                        runnerLoginView.hideLoading();
                    }
                });

            }
        });
    }

    public void clear()
    {
        runnerLoginView.clearUserName();
        runnerLoginView.clearPassword();
    }



}