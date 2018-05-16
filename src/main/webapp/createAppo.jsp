<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <link href="https://cdn.bootcss.com/bootstrap-select/1.12.1/css/bootstrap-select.min.css" rel="stylesheet">
    <script src="/js/jquery.min.js" ></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-select/1.12.1/js/bootstrap-select.min.js"></script>
    <style>

        .center_div{
            margin: 0 auto;
            width:60% /* value of your choice which suits your alignment */
        }
    </style>
</head>
<body>
<div class="container center_div">
    Create Appointment
<form action="${pageContext.request.contextPath}/appointment" type="post" >
<input type="hidden" value="add" name="action" />
    <div class="form-group">

        <label class="col-lg-1 control-label">Time slot:</label>

        <select  class="selectpicker show-menu-arrow form-control" name="timeslotStr" multiple>

            <c:forEach var="timeslot"  items="${timeslotList}" >
                <option value="${timeslot.timeslotId}"><c:out value="${timeslot.startTime} - ${timeslot.endTime}" /></option>
            </c:forEach>
        </select>

    </div>

    <div class="form-group">
        <label >First Name</label>
        <input type="text" class="form-control" name="firstName"  >
    </div>

    <div class="form-group">
        <label >Last Name</label>
        <input type="text" class="form-control" name="lastName"  >
    </div>

    <div class="form-group">
        <label >Phone Number</label>
        <input type="text" class="form-control" name="phoneNumber"  >
    </div>

    <div class="form-group">
        <label >Email</label>
        <input type="text" class="form-control" name="email"  >
    </div>


    <button type="submit" class="btn btn-default" data-dismiss="modal">Submit
    </button>

</form>
</div>

</body>
</html>
