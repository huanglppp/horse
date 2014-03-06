$(document).ready(function(){
	$("#btn-first").on("click",function(){
		$("#currentPage").val(1);
		var currentPage_first = parseInt($("#currentPage").val());
		var rows = parseInt($("#select-rows option:selected").val());
		listPage(rows,currentPage_first);
	});
	
	$("#btn-prev").on("click",function(){
		var currentPage = parseInt($("#currentPage").val());
		if(currentPage > 1){
			$("#currentPage").val(currentPage-1);
		}
		var currentPage_prev = parseInt($("#currentPage").val());
		var rows = parseInt($("#select-rows option:selected").val());
		listPage(rows,currentPage_prev);
	});
	
	$("#btn-next").on("click",function(){
		var currentPage = parseInt($("#currentPage").val());
		var pageCount = parseInt($("#pageCount").val());
		if ( currentPage < pageCount) {
			$("#currentPage").val(currentPage + 1);
		}
		var currentPage_next = parseInt($("#currentPage").val());
		var rows = parseInt($("#select-rows option:selected").val());
		listPage(rows,currentPage_next);
	});
	
	$("#btn-last").on("click",function(){
		var pageCount = parseInt($("#pageCount").val());
		$("#currentPage").val(pageCount);
		var currentPage_last = parseInt($("#currentPage").val());
		var rows = parseInt($("#select-rows option:selected").val());
		listPage(rows,currentPage_last);
	});
	
	$("#btn-go").on("click",function(){
		var goPage = $("#goPage").val();
		goPage = $.trim(goPage);
		goPage = parseInt(goPage);
		if (isNaN(goPage)) {
			jQuery("#goPage").val('');
			alert("页码数必需是一个数字");
			return false;
		}
		if(goPage<1){
			goPage = 1;
		}
		var pageCount = parseInt($("#pageCount").val());
		if(goPage > pageCount ){
			goPage = pageCount;
		}
		$("#currentPage").val(goPage);
		$("#goPage").val(goPage);
		var currentPage_go = parseInt($("#currentPage").val());
		var rows = parseInt($("#select-rows option:selected").val());
		listPage(rows,currentPage_go);
	});
	
	$("#select-rows").on("change",function(){
		var rows = parseInt($("#select-rows option:selected").val());
		$("#currentPage").val(1);
		var count = parseInt($("#count").val());
		var pageCount = 0;
		if(count % rows == 0){
			pageCount = count/rows;
		}else{
			pageCount = count/rows + 1;
		}
		$("#pageCount").val(pageCount);
		
		var currentPage_go = parseInt($("#currentPage").val());
		listPage(rows,currentPage_go);
	});
});
		 