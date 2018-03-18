package com.pay;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.dao.MerchantDao;
import com.dao.OrderDao;
import com.entity.Deliveryorder;
import com.entity.Merchant;

public class PayBills extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PayBills() {
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
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
        response. setCharacterEncoding("UTF-8");
        request. setCharacterEncoding("UTF-8");
        String delorderid = request.getParameter("delorderid");
        boolean success = false;
		Deliveryorder deliveryorder = new Deliveryorder();
		//将相应的deliveryOrder的状态设置为6（已经完成支付）
		deliveryorder.setStatus(6);
		deliveryorder.setDelorderid(Long.parseLong(delorderid));
		
		OrderDao orderDao=new OrderDao();
		MerchantDao merchantDao=new MerchantDao();
		Merchant merchant=merchantDao.findValidatedMerchantById(deliveryorder.getMerchantid());
		/**这里有错误，需要进行修改**/		
		merchant.setBalance(merchant.getBalance()+deliveryorder.getEstimatedtotalprice());
		if(orderDao.updateOrderAfterPay(deliveryorder)==0 || !merchantDao.updateMerchantBalance(merchant))
			success=false;
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", success);
		response.getWriter().append(jsonObject.toString());
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
