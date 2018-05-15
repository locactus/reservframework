<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <link rel="stylesheet" href="css/style.css"/>

</head>
<body>


<div id="app" >
    <form class="login-container" action="${pageContext.request.contextPath}/user?action=login" method="post">
        <h3 class="title">Login</h3>
        <div class="item">
            <label >
                <input name="username" class="input" type="text"  placeholder="User name">
            </label>
        </div>

        <div class="item">
            <label >
                <input class="submit"  type="submit" value="Login">
            </label>
        </div>

    </form>
</div>

<script src="/js/jquery.min.js" ></script>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>
