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
<title>Add Patient</title>
</head>
<body>
<h1 align="center">Add Patient</h1>
		<div class="col-sm-offset-1" >
		<form:form commandName="patient" cssClass="form-horizontal" action="/patients/newp" method="POST">
			
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
			
			<div class="form-group">
    			<div class="col-sm-offset-5 col-sm-10">
      			<button type="submit" class="btn btn-default">Add</button>
    		 </div>
    		 </div>
		</form:form>
		</div>
		
		<div>
			<c:forEach items="${rooms}" var="room" varStatus="status">
		   		<form:form action="/patients/add/${room.rid}" method="GET">
		   		</form:form>
		   </c:forEach>
		</div>
</body>
</html>