<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>角色编辑</title>
</head>
<body>
	<div class="breadcrumbs" id="breadcrumbs">
		<ul class="breadcrumb">
			<li><i class="ace-icon fa fa-home home-icon"></i> <a href="${ctx }/">首页</a></li>
		</ul>

		<div class="nav-search" id="nav-search">
			<form class="form-search">
				<span class="input-icon"> <input type="text" placeholder="Search ..." class="nav-search-input"
					id="nav-search-input" autocomplete="off" /> <i class="ace-icon fa fa-search nav-search-icon"></i>
				</span>
			</form>
		</div>
	</div>

	<div class="page-content">
		<div class="page-header">
			<h1>
				角色编辑 <small> <i class="ace-icon fa fa-angle-double-right"></i> 编辑角色信息
				</small>
			</h1>
		</div>
		<!-- /.page-header -->
		<div id="messageBox" class="error" style="display: none">输入有误，请先更正。</div>
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<form id="inputForm" class="form-horizontal" role="form" action="${ctx }/role/save" method="post">
					<input type="hidden" name="id" value="${role.id}" />
					<!-- #section:elements.form -->
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" for="name"> 角色名称 </label>

						<div class="col-sm-9">
							<input type="text" id="name" name="name" class="col-xs-10 col-sm-5" value="${role.name}" />
						</div>
					</div>

					<div class="clearfix form-actions">
						<div class="col-md-offset-3 col-md-9">
							<button class="btn btn-info" type="submit">
								<i class="ace-icon fa fa-check bigger-110"></i> 提交
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- /.page-content -->
</body>
</html>