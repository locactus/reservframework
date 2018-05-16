<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <link href="https://cdn.bootcss.com/bootstrap-select/1.12.1/css/bootstrap-select.min.css" rel="stylesheet">
    <link href="/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <script src="/js/jquery.min.js" ></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-select/1.12.1/js/bootstrap-select.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
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
    <%--<div class="form-group">--%>

        <%--<label class="col-lg-1 control-label">Time slot:</label>--%>

        <%--<select  class="selectpicker show-menu-arrow form-control" name="timeslotStr" multiple>--%>

            <%--<c:forEach var="timeslot"  items="${timeslotList}" >--%>
                <%--<option value="${timeslot.timeslotId}"><c:out value="${timeslot.startTime} - ${timeslot.endTime}" /></option>--%>
            <%--</c:forEach>--%>
        <%--</select>--%>

    <%--</div>--%>

    <fieldset>
        <legend>Add time slot</legend>

        <!-- T1 时间精确到年月日时分秒：2017-07-13 02:25:07am-->
        <div class="control-group">
            <label class="control-label">Start DateTime</label>
            <div class="controls input-append date form_datetime" data-date="2017-07-16T05:25:07Z" data-date-format="yyyy-mm-dd hh:ii:00" data-link-field="dtp_input1">

                <input size="20" type="text" value="" name="startDate" readonly>
                <span class="add-on"><i class="icon-remove"></i></span>
                <span class="add-on"><i class="icon-th"></i></span>
            </div>
            <input type="hidden" id="dtp_input1" value="" /><br/>
        </div>

        <div class="control-group">
            <label class="control-label">End DateTime</label>
            <div class="controls input-append date form_datetime" data-date="2017-07-16T05:25:07Z" data-date-format="yyyy-mm-dd hh:ii:00" data-link-field="dtp_input1">

                <input size="20" type="text" value="" name="endDate" readonly>
                <span class="add-on"><i class="icon-remove"></i></span>
                <span class="add-on"><i class="icon-th"></i></span>
            </div>
            <input type="hidden" id="dtp_input2" value="" /><br/>
        </div>

    </fieldset>


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
<script>

    $('.form_datetime').datetimepicker({
        language:  'fr',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1
    });


</script>
</body>
</html>
