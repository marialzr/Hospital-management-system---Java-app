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
<h1 align="center">Patients</h1>
<br/></br>
<table>
    <tr>
        <th width="800">
		<div class="col-sm-offset-1" >
		<form:form commandName="patient" cssClass="form-horizontal" method="POST">
			<div class="form-group">
				<label for="pid" class="col-sm-3 control-label">Patient Id</label>
				<div class="col-sm-5">
					<form:input path="pid" cssClass="form-control" placeholder="Patient Id"/>
				</div>
			</div>
			
			<div class="form-group">
				<label for="firstName" class="col-sm-3 control-label">First name</label>
				<div class="col-sm-5">
					<form:input path="firstName" cssClass="form-control" placeholder="First Name"/>
				</div>
			</div>
			
			<div class="form-group">
				<label for="lastName" class="col-sm-3 control-label">Last Name</label>
				<div class="col-sm-5">
					<form:input path="lastName" cssClass="form-control" placeholder="Last Name"/>
				</div>
			</div>
			<div class="form-group">
				<label for="phone" class="col-sm-3 control-label">Phone</label>
				<div class="col-sm-5">
					<form:input path="phone" cssClass="form-control" placeholder="Phone"/>
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-3 control-label">Email</label>
				<div class="col-sm-5">
					<form:input path="email" cssClass="form-control" placeholder="Email"/>
				</div>
			</div>
			<div class="form-group">
				<label for="room" class="col-sm-3 control-label">Room</label>
				<div class="col-sm-5">
					<form:select path="room" items="${rooms}" multiple="true" cssClass="form-control" placeholder="Room"/>
				</div>
			</div>
		</form:form>	 
  		</div>	
		</th>
        <th width="800">
        
<table>
    <tr>
        <th width="100">Id</th>
        <th width="200">First Name</th>
    </tr>
    <c:forEach items="${patients}" var="doc" varStatus="status">
        <tr>
            <td>${doc.pid}</td>
            <td>${doc.firstName}</td>
           <td>
           <form:form action="/patients/view/${doc.pid}" method="GET">
    		<input type="submit" value="View" />
		   </form:form>
		   </td>
		   <td>
		   <form:form action="/patients/delete/${doc.pid}" method="GET">
    		<input type="submit" value="Delete" />
		   </form:form>
		   </td>
		   <td>
		   <form:form action="/patients/update/${doc.pid}" method="GET">
    		<input type="submit" value="Update" />
		   </form:form>
		   </td>
        </tr>
    </c:forEach>
</table>
</th>
    </tr>
</table>
</body>
</html>