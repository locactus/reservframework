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
<%--<button type="button" class="btn btn-default" onclick="addTimeslot()" data-dismiss="modal">Create TimeSlot--%>
<%--</button>--%>
<button type="button" class="btn btn-default" onclick="addAppo()" data-dismiss="modal">Create Appo
</button>
<table class="table table-hover">
    <caption>appo List</caption>
    <thead>
    <tr>
        <th>No.</th>
        <th>timeslot</th>
        <th>contact User</th>
        <th>state</th>

    </tr>
    </thead>
    <tbody>

    <c:forEach var="appointment"  items="${appointments}" >
        <tr>
            <td>${appointment.appointmentId}</td>
            <td>${appointment.timeslot.startTime}-${appointment.timeslot.endTime}</td>
            <td>${appointment.firstName} ${appointment.lastName}</td>
            <td>${appointment.state}</td>

        </tr>
    </c:forEach>

    </tbody>
</table>
<script>
    function addAppo(){
        window.location.href="${pageContext.request.contextPath}/appointment?action=toaddAppo";
    }
    function addTimeslot(){
        window.location.href="${pageContext.request.contextPath}/appointment?action=toaddtimeslot";
    }

</script>
</body>
</html>
