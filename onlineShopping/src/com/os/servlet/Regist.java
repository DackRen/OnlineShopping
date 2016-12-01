package com.os.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.os.entity.Dao;
import com.os.service.customerAccountService.AccountService;

/**
 * Servlet implementation class Regist
 */
@WebServlet("/Regist")
public class Regist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Regist() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	/*
    	 * ��������û�ע��
    	 * ��������δ��������쳣
    	 */
    	AccountService cas =new AccountService();
    	
    	if(request.getParameter("rcustomer")!=null){
	    	cas.createCustomerAccount(request.getParameter("UserName"), request.getParameter("Telephone"),request.getParameter("Address"));
    		Dao.currentUser=cas.requestCustomerAccount(request.getParameter("UserName"));//��ǰ�û�Ϊx
    		
    		
    		/***********��תҳ��**************/
    		request.setAttribute("name", "haiyun");                                        // Ϊrequest������Ӳ���
  	      	RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerInteraction.html");    // ʹ��req�����ȡRequestDispatcher����
  	      	dispatcher.forward(request, response);  
  	      	/*************************/
    	}
    	else if(request.getParameter("rsupplier")!=null){
			cas.createSupplierAccount(request.getParameter("UserName"), request.getParameter("Telephone"),request.getParameter("Address"));
			Dao.currentUser=cas.requestSupplierAccount(request.getParameter("UserName"));//��ǰ�û�Ϊx
			
			/***********��תҳ��**************/
			request.setAttribute("name", "haiyun");                                        // Ϊrequest������Ӳ���
	      	RequestDispatcher dispatcher = request.getRequestDispatcher("SupplierInteraction.html");    // ʹ��req�����ȡRequestDispatcher����
	      	dispatcher.forward(request, response);  
	      	/*************************/
		}
    	else{
    		/***********��תҳ��**************/
			request.setAttribute("name", "haiyun");                                        // Ϊrequest������Ӳ���
	      	RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");    // ʹ��req�����ȡRequestDispatcher����
	      	dispatcher.forward(request, response);  
	      	/*************************/
    		
    	}
	}

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
		doGet(request, response);
	}
}
