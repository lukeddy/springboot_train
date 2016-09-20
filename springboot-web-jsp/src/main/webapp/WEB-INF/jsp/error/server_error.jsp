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
      <div class="alert alert-error">
          <h2>请求${url}发生了如下错误：</h2>
          <br/>
          <p>${exception}</p>
      </div>
  </div>
</body>
</html>