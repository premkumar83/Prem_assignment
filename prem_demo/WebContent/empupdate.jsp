<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Update</title>
</head>
<body>
	<h2>Sample Example using JDBC to save and retrieve data</h2>
	<form action=updateEmployeeDetails method="post">
		<pre>
<b>Employee ID:         </b><input type="text" name="employee_id" value='<s:property value="employee_id"/>'>
		
		
<b>Employee Name:        </b><input type="text"  name="employee_name" value='<s:property value="employee_name"/>'>
		           
		
<b>City:  </b><input type="text" name="city" value='<s:property value="city"/>'>
		
		<button name="submitType" value="update" type="submit">Update</button>
		</pre>
	</form>
	<s:if test="ctr>0">
		<span style="color: red;"><s:property value="msg" /></span>
	</s:if>
	<s:else>
		<span style="color: red;"><s:property value="msg" /></span>
	</s:else>
</body>
</html>