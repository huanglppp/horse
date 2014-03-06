<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎使用HTML5</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/table.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/page.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/role/list.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/page.js"></script>  
 </head>
<body>
	<div>
		角色编码：<input type="text" id="roleCode">
		角色名：<input type="text" id="roleName">
	</div>
	<div id="roleListDetailDiv" class="Table">
		<div class="Title">
			<span>角色列表</span>
		</div>
		<div class="Heading">
			<div class="Cell">
				<span>序号</span>
			</div>
			<div class="Cell">
				<span>角色编码</span>
			</div>
			<div class="Cell">
				<span>角色名</span>
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