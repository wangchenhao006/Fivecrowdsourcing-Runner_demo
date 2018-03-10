package com.example.wun.testservlet;

import java.io.BufferedInputStream;
import java.io.*;
import java.net.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import  android.os.*;
import android.view.View;
import android.view.*;
import android.widget.*;
import android.widget.Button;

import  android.util.Log;

import  org.json.*;

public class MainActivity extends AppCompatActivity  {

    private EditText etAccount;
    private EditText etPassword;
    private TextView tvResult;

    public HashMap<String, String> requestParam =new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAccount = (EditText) findViewById(R.id.et_account);
        etPassword = (EditText) findViewById(R.id.et_password);
        tvResult = (TextView) findViewById(R.id.tv_result);

        Button btnRegister = (Button) findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isEmpty(etAccount.getText().toString())
                        && !isEmpty(etPassword.getText().toString())) {
                    Log.e("Wang", "都不空");
                    register(etAccount.getText().toString(), etPassword.getText().toString());
                } else {
                    Toast.makeText(MainActivity.this, "账号、密码都不能为空！", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isEmpty(etAccount.getText().toString())
                        && !isEmpty(etPassword.getText().toString())) {
                    Log.e("Wang", "都不空");
                    login(etAccount.getText().toString(), etPassword.getText().toString());
                } else {
                    Toast.makeText(MainActivity.this, "账号、密码都不能为空！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static boolean isEmpty(String str) {
        if (str == null || "null".equals(str) || str.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    private void register(String account, String password) {
        String registerUrlStr = DataConfig.URL_Register + "?account=" + account + "&password=" + password;
        Log.e("register Input:",account+" "+password);
        requestParam.put("password",password);
        requestParam.put("account",account);

        new MyAsyncTask(tvResult,requestParam).execute(registerUrlStr);
    }

    private void login(String account, String password) {
        String loginUrlStr = DataConfig.URL_Login + "?account=" + account + "&password=" + password;
        Log.e("login Input",account+" "+password);
        requestParam.put("password",password);
        requestParam.put("account",account);

        new MyAsyncTask(tvResult,requestParam).execute(loginUrlStr);
    }

    /**
     * AsyncTask类的三个泛型参数：
     * （1）Param 在执行AsyncTask是需要传入的参数，可用于后台任务中使用
     * （2）后台任务执行过程中，如果需要在UI上先是当前任务进度，则使用这里指定的泛型作为进度单位
     * （3）任务执行完毕后，如果需要对结果进行返回，则这里指定返回的数据类型
     */
    public static class MyAsyncTask extends AsyncTask<String, Integer, String> {

        private TextView tv; // 举例一个UI元素，后边会用到
        HashMap<String,String> requestParam;
        private HashMap<String, String> propertyMap;

        public MyAsyncTask(TextView v,HashMap<String,String> requestParam) {
            tv = v;
            this.requestParam=requestParam;
        }

        @Override
        protected void onPreExecute() {
            Log.w("Wang", "task onPreExecute()");
        }

        /**
         * @param params 这里的params是一个数组，即AsyncTask在激活运行是调用execute()方法传入的参数
         */
        @Override
        protected String doInBackground(String... params) {
            Log.w("Wang", "task doInBackground()");
            HttpURLConnection connection = null;
            StringBuilder response = new StringBuilder();
            try {
                URL url = new URL(params[0]); // 声明一个URL,注意如果用百度首页实验，请使用https开头，否则获取不到返回报文
               System.out.println("params 0 :"+params[0]);

                connection = (HttpURLConnection) url.openConnection(); // 打开该URL连接

                connection.setRequestMethod("POST"); // 设置请求方法，“POST或GET”，我们这里用GET，在说到POST的时候再用POST
                connection.setConnectTimeout(80000); // 设置连接建立的超时时间
                connection.setReadTimeout(80000); // 设置网络报文收发超时时间

                // 如果是POST方法，需要在第3步获取输入流之前向连接写入POST参数
                DataOutputStream out = new DataOutputStream(connection.getOutputStream()); // 在此之前也可以用connection.getResponseCode()获取返回码，看是否为200

                //请求报文组装
                JSONObject object = new JSONObject();
                object.put("requestParam", requestParam);
                Log.e("JSON",object.toString());
                    //String param = "account=wang&password=jie"; // 这里我们先模拟一个参数列表
                out.writeBytes(object.toString());

                InputStream in = connection.getInputStream();  // 通过连接的输入流获取下发报文，然后就是Java的流处理
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return response.toString(); // 这里返回的结果就作为onPostExecute方法的入参
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            // 如果在doInBackground方法，那么就会立刻执行本方法
            // 本方法在UI线程中执行，可以更新UI元素，典型的就是更新进度条进度，一般是在下载时候使用
        }

        /**
         * 运行在UI线程中，所以可以直接操作UI元素
         * @param
         */
        @Override
        protected void onPostExecute(String result) {
            if (!"".equals(result)) {

                //LogUtil.logResponse(result); // 日志输出原始应答报文
                System.out.println(result);

                try {
                    JSONObject root = new JSONObject(result); // 此处就可以将服务端返回的Json的字符串还原成Json格式的数据
                    // 下边就可以根据需求将Json转化合适的数据结构来使用了
                    // ... ...自己的业务逻辑
                    String resCode = root.getString("resCode");
                    String resMsg = root.optString("resMsg");
                    System.out.println("resCode:"+resCode+"resMsg:"+resMsg);
                    JSONObject property = root.optJSONObject("property");

                    if (property != null) {
                        parseProperty(property,propertyMap);
                    }




                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("Wang", "结果为空！");
            }
        }
        /**
         * 简单信息部分的解析到
         *
         * @param property  信息部分
         * @param targetMap 解析后保存目标
         */
        private void parseProperty(JSONObject property, HashMap<String, String> targetMap) {
            Iterator<?> it = property.keys();
            while (it.hasNext()) {
                String key = it.next().toString();
                Object value = property.opt(key);
                targetMap.put(key, value.toString());
                System.out.println("key:"+key+"value:"+value);
            }
        }

    }
}