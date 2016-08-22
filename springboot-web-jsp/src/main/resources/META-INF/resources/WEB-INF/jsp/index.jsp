<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="inc/headerinc.jsp">
        <jsp:param name="pageTitle" value="你好！"/>
    </jsp:include>
</head>
<body>
   <jsp:include page="inc/nav.jsp"></jsp:include>
   <div class="container">
       <c:url value="<a href='http://www.baidu.com'>http://www.baidu.com</a>" var="url"/>
       <spring:url value="<a href='http://www.baidu.com'>http://www.baidu.com</a>" htmlEscape="true" var="springUrl" />
       Spring URL: ${springUrl} at ${time}
       <br>
       JSTL URL: ${url}
       <br>
       服务器消息: ${message}
   </div>
</body>
</html>
<jsp:include page="inc/footerinc.jsp"></jsp:include>