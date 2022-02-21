package org.samplestruts.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.samplestruts.bean.EmpBean;
import org.samplestruts.dao.employeeDao;

import com.opensymphony.xwork2.ActionSupport;

public class ReportAction extends ActionSupport {

	private static final long serialVersionUID = 6329394260276112660L;
	ResultSet rs = null;
	EmpBean bean = null;
	List<EmpBean> beanList = null;
	employeeDao empdao = new employeeDao();
	private boolean noData = false;

	@Override
	public String execute() throws Exception {
		try {
			beanList = new ArrayList<EmpBean>();
			rs = empdao.employeeReport();
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					bean = new EmpBean();
					bean.setEmployee_id(i);
					bean.setEmployee_name(rs.getString("employee_name"));
					bean.setCity(rs.getString("city"));
					beanList.add(bean);
				}
			}
			if (i == 0) {
				noData = false;
			} else {
				noData = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "REPORT";
	}

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}

	public List<EmpBean> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<EmpBean> beanList) {
		this.beanList = beanList;
	}

}
