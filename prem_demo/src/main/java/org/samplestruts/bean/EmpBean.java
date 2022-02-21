package org.samplestruts.bean;

public class EmpBean {
	int employee_id;
	// generate getter and setters 
	private String employee_name;
	private String city;

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int i) {
		this.employee_id = i;
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

	


}
