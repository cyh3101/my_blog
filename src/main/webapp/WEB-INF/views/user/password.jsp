<%--
  Created by IntelliJ IDEA.
  User: cai
  Date: 2017/6/24
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Password</title>
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
</head>
<body>
    <div class="container">
        <%@ include file="../module/top-col.jsp"%>
        <div class="row" style="margin:0px;">
            <div class="col-lg-2" style="padding: 0px;">
                <%@ include file="../module/left-col.jsp"%>
            </div>
            <div class="col-lg-12">
                <div id="mid-col">
                    <div class="body-wrap">
                        <c:if test="${errorMsg!=null}">
                            ${errorMsg}
                        </c:if>
                        <form action="${pageContext.request.contextPath}/user/password" method="post">
                            <input type="hidden" name="id" value="${user.id}"/>
                            <div class="form-group">
                                <label>旧密码:</label>
                                <input class="form-control" type="password" name="oldpassword"/>
                            </div>
                            <div class="form-group">
                                <label>新密码</label>
                                <input class="form-control" type="password" name="password"/>
                            </div>
                            <div class="form-group">
                                <label>新密码重复</label>
                                <input class="form-control" type="password" name="passwordrepeat"/>
                            </div>
                            <div class="form-group">
                                <input type="submit" value="更改"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
