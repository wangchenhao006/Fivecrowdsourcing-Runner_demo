package com.validate;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.IMerchantDao;
import com.dao.MerchantDao;
import com.entity.Merchant;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/validate.do")
public class validateMerchantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validateMerchantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Test
		HttpSession session=request.getSession(); 
		IMerchantDao merchantDao=new MerchantDao();
		List<Merchant> merchants=merchantDao.findMerchants();
		session.setAttribute("merchants", merchants);
		System.out.println(merchants.isEmpty());
		String url="jsp/validatelist.jsp";
		response.sendRedirect(url);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
