<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: cai
  Date: 2017/6/25
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserList</title>
    <link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <link href="//cdn.bootcss.com/bootstrap-markdown/2.10.0/css/bootstrap-markdown.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/pagination.css" rel="stylesheet">

    <script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap-markdown/2.10.0/js/bootstrap-markdown.js"></script>
    <script src="//cdn.bootcss.com/markdown.js/0.5.0/markdown.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.pagination.js"></script>

    <script type="text/javascript">
        function queryItems() {
            document.userForm.action="${pageContext.request.contextPath}/admin/checkUserList";
            document.userForm.submit();
        }
    </script>
</head>
<body>
    <div class="container">
        <%@ include file="../module/top-col.jsp"%>
        <div class="row" style="margin:0px;">
            <div class="col-lg-2" style="padding:0px;">
                <%@ include file="../module/left-col.jsp"%>
            </div>
            <div class="col-lg-12">
                <div id="mid-col">
                    <div class="body-wrap">
                        <form name="userForm" action="${pageContext.request.contextPath}/admin/checkUserList" method="post">
                            <table class="table">
                                <caption>查询条件:</caption>
                                <tr>
                                    <td>账号名称:<input name="user.username" class=""/></td>
                                    <td><input type="button" value="查询" class="form-control" onclick="queryItems()"/> </td>
                                </tr>
                            </table>
                            <table class="table table table-bordered table-striped table-hover text-center">
                                <thead>
                                <tr>
                                    <th>选择</th>
                                    <th>用户名</th>
                                    <th>创建时间</th>
                                    <th>最后登陆时间</th>
                                    <th>邮箱</th>
                                    <th>性别</th>
                                    <th>是否被锁</th>
                                    <th>操作</th>
                                </tr>
                                </thead>

                                <tbody>
                                <c:forEach items="${users}" var="user">
                                    <tr>
                                        <td><input type="checkbox" name="userId" value="${user.id}"/> </td>
                                        <td>${user.username}</td>
                                        <td>
                                            <fmt:formatDate value="${user.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                        </td>
                                        <td>
                                            <fmt:formatDate value="${user.lasttime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                        </td>
                                        <td>${user.email}</td>
                                        <td>
                                            <c:if test="${user.sex=='male'}">
                                                男
                                            </c:if>
                                            <c:if test="${user.sex=='female'}">
                                                女
                                            </c:if>
                                        </td>
                                        <td>
                                            <c:if test="${user.sex==true}">
                                                是
                                            </c:if>
                                            <c:if test="${user.sex==false}">
                                                否
                                            </c:if>
                                                </td>
                                        <td><a href="${pageContext.request.contextPath}/items/${user.id}">修改</a> </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
