package com.order;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.OrderDao;
import com.entity.Deliveryorder;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class ReturnDelingOrders
 */
@WebServlet(description = "返回配送中订单列表", urlPatterns = { "/ReturnDelingOrders" })
public class ReturnDelingOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ReturnDelingOrders() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//模拟APP发来的商家id
		long merchantid = 1;
		
		OrderDao orderdao = new OrderDao();
		List<Deliveryorder> delingorders = new ArrayList<Deliveryorder>();
		delingorders = orderdao.getOrdersByStatus(4, merchantid);
		
		//转换成JSON格式，写给APP。
		JSONArray jsonArray = JSONArray.fromObject(delingorders);
		System.out.println(jsonArray.toString());
		response.getWriter().append(jsonArray.toString());
	}

}
