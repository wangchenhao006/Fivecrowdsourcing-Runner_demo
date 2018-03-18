package com.order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.OrderDao;
import com.entity.Deliveryorder;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class SendDelOrderServlet
 */
@WebServlet("/SendDelOrderServlet")
public class SendDelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendDelOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//模拟APP发送过来的经纬度信息
		OrderDao orderdao = new OrderDao();
		Long runnerid = (long) 1;
		double lat1 = 30.228719;
		double lng1 = 119.713279;
		
		//更新跑腿人位置
		Double[] location = new Double[2];
		location[0] = lat1;location[1] = lng1;
		ServletContext application = request.getServletContext();
		application.setAttribute(runnerid.toString(), location);
		
		List<Deliveryorder> delOrderList = new ArrayList<Deliveryorder>();
		
		delOrderList = orderdao.getNearByDelOrder(lat1, lng1);
		//转换成JSON格式，写给APP。
		JSONArray jsonArray = JSONArray.fromObject(delOrderList);
		System.out.println(jsonArray.toString());
		//System.out.println(((Double[])application.getAttribute("1"))[0]);
		response.getWriter().append(jsonArray.toString());
	}

}
