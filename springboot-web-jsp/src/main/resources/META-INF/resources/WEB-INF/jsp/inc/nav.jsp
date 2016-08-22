<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="session"/>
<div class="container">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="${contextPath}/">首页</a>
                <ul class="nav navbar-nav">
                    <li><a href="${contextPath}/product/list" >产品列表</a></li>
                    <li><a href="${contextPath}/product/add" >创建产品</a></li>
                    <li><a href="${contextPath}/swagger-ui.html" target="_blank">API文档</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
