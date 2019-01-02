<%@ page import="entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>
<html>
<head>
    <title>后台主页</title>
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
        <a href="index.html" class="logo"><b><span>新闻页</span></b></a>
        <!--logo end-->
        <div class="top-menu">
            <ul class="pull-right top-menu">
                <br>
                <%
                    User user=(User)session.getAttribute("user");
                    if(user!=null){
                        %>
                         <li><a class="logout" href="http://localhost:8080/user/Logout?userName=<%=user.getUserName()%>"
                         >Logout</a></li>
                <%
                    }else{
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
                        if(user!=null) {/*说明已登录*/
                    %>
                    <img src="${pageContext.request.contextPath}/resource/img/ui-sam.jpg" class="img-circle" width="80">
                    <%
                        }else{
                            %>
                    <img src="" class="img-circle" width="80">
                    <%
                        }
                        %>

                </a>
                </p>
                <%

                    if(user!=null){/*说明已登录*/
                        %>
                    <h5 class="centered">管理员:<%=user.getUserName()%></h5>
                <%
                    }else{
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
                    <a href="javascript:;" class="dcjq-parent">
                        <i class="fa fa-desktop"></i>
                        <span>文章列表</span>
                        <span class="dcjq-icon"></span></a>
                </li>
                <li class="sub-menu dcjq-parent-li">
                    <a href="javascript:;" class="dcjq-parent">
                        <i class="fa fa-desktop"></i>
                        <span>评论列表</span>
                        <span class="dcjq-icon"></span></a>
                </li>
                <li class="sub-menu dcjq-parent-li">
                    <a href="javascript:;" class="dcjq-parent">
                        <i class="fa fa-desktop"></i>
                        <span>用户列表</span>
                        <span class="dcjq-icon"></span></a>
                    <ul class="sub" style="display: none;">
                        <li><a href="">普通用户</a></li>
                        <li><a href="">认证用户</a></li>
                        <li><a href="">管理员</a></li>
                    </ul>
                </li>
                <li class="sub-menu dcjq-parent-li">
                    <a href="javascript:;" class="dcjq-parent">
                        <i class="fa fa-desktop"></i>
                        <span>功能三</span>
                        <span class="dcjq-icon"></span></a>
                    <ul class="sub" style="display: none;">
                        <li><a href="">次级</a></li>
                        <li><a href="">次级</a></li>
                        <li><a href="">次级</a></li>
                    </ul>
                </li>
            </ul>
            <!-- sidebar menu end-->
        </div>
    </aside>



 <%--  <jsp:include page="newlist.jsp"/>--%>


   <%@include file="commentlist.jsp"%>





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
