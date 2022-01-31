<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Classes: list</title>
<jsp:include page="../header.jsp" />
</head>
<body>
<jsp:include page="../nav.jsp" />



<div class="container py-4" style="max-width:880px;">


		<div class="page-header d-print-none" style="margin-top:20px;">
			<div class="row align-items-center">
			    <div class="col">
			     
			    <div class="page-pretitle">
			    	List of 
			    </div>
				<h2 class="page-title">
					Classes
				</h2>
			</div>
              
              
              <!-- Page title actions -->
              <div class="col-auto ms-auto d-print-none">
                <div class="btn-list">          
                  <a href="/learnersadmin/classes/create" class="btn btn-primary d-none d-sm-inline-block">                 
                    Add new Class
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
                <th>Number</th>
                <th>Shift</th>
                <th>Students</th>
                 <th>Subjects</th>
                <th>Action</th>
                
            </tr>
            <c:set var="count" value="0" scope="page" />
            <c:forEach var="classes" items="${listClasses}">
            <c:set var="count" value="${count + 1}" scope="page"/>
                <tr>
                    <td><c:out value="${count}" /></td>
                    <td><c:out value="${classes.className}" /></td>
                    <td><c:out value="${classes.classNumber}" /></td>
                    <td><c:out value="${classes.classShift}" /></td>
                    <td><a href="/learnersadmin/student/index?class_id=${classes.id}" class="btn btn-outline-primary w-100 btn-sm">List of Students</a></td>
                    <td><a href="/learnersadmin/subject/index?class_id=${classes.id}" class="btn btn-outline-primary btn-sm">List of Subject</a></td>
                    <td>
                     <a href="edit?id=<c:out value='${classes.id}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete?id=<c:out value='${classes.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
	
</div>
 
       </div>
       
       </div>

</body>
</html>