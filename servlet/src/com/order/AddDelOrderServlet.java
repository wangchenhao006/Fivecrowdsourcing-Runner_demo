package com.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import com.ToolsClass.EstimateUtils;
import com.dao.OrderDao;
import com.entity.Deliveryorder;
/**
 * Servlet implementation class EditOrder
 */
@WebServlet(description = "新建任务单，返回预估时间和价格", urlPatterns = { "/AddDelOrderServlet" })
public class AddDelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDelOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		OrderDao orderdao = new OrderDao();
		//模拟APP发送过来的订单JSON数据
		Long merchantid = (long) 1;
		String cusname = "haha";
		String cusphone = "15248572865";
		String cusaddress = "浙工大东十四";
		double cuslat = 30.228719;
		double cuslng = 119.713279;
		String things = "apple * 2, orange * 3";
		String ordertime = "2018-01-12 12:12:12";
		Deliveryorder deliveryorder = new Deliveryorder();
		
		//获得预估时间和价格
		int extraTime = 15;//预估缓冲时间
		Double[] location = orderdao.getMerchantLocation(merchantid);//获得商户经纬度
		String url = "http://api.map.baidu.com/routematrix/v2/riding";//骑行接口
		//接口参数
		String param = "output=json&origins="+cuslat+","+cuslng+"&destinations="+location[0]+","+location[1]+"&ak=Gsj9D1Ih7RV00jypSLk8osnircS4NRPA";
		Long estimatedtime = (long) (Math.ceil(EstimateUtils.getEstimatedTime(url, param)/60)+extraTime);//单位：分钟
		int estimateddistance = EstimateUtils.getEstimatedDistance(url, param);
		double estimatedtotalprice = EstimateUtils.getEstimatedPrice(estimateddistance,ordertime,orderdao.getDelmethodid(merchantid));
		
		//转换成配送单对象并保存到数据库
		Deliveryorder deliveryorderNew = new Deliveryorder();
		deliveryorderNew.setMerchantid(merchantid);
		deliveryorderNew.setDelmethodid(orderdao.getDelmethodid(merchantid));
		deliveryorderNew.setCusName(cusname);
		deliveryorderNew.setCusAddress(cusaddress);
		deliveryorderNew.setCusPhone(cusphone);
		deliveryorderNew.setThings(things);
		deliveryorderNew.setEstimatedtime(estimatedtime);
		deliveryorderNew.setEstimatedtotalprice(estimatedtotalprice);
		deliveryorderNew.setDistance(estimateddistance);
		deliveryorderNew.setOrdertime(ordertime);
		deliveryorderNew.setStatus(1);
		
		orderdao.insertDeliveryorder(deliveryorderNew);
		
		//将预估时间和价格发给APP
		String timeAndPriceJSONStr = "{\"estimatedtime\":"+estimatedtime+",\"estimatedtotalprice\":"+estimatedtotalprice+"}";
		System.out.println(timeAndPriceJSONStr);
		JSONObject timeAndPriceJSON = new JSONObject(timeAndPriceJSONStr);
		response.getWriter().append(timeAndPriceJSON.toString());
		/*//获得派送单编号
		long delorderid = orderdao.getDeliveryorderId(deliveryorderNew);
		
		deliveryorderNew.setDelorderid(delorderid);*/
	} 

}
