<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Report</title>
<style>
table, td, th {border: 1px solid black;}
table {border-collapse: collapse;width: 60%;}
th {height: 30px;}
.button-update {background-color: #008CBA;color: white;}
.button-delete {background-color: red;color: white;}
</style>
</head>
<body>
	<h2>Sample Example using JDBC to save and retrieve data</h2>
	<s:form action="employeeReport.action" method="post"></s:form>
	<div style="margin-top: 40px;">
		<s:if test="noData==true">
			<table>
				<thead>
					<tr style="background-color: #E0E0E1;">
						
						<th>Employee ID</th>
						<th>Employee Name</th>
						<th>City</th>
						
					</tr>
				</thead>
				<s:iterator value="beanList">
					<tr>
						
						<td><s:property value="employee_id" /></td>
						<td><s:property value="employee_name" /></td>
						<td><s:property value="city" /></td>
						
						<td>
							
								<button class="button-update">Report</button>
							
							
						</td>
					</tr>
				</s:iterator>
			</table>
		</s:if>
		<s:else>
			<div style="color: red;">No Data Found.</div>
		</s:else>
	</div>
</body>
</html>