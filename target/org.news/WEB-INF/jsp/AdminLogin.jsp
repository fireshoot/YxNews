<%@ page import="org.springframework.ui.Model" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<html>
<head>
    <title>管理员登录</title>
    <%@include file="common/header.jsp"%>
</head>
<body>
<div id="login-page">
    <div class="container">
        <form class="form-login" action="${pageContext.request.contextPath}/user/toadminLogin" method="post">
            <h2 class="form-login-heading">管理员登录</h2>
            <div class="login-wrap">
                <input type="text" id="username" name="username" class="form-control" placeholder="User ID" autofocus>
                <br>
                <input type="password" id="password" name="password" class="form-control" placeholder="Password">
                <label class="checkbox">
                    <br>
                </label>
                <button class="btn btn-theme btn-block" id="submit" type="submit"><i class="fa fa-lock"></i>登 录</button>
                <div>
                    ${adminresult.errMes}
                    <%
                        session.removeAttribute("adminresult");
                    %>
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
    $.backstretch("${pageContext.request.contextPath}/resource/img/login-bg.jpg", {
        speed: 500
    });

    $(function(){
        user.Login.Submit();
    });
</script>

</body>
</html>
