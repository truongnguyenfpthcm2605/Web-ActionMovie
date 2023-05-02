
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ManagerAdmin Moive</title>
<%@ include file="/common/cssboostrap.jsp"%>
<style type="text/css">
.card-body span i:hover {
	transform: scale(1.1);
	color: red;
	transition: all linear 0.5s;
}
</style>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<div class="apps" id="actionMovie" style="width: 100%">
		<div class="row" style="width: 80%; margin: 10px auto;">
			<c:url var="app" value="/app" />
			<h2>Quản lý Video</h2>
			<hr>
			<div class="container styleChoose" style="width: 100%">
				<form action="MangerVideo" method="post"
					style="display: flex; justify-content: space-between;">
					<div class="form-group">
						<label for="exampleInputEmail1">Thể Loại</label> <br> <select
							name="typeMovie" id="" style="text-align: left;"
							class="btn btn-dark">
							<option value="-1" selected="selected">Tất Cả</option>
							<c:forEach var="item" items="${listgenre }">
								<option value="${item.getId() }"
									${item.getId() == check?'selected':'' }>${item.getTitle() }</option>
							</c:forEach>
						</select>
					</div>
					<div>
						<label for="">Tìm Kiếm</label> <br>
						<div style="display: flex; justify-content: space-between;">
							<input style="width: 65%;" type="search" name="searchfilm"
								class="form-control">
							<button class="btn btn-dark">Tìm Kiếm</button>
						</div>
					</div>
					<div>
						<label for="">Phim</label> <br> <a href="UnActive"
							class="btn btn-light "> Phim Đã Ẩn <i class='bx bx-hide'></i>
						</a>
					</div>
					<div>
						<label for="">Phim</label> <br> <a href="Active"
							class="btn btn-light ">Phim Hiện Hành<i class='bx bx-film'></i>
						</a>
					</div>
					<div>
						<label for="">Thêm Mới</label> <br> <a
							href='<c:url value="/Addvideo?action=new"></c:url>'
							class="btn btn-success">Thêm Phim Mới<i
							class='bx bxs-folder-plus'></i>
						</a>
					</div>
				</form>
			</div>
			<hr>
			<h5 class="badge badge-secondary">${name}</h5>
			<div class="row adminrow" style="width: 100%; margin: 0 auto;">
				<c:forEach var="item" items="${list }">
					<div class="col-md-3">
						<div class="card" style="width: 100%; border-radius: 20px;">
							<img src="/ASM-PS24083/images/${item.getPoster()}"
								class="card-img-top"
								style="border-radius: 20px 20px 0 0; height: 250px;" alt="...">
							<div class="card-body">
								<h5 class="card-title"
									style="white-space: nowrap; overflow: hidden;">${item.getTitle() }</h5>
								<div
									style="display: flex; justify-content: space-around; margin-bottom: 10px; align-items: center;">
									<span style="font-weight: 200;"><i class='bx bxs-show'></i>${item.getViews() }</span>
									<span><i class='bx bxs-heart'></i>${item.getTotalFavorites()}</span>
									<span><i class='bx bxs-share'></i>
										${item.getTotalShares()}</span>
								</div>
								<div
									style="display: flex; justify-content: space-around; margin-bottom: 10px; align-items: center;">
									<a
										href='<c:url value="/Video?action=watch&id=${ item.getLink()}"></c:url>'
										class="btn btn-dark"> <span><i
											class='bx bx-play-circle'></i></span> Xem Ngay
									</a> <a
										href='<c:url value="/Addvideo?action=update&id=${ item.getLink()}"></c:url>'>
										<span aria-controls="v-pills-profile"><i
											class='bx bxs-edit'></i></span>
									</a>
									<c:choose>
										<c:when test="${sessionScope.active}">
											<a style="color: red"
												href='<c:url value="/deleteVideo?id=${ item.getLink()}"></c:url>'>
												<span><i class='bx bxs-trash-alt'></i></span>
											</a>
										</c:when>
										<c:otherwise>
											<a style="color: green"
												href='<c:url value="/restoreVideo?id=${ item.getLink()}"></c:url>'>
												<span><i class='bx bxs-cylinder'></i></span>
											</a>
										</c:otherwise>
									</c:choose>
								</div>

							</div>
						</div>
					</div>
				</c:forEach>
			</div>

		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
	<%@ include file="/common/jsboostrap.jsp"%>

</body>
</html>