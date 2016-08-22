<%@ page contentType="text/html;charset=UTF-8"%>
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
    <h3>产品详情：</h3>
    <p>名称：${product.prodName}</p>
    <p>厂商：${product.prodCompany}</p>
    <p>名称：${product.prodDesc}</p>
    <br/>
    <a href="${contextPath}/product/list">返回列表</a>
</div>
</body>
</html>
<jsp:include page="../inc/footerinc.jsp"></jsp:include>