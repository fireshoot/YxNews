<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>主页</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/4.2.1/css/bootstrap.css" rel="stylesheet">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <!-- Custom Theme files -->
    <link href="${pageContext.request.contextPath}/resource/css/style2.css" rel="stylesheet" type="text/css" media="all"/>
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
<!-- header-section-starts -->
<div class="header">
    <div class="container">
        <div class="logo">
            <a href="index.html"><img src="${pageContext.request.contextPath}/resource/img/apple-touch-icon.png"
                                      class="img-responsive" alt=""/></a>
        </div>
        <div class="header-right">
            <h4><i class="phone"></i>用户</h4>
            <span class="menu"></span>
            <div class="top-menu">
                <ul>
                    <li><a href="index.html">新闻主页</a></li>
                    <li><a href="about.html">About Us</a></li>
                    <li><a href="services.html">Services</a></li>
                    <li><a class="active" href="#">个人中心</a></li>
                </ul>
            </div>
            <!-- script for menu -->
            <script>
                $("span.menu").click(function () {
                    $(".top-menu").slideToggle("slow", function () {
                        // Animation complete.
                    });
                });
            </script>
            <!-- script for menu -->
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<!-- header-section-ends -->
<div class="content">
    <div class="blog-section">
        <div class="container">
            <div class="col-md-8 left_column" style="float: left">
                <h2 class="with-line">新闻列表</h2>
                <article class="clearfix">
                    <header class="grid_8 alpha">
                        <div class="head_element"><span class="el_1">07</span><span class="el_2">May</span></div>
                        <div class="sub">
                            <a href="single.html" class="readblog">Lorem ipsum dolor sit amet</a>
                            <p class="sub_head">Posted by <a href="#">Admin</a> with <a href="#">3 comment(s)</a></p>
                        </div>
                        <div class="clearfix"></div>
                    </header>
                    <div class="alpha1"><a href="single.html"><img src="${pageContext.request.contextPath}/resource/img/index-3_img-1.jpg" alt=""/></a></div>
                    <div class="grid_b4">
                        <h5>Phasellus porta. Fusce suscipit varius mi. Cum sociis natoque penatibus et mag.</h5>
                        <p>Ut tellus dolor, dapibus eget, elementum vel, cursus eleifend, elit. Aenean auctor wisi et
                            urna. Aliquam erat volutpat. Duis ac turpis. Integer rutrum ante eu lacus.</p>
                        <a href="single.html" class="btn btn-1 btn-1c">Read More</a>
                    </div>
                    <div class="clearfix"></div>
                </article>
                <article class="clearfix">
                    <header class="grid_8 alpha">
                        <div class="head_element"><span class="el_1">04</span><span class="el_2">May</span></div>
                        <div class="sub">
                            <a href="single.html" class="readblog">Praesent vestibulum molestie</a>
                            <p class="sub_head">Posted by <a href="#">Admin</a> with <a href="#">3 comment(s)</a></p>
                        </div>
                        <div class="clearfix"></div>

                    </header>
                    <div class="alpha1"><a href="single.html"><img src="${pageContext.request.contextPath}/resource/img/index-3_img-2.jpg" alt=""/></a></div>
                    <div class="grid_b4">
                        <h5>Fusce feugiat malesuada odio. Morbi nunc odio, gravida at, cursus nec, luctus a.</h5>
                        <p>Aenean auctor wisi et urna. Aliquam erat volutpat. Duis ac turpis. Integer rutem. Lorem ipsum
                            dolor sit amet, conectetu er adipiscing elit. Praesent vestibulum.</p>
                        <a href="single.html" class="btn btn-1 btn-1c">Read More</a>
                    </div>
                </article>
                <article class="clearfix">
                    <header class="grid_8 alpha">
                        <div class="head_element"><span class="el_1">02</span><span class="el_2">May</span></div>
                        <div class="sub">
                            <a href="single.html" class="readblog">Cum sociis natoque penatib</a>
                            <p class="sub_head">Posted by <a href="#">Admin</a> with <a href="#">3 comment(s)</a></p>
                        </div>
                        <div class="clearfix"></div>
                    </header>
                    <div class="alpha1"><a href="single.html"><img src="${pageContext.request.contextPath}/resource/img/index-3_img-3.jpg" alt=""></a></div>
                    <div class="grid_b4">
                        <h5>Maecenas tristique orci ac sem. Duis ultri cies pharetra magna. Donec accumsan.</h5>
                        <p>Rutrum ante eu lacus. Lorem ipsum dolor sit amet, piscing elit. Praesent vestibulum molestie
                            lacus. Aenean nonummy hendrerit mauris. Phasellus porta. </p>
                        <a href="single.html" class="btn btn-1 btn-1c">Read More</a>
                    </div>
                </article>
            </div>
            <div class="col-md-4 right_column" style="float: left;">
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
                        <li><a href="#">我发表的文章</a></li>
                        <li><a href="#">我的评论</a></li>
                        <li><a href="#">我的消息</a></li>
                    </ul>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
</div>

<div class="footer text-center">
    <div class="copyright">
        <p> © Copyrights <strong>杨鑫</strong>. All Rights Reserved
            <a target="_blank" href="https://github.com/fireshoot/YxNews">项目地址</a></p>
    </div>
</div>

</body>
</html>