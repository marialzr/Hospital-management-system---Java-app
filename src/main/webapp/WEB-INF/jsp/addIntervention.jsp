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
<title>Add Intervention</title>
</head>
<body>
<h1 align="center">Add Intervention</h1>
		<div class="col-sm-offset-1" >
		<form:form commandName="patient" cssClass="form-horizontal" action="/interventions/newi" method="POST">
			<div class="form-group">
				<label for="date" class="col-sm-3 control-label">Date</label>
				<div class="col-sm-5">
					<form:input path="date" cssClass="form-control" placeholder="yyyy-mm-dd hh:mm:ss"/>
				</div>
			</div>
			
			<div class="form-group">
				<label for="success" class="col-sm-3 control-label">Success</label>
				<div class="col-sm-5">
					<form:input path="success" cssClass="form-control" placeholder="Success"/>
				</div>
			</div>
			<div class="form-group">
				<label for="duration" class="col-sm-3 control-label">Duration</label>
				<div class="col-sm-5">
					<form:input path="duration" cssClass="form-control" placeholder="Duration"/>
				</div>
			</div>
			
			<div class="form-group">
				<label for="patient" class="col-sm-3 control-label">Patients</label>
				<div class="col-sm-5">
					<form:select path="patient" items="${patients}" multiple="true" cssClass="form-control" placeholder="Patient"/>
				</div>
			</div>
			
			<div class="form-group">
				<label for="doctor" class="col-sm-3 control-label">Doctors</label>
				<div class="col-sm-5">
					<form:select path="doctor" items="${doctors}" multiple="true" cssClass="form-control" placeholder="Doctor"/>
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
			<c:forEach items="${patients}" var="p" varStatus="status">
		   		<form:form action="/interventions/add/${p.pid}" method="GET">
		   		</form:form>
		   </c:forEach>
		   <c:forEach items="${doctors}" var="p" varStatus="status">
		   		<form:form action="/interventions/add/${p.did}" method="GET">
		   		</form:form>
		   </c:forEach>
		</div>
</body>
</html>