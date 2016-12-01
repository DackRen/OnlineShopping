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
		 * ����Ӧ��Ϊ����ѡ����Ʒ������Ϣ����ѯ���Ƿ���Ȼ������µ��������
		 * �ּ�Ϊ�û���CustomerInteractionѡ����Ʒ�����ѡ�����ת����ҳ�棬���Զ������µ�����
		 */
		
		String[] values = request.getParameterValues("item") ;
		int[] item= {1};
		if(values!=null&&values.length>0) {
			for(int i= 0 ;i<values.length;i++){
				item[i]=Integer.parseInt(values[i]);
			}
		}
		//����ѡ�񲢴洢
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
