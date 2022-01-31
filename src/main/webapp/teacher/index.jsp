<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="../header.jsp" />
</head>
<body>
<jsp:include page="../nav.jsp" />


<div class="container py-4" style="max-width:780px;">


		<div class="page-header d-print-none" style="margin-top:20px;">
			<div class="row align-items-center">
			    <div class="col">
			     <!-- Page pre-title -->
			    <div class="page-pretitle">
			    	List of 
			    </div>
				<h2 class="page-title">
					Teachers
				</h2>
			</div>
              
              
              <!-- Page title actions -->
              <div class="col-auto ms-auto d-print-none">
                <div class="btn-list">          
                  <a href="/learnersadmin/teacher/create" class="btn btn-primary d-none d-sm-inline-block">
                    <!-- Download SVG icon from http://tabler-icons.io/i/plus -->
                     Create new Teacher
                  </a>
                  <a href="#" class="btn btn-primary d-sm-none btn-icon" data-bs-toggle="modal" data-bs-target="#modal-report" aria-label="Create new report">
                    <!-- Download SVG icon from http://tabler-icons.io/i/plus -->
                        </a>
                </div>
              </div>
              
              
            </div>

</div>

<div class="page-body">




<div class="card">

<table  class="table card-table table-vcenter text-nowrap datatable" >
            
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Action</th>
                
            </tr>
            <c:set var="count" value="0" scope="page" />
            <c:forEach var="teacher" items="${listTeacher}">
            <c:set var="count" value="${count + 1}" scope="page" />
                <tr>
                    <td><c:out value="${count}" /></td>
                    <td><c:out value="${teacher.fullName}" /></td>
                    <td><c:out value="${teacher.email}" /></td>
                    <td><c:out value="${teacher.phoneNumber}" /></td>
                    <td>
                     <a href="edit?id=<c:out value='${teacher.id}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete?id=<c:out value='${teacher.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
	
</div>
 
       </div>
       
       </div>
       

</body>
</html>