<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>
<html>
<head>
    <title>新闻主页</title>
    <%@include file="common/header.jsp" %>
</head>
<body>
${result.toString()}
<div>
    <div class="cnt">
        <ul>
            <div class="top">
                <div style="float:left; margin-bottom:50px;"><a
                        href=""><img STYLE="width: 996px"
                                     src="${pageContext.request.contextPath}/resource/img/weather.jpg"></a></div>
                <div class="clear"></div>
            </div>
        </ul>
    </div>
    <div class="cnt">
        <div class="left">
            <div class="bar02 font_red1"><a href="http://news.stnn.cc/hongkong/">热点新闻</a></div>
            <ul style="font-size:14px">
                <li style="background:url(http://www.stnn.cc/images/160401/16gb_bg06.gif) top left no-repeat; padding-left:14px; line-height:26px">
                    <a target="_blank" href="http://news.stnn.cc/hongkong/2018/1226/603039.shtml"
                       title="UGL事件|丁煌:律政司做法妥当 郑若骅回应充分" class="title">UGL事件|丁煌:律政司做法妥当 郑若骅回应充分</a></li>
            </ul>

            <div class="bar02 font_red1" style="margin-top:15px"><a href="http://news.stnn.cc/china/">娱乐新闻</a></div>
            <ul style="font-size:14px">
                <li style="background:url(http://www.stnn.cc/images/160401/16gb_bg06.gif) top left no-repeat; padding-left:14px; line-height:26px">
                    <a target="_blank" href="http://news.stnn.cc/china/2018/1226/603118.shtml"
                       title="国家网信办:金融信息服务提供者不得散布虚假信息"
                       class="title">国家网信办:金融信息服务提供者不得散布虚假信息</a></li>
            </ul>

            <div class="bar02 font_red1" style="margin-top:15px"><a href="http://news.stnn.cc/fzsjxw/">科技新闻</a></div>
            <ul style="font-size:14px">
                <li style="background:url(http://www.stnn.cc/images/160401/16gb_bg06.gif) top left no-repeat; padding-left:14px; line-height:26px">
                    <a target="_blank" href="http://news.stnn.cc/fzsjxw/2018/1226/603093.shtml"
                       title="女子偷手机得手后却踢醒对方，警察都忍不住笑……"
                       class="title">女子偷手机得手后却踢醒对方，警察都忍不住笑……</a></li>
            </ul>
        </div>
        <div class="right">
            <div class="bar02 font_red1"><a href="http://news.stnn.cc/hk_taiwan/">军事新闻</a></div>
            <ul style="font-size:14px">
                <li style="background:url(http://www.stnn.cc/images/160401/16gb_bg06.gif) top left no-repeat; padding-left:14px; line-height:26px">
                    <a target="_blank" href="http://news.stnn.cc/hk_taiwan/2018/1226/603121.shtml"
                       title="余莓莓泪骂蔡英文：为什么这样对我们？节目激动哭崩" class="title">
                        余莓莓泪骂蔡英文：为什么这样对我们？节目激动哭崩</a></li>
            </ul>


            <div class="bar02 font_red1" style="margin-top:15px"><a href="http://news.stnn.cc/guoji/">体育新闻</a></div>
            <ul style="font-size:14px">
                <li style="background:url(http://www.stnn.cc/images/160401/16gb_bg06.gif) top left no-repeat; padding-left:14px; line-height:26px">
                    <a target="_blank" href="http://news.stnn.cc/guoji/2018/1226/603113.shtml"
                       title="财长姆努钦稳定市场不力，特朗普不满与日俱增"
                       class="title">财长姆努钦稳定市场不力，特朗普不满与日俱增</a></li>
            </ul>

            <div class="bar02 font_red1" style="margin-top:15px"><a href="http://news.stnn.cc/19/">国际新闻</a></div>
            <ul style="font-size:14px">
                <li style="background:url(http://www.stnn.cc/images/160401/16gb_bg06.gif) top left no-repeat; padding-left:14px; line-height:26px">
                    <a target="_blank" href="http://news.stnn.cc/19/2018/1226/602992.shtml"
                       title="思想纵横：改革开放是党的主张与人民要求的统一"
                       class="title">思想纵横：改革开放是党的主张与人民要求的统一</a></li>
            </ul>
        </div>
    </div>

</div>

<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/twitter-bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-backstretch/2.0.4/jquery.backstretch.min.js"></script>
</body>
</html>
