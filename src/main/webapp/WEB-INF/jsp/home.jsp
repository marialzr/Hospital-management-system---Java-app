<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
<h1 align="center">Welcome to hospital management system</h1>
<br/><br/>
<div align="center">
		<form:form action="/patients/view/${1}" method="GET">
    		<input type="submit" value="Patients" />
		</form:form>
		<br/>
		<form:form action="/doctors/view/${1}" method="GET">
    		<input type="submit" value="Doctors" />
		</form:form>
		<br/>
		<form:form action="/interventions/add" method="GET">
    		<input type="submit" value="Add Intervention" />
		</form:form>
		<br/>   
		<form:form action="/patients/viewByRoom/${1}" method="GET">
    		<input type="submit" value="Patients by room" />
		</form:form>
		<br/>   
		<form:form action="/interventions/view" method="GET">
    		<input type="submit" value="View Interventions" />
		</form:form>
</div>
</body>
</html>