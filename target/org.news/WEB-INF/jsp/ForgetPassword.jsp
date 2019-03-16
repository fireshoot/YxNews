<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<html>
<head>
    <title>忘记密码</title>
    <%@include file="common/header.jsp"%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/script/register.js"></script>
</head>
<body>
<div id="login-page">
    <div class="container">
        <form class="form-login"  onsubmit="return forgetcheckAll()"
              action="${pageContext.request.contextPath}/user/toforgetpassword" method="post">
            <h2 class="form-login-heading">找回密码</h2>
            <div class="login-wrap">
                <input type="text" id="username" onblur="checkname()" name="username" class="form-control" placeholder="User Name" autofocus>
                <span id="tip_name" style="color: rebeccapurple"></span>
                <br>
                <input type="text" id="email" name="email" onblur="checkemail()" class="form-control" placeholder="Email">
                <span id="tip_email" style="color: rebeccapurple"></span>
                <br>
                <input type="password" id="new_password" onblur="checkpsd1()" name="password" class="form-control" placeholder="New Password">
                <span id="tip_password" style="color: rebeccapurple"></span>
                    <span class="pull-right">
            <a data-toggle="modal" >通过验证邮箱重置密码</a>
            </span>
                </label>
                <button class="btn btn-theme btn-block" id="submit" type="submit"><i class="fa fa-lock"></i>找回密码</button>

                <div>
                    ${result.errMes}
                </div>
            </div>
        </form>
    </div>
</div>

<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/twitter-bootstrap/4.2.1/js/bootstrap.min.js"></script>

<script src="https://cdn.bootcss.com/jquery-backstretch/2.0.4/jquery.backstretch.min.js"></script>
<script src="${pageContext.request.contextPath}/resource/script/user.js" type="text/javascript"  charset="UTF-8"></script>

<script type="text/javascript">
    $.backstretch("${pageContext.request.contextPath}/resource/img/ny.jpg", {
        speed: 500
    });

    $(function(){
        user.Login.Submit();
    });
</script>

</body>
</html>

