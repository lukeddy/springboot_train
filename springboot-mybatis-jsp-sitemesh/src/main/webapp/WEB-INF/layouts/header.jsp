<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<div id="navbar" class="navbar navbar-default">
	<div class="navbar-container" id="navbar-container">
		<div class="navbar-header pull-left">
			<a href="#" class="navbar-brand"> <small> <i class="fa fa-leaf"></i>内容管理系统
			</small>
			</a>
		</div>
		<div class="navbar-buttons navbar-header pull-right" role="navigation">
			<ul class="nav ace-nav">
				<li class="light-blue"><a data-toggle="dropdown" href="#" class="dropdown-toggle"> <img
						class="nav-user-photo" src="${ctx }/static/ace/1.3.3/avatars/user.jpg" /> <span class="user-info"> <small>欢迎,</small>
							<span class=""><shiro:principal property="name" /></span>
					</span> <i class="ace-icon fa fa-caret-down"></i>
				</a>

					<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
						<li><a href="#"> <i class="ace-icon fa fa-key"></i> 修改密码
						</a></li>

						<li class="divider"></li>

						<li><a href="${ctx }/logout"> <i class="ace-icon fa fa-power-off"></i> 退出系统
						</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
</div>