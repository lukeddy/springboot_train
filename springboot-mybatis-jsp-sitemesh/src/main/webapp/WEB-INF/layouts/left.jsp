<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<div id="sidebar" class="sidebar responsive">
	<ul class="nav nav-list">
		<li class=""><a node="1" href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-list"></i> <span
				class="menu-text"> 系统管理 </span> <b class="arrow fa fa-angle-down"></b>
		</a> <b class="arrow"></b>

			<ul class="submenu">
				<li class=""><a node="2" href="${ctx }/user/list"> <i class="menu-icon fa fa-caret-right"></i> 用户管理
				</a> <b class="arrow"></b></li>

				<li class=""><a node="3" href="${ctx }/role/list"> <i class="menu-icon fa fa-caret-right"></i> 角色管理
				</a> <b class="arrow"></b></li>
			</ul></li>

		<li class=""><a href="#"> <i class="menu-icon fa fa-list-alt"></i> <span class="menu-text"> 内容管理 </span>
		</a> <b class="arrow"></b></li>
		<li class=""><a href="${ctx }/logout"> <i class="menu-icon fa fa-picture-o"></i> <span class="menu-text">
					退出登录 </span>
		</a> <b class="arrow"></b></li>
	</ul>

	<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
		<i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left"
			data-icon2="ace-icon fa fa-angle-double-right"></i>
	</div>
</div>