package com.example.wun.fivecrowdsourcing_runner.Presenter;


import com.example.wun.fivecrowdsourcing_runner.Bean.Runner;
import com.example.wun.fivecrowdsourcing_runner.DataConfig;
import com.example.wun.fivecrowdsourcing_runner.View.Step2View;

/**
 * Created by Administrator on 2018/3/9.
 */

public class Step2Presenter {
    private Step2View step2View;
    private Runner runner = new Runner();
    public static String  URL=  DataConfig.URL;
    private String servletName="Step2Servlet";
    private String servletIP;

    public Step2Presenter(Step2View step2View) {
        this.step2View = step2View;
    }

    /*
    *@param inhand 身份证正面
    * param oppo 身份证背面
     */
    public void sendImage(String inhand,String oppo,  Runner runner) {
        this.runner = runner;
        //this.runner.setPhotoOfHealCert("images" + "\\" + runner.getRunnerId() + "\\" + healcertphoto);
        this.runner.setPhotoOfIdCardInhand("images" + "\\" + runner.getRunnerId() + "\\" + inhand);
        this.runner.setPhotoOfIdCardOppo("images" + "\\" + runner.getRunnerId()+"\\"+oppo);
        step2View.finishStep2(runner);
    }
}
