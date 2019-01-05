<%@ page import="entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>
<html>
<head>
    <title>后台主页-新闻列表</title>
    <%@include file="common/header.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/to-do.css">
</head>
<body>


<section id="container">
    <!--header start-->
    <header class="header black-bg">
        <div class="sidebar-toggle-box">
            <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
        </div>
        <!--logo start-->
        <a href="http://localhost:8080/user/index.html" class="logo"><b><span>新闻页</span></b></a>
        <!--logo end-->
        <div class="top-menu">
            <ul class="pull-right top-menu">
                <br>
                <%
                    User user = (User) session.getAttribute("user");
                    if (user != null) {
                %>
                <li><a class="logout" href="http://localhost:8080/user/Logout?userName=<%=user.getUserName()%>"
                >Logout</a></li>
                <%
                } else {
                %>
                <li><a class="logout" href="http://localhost:8080/user/adminLogin.html">ToLogin</a></li>
                <%
                    }
                %>

            </ul>
        </div>
    </header>
    <!--header end-->
    <!--sidebar start-->

    <aside>
        <div id="sidebar" class="nav-collapse " tabindex="5000" style="overflow: hidden; outline: none;">
            <!-- sidebar menu start-->
            <ul class="sidebar-menu" id="nav-accordion">
                <p class="centered"><a href="profile.html">
                    <%
                        if (user != null) {/*说明已登录*/
                    %>
                    <img src="${pageContext.request.contextPath}/resource/img/ui-sam.jpg" class="img-circle" width="80">
                    <%
                    } else {
                    %>
                    <img src="" class="img-circle" width="80">
                    <%
                        }
                    %>

                </a>
                </p>
                <%

                    if (user != null) {/*说明已登录*/
                %>
                <h5 class="centered">管理员:<%=user.getUserName()%>
                </h5>
                <%
                } else {
                %>
                <h5 class="centered">请登录！！</h5>
                <%
                    }
                %>
                <li class="mt">
                    <a href="/new/adminIndex.html">
                        <i class="fa fa-dashboard"></i>
                        <span>首 页</span>
                    </a>
                </li>
                <li class="sub-menu dcjq-parent-li">
                    <a href="#" class="dcjq-parent">
                        <i class="fa fa-desktop"></i>
                        <span>文章列表</span>
                        <span class="dcjq-icon"></span></a>
                </li>
                <li class="sub-menu dcjq-parent-li">
                    <a href="http://localhost:8080/new/commentlist.html" class="dcjq-parent">
                        <i class="fa fa-desktop"></i>
                        <span>评论列表</span>
                        <span class="dcjq-icon"></span></a>
                </li>
                <li class="sub-menu dcjq-parent-li">
                    <a href="http://localhost:8080/new/userlist.html" class="dcjq-parent">
                        <i class="fa fa-desktop"></i>
                        <span>用户列表</span>
                        <span class="dcjq-icon"></span></a>
                </li>
                <li class="sub-menu dcjq-parent-li">
                    <a href="http://localhost:8080/new/editor.html?index=2" class="dcjq-parent">
                        <i class="fa fa-desktop"></i>
                        <span>添加文章</span>
                        <span class="dcjq-icon"></span></a>
                </li>
            </ul>
            <!-- sidebar menu end-->
        </div>
    </aside>


    <!--sidebar end-->
    <!--main content start-->
    <section id="main-content">
        <div class="mt" style="margin-right: 5px;margin-left: 5px;margin-top: 5px;margin-bottom: 5px">

            <div class="col-md-12">
                <div style="color: rebeccapurple"></div>
                <div class="content-panel">
                    <h4><i class="fa fa-angle-right"></i> 新闻列表</h4>
                    <hr>
                    <div class="form-panel">
                        <form class="form-inline" role="form"
                              action="/new/seleceByLike" method="post"
                              style="display: contents">
                            <div class="form-group" style="display: contents">
                                <label class="sr-only" for="exampleInput1">模糊查询</label>
                                <span style="color: rebeccapurple" id="tip1"></span>
                                <input type="text" class="form-control" name="selectkey"  id="exampleInput1"
                                       placeholder="模糊查询">
                            </div>
                            <button type="submit" class="btn btn-theme">查找</button>
                        </form>
                        <form class="form-inline"
                              action="/new/seleceByKey"
                              style="display: contents">
                            <div class="form-group" style="display: contents">
                                <label class="sr-only" for="exampleInput2">关键字查询</label>
                                <span style="color: rebeccapurple" id="tip2"></span>
                                <input type="text" class="form-control" id="exampleInput2" name="selectkey"
                                       placeholder="关键字查询">
                            </div>
                            <button type="submit" class="btn btn-theme">查找</button>
                        </form>

                    </div>
                    <!-- /form-panel -->


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
                        <c:forEach var="news" items="${Newslist}">
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
                                    <a href="/new/delete?newId=${news.aNew.newId}&userName=${news.userName}&tag=2">
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

    <%-- <%@include file="commentlist.jsp"%>--%>


    <footer class="site-footer">
        <div class="text-center">
            <p>
                © Copyrights <strong>杨鑫</strong>. All Rights Reserved
            </p>
            <div class="credits">
                Created with template by <a href="https://github.com/fireshoot/YxNews">Github</a>
            </div>
            <a href="adminIndex.html#" class="go-top">
                <i class="fa fa-angle-up"></i>
            </a>
        </div>
    </footer>
    <!--footer end-->
</section>

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

    function checktext1() {
        text = document.getElementById("exampleInput1");
        tip = document.getElementById("tip1");
        if(text.value.toString()==""){
            tip.innerHTML="输入框不能为空";
            return false;
        }else{
            tip.innerHTML="";
            return true;
        }
    }
    function checktext2() {
        text = document.getElementById("exampleInput2");
        tip = document.getElementById("tip2");
        if(text.value.toString()==""){
            tip.innerHTML="输入框不能为空";
            return false;
        }else{
            tip.innerHTML="";
            return true;
        }
    }

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
