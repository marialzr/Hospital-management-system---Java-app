<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Interventions</h1>
<br/><br/>
<table>
	<tr>
		<th width="400"></th>
        <th width="200">Date</th>
        <th width="150">Doctor Id</th>
        <th width="150">Patient Id</th>
        <th width="150">Success</th>
        <th width="150">Duration</th>
    </tr>
    <c:forEach items="${interventions}" var="i" varStatus="status">
        <tr>
        	<th width="200"></th>
            <td>${i.date}</td>
            <td>${i.doctor.did}</td>
            <td>${i.patient.pid}</td>
            <td>${i.success}</td>
            <td>${i.duration}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>