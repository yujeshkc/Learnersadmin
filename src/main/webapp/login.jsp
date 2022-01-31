<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<jsp:include page="header.jsp" />
</head>
<body>

<div class="page page-center">
      <div class="container-tight py-2">
        <div class="text-center mb-2">
          <a href="." class="navbar-brand navbar-brand-autodark"><img src="./static/logo.svg" height="36" alt=""></a>
        </div>
        <form class="card card-md" action="/learnersadmin/logincheck" method="post" autocomplete="off">
          <div class="card-body">
            
            <div class="mb-3">
              <label class="form-label">Username</label>
              <input type="text" name="username" class="form-control" placeholder="Enter email">
            </div>
            <div class="mb-2">
              <label class="form-label">
                Password              
              </label>
              <div class="input-group input-group-flat">
                <input name="password"  type="password" class="form-control" placeholder="Password" autocomplete="off">                
              </div>
            </div>

            <div class="form-footer">
              <button type="submit" class="btn btn-primary w-100">Sign in</button>
              <c:if test="${param.error eq 1}">
               <span name="errorGender">error</span>
              </c:if>
              
             
            </div>
          </div>
      </form>
        
      </div>
    </div>

</body>
</html>