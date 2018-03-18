package com.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import com.dao.OrderDao;
/**
 * Servlet implementation class ConfirmDelOrderServlet
 */
@WebServlet("/ConfirmDelOrderServlet")
public class ConfirmDelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmDelOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long delorderid = (long) 6;
		OrderDao orderdao = new OrderDao();
		int ans = orderdao.updateOrderStatus(delorderid);
		String result = "";
		if(ans!=0)
			result = "success";
		else
			result = "failed";
		
		JSONObject json = new JSONObject();
		json.append("result", result);
		System.out.println(json.toString());
		response.getWriter().append(json.toString());
	}

}
