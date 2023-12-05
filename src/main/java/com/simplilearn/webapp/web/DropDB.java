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
@WebServlet("/drop-db")
public class DropDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * This doGet method load the drop-db jsp page.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// set content type
		response.setContentType("text/html");
		response.sendRedirect("drop-db.jsp");

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
		String dbName = request.getParameter("db_name");
		
		DatabaseConnection db = null;
		
		try {
			// step 1: create connection
			db = new DatabaseConnection();
			db.init();
			
			// step 2: create statement and execute query 
			String query = "DROP database "+dbName +";";
			db.executeUpdate(query);
			
			request.getRequestDispatcher("index.jsp").include(request, response);
			
			out.println("<h2> DB is droped sucessfully ! </h2>");
			
		} catch (Exception e) {
			 e.printStackTrace();
			out.println("<h2> Exception Occured </h2>");
		} finally {
			out.close();
			db.close();
		}
	}

}
