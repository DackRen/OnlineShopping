package com.os.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.os.coordination.CustomerCoodinator;


/**
 * Servlet implementation class Shop
 */
@WebServlet("/Shop")
public class Shop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Shop() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		CustomerCoodinator customerCoodinator=new CustomerCoodinator();
		//PrintWriter out = response.getWriter();
		
		/*
		 * 本类应该为根据选择商品生成信息，并询问是否购买，然后调用下单服务服务
		 * 现简化为用户在CustomerInteraction选择商品并点击选择后即跳转至本页面，并自动调用下单服务
		 */
		
		String[] values = request.getParameterValues("item") ;
		int[] item= {1};
		if(values!=null&&values.length>0) {
			for(int i= 0 ;i<values.length;i++){
				item[i]=Integer.parseInt(values[i]);
			}
		}
		//处理选择并存储
		customerCoodinator.requesPurchase(customerCoodinator.requestSelectionFromCatalog(item));
		
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
