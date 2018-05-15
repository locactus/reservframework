<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <link href="/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
</head>
<body>


<div class="container">
    <!--
    说明：
    1）data-date="2017-07-16T05:25:07Z"
                        设置的是开始的时间，即第一次打开日历是显示的时间；

    2）data-date-format="dd MM yyyy - HH:ii p"
                        设置的是时间的显示格式；其中MM显示的是英文月份，mm显示的是数字中文；
                        可以根据个人爱好设置为 yyyy-mm-dd 等格式。

     -->
    <form action="" class="form-horizontal">
        <fieldset>
            <legend>Test</legend>

            <!-- T1 时间精确到年月日时分秒：2017-07-13 02:25:07am-->
            <div class="control-group">
                <label class="control-label">Start DateTime</label>
                <div class="controls input-append date form_datetime" data-date="2017-07-16T05:25:07Z" data-date-format="mm/dd/yyyy HH:ii p" data-link-field="dtp_input1">

                    <input size="20" type="text" value="" readonly>
                    <span class="add-on"><i class="icon-remove"></i></span>
                    <span class="add-on"><i class="icon-th"></i></span>
                </div>
                <input type="hidden" id="dtp_input1" value="" /><br/>
            </div>

            <div class="control-group">
                <label class="control-label">End DateTime</label>
                <div class="controls input-append date form_datetime" data-date="2017-07-16T05:25:07Z" data-date-format="mm/dd/yyyy HH:ii p" data-link-field="dtp_input1">

                    <input size="20" type="text" value="" readonly>
                    <span class="add-on"><i class="icon-remove"></i></span>
                    <span class="add-on"><i class="icon-th"></i></span>
                </div>
                <input type="hidden" id="dtp_input2" value="" /><br/>
            </div>

        </fieldset>
        <button type="button" class="btn btn-default" data-dismiss="modal">Save
        </button>
    </form>
</div>
<script src="/js/jquery.min.js" ></script>
<script src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript">
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
