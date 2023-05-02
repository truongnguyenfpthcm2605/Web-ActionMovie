<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Action Moview</title>
<%@ include file="/common/cssboostrap.jsp"%>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="apps" id="actionMovie" style="width: 100%">
		<div class="controller" style="width: 80%; margin: 10px auto;">
			<h5 class="badge badge-secondary">${name}</h5>
			<hr>
			<c:url var="app" value="/app" />
			<div class="row film">
				<c:choose>
					<c:when test="${ not empty list }">
						<c:forEach var="item" items="${list }">
							<div class="col-md-3">
								<div class="card">
									<img src="/ASM-PS24083/images/${item.getPoster() }"
										class="card-img-top"
										style="border-radius: 20px 20px 0 0; height: 250px;" alt="...">
									<div class="card-body">
										<h5 class="card-title"
											style="white-space: nowrap; overflow: hidden;">${item.getTitle() }</h5>
										<div
											style="display: flex; justify-content: space-around; margin-bottom: 10px; align-items: center;">
											<span style="font-weight: 200;"><i class='bx bxs-show'></i>${item.getViews() }</span>
											 <span><i	class='bx bxs-heart'></i>${item.getTotalFavorites()}</span> 
													 <span><i class='bx bxs-share'></i>${item.getTotalShares()}</span>
										</div>
										<c:set var="idgenre" value="${item.getGenre().getId()}"
											scope="session" />
										<a
											href='<c:url value="/Video?action=watch&id=${ item.getLink()}"></c:url>'
											class="btn btn-dark"> <span><i
												class='bx bx-play-circle'></i></span> Xem Ngay
										</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:when>
				</c:choose>
			</div>
			<c:if test="${number >8}">
					<div class="controller" style="text-align: center;">
				<div class="btn-group" role="group" aria-label="Basic example">
					<c:if test="${curentpage ==1}">
						<a href="" class="btn btn-light disabled"><i
							class='bx bx-left-arrow-alt'></i></a>
					</c:if>
					<c:if test="${curentpage >1 }">
						<a href="HomePage?page=${curentpage-1}"
							class="btn btn-light "><i class='bx bx-left-arrow-alt'></i></a>
					</c:if>
					<c:forEach varStatus="i" begin="1" end="${maxpage }">
						<a href="HomePage?page=${i.index}"
							class="btn btn-light ${curentpage==i.index ? 'active' : ''}">${i.index}</a>
					</c:forEach>

					<a href="HomePage?page=${curentpage+1}"
						class="btn btn-light "><i class='bx bx-right-arrow-alt'></i></a>

				</div>
			</div>
			</c:if>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<%@ include file="/common/jsboostrap.jsp"%>
</body>
</html>