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
					Subject
				</h2>
			</div>
              
              
              <!-- Page title actions -->
              <div class="col-auto ms-auto d-print-none">
                <div class="btn-list">          
                  <a href="/learnersadmin/subject/create?class_id=${class_id}" class="btn btn-primary d-none d-sm-inline-block">                 
                    Add new Subject
                  </a>
                   
                </div>
              </div>
              
              
            </div>
            
               <div class="col-12">
                <div class="card">               
                  <div class="card-body row">
                  <div class="col-1">
                  <a href="/learnersadmin/classes/index"><img src="/learnersadmin/img/back.png" width=50></a>
                  </div>
                  <div class="col-4">
                    <div class="subheader">Class Detail</div>
                    <div class="h3 m-0">${classes.className}</div>
                  </div>
                  </div>
                </div>
              </div>

</div>

<div class="page-body">




<div class="card">

<table  class="table card-table table-vcenter text-nowrap datatable" >
            
            <tr>
                <th>ID</th>
                <th>Subject</th>
                <th>Time</th>
                <th>Teacher</th>
                <th>Action</th>
                
            </tr>
            <c:set var="count" value="0" scope="page" />
            <c:forEach var="subject" items="${listSubject}">
            <c:set var="count" value="${count + 1}" scope="page"/>
                <tr>
                    <td><c:out value="${count}" /></td>
                    <td><c:out value="${subject.subject}" /></td>
                    <td><c:out value="${subject.subjectTime}" /></td>
                    <td><c:out value="${subject.teacher.fullName}" /></td>
                   
                   <td>
                     <a href="edit?id=<c:out value='${subject.id}' />&class_id=<c:out value='${subject.classes.id}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete?id=<c:out value='${subject.id}' />&class_id=<c:out value='${subject.classes.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
	
</div>
 
       </div>
       
       </div>


</body>
</html>