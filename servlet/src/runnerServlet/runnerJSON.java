package runnerServlet;

import java.io.PrintWriter;
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

import net.sf.json.JSONObject;

@WebServlet(
		description = "runnerJSON", 
		urlPatterns = { "/runnerJSON" }
		)
public class runnerJSON extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public runnerJSON() {
		super();
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BufferedReader reader = request.getReader();  
		    String requestStr = reader.readLine();  
		   // LogUtil.log(requestStr); // 查看一下拿到的参数是个什么样的结构，然后有针对性的解析  
		      System.out.println(requestStr);
		   /* HashMap<String, String> requestMap = parseStrToMap(requestStr);  
		   String account =requestMap.get("account");  
		   String password = requestMap.get("password");  
		      
		    response.getWriter().append("你提交的账号为: ").append(account).append("\n密码：").append(password);  
		   
		
		/* BufferedReader read = request.getReader();
	        StringBuilder sb = new StringBuilder();
	        String line = null;
	        while ((line = read.readLine()) != null) {
	            sb.append(line);
	            System.out.println(line);
	        }
	        System.out.println(sb);
	        String req = sb.toString();
	        System.out.println(req);*/

	        // 第一步：获取 客户端 发来的请求，恢复其Json格式——>需要客户端发请求时也封装成Json格式
	        /*JSONObject object = JSONObject.fromObject(req);

	        // 第二步：将Json转化为别的数据结构方便使用或者直接使用（此处直接使用），进行业务处理，生成结果
	        // 拼接SQL查询语句
	        String sql = String.format("SELECT * FROM %s WHERE account='%s'", 
	                DBNames.Table_Account, 
	                object.getString("name"));
	        System.out.println(sql);

	        // 自定义的结果信息类
	        CommonResponse res = new CommonResponse();
	        try {
	            ResultSet result = DatabaseUtil.query(sql); // 数据库查询操作
	            if (result.next()) {
	                if (result.getString("password").equals(object.getString("password"))) {
	                    res.setResult("0", "登陆成功");
	                    res.getProperty().put("custId", result.getString("_id"));
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
//	      response.getWriter().append(EncryptUtil.getEDSEncryptStr(resStr)); // 可以对字符串进行加密操作，相应的到了客户端就需要解密
	        response.getWriter().append(resStr).flush();*/
	    }


}
