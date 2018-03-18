package com.example.wun.fivecrowdsourcing_runner.Presenter;


import android.util.Log;

import com.example.wun.fivecrowdsourcing_runner.Activity.LoginActivity;
import com.example.wun.fivecrowdsourcing_runner.Bean.Runner;
import com.example.wun.fivecrowdsourcing_runner.DataConfig;
import com.example.wun.fivecrowdsourcing_runner.View.LoginView;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/2/13.
 */

public class LoginPresenter {
    private String servletName= DataConfig.URL_Login;
    private String servletIP;
    private String result;
    private String jsonData;
    private LoginView loginView;//loginView接口

    private Runner runner =new Runner();

    public LoginPresenter(LoginActivity loginView) {
        this.loginView = loginView;
    }


    public void Login(String phone,String password,String url){
//        //特殊通道，当服务器不行时直接登陆
        if(DataConfig.debugFlag==true) {
            runner.setName("wch");
            runner.setPhone("177740");
            loginView.onSuccess(runner);
        }
       servletIP=url+servletName;
       Log.v("servlet",servletIP);
       Log.v("phone",phone);
        Log.v("ppassword",password);
      sendRequestWithOkHttp(servletIP,phone,password);
    }

    private void sendRequestWithOkHttp(final String servletIP, final String phone,final String password) {
        try {
            RequestBody requestBody = new FormBody.Builder().
                    add("phone", phone).add("password", password).build();
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().
                    url(servletIP).
                    post(requestBody).
                    build();
            Log.v("request",request.toString());
            Response response = client.newCall(request).execute();
            jsonData = response.body().string().toString();
            Log.v("jsonData",jsonData);
            parseJSONWithJONObject(jsonData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void parseJSONWithJONObject(String jsonData) {
        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            result=jsonObject.getString("result");
            Log.v("result",result);
            if(result.equals("success")){
                runner.setPhone(jsonObject .getString("phone"));
                runner.setName(jsonObject . getString("name"));
               // runner.setRunnerId(jsonObject.getLong("merchantid"));//这里用的商家的登录，所以名称未改
                runner.setRunnerId(jsonObject.getLong("runnerid"));
                Log.v("login return runnerid",runner.getRunnerId().toString());
                loginView.onSuccess(runner);
            }else
                loginView.onFailed();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
