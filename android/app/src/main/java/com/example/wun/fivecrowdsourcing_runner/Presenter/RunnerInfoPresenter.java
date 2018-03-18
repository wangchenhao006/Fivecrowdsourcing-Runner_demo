package com.example.wun.fivecrowdsourcing_runner.Presenter;


import com.example.wun.fivecrowdsourcing_runner.Bean.Runner;
import com.example.wun.fivecrowdsourcing_runner.DataConfig;
import com.example.wun.fivecrowdsourcing_runner.View.RunnerInfoView;

/**
 * Created by Administrator on 2018/3/7.
 */

public class RunnerInfoPresenter {
    private Runner runner =new Runner();
    public static String  URL=  DataConfig.URL;
    private String servletIP;
    private String servletName="Step1Servlet";
    private RunnerInfoView runnerInfoView;

    public RunnerInfoPresenter(RunnerInfoView runnerInfoView) {
        this.runnerInfoView = runnerInfoView;
    }

    public void sendRunnerInfo(String name, String phone, Runner runner) {
        this.runner.setRunnerId((runner.getRunnerId()));
        this.runner.setName(name);

        this.runner.setPhone(phone);

        runnerInfoView.finishStep1(this.runner);
    }

    public void sendRunnerInfo(String name, String phone, String s2, Runner runner) {
        this.runner.setRunnerId((runner.getRunnerId()));
        this.runner.setName(name);

        this.runner.setPhone(phone);

        runnerInfoView.finishStep1(this.runner);
    }
}
