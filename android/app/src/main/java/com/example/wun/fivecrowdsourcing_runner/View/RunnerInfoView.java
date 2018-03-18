package com.example.wun.fivecrowdsourcing_runner.View;

import com.example.wun.fivecrowdsourcing_runner.Bean.Runner;

/**
 * Created by Administrator on 2018/3/6.
 */

public interface RunnerInfoView {
    //跳转地图
    void gotomap();
    //第一步注册完成
   void finishStep1(Runner runner);
}
