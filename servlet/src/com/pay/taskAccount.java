package com.pay;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.dao.OrderDao;
import com.dao.RunnerDao;
import com.entity.Deliveryorder;
import com.entity.Runner;

public class taskAccount extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public taskAccount() {
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
		String result = request.getParameter("delorderid");
		//表示成功与否
		boolean success = false;
		Deliveryorder deliveryorder = new Deliveryorder();
		if (result != null) {
			OrderDao orderDao = new OrderDao();
			deliveryorder = orderDao.getOrderById(Long.parseLong(result));
			success = true;
		}
		//重量加价，时间加价，基础价
		Double weightPrice = calWeightPrice(deliveryorder);
		Double timePrice = calTimePrice(deliveryorder);
		Double basePrice = calBasePrice(deliveryorder);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		deliveryorder.setOuttime(sdf.format(Calendar.getInstance().getTime()));
		deliveryorder
				.setExtraprice(deliveryorder.getExtraprice() + weightPrice);
		deliveryorder.setStatus(5);
		OrderDao orderDao = new OrderDao();
		RunnerDao runnerDao=new RunnerDao();
		Runner runner=runnerDao.getRunnerById(deliveryorder.getRunnerid());
		//实际这单的定价
		Double realPay=deliveryorder.getExtraprice()+weightPrice;
		//余额增加，信用分加10
		runner.setBalance(runner.getBalance()+realPay);
		runner.setIntegral(runner.getIntegral()+10);
		//在这里讲相应order的状态变为5，并且将runner的相应的余额和积分改变
		if (orderDao.updateOrder(deliveryorder) == 0  || runnerDao.updateRunner(runner) )
			success = false;
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", success);
		jsonObject.put("deliveryorder", deliveryorder);
		// 时间段加价，质量加价，基础价
		jsonObject.put("weightPrice", weightPrice);
		jsonObject.put("timePrice", timePrice);
		jsonObject.put("basePrice", basePrice);
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

	// 重量加价+距离加价+时间段加价
	// toDo:距离加价

	// 计算基础价
	private Double calBasePrice(Deliveryorder deliveryorder) {
		return deliveryorder.getEstimatedtotalprice()
				- calTimePrice(deliveryorder);
	}

	// 计算时间段加价
	private Double calTimePrice(Deliveryorder deliveryorder) {
		Double timePrice = 0.0;
		String orderTime = deliveryorder.getOrdertime();
		Calendar orderCal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date;
		try {
			date = sdf.parse(orderTime);
			orderCal.setTime(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (orderCal.HOUR_OF_DAY >= 0 && orderCal.HOUR_OF_DAY < 7)
			timePrice = 8.0;
		else if (orderCal.HOUR_OF_DAY >= 22 && orderCal.HOUR_OF_DAY < 24)
			timePrice = 4.0;
		return timePrice;
	}

	// 计算重量加价
	private Double calWeightPrice(Deliveryorder deliveryorder) {
		Double weightPrice = 0.0;
		if (deliveryorder.getTrueweight() > 5
				&& deliveryorder.getTrueweight() <= 10)
			weightPrice = Math.ceil(deliveryorder.getTrueweight() - 5);
		else if (deliveryorder.getTrueweight() <= 5)
			;
		else
			weightPrice = Math.ceil((deliveryorder.getTrueweight() - 10) / 5);
		return weightPrice;

	}

}
