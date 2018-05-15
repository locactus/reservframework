<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <script src="/js/jquery.min.js" ></script>
    <script src="/js/bootstrap.min.js"></script>
</head>
<body>

<form role="form">

    <div class="form-group">

        <label for="name" >Time slot</label>

        <select id="example-multiple" multiple="multiple">
            <option value="cheese">8:00-9:00</option>
            <option value="tomatoes">8:00-9:00</option>
            <option value="mozarella">8:00-9:00</option>
            <option value="mushrooms">8:00-9:00</option>
            <option value="pepperoni">8:00-9:00</option>
            <option value="onions">8:00-9:00</option>
        </select>
        </br>


    </div>

    <div class="form-group">

        <label for="user" >contact User</label>


        <select id="example-radio">
            <option value="cheese">Cheese</option>
            <option value="tomatoes">Tomatoes</option>
            <option value="mozarella">Mozzarella</option>
            <option value="mushrooms">Mushrooms</option>
            <option value="pepperoni">Pepperoni</option>
            <option value="onions">Onions</option>
        </select>
        </br>
    </div>

    <button type="button" class="btn btn-default" data-dismiss="modal">Submit
    </button>

</form>


</body>
</html>
