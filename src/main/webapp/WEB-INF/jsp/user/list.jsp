<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎使用HTML5</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/table.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/page.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/user/list.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/page.js"></script>  
 </head>
<body>
	<div>
		用户编码：<input type="text" id="userCode">
		用户名：<input type="text" id="userName">
	</div>
	<div id="userListDetailDiv" class="Table">
		<div class="Title">
			<span>用户列表</span>
		</div>
		<div class="Heading">
			<div class="Cell">
				<span>序号</span>
			</div>
			<div class="Cell">
				<span>用户编码</span>
			</div>
			<div class="Cell">
				<span>用户名</span>
			</div>
		</div>
		 
	</div>
	<%@ include file="../page.jsp"%>
	<script>
		(function() {
			listPage(5,1);
		})();
	</script>
</body>
</html>