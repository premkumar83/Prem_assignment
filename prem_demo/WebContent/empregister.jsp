<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Save Employee</title>
<style type="text/css">
.button-register {background-color: green;color: white;}
.button-report {background-color: #000000;color: white;margin-left: 30%;}
</style>
</head>
<body>
	<h2>Sample Example using JDBC to save and retrieve data</h2>
	
	<a href="report"><button class="button-report" type="button">Report</button></a>
	<s:form action="saveEmployee.action" method="post">
		<s:textfield label="Employee ID" name="employee_id" />
		<s:textfield label="Employee Name" name="employee_name" />
		<s:textfield label="City" name="city" />
		<s:submit cssClass="button-register" value="Save" />
	</s:form>
	<s:if test="ctr>0">
		<span style="color: green;"><s:property value="msg" /></span>
	</s:if>
	<s:else>
		<span style="color: red;"><s:property value="msg" /></span>
	</s:else>
</body>
</html>