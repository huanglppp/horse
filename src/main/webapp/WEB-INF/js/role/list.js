function listPage(pageSize, currentPage) {
				var getroleList = "getRoleList";
				var roleCode = $("#roleCode").val();
				var roleName = $("#roleName").val();
				$.getJSON(getroleList, {
					roleCode : roleCode,
					roleName : roleName,
					pageSize : pageSize,
					currentPage : currentPage
				}).done(
						function(data) {
							$(".Row").empty();
							$("#currentPageSpan").empty();
							$("#pageCountSpan").empty();
							$("#countSpan").empty();
							var roleDetail = "";
							$.each(data.items, function(i, item) {
								roleDetail += "<div class='Row'>";
								roleDetail += "	<div class='Cell'><span>" + (i + 1)
										+ "</span></div>";
								roleDetail += "	<div class='Cell'><span>" + item.roleCode
										+ "</span></div>";
								roleDetail += "	<div class='Cell'><span>" + item.roleName
										+ "</span></div>";
								roleDetail += "</div>";
							});
							$("#roleListDetailDiv").append(roleDetail);
							$("#currentPageSpan").append(data.currentPage);
							$("#pageCountSpan").append(data.pageCount);
							$("#countSpan").append(data.count);

							$("#currentPage").val(data.currentPage);
							$("#pageCount").val(data.pageCount);
							$("#count").val(data.count);
						});
			}