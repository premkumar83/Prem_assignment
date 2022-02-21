package org.samplestruts.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class employeeDao {
	
	// method for create connection
	public static Connection getConnection() throws Exception {
		Connection conn = null;
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			//return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:productDB");
			String connUrl ="jdbc:oracle:thin:@localhost:1521:testDB";
			String username = "username";
            String password = "******";
            conn = DriverManager.getConnection(connUrl, username, password);
            if (conn != null) {
                System.out.println("Database Connection successfull");
            }
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return conn;
	}

	// method for save employee data in database
	public int saveEmployee(String employee_id, String employee_name, String city) throws Exception {
		int i = 0;
		try {
			String sql = "INSERT INTO EMPLOYEE VALUES (?,?,?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, employee_id);
			ps.setString(2, employee_name);
			ps.setString(3, city);
			
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return i;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	// method for fetch saved employeee data
	public ResultSet employeeReport() throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT EMPLOYEE_ID,EMPLOYEE_NAME,CITY FROM EMPLOYEE";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	// method for fetch old data to be update
	public ResultSet fetchEmployeeDetails(String employee_id) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT EMPLOYEE_ID,EMPLOYEE_NAME,CITY FROM EMPLOYE WHERE EMPLOYEE_ID=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, employee_id);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	// method for update new data in database
	public int updateEmployeeDetails(String employee_id, String employee_name, String city)
			throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		int i = 0;
		try {
			String sql = "UPDATE EMPLOYEE SET EMPLOYEE_NAME=?,CITY=? WHERE EMPLOYEE_ID=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, employee_id);
			ps.setString(2, employee_name);
			ps.setString(3, city);
			
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			getConnection().rollback();
			return 0;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	
}
