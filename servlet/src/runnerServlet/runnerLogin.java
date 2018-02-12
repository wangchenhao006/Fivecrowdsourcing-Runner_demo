package runnerServlet;

import java.io.PrintWriter;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		 request.setCharacterEncoding("utf-8");  //设置请求报文格式
		 response.setContentType("text/html;charset=utf-8"); // 设置响应报文的编码格式  
		 
		String account = request.getParameter("account"); // 从 request 中获取名为 account 的参数的值 
		String password = request.getParameter("password"); // 从 request 中获取名为password 的参数的值 
		
		System.out.println("account:" + account + "\npassword:" + password); // 打印出来看一看 
		
		
		PrintWriter pw =response.getWriter();
		pw.println("postAccount："+account+" postPassword:"+password);
		pw.flush();
	}

}
