<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Class Form</title>
<jsp:include page="../header.jsp" />
</head>
<body>
<jsp:include page="../nav.jsp" />

<div class="container py-4" style="max-width:780px;">

<div class="page-body">

<div class="card card-md">
<div class="card-header">
		<h1 class="m-0">Class</h1>
	</div>
<div class="card-body">

	

	<form class="form" action="/learnersadmin/classes/update" method="post"  >
	  <!-- Text input -->
	  <div class="form-outline mb-4">
		  <label class="form-label" for="className">Class Name</label>
	      <input type="text" id="className" class="form-control" name="className" value="${updateClass.className}" />
	  </div>
	
	  <!-- Text input -->
	  <div class="form-outline mb-4">
	    <label class="form-label" for="classNumber">Class Number</label>
	    <input type="number" id="classNumber" class="form-control" name="classNumber" value="${updateClass.classNumber}"  />	   
	  </div>
	
	  <!-- Email input -->
	  <div class="form-outline mb-4">
	  	<label class="form-label" for="phone">Class Shift</label>
	    <input type="text" id="classShift" class="form-control" name="classShift" value="${updateClass.classShift}" />	    
	  </div>	
	
	  <!-- Submit button -->
	  <input type="text" id="idc" class="form-control" name="id" value="${updateClass.id}" hidden="hidden" />
	  <button type="submit" class="btn btn-primary btn-block mb-4">Update</button>
	</form>
	
</div>

	</div><!-- card -->
</div>



</div>



</body>
</html>