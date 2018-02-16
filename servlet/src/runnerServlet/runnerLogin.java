package runnerServlet;

import java.io.PrintWriter;
import java.io.Reader;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.sf.json.JSONArray;   
import net.sf.json.JSONObject; 

/**
 * runnerServlet implementation class runnerLogin
 */
@WebServlet(
		description = "runner登录", 
		urlPatterns = { "/runnerLogin" }, 
		initParams = { 
				@WebInitParam(name = "account", value = "wang", description = "帐号"), 
				@WebInitParam(name = "password", value = "", description = "密码")
		})
public class runnerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public runnerLogin() {
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// request.setCharacterEncoding("utf-8");  //设置请求报文格式
		 
		//doPost(request,response);//跳转到dopost测试
		 //String account = request.getParameter("account"); // 从 request 中获取名为 account 的参数的值 
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//用来测试，打印账户名
		/* response.setContentType("text/html;charset=utf-8"); // 设置响应报文的编码格式  
		PrintWriter pw =response.getWriter();
		pw.println("getAccount："+account);
		pw.flush();*/
		String code = "";  
        String message = "";  
        
        
		  String account = request.getParameter("account"); // 从 request 中获取名为 account 的参数的值  
		  String password = request.getParameter("password"); // 从 request 中获取名为 password 的参数的值  
		    System.out.println("account:" + account + "\npassword:" + password); // 打印出来看一看  
		  
		    /*String result = "";  
		    if("王x".equals(account)   
		            && "杰x".equals(password)){ // 添加中文  
		        result = "Login Success!" + "成功了！"; // 响应也加点中文  
		    }else {  
		        result = "Sorry Account or password error." + "有点问题！"; // 响应也加点中文  
		    }  
		    /* 这里我们只是模拟了一个最简单的业务逻辑，当然，你的实际业务可以相当复杂 */  
		      
		    /*PrintWriter pw = response.getWriter(); // 获取 response 的输出流  
		    pw.println(result); // 通过输出流把业务逻辑的结果输出  
		    pw.flush(); */
		    
		    
	        try {  
	        	 Connection connect = DBUtil.getConnection(); 
	        	if(!connect.isClosed()) 
	                System.out.println("Succeeded connecting to the Database!");
	                else System.out.println("Failed connecting to the Database!");
	        	
	      
	            Statement statement =  connect.createStatement(); // Statement可以理解为数据库操作实例，对数据库的所有操作都通过它来实现  
	            
	            String sql = "select account from " + DBUtil.TABLE_ACCOUNT + " where account='" + account  
	                    + "' and password='" + password + "'";  
	            System.out.println(sql);  
	            ResultSet result = DBUtil.query(sql);  
	            if (result.next()) { // 能查到该账号，说明已经注册过了  
	                code = "200";  
	                message = "登陆成功";  
	            } else {  
	  
	                code = "100";  
	                message = "登录失败，密码不匹配或账号未注册";  
	            }  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	        response.setContentType("text/html;charset=utf-8"); // 设置响应报文的编码格式  
	        response.getWriter().append("code:").append(code).append(";message:").append(message);  
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        StringBuilder sb = new StringBuilder();
        BufferedReader br = request.getReader();;

        String str = null;

        // retrieve JOSNArray send to Servlet
        while ((str = br.readLine()) != null) {
            sb.append(str);
        }
        if(sb.equals(null))
        	System.out.println("BufferedReader : NULL");
        else System.out.println("BufferedReader : NOT NULL");
        
        String req = sb.toString();
        //String req = "{\"requestParam\":{\"password\":\"123\", \"account\":\"abc\"}}";
        //System.out.println(req);
        
        JSONObject string_to_json = JSONObject.fromObject("{\"data\": {\"pages\": [ {\"comment\": \"just for test\"},{\"comment\": \"just for test\"}],\"total_count\": 2 },\"errcode\": 0}");
        System.out.println(string_to_json);
        JSONObject json_to_data = string_to_json.getJSONObject("data");
        System.out.println(json_to_data.toString());
        // 第一步：获取 客户端 发来的请求，恢复其Json格式——>需要客户端发请求时也封装成Json格式
        JSONObject object = JSONObject.fromObject(req);
        System.out.println(object);
      
     // requestCode暂时用不上
     		// 注意下边用到的2个字段名称requestCode、requestParam要和客户端CommonRequest封装时候的名字一致
     		//String str1 = object.getString("account");
        
     		JSONObject requestParam = object.getJSONObject("requestParam");
     		System.out.println(requestParam.toString());
     		
        // 第二步：将Json转化为别的数据结构方便使用或者直接使用（此处直接使用），进行业务处理，生成结果
        // 拼接SQL查询语句
        String sql = String.format("SELECT * FROM %s WHERE account='%s'", 
                DBUtil.TABLE_ACCOUNT, 
                requestParam.getString("account"));
        System.out.println(sql);

        // 自定义的结果信息类
        commonResponse res = new commonResponse();
        try {
            ResultSet result = DBUtil.query(sql); // 数据库查询操作
            if (result.next()) {
                if (result.getString("password").equals(requestParam.getString("password"))) {
                    res.setResult("0", "登陆成功");
                    res.getProperty().put("user_Id", result.getString("user_id"));
                } else {
                    res.setResult("100", "登录失败，登录密码错误");
                }
            } else {
                res.setResult("200", "该登陆账号未注册");
            }
        } catch (SQLException e) {
            res.setResult("300", "数据库查询错误");
            e.printStackTrace();
        }

        // 第三步：将结果封装成Json格式准备返回给客户端，但实际网络传输时还是传输json的字符串
        // 和我们之前的String例子一样，只是Json提供了特定的字符串拼接格式
        String resStr = JSONObject.fromObject(res).toString();
        System.out.println(resStr);
//      response.getWriter().append(EncryptUtil.getEDSEncryptStr(resStr)); // 可以对字符串进行加密操作，相应的到了客户端就需要解密
        response.getWriter().append(resStr).flush();
    }

}