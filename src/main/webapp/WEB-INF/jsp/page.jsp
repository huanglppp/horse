 <%@ page language="java" pageEncoding="UTF-8"%>
 	 
 	<input type="hidden" id="currentPage" name="currentPage">
 	<input type="hidden" id="pageCount" name="pageCount">
 	<input type="hidden" id="count" name="count">
	 
	<div class="foot_page">
	   <div class="page_left">
	   		第<span id="currentPageSpan" class="number"></span>页,共<span id="pageCountSpan" class="number"></span>页,每页显示&nbsp;
       		<span class="page">
       		<select id="select-rows">
		         <option value="5">5</option>
		         <option value="10">10</option>
		         <option value="15">15</option>
		         <option value="20">20</option>
		         <option value="30">30</option>
		         <option value="50">50</option>
	       </select>
       	   </span>共有<span id="countSpan" class="number"></span>条记录
       </div>
       
       <div>
        
         <ul class="page_nav">
           <li class="page_0" id="btn-first">首页</li>
           <li class="page_0" id="btn-prev">上一页</li>          
           <li class="page_0" id="btn-next">下一页</li>
           <li class="page_0" id="btn-last">尾页</li>
           <li>
           	<span class="current_num">第<input id="goPage" size="2" value=""/>页</span>
           </li>
           <li class="page_0" id="btn-go">GO</li>
         </ul>
       </div>
	</div>