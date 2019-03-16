<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>
<html>
<head>
    <title>用户注册</title>
    <%@include file="common/header.jsp" %>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/script/register.js"></script>
</head>
<body>

<section id="main-content">
    <section class="wrapper">
        <div class="row mt">
            <div class="col-lg-12">
                <div class="form-panel">
                    <label class="col-sm-2 col-sm-2 control-label" style="color: red">
                        ${result.errMes}</label>
                    <h4 class="mb"><i class="fa fa-angle-right"></i>用户注册</h4>
                    <form class="form-horizontal style-form" method="post" onsubmit="return checkAll()"
                          action="${pageContext.request.contextPath}/user/toregister">

                        <div class="form-group">
                            <label class="col-sm-2 col-sm-2 control-label">用户名(昵称)</label>
                            <div class="col-sm-10">
                                <input class="form-control" id="username" name="userName"
                                       onblur="checkname()"  type="text">
                                <span id="tip_name" style="color: rebeccapurple"></span>
                            </div>

                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 col-sm-2 control-label">密 码</label>
                            <div class="col-sm-10">
                                <input type="password" id="password" name="userPassword" onblur="checkpsd1()"
                                       class="form-control" placeholder="">
                                <span class="help-block" id="tip_password">密码长度6-25位</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 col-sm-2 control-label">确认密码</label>
                            <div class="col-sm-10">
                                <input type="password" id="password1" name="aginpassword" onblur="checkpsd2()"
                                       class="form-control" placeholder="">
                                <span class="help-block" id="tip_password1">两次密码要相同</span>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 col-sm-2 control-label">邮 箱</label>
                            <div class="col-sm-10">
                                <input class="form-control" id="email" name="userEmail"
                                       onblur="checkemail()" <%--id="focusedInput"--%> type="text">
                                <span id="tip_email" style="color: rebeccapurple"></span>
                            </div>

                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 col-sm-2 control-label">账户类型(0:普通用户)</label>
                            <div class="col-sm-10">
                                <input class="form-control" name="userType" id="disabledInput" value=0 type="text"
                                       disabled>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 col-sm-2 control-label">年 龄</label>
                            <div class="col-sm-10">
                                <input type="text" id="age" onblur="Age()" name="userAge" class="form-control"
                                       placeholder="0-100">
                                <span id="tip_age" style="color: rebeccapurple"></span>
                            </div>

                        </div>
                        <br>
                        <button type="submit" class="btn btn-theme">注 册</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <button type="reset" class="btn btn-theme">取 消</button>
                    </form>
                </div>
            </div>
            <!-- col-lg-12-->
        </div>
    </section>
    <!-- /wrapper -->
</section>

<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/twitter-bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-backstretch/2.0.4/jquery.backstretch.min.js"></script>

<script class="include" type="text/javascript"
        src="${pageContext.request.contextPath}/resource/lib/jquery.dcjqaccordion.2.7.js"></script>
<script src="https://cdn.bootcss.com/jquery-scrollTo/2.1.2/jquery.scrollTo.min.js"></script>
<script src="https://cdn.bootcss.com/jquery.nicescroll/3.7.6/jquery.nicescroll.js"></script>
<script src="${pageContext.request.contextPath}/resource/lib/common-scripts.js"></script>
<script src="${pageContext.request.contextPath}/resource/lib/jquery-ui-1.9.2.custom.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-switch/4.0.0-alpha.1/js/bootstrap-switch.js"></script>
<script src="https://cdn.bootcss.com/jquery-tagsinput/1.3.6/jquery.tagsinput.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/resource/lib/bootstrap-daterangepicker/daterangepicker.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/resource/lib/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
<script src="${pageContext.request.contextPath}/resource/lib/form-component.js"></script>
<script src="${pageContext.request.contextPath}/resource/script/user.js" type="text/javascript"
        charset="UTF-8"></script>

<script type="text/javascript">
    $.backstretch("${pageContext.request.contextPath}/resource/img/ny.jpg", {
        speed: 500
    });

    $(function () {
        user.Login.Register();
    });

</script>
</body>
</html>