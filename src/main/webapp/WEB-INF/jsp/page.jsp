<%@ page language="java" pageEncoding="UTF-8"%>

 
<s:hidden id="currentPage" name="currentPage" />
<s:hidden id="pageCount" name="pageCount" />
	<div class="foot_page">
		<div class="page_left">第<span class="number"><s:property	value="currentPage>pageCount?pageCount:currentPage" /></span>页,共<span class="number"><s:property value="pageCount" /></span>页,每页显示&nbsp;
       <span class="page">
       <select name="criteria.rows" onchange="changePage();">
         <option value="5" <s:if test="criteria.rows==5">selected="selected"</s:if> >5</option>
         <option value="10" <s:if test="criteria.rows==10">selected="selected"</s:if> >10</option>
         <option value="15" <s:if test="criteria.rows==15">selected="selected"</s:if>>15</option>
         <option value="20" <s:if test="criteria.rows==20">selected="selected"</s:if>>20</option>
         <option value="30" <s:if test="criteria.rows==30">selected="selected"</s:if>>30</option>
         <option value="50" <s:if test="criteria.rows==50">selected="selected"</s:if>>50</option>
       </select>
       </span>共有<span class="number">${count}</span>条记录</div>
       
       <div>
        
         <ul class="page_nav">
           <li class="page_0" id="btn-first" value="%{getText('button.first')}"  >首页</li>
           <li class="page_0" id="btn-prev" value="%{getText('button.prev')}"   >上一页</li>          
           <li class="page_0" id="btn-next"  >下一页</li>
           <li class="page_0" id="btn-last" value="%{getText('button.last')}"  >尾页</li>
           <li>
           <span class="current_num">第<input id="goPage" size="2" value="${currentPage}"/>页</span>
           </li>
           <li class="page_0"   onclick="goPages();" >GO</li>
         </ul>
       </div>
	</div>
	
	
	<script>
		(function() {
			 
		})();
		
		 
	</script>
 