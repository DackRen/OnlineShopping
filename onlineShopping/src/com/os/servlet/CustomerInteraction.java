package com.os.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.os.coordination.CustomerCoodinator;
import com.os.coordination.ICustomerCoodinator;
import com.os.entity.Catalog;
import com.os.entity.Dao;
import com.os.entity.Item;
import com.os.service.catalogService.CatalogType;

/**
 * Servlet implementation class CustomerInteraction
 */
@WebServlet("/CustomerInteraction")
public class CustomerInteraction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerInteraction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CatalogType catalogType = CatalogType.BOOK;;
		if(request.getParameter("cc")!=null){
			switch(request.getParameter("catalog")){
			case "BOOK":
				break;
			case "COMPUTER":
				catalogType=CatalogType.COMPUTER;
				break;
			case "TOY":
				catalogType=CatalogType.TOY;
				break;
			default:
				System.out.println("error");
			}
			Dao.dao.test();
			Catalog catalog = new Catalog();
			ICustomerCoodinator customerCoodinator = new CustomerCoodinator();
			catalog=customerCoodinator.requestCatalog(catalogType);

			PrintWriter out = response.getWriter();
			String title = "Catalog";
		    String docType =
		    "<!doctype html public \"-//w3c//dtd html 4.0 " +
		    "transitional//en\"> \n";
		    out.println(docType +"<html> \n" +"<head><title>" + title + "</title></head> \n");
		    out.println("<body bgcolor=\"#f0f0f0\">\n" +"<h1 align=\"center\">" + title + "</h1>\n" +"<ul>\n");
		    out.println("<form> action=\"Shop\" method=\"GET\"");  
		    out.println("  <li><b>CatalogType:</b>"+ catalog.getCatalogType() + " \n");
		    out.println("  <li><b>ItemList:</b>" + " \n");
			for (Item it : catalog.getItemList()) {  
				out.println("<input type=\"checkbox\" name=\"item\" valuse=\""+it.getItemId()+"\"/>"
			+"ID:\t"+it.getItemId()+"\tQUANTITY:\t"+it.getQuantity()+"\tUNITCOST:\t"+it.getUnitCost()+" \n");
			}  
			out.println("  <li><b>Supplier:</b>"+ catalog.getSupplierId() + " \n" + "<input type=\"submit\" value=\"Choise\" /></form>");  
			out.println(
			"<a href=\"CustomerInteraction.html\">CustomerHome</a>" + " \n" +
			"</ul> \n" +"</body></html>");
		}
	}
//	    	else
//	    		out.print("<script>alert(\"Login fail\")</script>");
//	    }
//		else{
//			if(cas.requestSupplierAccount(request.getParameter("UserName"))!=-1){
//				Dao.currentUser=cas.requestSupplierAccount(request.getParameter("UserName"));//当前用户为x
//				/***********跳转页面**************/
//				request.setAttribute("name", "haiyun");                                        // 为request对象添加参数
//  	      		RequestDispatcher dispatcher = request.getRequestDispatcher("SupplierInteraction.html");    // 使用req对象获取RequestDispatcher对象
//  	      		dispatcher.forward(request, response);  
//  	      		/*************************/
//			}
//			else{
//				out.print("<script>alert(\"Login fail\")</script>");
//			}
//		}
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
