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
    <tr>
        <td>1</td>
        <td>8:00-12:00</td>
        <td>xiaoxiao</td>
        <td>pending</td>
        <td>
            <button type="button" class="btn btn-default" data-dismiss="modal">Reserve
            </button>
        </td>
    </tr>
    <tr>
        <td>2</td>
        <td>8:00-12:00</td>
        <td>xiaoxiao</td>
        <td>reserved</td>
        <td>
            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel
            </button>
        </td>
    </tr>
    <tr>
        <td>3</td>
        <td>8:00-12:00</td>
        <td>xiaoxiao</td>
        <td>open</td>
        <td>
            <button type="button" class="btn btn-default" data-dismiss="modal">Reserve
            </button>
        </td>
    </tr>
    </tbody>
</table>

</body>
</html>
