<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../inc/headerinc.jsp">
        <jsp:param name="pageTitle" value="i18n测试"/>
    </jsp:include>
</head>
<body>
   <jsp:include page="../inc/nav.jsp"></jsp:include>
   <div class="container">
       <p>语言 <a href="${contextPath}/i18n?lang=en">EN</a> <a href="${contextPath}/i18n?lang=zh">中文</a></p>
       <p><spring:message code="web.login.title" /></p>
       <p><spring:message code="web.description"/></p>
   </div>
</body>
</html>
<jsp:include page="../inc/footerinc.jsp"></jsp:include>