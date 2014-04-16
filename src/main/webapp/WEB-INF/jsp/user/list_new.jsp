<%@ page language="java" pageEncoding="UTF-8"%>

 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>会员中心</title>

<link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/member.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery/jquery.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/page_new.js"></script> 
<script type="text/javascript">
	 
		page1(1);
		function page1(currentPage){
			var getUserList = "getUserListAjax";
			jQuery.getJSON(getUserList, {currentPage : currentPage},function(data){
				jQuery("#userListDetailDiv").empty();
				var userDetail = "";
				jQuery.each(data.items, function(i, item) {
					userDetail += "<tr>";
					userDetail += "	<td>" + item.userCode+ "</td>";
					userDetail += "	<td>" + item.userName+"</td>";
					userDetail += "	<td><a href='view?id="+item.userID+ "'>查看</a></td>";
					userDetail += "</tr>";
				});
				
				jQuery("#userListDetailDiv").append(userDetail);
				if(data.pageCount>0){
					pageInit("pageDiv",data.currentPage,data.pageCount,"page1");
				}
			});
		}
		 
		
	 
</script>
</head>

<body>
 
 

<div class="right_menu">
	<ul>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_ys1">
			<tr class="tr_bg1">
                <td style="width:70px;">用户编码</td>
                <td style="width:70px;">用户名</td>
                <td style="width:150px;">操作</td>
			</tr>
			<tbody id="userListDetailDiv">
			</tbody>
			  
		</table>
	</ul>
</div>
    
    <div class="right_pag">
		<div class="pag_R" id="pageDiv">
			 
		</div>
    </div>
</div>
<div class="clear"></div>

 

</body>
</html>
 