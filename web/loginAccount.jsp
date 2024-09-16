<%-- 
    Document   : loginAccount
    Created on : 19 thg 6, 2024, 03:34:37
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Bootstrap Simple Login Form</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>
.login-form {
    width: 340px;
    margin: 50px auto;
  	font-size: 15px;
}
.login-form form {
    margin-bottom: 15px;
    background: #f7f7f7;
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    padding: 30px;
}
.login-form h2 {
    margin: 0 0 15px;
}
.form-control, .btn {
    min-height: 38px;
    border-radius: 2px;
}
.btn {        
    font-size: 15px;
    font-weight: bold;
}
</style>
    </head>
    
    <body>
      
        
        <div class="login-form">
    <form action="URLloginController" method="POST">
        <h2 class="text-center">Log in</h2>     
       <% String message=(String)request.getAttribute("message");
        if(message != null){
    %>
        <p style="color: red"><%=message%></p>
        <%}%>
        
        <div class="form-group">
            <input type="text" name="userName" class="form-control" placeholder="userName" required="required">
        </div>
        <div class="form-group">
            <input type="password" name="passWord" class="form-control" placeholder="passWord" required="required">
        </div>
        
        <div class="form-group">
            <button type="submit" name="submit" class="btn btn-primary btn-block">Log in</button>
              <input type="hidden" name="service" value="login">
        </div>
         
    </form>
        <p class="text-center"><a href="URLloginController?service=register">Create an Account</a></p>
</div>
    </body>
</html>

