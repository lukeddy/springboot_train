<%@page language="java" contentType="text/html;charset=UTF-8"%>
<!-- 使用此信息提示框 需要有message  和   code   -->
<c:if test="${code == '1'}">
	<div id="custom_message_alert" class="alert alert-success alert-dismissible fade in message" role="alert">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		${message } 
	</div>
</c:if>
<c:if test="${code == '0'}">
	<div id="custom_message_alert" class="alert alert-danger alert-dismissible fade in message" role="alert">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		${message } 
	</div>
</c:if>
<c:if test="${!empty code}">
<script type="text/javascript">
	(function(){
		setTimeout(function(){
			$('#custom_message_alert').alert('close');
		}, 2000)
	})();
</script>
</c:if>