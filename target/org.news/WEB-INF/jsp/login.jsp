<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<html>
<head>
    <title>用户登录</title>
    <%@include file="common/header.jsp"%>
</head>
<body>
<div id="login-page">
    <div class="container">
        <form class="form-login" action="${pageContext.request.contextPath}/user/login" method="post">
            <h2 class="form-login-heading">用户登录</h2>
            <div class="login-wrap">
                <input type="text" id="username" name="username" class="form-control" placeholder="User ID" autofocus>
                <br>
                <input type="password" id="password" name="password" class="form-control" placeholder="Password">
                <label class="checkbox">
                    <input type="checkbox" value="remember-me"> Remember me
                    <span class="pull-right">
            <a data-toggle="modal" href="${pageContext.request.contextPath}/user/forgetpassword.html"> 忘记密码?</a>
            </span>
                </label>
                <button class="btn btn-theme btn-block" id="submit" type="submit"><i class="fa fa-lock"></i>登 录</button>
                <hr>
                <div style="color: rebeccapurple">
                        ${result.errMes}
                    <%
                        session.removeAttribute("result");
                    %>
                </div>
                <span id="killPhoneMessage" class="glyphicon"></span>
                <div class="registration">
                    还没有账户?<br/>
                    <a class="" href="${pageContext.request.contextPath}/user/register.html">
                        注册一个
                    </a>
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
