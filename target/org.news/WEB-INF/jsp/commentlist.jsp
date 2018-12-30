<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--sidebar end-->
<!--main content start-->
<section id="main-content">
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
                    <c:forEach var="comment" items="${commentlist}">
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
