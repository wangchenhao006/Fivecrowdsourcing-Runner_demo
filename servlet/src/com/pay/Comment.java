package com.pay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.dao.CommentDao;
import com.dao.OrderDao;
import com.entity.Deliveryorder;
import com.entity.Evaluation;
import com.entity.Merchant;

public class Comment extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Comment() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		/**
		 * 把请求的json数据读取出来。
		 */
		InputStream is = request.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is,
				"utf-8"));
		String line = null;
		StringBuffer sb = new StringBuffer();
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		CommentDao commentDao = new CommentDao();
		System.out.println(sb.toString());
		String CommentJson = sb.toString();
		System.out.println(CommentJson);// 其中sb为json数据包含了comment的所有内容
		Evaluation comment = JSON.parseObject(CommentJson, Evaluation.class);
		// 表示成功与否
		boolean success = false;
		if (commentDao.insertAComment(comment) > 0)
			success = true;
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", success);
		response.getWriter().append(jsonObject.toString());
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
