<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>登录-内容管理系统</title>

<meta name="description" content="User login page" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet" media="screen" />
<link href="http://apps.bdimg.com/libs/fontawesome/4.4.0/css/font-awesome.css" rel="stylesheet" />

<!-- ace styles -->
<link rel="stylesheet" href="${ctx }/static/ace/1.3.3/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />
<link rel="stylesheet" href="${ctx}/static/mimidai/css/main.css" />
<!--[if lte IE 9]>
		<link rel="stylesheet" href="${ctx }/static/ace/1.3.3/css/ace-part2.min.css" class="ace-main-stylesheet" />
	  	<link rel="stylesheet" href="${ctx }/static/ace/1.3.3/css/ace-ie.min.css" />
	<![endif]-->

<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->
<!--[if lte IE 8]>
	<script src="${ctx }/static/ace/1.3.3/js/html5shiv.min.js"></script>
	<script src="${ctx }/static/ace/1.3.3/js/respond.min.js"></script>
	<![endif]-->

<!--[if !IE]> -->
<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<!-- <![endif]-->
<!--[if IE]>
	<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/1.11.3/jquery.min.js"></script>
	<![endif]-->
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<!-- ace scripts -->
<script src="${ctx }/static/ace/1.3.3/js/ace-elements.min.js"></script>
<script src="${ctx }/static/ace/1.3.3/js/ace.min.js"></script>
</head>

<body class="login-layout light-login">
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<span class="red"></span> <span class="grey" id="id-text2">后台管理系统</span>
							</h1>
							<h4 class="blue" id="id-company-text">&copy; xxx</h4>
						</div>

						<div class="space-6"></div>

						<div class="position-relative">
							<div id="login-box" class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<i class="ace-icon fa fa-coffee green"></i> 用户登录
										</h4>

										<div class="space-6"></div>

										<form action="${ctx }/login" method="post">
											<fieldset>
												<label class="block clearfix"> <span class="block input-icon input-icon-right"> <input
														type="text" class="form-control" placeholder="用户名" name="username" /> <i class="ace-icon fa fa-user"></i>
												</span>
												</label> <label class="block clearfix"> <span class="block input-icon input-icon-right"> <input
														type="password" class="form-control" placeholder="密码" name="password" /> <i class="ace-icon fa fa-lock"></i>
												</span>
												</label>

												<div class="space"></div>

												<div class="clearfix">
													<label class="inline"> <input type="checkbox" class="ace" /> <span class="lbl"> 记住我</span>
													</label>

													<button type="submit" class="width-35 pull-right btn btn-sm btn-primary">
														<i class="ace-icon fa fa-key"></i> <span class="bigger-110">登录</span>
													</button>
												</div>

												<div class="space-4"></div>
											</fieldset>
										</form>
									</div>
									<!-- /.widget-main -->

									<div class="toolbar clearfix">
										<div>
											<a href="#" data-target="#forgot-box" class="forgot-password-link"> <i class="ace-icon fa fa-arrow-left"></i>
												忘记密码？
											</a>
										</div>

										<div>
											<a href="#" data-target="#signup-box" class="user-signup-link"> 我要注册 <i
												class="ace-icon fa fa-arrow-right"></i>
											</a>
										</div>
									</div>
								</div>
								<!-- /.widget-body -->
							</div>
							<!-- /.login-box -->

							<div id="forgot-box" class="forgot-box widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header red lighter bigger">
											<i class="ace-icon fa fa-key"></i> 找回密码
										</h4>

										<div class="space-6"></div>
										<p>输入注册邮箱</p>

										<form>
											<fieldset>
												<label class="block clearfix"> <span class="block input-icon input-icon-right"> <input
														type="email" class="form-control" placeholder="Email" /> <i class="ace-icon fa fa-envelope"></i>
												</span>
												</label>

												<div class="clearfix">
													<button type="button" class="width-35 pull-right btn btn-sm btn-danger">
														<i class="ace-icon fa fa-lightbulb-o"></i> <span class="bigger-110">发送邮件!</span>
													</button>
												</div>
											</fieldset>
										</form>
									</div>
									<!-- /.widget-main -->

									<div class="toolbar center">
										<a href="#" data-target="#login-box" class="back-to-login-link"> 返回登录 <i
											class="ace-icon fa fa-arrow-right"></i>
										</a>
									</div>
								</div>
								<!-- /.widget-body -->
							</div>
							<!-- /.forgot-box -->

							<div id="signup-box" class="signup-box widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header green lighter bigger">
											<i class="ace-icon fa fa-users blue"></i> 注册
										</h4>

										<div class="space-6"></div>

										<form>
											<fieldset>
												<label class="block clearfix"> <span class="block input-icon input-icon-right"> <input
														type="email" class="form-control" placeholder="邮箱" /> <i class="ace-icon fa fa-envelope"></i>
												</span>
												</label> <label class="block clearfix"> <span class="block input-icon input-icon-right"> <input
														type="text" class="form-control" placeholder="用户名" /> <i class="ace-icon fa fa-user"></i>
												</span>
												</label> <label class="block clearfix"> <span class="block input-icon input-icon-right"> <input
														type="password" class="form-control" placeholder="密码" /> <i class="ace-icon fa fa-lock"></i>
												</span>
												</label> <label class="block clearfix"> <span class="block input-icon input-icon-right"> <input
														type="password" class="form-control" placeholder="密码确认" /> <i class="ace-icon fa fa-retweet"></i>
												</span>
												</label> <label class="block"> <input type="checkbox" class="ace" /> <span class="lbl"> 我接受 <a
														href="#">《xxx用户协议》</a>
												</span>
												</label>

												<div class="space-24"></div>

												<div class="clearfix">
													<button type="button" class="width-65 pull-right btn btn-sm btn-success">
														<span class="bigger-110">注册</span> <i class="ace-icon fa fa-arrow-right icon-on-right"></i>
													</button>
												</div>
											</fieldset>
										</form>
									</div>

									<div class="toolbar center">
										<a href="#" data-target="#login-box" class="back-to-login-link"> <i class="ace-icon fa fa-arrow-left"></i>
											返回登录
										</a>
									</div>
								</div>
								<!-- /.widget-body -->
							</div>
							<!-- /.signup-box -->
						</div>
						<!-- /.position-relative -->
					</div>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.main-content -->
	</div>
	<!-- /.main-container -->

	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		jQuery(function($) {
			$(document).on('click', '.toolbar a[data-target]', function(e) {
				e.preventDefault();
				var target = $(this).data('target');
				$('.widget-box.visible').removeClass('visible');//hide others
				$(target).addClass('visible');//show target
			});
		});

		//you don't need this, just used for changing background
		jQuery(function($) {
			$('#btn-login-dark').on('click', function(e) {
				$('body').attr('class', 'login-layout');
				$('#id-text2').attr('class', 'white');
				$('#id-company-text').attr('class', 'blue');

				e.preventDefault();
			});
			$('#btn-login-light').on('click', function(e) {
				$('body').attr('class', 'login-layout light-login');
				$('#id-text2').attr('class', 'grey');
				$('#id-company-text').attr('class', 'blue');

				e.preventDefault();
			});
			$('#btn-login-blur').on('click', function(e) {
				$('body').attr('class', 'login-layout blur-login');
				$('#id-text2').attr('class', 'white');
				$('#id-company-text').attr('class', 'light-blue');

				e.preventDefault();
			});

		});
	</script>
</body>
</html>