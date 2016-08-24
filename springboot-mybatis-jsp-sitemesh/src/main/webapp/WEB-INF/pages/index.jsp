<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" xmlns:layout="http://www.ultraq.net.nz/web/thymeleaf/layout"
	layout:decorator="layout">
<head>
<title>首页</title>
</head>
<body>
	<!-- /section:basics/sidebar -->
	<div class="main-content" layout:fragment="content">
		<div class="main-content-inner">
			<!-- #section:basics/content.breadcrumbs -->
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>

				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="/" th:href="@{/}">首页</a></li>
				</ul>
				<!-- /.breadcrumb -->

				<!-- #section:basics/content.searchbox -->
				<div class="nav-search" id="nav-search">
					<form class="form-search">
						<span class="input-icon"> <input type="text" placeholder="Search ..." class="nav-search-input"
							id="nav-search-input" autocomplete="off" /> <i class="ace-icon fa fa-search nav-search-icon"></i>
						</span>
					</form>
				</div>
				<!-- /.nav-search -->
				<!-- /section:basics/content.searchbox -->
			</div>

			<div class="page-content">首页</div>
			<!-- /.page-content -->
		</div>
	</div>
	<!-- /.main-container -->
</body>
</html>
