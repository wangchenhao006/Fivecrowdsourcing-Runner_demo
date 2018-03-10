package com.example.wun.testservlet.Biz;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by WUN on 2018/3/4.
 */

public class LoginThread extends Thread{



        String url;
        String account;
        String password;

        public LoginThread() {
        }

        public LoginThread(String url, String account, String password) {
            this.url = url;
            this.account= account;
            this.password = password;
        }

        private void doPost() throws IOException {
        /*将username和password传给Tomcat服务器*/
            url=url+"?account="+account+"&password="+password;
            String param = "?account="+account+"&password="+password;
            try {
                URL httpUrl = new URL(url);
            /*获取网络连接*/
                HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
            /*设置请求方法为GET方法*/
                conn.setRequestMethod("POST");
            /*设置访问超时时间*/

                conn.setConnectTimeout(80000); // 设置连接建立的超时时间
                conn.setReadTimeout(80000); // 设置网络报文收发超时时间

                // 如果是POST方法，需要在第3步获取输入流之前向连接写入POST参数
                DataOutputStream out = new DataOutputStream(conn.getOutputStream()); // 在此之前也可以用connection.getResponseCode()获取返回码，看是否为200

                //请求报文组装
                JSONObject object = new JSONObject();
                object.put("requestParam", param);
                Log.e("JSON",object.toString());
                //String param = "account=wang&password=jie"; // 这里我们先模拟一个参数列表
                out.writeBytes(object.toString());

                BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String str;
                StringBuffer sb=new StringBuffer();
                //读取服务器返回的信息
                while((str=reader.readLine())!=null)
                {
                    sb.append(str);
                }
                //把服务端返回的数据打印出来
                System.out.println("result"+sb.toString());

                JSONObject root = new JSONObject(sb.toString()); // 此处就可以将服务端返回的Json的字符串还原成Json格式的数据
                // 下边就可以根据需求将Json转化合适的数据结构来使用了
                // ... ...自己的业务逻辑
                String resCode = root.getString("resCode");
                String resMsg = root.optString("resMsg");
                System.out.println("resCode:"+resCode+"resMsg:"+resMsg);

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        /*在run中调用doGet*/
        @Override
        public void run() {
            try {
                doPost();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


