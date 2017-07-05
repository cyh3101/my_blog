<%--
  Created by IntelliJ IDEA.
  User: cai
  Date: 2017/6/25
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
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
                        <a href="${pageContext.request.contextPath}/admin/checkUserList">checkUserList</a>
                        <a href="${pageContext.request.contextPath}/admin/checkSessionList">checkSessionList</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
