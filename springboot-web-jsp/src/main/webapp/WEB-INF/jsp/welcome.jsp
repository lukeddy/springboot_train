<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>你好！</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="assets/css/site.css">
</head>
<body>
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
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="assets/js/hello.js"></script>