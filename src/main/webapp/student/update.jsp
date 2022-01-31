<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Update</title>
<jsp:include page="../header.jsp" />
</head>
<body>
	<jsp:include page="../nav.jsp" />



	<div class="container py-4" style="max-width: 780px;">

		<div class="page-body">

			<div class="card card-md">
				<div class="card-header">
					<h1 class="m-0">Student</h1>
				</div>
				<div class="card-body">

					<form class="form" action="/learnersadmin/student/update"
						method="post">

						<div class="row">
							<div class="col-6">
								<div class="form-outline mb-4">
									<label class="form-label" for="fullname">Full Name</label> <input
										type="text" id="fullname" class="form-control" name="fullname" value="${updateStudent.fullName}"  />
								</div>
							</div>
							<div class="col-6">
								<div class="form-outline mb-4">
										<label class="form-label" for="fullname">Email</label> <input
											type="email" value="${updateStudent.email}"  id="email" class="form-control" name="email" />
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-6">
								<div class="form-outline mb-4">
									<label class="form-label" for="age">Age</label>
									<input type="number" value="${updateStudent.age}" id="age" class="form-control" name="age" />
								</div>
							</div>
							<div class="col-6">
								<div class="form-outline mb-4">
									<!--  <label class="form-label" for="fullname">Class</label> -->
									<input type="number" value="${updateStudent.classes.id}"  hidden="hidden" id="class" class="form-control" name="class_id" />
									<input type="number" value="${updateStudent.id}"  hidden="hidden" id="class" class="form-control" name="id" />
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