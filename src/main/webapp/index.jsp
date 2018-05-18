<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="css/login.css"/>
    <link href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css" rel="stylesheet" >


</head>
<body>


<div id="app" >
    <form class="login-container" action="${pageContext.request.contextPath}/user?action=login" method="post">
        <h3 class="title">Login</h3>

        <div class="item">
            <label >
                <input id="username" name="username" class="form-control" type="text"  placeholder="User name">
            </label>

        </div>

        <div class="form-check">
            <input class="form-check-input" type="radio" name="usertype" id="clientRadio" value="client" checked>
            <label class="form-check-label" for="clientRadio">
                Client
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="usertype" id="staffRadio" value="staff">
            <label class="form-check-label" for="staffRadio">
                Staff
            </label>
        </div>


        <div class="item">
            <label >
                <input class="btn btn-success"  type="submit" value="Login">
            </label>
        </div>

    </form>
</div>



<script src="/js/jquery.min.js" ></script>
<script src="https://getbootstrap.com/docs/4.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
