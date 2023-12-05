package com.simplilearn.webapp.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.webapp.db.DatabaseConnection;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/update-product")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * This doGet method load the add-product jsp page.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// set content type
		response.setContentType("text/html");
		response.sendRedirect("update-product.jsp");

	}

	/**
	 * This doPost handle form submission.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// set content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// collect input parameters
		String productId = request.getParameter("product_id");
		String productName = request.getParameter("product_name");
		String productDec = request.getParameter("product_desc");
		String productPrice = request.getParameter("product_price");
		DatabaseConnection db = null;
		
		try {
			// step 1: create connection
			db = new DatabaseConnection();
			db.init();
			
			// step 2: create statement and execute query 
			String query = "UPDATE eproducts set product_name='"+productName +"', product_desc='" 
							+productDec+"', price=" +productPrice +" where product_id="+productId;
			int nfra = db.executeUpdate(query);
			
			request.getRequestDispatcher("index.jsp").include(request, response);
			
			if(nfra>0) {
				out.println("<h2> Product is update sucessfully ! </h2>");
			} else {
				out.println("<h2> Product updation is failed ! </h2>");
			}
			
		} catch (Exception e) {
			// e.printStackTrace();
			out.println("<h2> Exception Occured </h2>");
		} finally {
			out.close();
			db.close();
		}
	}

}
