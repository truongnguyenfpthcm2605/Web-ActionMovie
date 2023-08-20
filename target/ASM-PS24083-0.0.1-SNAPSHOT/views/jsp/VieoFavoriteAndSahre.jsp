<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ include file="/common/cssboostrap.jsp"%>
<div class="controller" style="width: 100%; margin: 0 auto;">
	<h2>Tổng Hợp</h2>
	<hr>
	<form action="VieoFavoriteAndSahre" method="post"
		style="display: flex; justify-content: space-around; margin: 20px auto; width: 40%;">
		<input type="text" name="titlevideo" value="${key}"
			placeholder="Nhập id video" class="form-control" style="width: 70%">
		<button class="btn btn-dark">Tìm Kiếm</button>
	</form>

	<c:choose>
		<c:when test="${not empty list }">
			<c:forEach var="item" items="${list }">
				<div class="statistical">
					<div style="width: 40%;">
						<div class="row">
							<div class="col-md-6">
								<img src="/ASM-PS24083/images/${item.getPoster() }" alt=""
									style="height: 250px;"> <a
									href='<c:url value="/Video?action=watch&id=${ item.getLink()}"></c:url>'
									class="btn btn-light">Xem Chi Tiết <i class='bx bx-show'></i></a>
							</div>
							<div class="col-md-6">
								<h6 class="badge badge-success" style="width: 100%;">${item.getTitle()}</h6>
							</div>
						</div>
					</div>
					<div>
						<div>
							<label for="">Số Người thích</label> <br> <a	
							 href='<c:url value="/personLike?id=${item.getId()}"></c:url>'
								style="color: aqua; font-size: 30px;">${item.getTotalFavorites()}<i
								class='bx bx-like'></i></a>
						</div>
						<div>
							<label for="">Số Người nhận</label> <br> <a
								href='<c:url value="/personShare?id=${ item.getId()}"></c:url>'
								style="color: yellow; font-size: 30px;">
								${item.getTotalShares() } <i class='bx bx-mail-send'></i>
							</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<p>Danh Sách Trống</p>
		</c:otherwise>
	</c:choose>

</div>


