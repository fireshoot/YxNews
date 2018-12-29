<%@ page import="entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <title>文章编辑器</title>
    <style>
        .form-group {
            border: 1px solid #F2F3F6;
            display: inline-block;
            width: 80%;
            margin-bottom: 0;
        }
        .form-group label {
            line-height: 34px;
            width: 5%;
            float: left;
            padding-left: 5px;
            margin-bottom: 0;
        }
        .form-group input, .form-group input:focus {
            border: none;
            padding: 0;
            width: 80%;
            float: left;
            height: 6%;
        }
        h4 {
            font-size: 24px;
            color: #a2a2a2;
            font-weight: 300;
        }
        .btn-theme {
            color: #fff;
            background-color: #4ECDC4;
            border-color: #48bcb4;
        }
    </style>
</head>
<body>
<h4 style="margin-left: 100px;margin-top: 10px">${title}插入新闻</h4>

<div style="margin-left: 100px;margin-right: 100px;margin-top:50px;margin-bottom: 200px">
    <%
        User user=(User)session.getAttribute("user");
    %>

    <span>${updateResult.errMes}</span>

    <form action="${pageContext.request.contextPath}/new/update" method="post">

        <input style="display: none" name="newId" value="${editResult.data.aNew.newId}">

        <div class="form-group">
            <label for="to" class="">标 题:</label>
            <input type="text" name="title" tabindex="1" id="to" class="form-control" value="${editResult.data.aNew.title}">
        </div>
        <div class="form-group">
            <label for="category" class="">类 型:</label>
            <input type="text"  name="categoryId" tabindex="1" id="category" class="form-control"
                   value="${editResult.data.aNew.categoryId}">
            <span id="tip_category" style="color: rebeccapurple"></span>
        </div>
        <div class="form-group">
            <label for="dov" class="">作者:</label>
            <input type="text" name="author " tabindex="1" id="dov" class="form-control" value="${editResult.data.user.userName}">
        </div>
        <div class="form-group">
            <label for="do" class="">关键字:</label>
            <input type="text" name="keyWords" tabindex="1" id="do" class="form-control" value="${editResult.data.aNew.keyWords}">
        </div>
        <div id="NewContent" style="display: none">${editResult.data.aNew.content}</div>
        <!-- 加载编辑器的容器 -->
        <script id="container" name="content" type="text/plain">
        </script>

        <button class="btn-theme" id="submit" type="submit"><i class="fa fa-lock"></i>提 交</button>
    </form>
</div>

<!-- 配置文件 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/ueditor/ueditor.config.js" ></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/ueditor/ueditor.all.js" ></script>
<!-- 实例化编辑器 -->
<script type="text/javascript">
    var ue = UE.getEditor('container');
    var tsg=document.getElementById('NewContent').innerHTML;
    setTimeout(function () {
        ue.setContent(tsg.toString());
    },500)


</script>


</body>
</html>
