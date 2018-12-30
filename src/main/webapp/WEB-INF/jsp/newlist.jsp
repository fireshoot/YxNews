<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--sidebar end-->
<!--main content start-->
<section id="main-content">
    <div class="mt" style="margin-right: 5px;margin-left: 5px;margin-top: 5px;margin-bottom: 5px">
        <div class="col-md-12">
            <div style="color: rebeccapurple">${result}</div>
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
