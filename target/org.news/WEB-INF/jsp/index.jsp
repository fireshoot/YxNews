<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>
<html>
<head>
    <title>新闻主页</title>
    <%@include file="common/header.jsp" %>
</head>
<body>
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
            <div class="bar02 font_red1"><a href="">热点新闻</a></div>
            <c:forEach var="hot" items="${list.HOT_NEWS}">
                <ul style="font-size:14px">
                    <li style="background:url(http://www.stnn.cc/images/160401/16gb_bg06.gif)
                    top left no-repeat; padding-left:14px; line-height:26px">
                        <a target="_blank" href="/new/detail?newId=${hot.newId}" title="${hot.keyWords}|${hot.title}"
                           class="title">${hot.keyWords}|${hot.title}</a></li>
                </ul>
            </c:forEach>

            <div class="bar02 font_red1" style="margin-top:15px"><a href="">娱乐新闻</a></div>
            <c:forEach var="enter" items="${list.ENTERTAINMENT_NEWS}">
                <ul style="font-size:14px">
                    <li style="background:url(http://www.stnn.cc/images/160401/16gb_bg06.gif) top left no-repeat; padding-left:14px; line-height:26px">
                        <a target="_blank" href="/new/detail?newId=${enter.newId}"
                           title="${enter.keyWords}:${enter.title}"
                           class="title">${enter.keyWords}:${enter.title}</a></li>
                </ul>
            </c:forEach>

            <div class="bar02 font_red1" style="margin-top:15px"><a href="">科技新闻</a></div>
            <c:forEach var="tech" items="${list.TECH_NEWS}">
                <ul style="font-size:14px">
                    <li style="background:url(http://www.stnn.cc/images/160401/16gb_bg06.gif) top left no-repeat;
                     padding-left:14px; line-height:26px">
                        <a target="_blank" href="/new/detail?newId=${tech.newId}"
                           title="${tech.keyWords}|${tech.title}"
                           class="title">${tech.keyWords}|${tech.title}</a></li>
                </ul>
            </c:forEach>
        </div>
        <div class="right">
            <div class="bar02 font_red1"><a href="">军事新闻</a></div>
            <c:forEach var="mili" items="${list.MILITARY}">
                <ul style="font-size:14px">
                    <li style="background:url(http://www.stnn.cc/images/160401/16gb_bg06.gif) top left no-repeat; padding-left:14px; line-height:26px">
                        <a target="_blank" href="/new/detail?newId=${mili.newId}"
                           title="${mili.keyWords}|${mili.title}" class="title">
                                ${mili.keyWords}|${mili.title}</a></li>
                </ul>
            </c:forEach>


            <div class="bar02 font_red1" style="margin-top:15px"><a href="">体育新闻</a></div>
            <c:forEach var="sport" items="${list.SPORT_NEWS}">
                <ul style="font-size:14px">
                    <li style="background:url(http://www.stnn.cc/images/160401/16gb_bg06.gif) top left no-repeat;
                padding-left:14px; line-height:26px">
                        <a target="_blank" href="/new/detail?newId=${sport.newId}"
                           title="${sport.keyWords}|${sport.title}"
                           class="title">${sport.keyWords}|${sport.title}</a></li>
                </ul>
            </c:forEach>

            <div class="bar02 font_red1" style="margin-top:15px"><a href="">国际新闻</a></div>
            <c:forEach var="world" items="${list.WORLD_NEWS}">
                <ul style="font-size:14px">
                    <li style="background:url(http://www.stnn.cc/images/160401/16gb_bg06.gif) top left no-repeat; padding-left:14px; line-height:26px">
                        <a target="_blank" href="/new/detail?newId=${world.newId}"
                           title="${world.keyWords}|${world.title}"
                           class="title">
                            ${world.keyWords}|${world.title}
                        </a></li>
                </ul>
            </c:forEach>
        </div>
    </div>

</div>

<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/twitter-bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-backstretch/2.0.4/jquery.backstretch.min.js"></script>
</body>
</html>
