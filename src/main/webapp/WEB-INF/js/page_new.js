/**
 * 初始化分页显示内容
 * @param elementId  显示元素ID
 * @param currentPage 当前页
 * @param pageCount 最大页数
 */
function pageInit(elementId,currentPage,pageCount,methodName){
			var $elementId = jQuery("#"+elementId);
			$elementId.empty();
			var currsPage =  currentPage;
		    var totalPage = pageCount;
		    var grountCount = 5;    //每组显示的个数 (可以自定义)  
		    var offset = 2;//当前页面偏移量
		    var currsPageYMax = getCurrsPageYMax(currsPage,offset,totalPage);  //页面显示的页码最大值 
		    var currsPageYMin = getCurrsPageYMin(currsPage,offset);  //页面显示的页码最小值
		     
		    var strPage = "";           //向页面输出值  
	    	//获取上一页和第1页的内容 
		    strPage += getPrevAndFistPage(currsPage,methodName);
		    
		    strPage += getFrontEllipsis(currsPageYMin);
		    
		    //当最小页码小于等于最大页码时，才获取中间分页码信息
	    	if(currsPageYMin<=currsPageYMax){
	    		strPage += getMiddlePage(currsPage,grountCount,currsPageYMin,totalPage,currsPageYMax,methodName);
	    	}
	    	
	    	strPage += getBehindEllipsis(currsPageYMax,totalPage);
	    	
	    	//当只有一页时，第1页跟最后1页，是一样的，所以过滤掉最后1页
	    	if(totalPage>1){
	    		strPage += getLastPage(currsPage,totalPage,methodName);
	    	}
	    	strPage += getNextPage(currsPage,totalPage,methodName);
	    	$elementId.append(strPage);
		}
		 

/*
		 *获取页面显示的页码最大值，最大值为（最大页码-1）
		 *如最大页为10，则页面显示的页码最大值为9
		 */
		function getCurrsPageYMax(currsPage,offset,totalPage){
			var currsPageYMax = currsPage+offset;
			if(currsPageYMax >= totalPage){
				currsPageYMax = totalPage - 1;
			}
			return currsPageYMax;
		}
		
		/*
		 *获取页面显示的页码最小值，最小值为2
		 */
		function getCurrsPageYMin(currsPage,offset){
			var currsPageYMin = currsPage-offset;
			if(currsPageYMin <2){
				currsPageYMin = 2;
			}
			return currsPageYMin;
		}
		
		/*
		 * 获取上一页和第一页显示内容
		 */
		function getPrevAndFistPage(currsPage,methodName){
			var strPrevAdnFist="";
			if(currsPage == 1){  
				strPrevAdnFist += "<span class='prePage_h'> 上一页 </span>";
				strPrevAdnFist += "<a class='pageNum cPage' href='javascript:void(0);' onclick='"+methodName+"(1)'>1</a>"; 
	        }else{  
	        	strPrevAdnFist += "<a class='prePage' href='javascript:void(0);' onclick='"+methodName+"("+(currsPage-1)+")'>上一页</a>";
	        	strPrevAdnFist += "<a class='pageNum' href='javascript:void(0);' onclick='"+methodName+"(1)'>1</a>"; 
	        } 
			return strPrevAdnFist;
		}
		
		/*
		 * 获取中间页码（2到total-1）
		 */
		function getMiddlePage(currsPage,grountCount,currsPageYMin,totalPage,currsPageYMax,methodName){
			var strMidlePage="";
			for(var i = 0;i<grountCount;i++){
	            var middlePage = currsPageYMin+i; 
	            if(middlePage==0){
	            	continue;
	            }
	          
	            if(middlePage>currsPageYMax || middlePage == totalPage){  
	                break;  
	            } 
	            if(middlePage == currsPage){  
	            	strMidlePage += " <a class='pageNum cPage' href='javascript:void(0);'>"+middlePage+" </a>"; 
	            }else{  
	            	strMidlePage += " <a class='pageNum' href='javascript:void(0);' onclick='"+methodName+"("+middlePage+")'>"+middlePage+"</a>";
	            }  
	        } 
			return strMidlePage;
		}
		
		/*
		 * 获取最后一页显示内容
		 */
		function getLastPage(currsPage,totalPage,methodName){
			var strLastPage="";
			if(currsPage == totalPage){  
				strLastPage += " <a class='pageNum cPage' href='javascript:void(0);' onclick='"+methodName+"("+totalPage+")'>"+totalPage+"</a>";
	        }else{  
	        	strLastPage += " <a class='pageNum' href='javascript:void(0);' onclick='"+methodName+"("+totalPage+")'>"+totalPage+"</a>";
	        } 
			return strLastPage;
		}
		
		/*
		 *获取下一页
		 */
		function getNextPage(currsPage,totalPage,methodName){
			var strNextPage="";
			
			if(currsPage == totalPage){  
				strNextPage += "<span class='prePage_h'> 下一页 </span>";
	        }else{  
	        	strNextPage += "<a class='prePage' href='javascript:void(0);' onclick='"+methodName+"("+(currsPage+1)+")'>下一页</a>";
	        } 
			return strNextPage;
		}
		
		
		
		/*
		 * 获取前面省略号
		 */
		function getFrontEllipsis(currsPageYMin){
			var strFrontEllipsis="";
			if(currsPageYMin>2){
				strFrontEllipsis += "<span class='pageEllipsis'> ...</span>";
	    	} 
			return strFrontEllipsis;
		}
		
		/*
		 * 获取后面省略号
		 */
		function getBehindEllipsis(currsPageYMax,totalPage){
			var strBehindEllipsis="";
			if((currsPageYMax+1)<totalPage){
				strBehindEllipsis += "<span class='pageEllipsis'> ...</span>";
	    	}
			return strBehindEllipsis;
		}
		
		