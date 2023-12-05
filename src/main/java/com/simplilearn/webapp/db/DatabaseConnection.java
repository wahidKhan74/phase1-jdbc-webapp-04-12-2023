package com.simplilearn.webapp.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class is for DatabaseConnection.
 * 
 * @author khanw
 */
public class DatabaseConnection {

	// data source properties
	private final String DB_URL = "jdbc:mysql://localhost:3306/estore_zone_db";
	private final String DB_USR = "newdevuser";
	private final String DB_PAS = "DevUser!74";

	Connection connection = null;
	Statement statment = null;
	ResultSet rst;
	PreparedStatement prstm = null;
	CallableStatement callstm = null;

	/**
	 * This method initialize connection.
	 * 
	 * @return connection.
	 */
	public Connection init() {
		try {
			// step1 : Register Driver (optional)
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. Register Driver class.");

			// step2 : Create a connection
			connection = DriverManager.getConnection(DB_URL, DB_USR, DB_PAS);
			System.out.println("2. Connection is created.");

		} catch (ClassNotFoundException e) {
			System.out.println("Exception Occured ::: " + e.getClass());
		} catch (SQLException e) {
			System.out.println("Exception Occured ::: " + e.getClass());
			// e.printStackTrace();
		}
		return connection;
	}

	/**
	 * Closed the connection.
	 */
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("Exception Occured ::: " + e.getClass());
		}
	}

	/**
	 * Execute read query.
	 * 
	 * @param query
	 * @return rst
	 */
	public ResultSet executeQuery(String query) {
		try {
			// step3 : Create a statement
			statment = connection.createStatement();
			System.out.println("3. Statement is created.");

			rst = statment.executeQuery(query);
			System.out.println("4. Execute Query.");

		} catch (SQLException e) {
			System.out.println("Exception Occured ::: " + e.getClass());
			// e.printStackTrace();
		}
		return rst;
	}

	/**
	 * Execute insert, update, delete query.
	 * 
	 * @param query
	 * @return int
	 */
	public int executeUpdate(String query) {
		int rowsAffected = 0;
		try {
			// step3 : Create a statement
			if(statment==null)
				statment = connection.createStatement();
			System.out.println("3. Statement is created.");

			rowsAffected = statment.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Exception Occured ::: " + e.getClass());
			e.printStackTrace();
		} finally {
			// clean up
//			try {
//				statment.close();
//			} catch (SQLException e) {
//				System.out.println("Exception Occured ::: " + e.getClass());
//			}

		}
		return rowsAffected;
	}

	/**
	 * Execute insert, update, delete query.
	 * 
	 * @param query
	 * @return int
	 */
	public int executeUpdatePrStm(String query, String... args) {
		int rowsAffected = 0;
		try {
			// step3 : Create a prepare statement
			prstm = connection.prepareStatement(query);
			System.out.println("3. Prepare Statement is created.");
			
			System.out.println(args.toString());
			
			// set parameters for prepare statement call
			// set product name
			prstm.setString(1, args[0]);
			// set product desc
			prstm.setString(2, args[1]);
			// set product price
			prstm.setString(3, args[2]);
			
			rowsAffected = prstm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Exception Occured ::: " + e.getClass());
			e.printStackTrace();
		} finally {
			// clean up
			try {
				prstm.close();
			} catch (SQLException e) {
				System.out.println("Exception Occured ::: " + e.getClass());
			}

		}
		return rowsAffected;
	}

	

	/**
	 * Execute insert, update, delete query.
	 * 
	 * @param query
	 * @return int
	 */
	public int executeUpdateCallStm(String query, String... args) {
		int rowsAffected = 0;
		try {
			// step3 : Create a callable statement
			callstm = connection.prepareCall(query);
			System.out.println("3. Callable Statement is created.");
			
			// set parameters for prepare callstm
			// set product name
			callstm.setString(1, args[0]);
			// set product desc
			callstm.setString(2, args[1]);
			// set product price
			callstm.setString(3, args[2]);
			
			rowsAffected = callstm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Exception Occured ::: " + e.getClass());
			e.printStackTrace();
		} finally {
			// clean up
			try {
				callstm.close();
			} catch (SQLException e) {
				System.out.println("Exception Occured ::: " + e.getClass());
			}

		}
		return rowsAffected;
	}

	/**
	 * Complete jdbc operation guide.
	 */
	public void jdbcOperation() {

		try {
			// step1 : Register Driver (optional)
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. Register Driver class.");

			// step2 : Create a connection
			connection = DriverManager.getConnection(DB_URL, DB_USR, DB_PAS);
			System.out.println("2. Connection is created.");

			// step3 : Create a statement
			statment = connection.createStatement();
			System.out.println("3. Statement is created.");

			// step4 : Execute query
			String query = "select * from eproducts;";
			rst = statment.executeQuery(query);
			System.out.println("4. Query is executed.");

		} catch (ClassNotFoundException e) {
			System.out.println("Exception Occured ::: " + e.getClass());
		} catch (SQLException e) {
			System.out.println("Exception Occured ::: " + e.getClass());
			// e.printStackTrace();
		} finally {
			// clean up
			try {
				// step5 : close connection
				rst.close();
				statment.close();
				connection.close();
				System.out.println("5. Closing the connection.");
			} catch (SQLException e) {
				System.out.println("Exception Occured ::: " + e.getClass());
			}

		}

	}

}
