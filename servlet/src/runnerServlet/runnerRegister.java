package runnerServlet;
/*
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
*/
import runnerServlet.DBUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

/*
import beans.CommonRequest;
import beans.CommonResponse;
import constants.DBNames;
import encrypt.DecryptUtil;
import encrypt.EncryptUtil;

import util.DatabaseUtil;*/

/**
 * runnerServlet implementation class runnerRegister
 */
@WebServlet(
		description = "runner登录", 
		urlPatterns = { "/runnerRegister" } 
		)
public class runnerRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public runnerRegister() {
        // TODO Auto-generated constructor stub
    }
    @Override  
  /*  protected void service(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        String method = request.getMethod();  
        if ("GET".equals(method)) {  
           System.out.println("请求方法：GET");  
            doGet(request, response);  
        } else if ("POST".equals(method)) {  
            System.out.println("请求方法：POST");  
            doPost(request, response);  
        } else {  
            System.out.println("请求方法分辨失败！");  
        }  
    }  */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("不支持GET方法;");
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
		        
		      
		        // 第一步：获取 客户端 发来的请求，恢复其Json格式——>需要客户端发请求时也封装成Json格式
		        JSONObject object = JSONObject.fromObject(req);
		        System.out.println(object);
		      
		     // requestCode暂时用不上
		     		// 注意下边用到的2个字段名称requestCode、requestParam要和客户端CommonRequest封装时候的名字一致
		     		//String str1 = object.getString("account");
		        
		     		JSONObject requestParam = object.getJSONObject("requestParam");
		     		System.out.println(requestParam.toString());
		     		
		     		String account = requestParam.getString("account"); // 从 request 中获取名为 account 的参数的值  
		            String password = requestParam.getString("password"); // 从 request 中获取名为 password 的参数的值  
		     		
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
		            if(result.next()){ // 已存在  
		            	res.setResult("201", "该账号已注册，请使用此账号直接登录或使用其他账号注册");
		            }		                      
		            else { // 不存在  
		                String sqlInsertPass = "insert into " + DBUtil.TABLE_ACCOUNT+ "(account,password) values('"+account+"','"+password+"')";  
		                // 更新类操作返回一个int类型的值，代表该操作影响到的行数  
		                int row1 = DBUtil.update(sqlInsertPass); // 插入帐号密码  
		                if(row1 == 1){  
		                System.out.println( "插入成功！");
		                res.setResult("100", "注册成功");
		              
		            } 
		            }
		        }
		            catch (SQLException e) {
		            res.setResult("300", "数据库查询错误");
		            e.printStackTrace();
		        }

		        // 第三步：将结果封装成Json格式准备返回给客户端，但实际网络传输时还是传输json的字符串
		        // 和我们之前的String例子一样，只是Json提供了特定的字符串拼接格式
		        String resStr = JSONObject.fromObject(res).toString();
		        System.out.println(resStr);
//		      response.getWriter().append(EncryptUtil.getEDSEncryptStr(resStr)); // 可以对字符串进行加密操作，相应的到了客户端就需要解密
		        response.getWriter().append(resStr).flush(); 
	      
	}
	

}
