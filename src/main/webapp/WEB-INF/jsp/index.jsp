<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>首页</title>
  </head>  
  <body>
       <div>
       		<ul>
       			<li><a href="${pageContext.request.contextPath}/user/list">用户列表</a></li>
       			 <li><a href="${pageContext.request.contextPath}/role/list">角色列表</a></li>
       		</ul>
       </div>
  </body>
</html>