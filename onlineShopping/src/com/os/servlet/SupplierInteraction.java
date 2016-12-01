package com.os.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.os.coordination.ISupplierCoordinator;
import com.os.coordination.SupplierCoordinator;
import com.os.entity.Dao;


/**
 * Servlet implementation class SupplierInteraction
 */
@WebServlet("/SupplierInteraction")
public class SupplierInteraction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierInteraction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		//初始化供应商协助者
		ISupplierCoordinator supplierCoordinator = new SupplierCoordinator();
		//通过供应商协助者请求订单
		int orderId=supplierCoordinator.requestOrder(Dao.currentUser);
		
		String title = "Order";
	    String docType =
	    "<!doctype html public \"-//w3c//dtd html 4.0 " +
	    "transitional//en\"> \n";
	      out.println(docType +
	                "<html>\n" +
	                "<head><title>" + title + "</title></head>\n" +
	                "<body bgcolor=\"#f0f0f0\">\n" +
	                "<h1 align=\"center\">" + title + "</h1>\n" +
	                "<ul>\n" +
	                "  <li><b>OrderID:</b>"
	                + orderId + "\n" +
	                "<a href=\"SupplierInteraction.html\">SupplierHome</a>" + "\n" +
	                "</ul>\n" +
	                "</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
