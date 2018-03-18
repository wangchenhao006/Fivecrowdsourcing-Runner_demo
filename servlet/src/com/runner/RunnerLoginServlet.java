package com.runner;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.dao.RunnerDao;
import com.entity.Runner;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/RunnerLoginServlet")
public class RunnerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RunnerLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");

		JSONObject jsonObject = null;
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		System.out.println(phone + " " + password);
		String result = null;
		RunnerDao runnerDao = new RunnerDao();
		try{
		Runner runner = runnerDao.checkRunner(phone, password);
		// 判断密码是否正确
		if (runner != null) {
			result = "success";
			// 数据转换
			jsonObject = new JSONObject(runner);
			jsonObject.put("result", result);
			System.out.println(jsonObject);
		} else{
			result = "false";
			jsonObject = new JSONObject();
	     	jsonObject.put("result", result);		  
		}
		}
		catch(Exception e)
		{
			result = "false";
			jsonObject = new JSONObject();
			jsonObject.put("result", result);
		}
		response.getWriter().append(jsonObject.toString());
		}

}