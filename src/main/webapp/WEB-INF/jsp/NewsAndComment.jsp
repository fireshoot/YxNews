<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>
<html>
<head>
    <title>个人中心</title>
    <%@include file="common/header.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/to-do.css">
    <!-- Custom Theme files -->
    <link href="https://cdn.bootcss.com/twitter-bootstrap/4.2.1/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resource/css/style2.css" rel="stylesheet" type="text/css"
          media="all"/>
    <!-- Custom Theme files -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!--webfont-->
    <link href='http://fonts.useso.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic'
          rel='stylesheet' type='text/css'>
</head>
<body>


<!--sidebar end-->
<!--main content start-->
<section id="main-content33">
    <div class="mt" style="margin-right: 5px;margin-left: 5px;margin-top: 5px;margin-bottom: 5px">
        <div class="col-md-12">
            <%-- <div style="color: rebeccapurple">${result}</div>--%>
            <div class="content-panel">
                <h4><i class="fa fa-angle-right"></i> 新闻列表</h4>
                <hr>
                <table class="table table-striped table-advance table-hover">
                    <thead>
                    <tr>
                        <th><i class="fa fa-bullhorn"></i> 编号</th>
                        <th><i class="fa fa-tags"></i> 类别</th>
                        <th><i class="fa fa-user"></i> 作者账户</th>
                        <th><i class="fa fa-tasks"></i> 标题</th>
                        <th class="hidden-phone"><i class="fa fa-question-circle"></i> 描述</th>
                        <th class="hidden-phone"><i class="fa fa-bars"></i> 发表时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="news" items="${news}">
                        <tr>
                            <td>
                                    ${news.aNew.newId}
                            </td>
                            <td class="hidden-phone">${news.typeName}</td>
                            <td>${news.userName}</td>
                            <td>${news.aNew.title}</td>
                            <td id="desc">${news.aNew.keyWords}"</td>
                            <td><fmt:formatDate value="${news.aNew.createTime}"
                                                pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                            <td>
                                <a href="/new/detail?newId=${news.aNew.newId}">
                                    <button class="btn btn-success">
                                        <i class="fa fa-check">
                                            详情</i></button>
                                </a>
                                <a href="/new/edit?newId=${news.aNew.newId}&userName=${news.userName}">
                                    <button class="btn btn-primary"><i class="fa fa-pencil">修改
                                    </i></button>
                                </a>
                                <a href="/new/delete?newId=${news.aNew.newId}&userName=${news.userName}">
                                    <button class="btn btn-danger">
                                        <i class="fa fa-trash-o ">
                                            删除</i></button>
                                </a>

                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
            <!-- /content-panel -->
        </div>
        <!-- /col-md-12 -->
    </div>
</section>
<!-- /MAIN CONTENT -->
<!--main content end-->
<!--footer start-->
<!--sidebar end-->




<!--main content start-->
<section id="main-content44">
    <div class="mt" style="margin-right: 5px;margin-left: 5px;margin-top: 5px;margin-bottom: 5px">
        <div class="col-md-12">
            <div style="color: rebeccapurple">${result}</div>
            <div class="content-panel">
                <h4><i class="fa fa-angle-right"></i> 评论列表</h4>
                <hr>
                <table class="table table-striped table-advance table-hover">
                    <thead>
                    <tr>
                        <th><i class="fa fa-bullhorn"></i> 编号</th>
                        <th><i class="fa fa-tags"></i> 评论内容</th>
                        <th><i class="fa fa-user"></i> 评论用户</th>
                        <th><i class="fa fa-tasks"></i> 新闻标题</th>
                        <th class="hidden-phone"><i class="fa fa-bars"></i> 发表时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="comment" items="${comment}">
                        <tr>
                            <td>
                                    ${comment.comment.commentId}
                            </td>
                            <td class="hidden-phone">${comment.comment.content}</td>
                            <td>${comment.username}</td>
                            <td>${comment.newtitle}</td>
                            <td><fmt:formatDate value="${comment.comment.createTime}"
                                                pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                            <td>
                                <a href="/new/deletecomment?commentId=${comment.comment.commentId}&userName=${comment.username}">
                                    <button class="btn btn-danger">
                                        <i class="fa fa-trash-o ">
                                            删除</i></button>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
            <!-- /content-panel -->
        </div>
        <!-- /col-md-12 -->
    </div>
</section>
<!-- /MAIN CONTENT -->
<!--main content end-->
<!--footer start-->
</div>

<div class="col-md-4 right_column" style="float: right;">
    <div class="item">
        <header>
            <h2 class="with-line">新闻分类</h2>
        </header>
        <ul>
            <li><a href="#">热点</a></li>
            <li><a href="#">娱乐</a></li>
            <li><a href="#">科技</a></li>
            <li><a href="#">军事</a></li>
            <li><a href="#">体育</a></li>
            <li><a href="#">国际</a></li>
        </ul>
    </div>
    <div class="item2">
        <header>
            <h2 class="with-line">与我相关</h2>
        </header>
        <ul>
            <li><a href="http://localhost:8080/new/editor.html">添加文章</a></li>
            <li><a href="#">我发表的文章</a></li>
            <li><a href="#">我的评论</a></li>
            <li><a href="#">我的消息</a></li>
        </ul>
    </div>
</div>
<div class="clearfix"></div>


<div class="footer text-center">
    <div class="copyright">
        <p> © Copyrights <strong>杨鑫</strong>. All Rights Reserved
            <a target="_blank" href="https://github.com/fireshoot/YxNews">项目地址</a></p>
    </div>
</div>


${result.data}
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/twitter-bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-backstretch/2.0.4/jquery.backstretch.min.js"></script>

<script class="include" type="text/javascript"
        src="${pageContext.request.contextPath}/resource/lib/jquery.dcjqaccordion.2.7.js"></script>
<script src="https://cdn.bootcss.com/jquery-scrollTo/2.1.2/jquery.scrollTo.min.js"></script>
<script src="https://cdn.bootcss.com/jquery.nicescroll/3.7.6/jquery.nicescroll.js"></script>
<script src="${pageContext.request.contextPath}/resource/lib/common-scripts.js"></script>

<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<%--
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/css/bootstrap-wysihtml5/wysihtml5-0.3.0.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/css/bootstrap-wysihtml5/bootstrap-wysihtml5.js"></script>
--%>


<script src="${pageContext.request.contextPath}/resource/script/tasks.js" type="text/javascript"></script>
<script>
    jQuery(document).ready(function () {
        TaskList.initTaskWidget();
    });

    function detail(id) {
        location.href = "/new/delete?newId=" + id;
    }

    var desc = document.getElementById('desc').innerHTML;
    var text = desc.toString().substring(0, 20) + "......";
    var desc1 = document.getElementById('desc');

    desc1.innerHTML = text;


    /*
    * <p>你的事件应该绑定在按钮上，而不是ready上。<br/>var bready=false;<br/>B.addListener(&quot;ready&quot;,function(){bready=true;});//防止在按钮按下的时候，编辑器还没初始化<br/><br/>bt.addListener(&quot;click&quot;,function(){<br/>if (bready) B.setContent(&quot;内容&quot;);<br/>else B.addListener(&quot;ready&quot;,function(){B.setContent(&quot;内容&quot;);});//如果点下按钮时还没初始化，那么就等初始化完成的时候自动把内容放进去<br/>})<img src="/ueditor/jsp/upload/image/20181228/1545998530000092022.jpg" title="1545998530000092022.jpg" alt="机械师壁纸 (13).jpg"/></p>
    * */

    //wysihtml5 start

    /*    $('.wysihtml5').wysihtml5();*/

    //wysihtml5 end
    $(function () {
        $("#sortable").sortable();
        $("#sortable").disableSelection();
    });
</script>
</body>
</html>
