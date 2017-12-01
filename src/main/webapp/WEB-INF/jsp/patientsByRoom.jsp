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
<h1 align="center">Patients by room</h1>
<br/><br/>
<table>
    <tr>
		    <tr>
		    	<th width="100"></th>
		        <th width="100">Room Id</th>
		    </tr>
		    <c:forEach items="${rooms}" var="doc" varStatus="status">
		        <tr>
		        	<th width="200"></th>
		            <td>${doc.rid}</td>
		           <td>
		           		<form:form action="/patients/viewByRoom/${doc.rid}" method="GET">
    					<input type="submit" value="View" />
		   				</form:form>
				   </td>
				   
		        </tr>
		    </c:forEach>
		
		<div class="form-group">
				<div class="col-sm-6 col-sm-offset-1">
					<form:select path="room" items="${room.patients}" multiple="true" cssClass="form-control" placeholder="Room"/>
				</div>
			</div>
    </tr>
</table>
</body>
</html>