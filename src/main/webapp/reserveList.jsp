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
<table class="table table-hover">
    <caption>reverse</caption>
    <thead>
    <tr>
        <th>No.</th>
        <th>timeslot</th>
        <th>contact User </th>
        <th>state</th>
        <th>Operator</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="appointment"  items="${appointments}" >
        <tr>
            <td>${appointment.appointmentId}</td>
            <td>${appointment.timeslot.startTime}-${appointment.timeslot.endTime}</td>
            <td>${appointment.firstName} ${appointment.lastName}</td>
            <td>${appointment.state}</td>
            <td>
                <button type="button" onlcick="approvel()" class="btn btn-default" data-dismiss="modal">Approvel
                </button>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>

</body>
</html>
