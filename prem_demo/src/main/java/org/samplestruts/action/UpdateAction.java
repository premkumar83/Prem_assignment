package org.samplestruts.action;

import java.sql.ResultSet;

import org.samplestruts.dao.employeeDao;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport {

	private static final long serialVersionUID = -1905974197186620917L;
	//private String eid = "", ename = "", city = "";
	private String msg = "";
	ResultSet rs = null;
	employeeDao dao = new employeeDao();
	String submitType;
	private String employee_id, employee_name, city;

	@Override
	public String execute() throws Exception {
		try {
			if (submitType.equals("updatedata")) {
				rs = dao.fetchEmployeeDetails(getEmployee_id());
				if (rs != null) {
					while (rs.next()) {
						employee_id = rs.getString("EMPLOYEE_ID");
						employee_name = rs.getString("EMPLOYEE_NAME");
						city = rs.getString("CITY");
						
					}
				}
			} else {
				int i = dao.updateEmployeeDetails(employee_id, employee_name, city);
				if (i > 0) {
					msg = "Record Updated Successfuly";
				} else {
					msg = "error";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "UPDATE";
	}

	public String getEmployee_id() {
		return getEmployee_id();
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return getEmployee_name();
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}

}
