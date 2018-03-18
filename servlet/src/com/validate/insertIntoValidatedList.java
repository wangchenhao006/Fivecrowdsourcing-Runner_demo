package com.validate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.MerchantDao;
import com.entity.Merchant;

public class insertIntoValidatedList extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public insertIntoValidatedList() {
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
		HttpSession session = request.getSession();
		Merchant merchant = (Merchant) session.getAttribute("merchant");
		ArrayList<Merchant> validatedMerchants;
		if (session.getAttribute("validatedMerchants") == null) {
			validatedMerchants = new ArrayList<>();
			validatedMerchants.add(merchant);
			session.setAttribute("validatedMerchants", validatedMerchants);
		}
		else
		{
			validatedMerchants=(ArrayList<Merchant>)session.getAttribute("validatedMerchants");
			validatedMerchants.add(merchant);
			session.setAttribute("validatedMerchants", validatedMerchants);
		}
		response.sendRedirect("jsp/profile.jsp");
		
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
