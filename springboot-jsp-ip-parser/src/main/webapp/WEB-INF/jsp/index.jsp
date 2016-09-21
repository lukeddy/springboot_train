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
       <div class="col-md-12">
           <h5>表单区</h5>
           <form action="/query" method="post">
               <div class="form-group">
                   <textarea name="ipList" rows="12" style="width: 100%;padding:10px;"></textarea>
               </div>
               <div class="btn-group">
                   <button type="submit" class="btn btn-primary">查询</button>
                   <button type="reset" class="btn btn-default">清空</button>
               </div>
           </form>
           <br/>
           <p class="well">
               注意事项：多个IP，每个IP地址占一行;
           </p>
       </div>
       <div class="col-md-12">
           <h5>结果区</h5>
           <br>
           <div class="col-md-6">
               <div id="chartdiv1" class="pie-container"></div>
           </div>
           <div class="col-md-6">
               <div id="chartdiv2" class="pie-container"></div>
           </div>
           <br>
           <div class="col-md-6">
               <div id="chartdiv3" class="pie-container"></div>
           </div>
           <div class="col-md-6">
               <div id="chartdiv4" class="pie-container"></div>
           </div>
           <c:if test="${not empty queryIPList}">
               <p>${queryIPList}</p>
           </c:if>
       </div>
   </div>
</body>
</html>
<jsp:include page="inc/footerinc.jsp"></jsp:include>
<script>
    $(function () {
        //省饼图
        $.getJSON("${contextPath}/assets/data/province_data.json", function(json){
            createPieChart(json,"chartdiv1");
        });
        //市饼图
        $.getJSON("${contextPath}/assets/data/city_data.json", function(json){
            createPieChart(json,"chartdiv2");
        });
        //区饼图
        $.getJSON("${contextPath}/assets/data/district_data.json", function(json){
            createPieChart(json,"chartdiv3");
        });
        //省份饼图
        $.getJSON("${contextPath}/assets/data/sichuan_data.json", function(json){
            createPieChart(json,"chartdiv4");
        });
    });
</script>

