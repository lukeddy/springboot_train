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
    <h3>添加产品详情：</h3>
    <form action="${contextPath}/product/add" method="post">
        <p>编号：<input type="text" name="id"/></p>
        <p>名称：<input type="text" name="prodName"/></p>
        <p>厂商：<input type="text" name="prodCompany"/></p>
        <p>描述：<input type="text" name="prodDesc"/></p>
        <p>
            <button type="submit">提交</button>
            <button type="reset">重置</button>
        </p>
    </form>
    <br/>
    <a href="${contextPath}/product/list">返回列表</a>
</div>
</body>
</html>
<jsp:include page="../inc/footerinc.jsp"></jsp:include>