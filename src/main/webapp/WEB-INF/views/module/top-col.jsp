<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: cai
  Date: 2017/6/20
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <div class="top-col">
        <div class="navbar navbar-inverse">
            <div class="navbar-header">
                <a href="javascript:void(0);" class="navbar-header"></a>
            </div>
            <!--游客模式-->
            <shiro:guest>
                <div style="float:right">
                    <ul class="nav navbar-nav">
                        <li><a href="${pageContext.request.contextPath}/user/login">登陆</a> </li>
                        <li><a href="${pageContext.request.contextPath}/user/register">注册</a></li>
                    </ul>
                </div>
            </shiro:guest>

            <!--用户登陆模式-->
            <shiro:user>
                <div style="float: right">
                    <ul class="nav navbar-nav">
                        <li><a href="javascript:void(0)">[<shiro:principal/>]</a> </li>
                        <li><a href="javascript:void(0)"></a> </li>
                        <li class="dropdown">
                            <a href="##" data-toggle="dropdown" class="dropdown-toggle">设置
                                <span class="caret"></span> </a>
                            <ul class="dropdown-menu">
                                <li><a href="${pageContext.request.contextPath}/user/setting/<shiro:principal/>">设置个人信息</a></li>
                                <li><a href="${pageContext.request.contextPath}/user/password">修改密码</a> </li>
                                <li><a href="${pageContext.request.contextPath}/user/logout">登出</a></li>
                            </ul>
                        </li>
                        <shiro:hasAnyRoles name="blogger,administrator">
                            <li class="dropdown">
                                <a href="##" data-toggle="dropdown" class="dropdown-toggle">我的控制
                                    <span class="caret"></span> </a>
                                <ul class="dropdown-menu">
                                    <li><a href="${pageContext.request.contextPath}/admin/home">控制</a> </li>
                                    <li><a href="${pageContext.request.contextPath}/blog/write">写文章</a> </li>
                                </ul>
                            </li>

                        </shiro:hasAnyRoles>
                    </ul>
                </div>
            </shiro:user>

        </div>
    </div>
