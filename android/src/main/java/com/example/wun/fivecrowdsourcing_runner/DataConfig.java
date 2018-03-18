package com.example.wun.fivecrowdsourcing_runner;

/**
 * Created by WUN on 2018/2/12.
 */


public class DataConfig {
    //public static String URL = "http://192.168.1.10:8080/runnerTomcat/"; // IP地址请改为你自己的IP
    //public static String URL = "http://192.168.1.10:8080/FiveCrowdsourcing-Server/";
    //public static final String  URL="http://192.168.155.1:8080/FiveCrowdsourcing-Server/";//无闪讯
   // public static final String  URL="http://180.163.32.172:8080/FiveCrowdsourcing-Server/";
    //
   // public static final String  URL="http://101.227.139.187:8080/FiveCrowdsourcing-Server/";

    public static final String  URL="http://172.22.121.113:8080/FiveCrowdsourcing-Server/";//闪讯
    //public static String URL = "http://192.168.1.10:8080/MyWorld_Service/";
    //public static String URL_Register = URL + "runnerRegister";
    public static String URL_Register = URL + "runnerRegister";
    //public static String URL_Login = URL + "runnerLogin";

    public static String URL_Login = "RunnerLoginServlet";
    //public static String URL_Login = URL + "LoginServlet";

    public static String URL_UploadImage = "RunnerUploadImage";
}
