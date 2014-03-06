function listPage(pageSize, currentPage) {
				var getUserList = "getUserList";
				var userCode = $("#userCode").val();
				var userName = $("#userName").val();
				$.getJSON(getUserList, {
					userCode : userCode,
					userName : userName,
					pageSize : pageSize,
					currentPage : currentPage
				}).done(
						function(data) {
							$(".Row").empty();
							$("#currentPageSpan").empty();
							$("#pageCountSpan").empty();
							$("#countSpan").empty();
							var userDetail = "";
							$.each(data.items, function(i, item) {
								userDetail += "<div class='Row'>";
								userDetail += "	<div class='Cell'><span>" + (i + 1)
										+ "</span></div>";
								userDetail += "	<div class='Cell'><span>" + item.userCode
										+ "</span></div>";
								userDetail += "	<div class='Cell'><span>" + item.userName
										+ "</span></div>";
								userDetail += "</div>";
							});
							$("#userListDetailDiv").append(userDetail);
							$("#currentPageSpan").append(data.currentPage);
							$("#pageCountSpan").append(data.pageCount);
							$("#countSpan").append(data.count);

							$("#currentPage").val(data.currentPage);
							$("#pageCount").val(data.pageCount);
							$("#count").val(data.count);
						});
			}