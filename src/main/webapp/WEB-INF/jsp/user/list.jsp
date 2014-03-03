<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎使用HTML5</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/table.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/page.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-2.1.0.min.js"></script>

</head>
<body>

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
	
	
	<script>
		(function() {
			getUserList();
			
			function getUserList(){
				var getUserList = "getUserList";
				$.getJSON(getUserList, {}).done(function(data) {
					var userDetail = "";
					$.each(data,function(i,item){
						userDetail += "<div class='Row'>";
						userDetail += "	<div class='Cell'><span>"+(i+1)+"</span></div>";
						userDetail += "	<div class='Cell'><span>"+item.userCode+"</span></div>";
						userDetail += "	<div class='Cell'><span>"+item.userName+"</span></div>";
						userDetail += "</div>";
					});
					$("#userListDetailDiv").append(userDetail);
				});
			}
		})();
		
		 
	</script>
</body>
</html>