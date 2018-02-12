package runnerServlet;

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

import runnerServlet.DBUtil;

/**
 * runnerServlet implementation class runnerRegister
 */
@WebServlet(
		description = "runner登录", 
		urlPatterns = { "/runnerRegister" }, 
		initParams = { 
				@WebInitParam(name = "account", value = "wang", description = "帐号"), 
				@WebInitParam(name = "password", value = "", description = "密码")
		})
public class runnerRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public runnerRegister() {
        // TODO Auto-generated constructor stub
    }
    @Override  
    protected void service(HttpServletRequest request, HttpServletResponse response)  
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
    }  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String account;  
	    String password;  
	      
	    BufferedReader reader = request.getReader();  
	    String requestStr = reader.readLine();  
	   // LogUtil.log(requestStr); // 查看一下拿到的参数是个什么样的结构，然后有针对性的解析  
	      System.out.println(requestStr);
	    HashMap<String, String> requestMap = parseStrToMap(requestStr);  
	    account =requestMap.get("account");  
	    password = requestMap.get("password");  
	      
	    response.getWriter().append("你提交的账号为: ").append(account).append("\n密码：").append(password);  */
		 BufferedReader reader = request.getReader();  
		    String requestStr = reader.readLine();  
		String account = request.getParameter("account"); // 从 request 中获取名为 account 的参数的值  
        String password = request.getParameter("password"); // 从 request 中获取名为 password 的参数的值  
        System.out.println("account:" + account + "\npassword:" + password); // 打印出来看一看  
       
	   // LogUtil.log(requestStr); // 查看一下拿到的参数是个什么样的结构，然后有针对性的解析  
	      System.out.println(requestStr);
	      
        String resCode = "";  
        String resMsg = "";  
        String userId = ""; 
        if(account!=null&&password!=null)
		{try {  
			//建立与数据库的连接
	            Connection connect = DBUtil.getConnection();  
	            if(!connect.isClosed()) 
	                System.out.println("Succeeded connecting to the Database!");
	                else System.out.println("Failed connecting to the Database!");
	            Statement statement =  connect.createStatement(); // Statement可以理解为数据库操作实例，对数据库的所有操作都通过它来实现  
	            
	            ResultSet result;  
	              
	            String sqlQuery = "select * from " +DBUtil.TABLE_ACCOUNT  + " where account='" + account + "'";  
	              
	            // 查询类操作返回一个ResultSet集合，没有查到结果时ResultSet的长度为0  
	            result = statement.executeQuery(sqlQuery); // 先查询同样的账号（比如手机号）是否存在  
	            if(result.next()){ // 已存在  
	                resCode = "201";  
	                resMsg = "该账号已注册，请使用此账号直接登录或使用其他账号注册";  
	                userId = "";  
	                
	            } else { // 不存在  
	                String sqlInsertPass = "insert into " + DBUtil.TABLE_ACCOUNT+ "(account,password) values('"+account+"','"+password+"')";  
	                // 更新类操作返回一个int类型的值，代表该操作影响到的行数  
	                int row1 = statement.executeUpdate(sqlInsertPass); // 插入帐号密码  
	                if(row1 == 1){  
	                System.out.println( "插入成功！");
	             
	                  
	                    resCode = "100";  
	                    resMsg = "注册成功";  
	                    
	            } 
	            }
	              
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	           
	        } }
        else { resCode = "202";  
        resMsg = "帐号密码为空"; }
	          
	        HashMap<String, String> map = new HashMap<>();  
	        map.put("resCode", resCode);  
	        map.put("resMsg", resMsg);  
	        map.put("userId", userId);  
	          
	        response.setContentType("text/html;charset=utf-8"); // 设置响应报文的编码格式  
	        PrintWriter pw = response.getWriter(); // 获取 response 的输出流  
	        pw.println(map.toString()); // 通过输出流把业务逻辑的结果输出  
	        pw.flush();  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account;  
	    String password;  
	      
	    BufferedReader reader = request.getReader();  
	    String requestStr = reader.readLine();  
	   // LogUtil.log(requestStr); // 查看一下拿到的参数是个什么样的结构，然后有针对性的解析  
	      System.out.println(requestStr);
	    HashMap<String, String> requestMap = parseStrToMap(requestStr);  
	    account =requestMap.get("account");  
	    password = requestMap.get("password");  
	      
	    response.getWriter().append("你提交的账号为: ").append(account).append("\n密码：").append(password);  
	      
	}
	
	private HashMap<String, String> parseStrToMap(String str) {  
	    HashMap<String, String> resultMap = new HashMap<>();  
	    String[] items = str.split("&");  
	    String[] itemStrs = new String[2];  
	    for (String item : items) {  
	        itemStrs = item.split("=");  
	        resultMap.put(itemStrs[0], itemStrs[1]);  
	    }  
	    return resultMap;  
	}  
}
