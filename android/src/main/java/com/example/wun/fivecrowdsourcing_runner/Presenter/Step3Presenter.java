package com.example.wun.fivecrowdsourcing_runner.Presenter;


import com.example.wun.fivecrowdsourcing_runner.Bean.Runner;
import com.example.wun.fivecrowdsourcing_runner.DataConfig;
import com.example.wun.fivecrowdsourcing_runner.View.Step3View;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/3/9.
 */

public class Step3Presenter {

    private Step3View step3View;
    private Runner runner = new Runner();
    public static String  URL=  DataConfig.URL;
    private String servletName="RunnerInfoServlet";
    private String servletIP;

    public Step3Presenter(Step3View step3View) {
        this.step3View = step3View;
    }

    public void sendImage( String idcardnumber, Runner runner,String filename) {
        this.runner = runner;
        //runner.setName(name);
        runner.setIdCardNumber(idcardnumber);
        runner.setPhotoOfHealCert("images" + "\\" + runner.getRunnerId() + "\\" + filename);
        servletIP=URL+servletName;
        sendRequestWithOkHttp(this.runner,servletIP);
    }

    private void sendRequestWithOkHttp(final Runner runner, String servletIP) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //转换成JSON格式
                    Gson gson = new Gson();
                    String runnerdata = gson.toJson(runner);

                    RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8")
                            , runnerdata);
                    Request request = new Request.Builder().
                            url(servletIP).
                            post(requestBody).
                            build();

                    OkHttpClient client = new OkHttpClient();
                    Response response = client.newCall(request).execute();

                    String jsonData= response.body().string().toString();
                    parseJSONWithJONObject(jsonData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void parseJSONWithJONObject(String jsonData) {
        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            String result=jsonObject.getString("result");
            if(result.equals("success")){
                step3View.finishStep3(runner);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
