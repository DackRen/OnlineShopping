package com.os.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.os.entity.Dao;
import com.os.service.customerAccountService.AccountService;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AccountService cas =new AccountService();
		
		PrintWriter out = response.getWriter();
		
		if(request.getParameter("lcustomer")!=null){
	    	if(cas.requestCustomerAccount(request.getParameter("UserName"))!=-1){
	    		Dao.currentUser=cas.requestCustomerAccount(request.getParameter("UserName"));//当前用户为x
	    		/***********跳转页面**************/
	    		request.setAttribute("name", "haiyun");                                        // 为request对象添加参数
	  	      	RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerInteraction.html");    // 使用req对象获取RequestDispatcher对象
	  	      	dispatcher.forward(request, response);  
	  	      	/*************************/
	  	    }
	    	else
	    		out.print("<script>alert(\"Login fail\")</script>");
	    }
		else{
			if(cas.requestSupplierAccount(request.getParameter("UserName"))!=-1){
				Dao.currentUser=cas.requestSupplierAccount(request.getParameter("UserName"));//当前用户为x
				/***********跳转页面**************/
				request.setAttribute("name", "haiyun");                                        // 为request对象添加参数
  	      		RequestDispatcher dispatcher = request.getRequestDispatcher("SupplierInteraction.html");    // 使用req对象获取RequestDispatcher对象
  	      		dispatcher.forward(request, response);  
  	      		/*************************/
			}
			else{
				out.print("<script>alert(\"Login fail\")</script>");
			}
		}
		
		
		
		/*
	      PrintWriter out = response.getWriter();
		  String title = "Using GET Method to Read Form Regist";
	      String docType =
	      "<!doctype html public \"-//w3c//dtd html 4.0 " +
	      "transitional//en\">\n";
	      out.println(docType +
	                "<html>\n" +
	                "<head><title>" + title + "</title></head>\n" +
	                "<body bgcolor=\"#f0f0f0\">\n" +
	                "<h1 align=\"center\">" + title + "</h1>\n" +
	                "<ul>\n" +
	                "  <li><b>UserName:</b>"
	                + customer.getCustomerName() + "\n" +
	                "  <li><b>TelephoneNumber:</b>"
	                + customer.getTelephoneNumber() + "\n" +
	                "  <li><b>Address:</b>："
	                + customer.getAddress() + "\n" +
	                "  <li><b>Type:</b>："
	                + request.getParameter("Customer") + "\n" +
	                "<a href=\"CustomerHome.html\">CustomerHome</a>" + "\n" +
	                "<a href=\"SupplierInteraction.html\">SupplierHome</a>" + "\n" +
	                "</ul>\n" +
	                "</body></html>");
*/
	      /*
	      request.setAttribute("name", "haiyun");                                        // 为request对象添加参数
	      RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerHome.html");    // 使用req对象获取RequestDispatcher对象
	      dispatcher.forward(request, response);  
	      */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
