<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css" rel="stylesheet" >
    <script src="/js/jquery.min.js" ></script>
    <script src="https://getbootstrap.com/docs/4.0/dist/js/bootstrap.min.js"></script>
</head>
<body>
<table class="table table-hover" style="padding: 0px 100px">
    <caption></caption>
    <thead class="thead-dark" >
    <tr>
        <th scope="col">No.</th>
        <th scope="col">Appointment Time</th>
        <th scope="col">Client's Name </th>
        <th scope="col">State</th>
        <th scope="col">Process</th>
    </tr>
    </thead>
    <tbody id="appendBody" >
    <%--<c:forEach var="appointment"  items="${appointments}" >--%>
        <%--<tr>--%>
            <%--<td>${appointment.appointmentId}</td>--%>
            <%--<td><fmt:formatDate value="${appointment.timeslot.startTime}" pattern="EEE MMM d yyyy, HH:mm"/> - <fmt:formatDate value="${appointment.timeslot.endTime}" pattern="HH:mm"/></td>--%>
            <%--<td>${appointment.firstName} ${appointment.lastName}</td>--%>
            <%--<td>${appointment.state}</td>--%>
            <%--<td>--%>
                <%--<c:if test="${appointment.state eq 'PENDING'}">--%>
                    <%--<button type="button" onclick="approvel('${appointment.appointmentId}')" class="btn btn-danger" data-dismiss="modal">Approvel--%>
                    <%--</button>--%>
                <%--</c:if>--%>
            <%--</td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>

    </tbody>
</table>
<p style="text-align:center;"> <img id="loading" src="img/Loading_icon.gif"/> </p>

<button type="button" class="btn btn-primary" onclick="signOut()" data-dismiss="modal">Sign out
</button>

<script>
    function getRootPath(){
        var curWwwPath=window.document.location.href;
        var pathName=window.document.location.pathname;
        var pos=curWwwPath.indexOf(pathName);
        var localhostPaht=curWwwPath.substring(0,pos);
        var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
        return(localhostPaht+projectName);
    }

    function approvel(appointmentId){
        window.location.href="${pageContext.request.contextPath}/appointment?action=confirm&appointmentId="+appointmentId;
    }

    $(function(){
        //get list
        $.get(getRootPath() + '/appointment?action=getList').done(function (o) {
            $("#loading").hide();
            let obj = JSON.parse(o);
            $.each(obj,function(index,e){

                var tr = $("<tr>");
                $("<td>").text(e.appointmentId).appendTo(tr);
                $("<td>").text(e.startTimeStr+" -"+ e.endTimeStr)
                        .appendTo(tr);
                $("<td>").text(e.firstName+" "+ e.lastName)
                        .appendTo(tr);
                $("<td>").text(e.state)
                        .appendTo(tr);
                if(e.state=='PENDING'){
                    $("<button>").attr("onclick",'approvel("'+ e.appointmentId+'")')
                                 .attr("class","btn btn-danger").text("Approvel").appendTo(tr);
                }
                tr.appendTo($("#appendBody"));
            });
        });
    });

    function signOut(){
        window.location.href="${pageContext.request.contextPath}/";
    }

</script>
</body>
</html>
