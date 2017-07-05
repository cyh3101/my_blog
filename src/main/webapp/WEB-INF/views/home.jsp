<%--
  Created by IntelliJ IDEA.
  User: cai
  Date: 2017/6/18
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>home page</title>
    <link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <link href="//cdn.bootcss.com/bootstrap-markdown/2.10.0/css/bootstrap-markdown.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/pagination.css" rel="stylesheet">

    <script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap-markdown/2.10.0/js/bootstrap-markdown.js"></script>
    <script src="//cdn.bootcss.com/markdown.js/0.5.0/markdown.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.pagination.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
           $.ajax({
               type:'post',
               url:'${pageContext.request.contextPath}/getblog',
               data:null,
               success:test
           })
        });
        function test(data) {
            var i = 0;
            $('.body-wrap div p').each(function () {
                $(this).html(markdown.toHTML(data[i].text));
                i++;
            });
        }
    </script>
</head>
<body>
    <div class="container">
        <%@ include file="module/top-col.jsp"%>
        <div class="row" style="margin:0px;">
            <div class="col-lg-2" style="padding: 0px;">
                <%@ include file="module/left-col.jsp"%>
            </div>
            <div class="col-lg-12">
                <div id="mid-col">
                    <div class="body-wrap">
                        <c:forEach items="${blogs}" var="blog">
                            <div class="article-inner ${blog.title}">
                                <header class="article-header">
                                    <h2>${blog.title}</h2>
                                </header>
                                <div class="details">
                                    <p class="text-left"></p>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
