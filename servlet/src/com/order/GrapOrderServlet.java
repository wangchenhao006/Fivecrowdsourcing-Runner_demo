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
 * Servlet implementation class GrapOrderServlet
 */
@WebServlet(description = "抢单", urlPatterns = { "/GrapOrderServlet" })
public class GrapOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GrapOrderServlet() {
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
		response.setContentType("text/html;charset=utf-8");
		Long delorderid = (long) 6;
		Long runnerid = (long) 1;
		OrderDao orderdao = new OrderDao();
		int ans = orderdao.updateOrderAfterOrderGrabbed(delorderid, runnerid);
		String result = "";
		if(ans==-1)
			result="单子已经被抢走了！";
		else if(ans!=0)
			result = "抢单成功！";
		else
			result = "抢单失败~";
		
		JSONObject json = new JSONObject();
		json.append("result", result);
		System.out.println(json.toString());
		response.getWriter().append(json.toString());
	}

}
