<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <jsp:include page="../inc/headerinc.jsp">
        <jsp:param name="pageTitle" value="添加产品"/>
    </jsp:include>
</head>
<body>
<jsp:include page="../inc/nav.jsp"></jsp:include>

<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>产品名</th>
            <th>生产商</th>
            <th>操作</th>
        </tr>
        </thead>
        <c:forEach var="prod" items="${prodList}">
            <tr>
                <td>${prod.id}</td>
                <td>${prod.prodName}</td>
                <td>${prod.prodCompany}</td>
                <td>
                    <a href="${contextPath}/product/detail/${prod.id}">详情</a>
                    <a href="${contextPath}/product/del/${prod.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
<jsp:include page="../inc/footerinc.jsp"></jsp:include>