<%--
  Created by IntelliJ IDEA.
  User: cai
  Date: 2017/6/23
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>register</title>
    <link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet" rel="stylesheet">
    <link href="//cdn.bootcss.com/bootstrap-markdown/2.10.0/css/bootstrap-markdown.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
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
        <%@ include file="../module/left-col.jsp"%>
        <div class="mid-col">
            <div class="body-wrap">
                <c:if test="${errors!=null}">
                    <div class="alert alert-info">
                        <c:forEach items="${errors}" var="error">
                            ${error.toString()}<br/>
                        </c:forEach>

                    </div>
                </c:if>
                <c:if test="${errormessage}!=null">
                    <div class="alert alert-info">
                        ${errormessage}
                    </div>
                </c:if>

                <form action="${pageContext.request.contextPath}/user/register" method="post">
                    <div class="form-group">
                        <label>userName:</label>
                        <input class="form-control" type="text" name="username" value="${user.username}"/><br/>
                    </div>
                    <div class="form-group">
                        <label>password:</label>
                        <input class="form-control" type="password" name="password" value="${user.password}"/><br/>
                    </div>
                    <div class="form-group">
                        <label>email:</label>
                        <input class="form-control" type="email" name="email" value="${user.email}"/><br/>
                    </div>
                    <div class="form-group">
                        <label>sex:</label>
                        <div class="radio">
                            <label>
                                <input type="radio" name="sex" id="optionRadio1" value="male" checked>male
                            </label>
                        </div>
                        <div class="radio">
                            <label><input type="radio" name="sex" id="optionRadio2" value="female">female</label>
                        </div>
                    </div>

                    <div class="form-group">
                        <input type="submit" value="register">
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
