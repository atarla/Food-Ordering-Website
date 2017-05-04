/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;



/**
 *
 * @author Pooja
 */
public class DBUtility {
    public DBUtility() {

		// TODO Auto-generated connstructor stub

	}



	

	public static Connection getConnection() {

		Connection conn=null;

		try {

			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e1) {

			// TODO Auto-generated catch block

			e1.printStackTrace();

		}

		try {

			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/food?autoReconnect=true&useSSL=false","root","password-1");
//                                                      conn= DriverManager.getConnection("jdbc:mysql://nbadproject.co6umk4usv3m.us-west-2.rds.amazonaws.com:3306/food?autoReconnect=true&useSSL=false","root","password-1");

		} catch (SQLException e) {

			System.err.println("ERROR : No connection.");

			System.err.println("ERROR : \nSQL Error Code : "+e.getErrorCode()+" SQL State : "+e.getSQLState());

		}

		return conn;

	}  

	

	
	

	public static void closeConnection(Connection conn){

		try {

			conn.close();

		} catch (SQLException e) {

			System.err.println("ERROR : Cannot close the connection.");

			System.err.println("ERROR : \nSQL Error Code : "+e.getErrorCode()+" SQL State : "+e.getSQLState());

		}

	}

}

   
