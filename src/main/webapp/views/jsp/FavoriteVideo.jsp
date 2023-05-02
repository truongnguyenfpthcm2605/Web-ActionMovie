<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Favorite Movie</title>
<%@ include file="/common/cssboostrap.jsp"%>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="apps" id="actionMovie" style="width: 100%">
		<div class="container">
			<c:url var="app" value="/app" />
			<h2>Thông tin Của Bạn</h2>
			<div class="container banneruser">
				<div class="avtuser">
					<img src="/ASM-PS24083/images/${user.getAvatar()}" alt=""
						style="height: 250px;width: 250px">
					<h2 style="width: 100%; text-align: left; margin-left: 10px">${user.getUsername() }</h2>
				</div>
			</div>
			<hr>
			<div class="container">
				<h3 class="badge badge-secondary infor ">Họ và tên :</h3>
				<span class="contentinfor">${user.getFullname() }</span> <br>
				<h3 class="badge badge-secondary infor">Email :</h3>
				<span class="contentinfor">${user.getEmail()}</span> <br>
				<h3 class="badge badge-secondary infor">Ngày Tạo :</h3>
				<span class="contentinfor"><fmt:formatDate
						value="${user.getStarday()}" pattern="dd/MM/yyyy" /> </span> <br>
				<h3 class="badge badge-secondary infor">Ngày Sinh :</h3>
				<span class="contentinfor"> <fmt:formatDate
						value="${user.getBirth() }" pattern="dd/MM/yyyy" />
				</span> <br>
				<h3 class="badge bg-warning" style="font-style: 20px;">Vip
					Movie : ${user.getVip()==1?"Tài Khoản Vip":"Chưa Kích Hoạt" }</h3>
				<br> <br> <a href="editAccount" class="btn btn-light">Chỉnh
					sủa thông tin <i class='bx bx-plus'></i>
				</a> <a href="changepass" class="btn btn-light">Đổi mật khẩu<i
					class='bx bx-check-shield'></i></a>
			</div>
			<hr>
			<h2>
				<i class='bx bxs-heart'></i>Video Yêu Thích Của Bạn
			</h2>
			<div class="container">
				<div class="row film">
					<c:choose>
						<c:when test="${ not empty list }">
							<c:forEach var="item" items="${list }">
								<div class="col-md-3">
									<div class="card">
										<img src="/ASM-PS24083/images/${item.getPoster() }"
											class="card-img-top"
											style="border-radius: 20px 20px 0 0; height: 250px;"
											alt="...">
										<div class="card-body">
											<h5 class="card-title"
												style="white-space: nowrap; overflow: hidden;">${item.getTitle() }</h5>
											<div
												style="display: flex; justify-content: space-around; margin-bottom: 10px; align-items: center;">
												<span style="font-weight: 200;"><i
													class='bx bxs-show'></i>${item.getViews() }</span> <span><i
													class='bx bxs-heart'></i>${item.getTotalFavorites()}</span> <span><i
													class='bx bxs-share'></i>${item.getTotalShares()}</span>
											</div>
											<div
												style="display: flex; justify-content: space-between; align-items: center;">
												<a
													href='<c:url value="/Video?action=watch&id=${item.getLink()}"></c:url>'
													class="btn btn-dark"> <span><i
														class='bx bx-play-circle'></i></span> Xem Ngay
												</a> <a style="color: red;"
													href='<c:url value="/Video?action=delete&id=${item.getLink()}"></c:url>'>
													<i style="font-size: 25px" class='bx bxs-trash-alt'></i>
												</a>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<p>Bạn Chưa Yêu Thích Video Nào</p>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<h2>
				<i class='bx bxs-heart'></i>Video Đã Chia Sẻ
			</h2>
			<div class="container">
				<div class="row film">
					<c:choose>
						<c:when test="${ not empty listshare }">
							<c:forEach var="item" items="${listshare }">
								<div class="col-md-3">
									<div class="card">
										<img src="/ASM-PS24083/images/${item.getPoster() }"
											class="card-img-top"
											style="border-radius: 20px 20px 0 0; height: 250px;"
											alt="...">
										<div class="card-body">
											<h5 class="card-title"
												style="white-space: nowrap; overflow: hidden;">${item.getTitle() }</h5>
											<div
												style="display: flex; justify-content: space-around; margin-bottom: 10px; align-items: center;">
												<span style="font-weight: 200;"><i
													class='bx bxs-show'></i>${item.getViews() }</span> <span><i
													class='bx bxs-heart'></i>${item.getTotalFavorites()}</span> <span><i
													class='bx bxs-share'></i>${item.getTotalShares()}</span>
											</div>
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
						<c:otherwise>
							<p>Bạn Chưa Yêu Thích Video Nào</p>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<%@ include file="/common/jsboostrap.jsp"%>

</body>
</html>
