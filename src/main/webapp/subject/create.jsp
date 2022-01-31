<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subject List</title>
<jsp:include page="../header.jsp" />
</head>
<body>
	<jsp:include page="../nav.jsp" />



	<div class="container py-4" style="max-width: 780px;">

		<div class="page-body">

			<div class="card card-md">
				<div class="card-header">
					<h1 class="m-0">Subject</h1>
				</div>
				<div class="card-body">

					<form class="form" action="/learnersadmin/subject/insert"
						method="post">

						<div class="row">
							<div class="col-6">
								<div class="form-outline mb-4">
									<label class="form-label" for="subject">Subject</label> <input
										type="text" id="subject" class="form-control" name="subjectName" />
								</div>
							</div>
							<div class="col-6">
								<div class="form-outline mb-4">
										<label class="form-label" for="fullname">Time</label> <input
											type="text" id="subjectTime" class="form-control" name="subjectTime" />
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-6">
								<div class="form-outline mb-4">
									<label class="form-label" for="fullname">Teacher</label>										
									<select class="form-select" name="teacher">
									  <c:forEach var="item" items="${listTeacher}">
									    <option value="${item.id}" ${item.id == selectedDept ? 'selected="selected"' : ''}>${item.fullName}</option>
									  </c:forEach>
									</select>
								</div>
							</div>
							<div class="col-6">
								<div class="form-outline mb-4">									
									<input type="number" value="${class_id}" hidden="hidden" class="form-control" name="class_id" />
								</div>
							</div>
						</div>
						
						<!-- Submit button -->
	  					<button type="submit" class="btn btn-primary btn-block mb-4">Create</button>
					</form>
				</div>

			</div>
			<!-- card -->
		</div>



	</div>

</body>
</html>