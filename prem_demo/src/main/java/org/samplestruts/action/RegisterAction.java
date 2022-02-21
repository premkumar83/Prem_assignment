package org.samplestruts.action;

//import org.samplestruts.bean.String;
import org.samplestruts.dao.employeeDao;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 2139116285823340125L;
	private String employee_id, employee_name, city;
	private String msg = "";
	employeeDao empdao = null;
	int ctr = 0;

	@Override
	public String execute() throws Exception {
		empdao = new employeeDao();

		try {
			ctr = empdao.saveEmployee(employee_id, employee_name, city);
			if (ctr > 0) {
				msg = "Employee Registration Successfull";
			} else {
				msg = "Somthing went wrong";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "REGISTER";
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
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

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCtr() {
		return ctr;
	}

	public void setCtr(int ctr) {
		this.ctr = ctr;
	}

}
