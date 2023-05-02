<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<style>
.titlewep {
	font-size: 2rem;
	color: #66347F;
	font-weight: bold;
	font-style: italic;
}

.navs a {
	font-size: 15px;
}

.navs a:hover {
	transform: scale(1.05);
	transition: all linear 0.5s;
	color: #66347F;
}
/* pay */
.contentdialog {
	width: auto;
	width: 1000px;
	margin: 0;
	border-radius: 10px;
}

.pay {
	display: flex;
	justify-content: space-around;
	width: 100%;
}

.pay>div {
	text-align: center;
	padding: 10px;
	background-color: rgba(0, 0, 0, 0.1);
	border-radius: 20px;
	margin: 10px;
	width: 45%;
}

.pay>div:hover {
	transform: scale(1.02);
	transition: all linear .5s;
	box-shadow: rgba(14, 30, 37, 0.12) 0px 2px 4px 0px,
		rgba(14, 30, 37, 0.32) 0px 2px 16px 0px;
	background-color: rgba(0, 0, 0, 0.04);
}

.pay h3 {
	margin-bottom: 10px;
}

.pay a {
	border-radius: 10px;
}
</style>
<div class="onhead">
	<c:url var="app" value="/app"></c:url>
	<div class="header"
		style="background-color: rgba(0, 0, 0, 0.1); height: auto;">
		<div class="container d-flex flex-wrap"
			style="justify-content: space-between; text-align: center; margin: 0px auto; padding: 10px;">
			<a href="index"
				class="d-flex align-items-center mb-3 mb-lg-0 me-lg-auto text-dark text-decoration-none">
				<svg class="bi me-2" width="40" height="32">
                            <use xlink:href="#bootstrap"></use>
                        </svg> <span class=" titlewep">Action
					Movie&#169;</span>
			</a>
			<div
				style="display: flex; justify-content: space-between; align-items: center; cursor: pointer;">
				<c:choose>
					<c:when test="${ not empty sessionScope.currentUser.avatar }">
						<img src="/ASM-PS24083/images/${sessionScope.currentUser.avatar }"
							alt="" style="border-radius: 50%; width: 40px; height: 40px">
					</c:when>
					<c:otherwise>
						<img src="/ASM-PS24083/views/img/avt.png" alt=""
							style="border-radius: 50%; width: 40px;">
					</c:otherwise>
				</c:choose>
				<h5
					style="margin: 0 0 0 10px; font-style: italic; font-family: 'Times New Roman', Times, serif; color: aliceblue; font-weight: bold;">
					<c:choose>
						<c:when test="${ not empty sessionScope.currentUser }">
										Welcome, 	${sessionScope.currentUser.fullname}
								</c:when>
						<c:otherwise>
										Đăng Nhập
								</c:otherwise>
					</c:choose>
				</h5>
			</div>
		</div>
		<div class="rows bg-light">
			<nav class="navbar navbar-expand-lg navbar-light bg-light"
				style="margin-left: 10%;">
				<a class="navbar-brand" href="index"><span><i
						class='bx bxs-home'></i></span> Trang Chủ</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto navs">
						<c:choose>
							<c:when test="${ sessionScope.currentUser.admin==false}">
								<li class="nav-item"><a class="nav-link" href="Favorite"
									style="color: #D21312; cursor: pointer;" class='bx bxs-heart'><i
										class='bx bxs-heart'></i>Yêu Thích</a></li>
								<li class="nav-item"><a class="nav-link" href="logout"
									style="color: #D21312; cursor: pointer;" class='bx bxs-heart'>
										<i class='bx bxs-log-out'></i>Đăng Xuất
								</a></li>
								<li class="nav-item"><a class="nav-link" href="index"
									href="index"><span><i class='bx bxs-film'></i></span>Phim
										Truyện </a></li>
							</c:when>
							<c:when test="${ sessionScope.currentUser.admin ==true}">
								<li class="nav-item"><a class="nav-link" href="MangerVideo"
									style="color: green; cursor: pointer;" class='bx bxs-heart'><i
										class='bx bxs-book-content'></i>Quản Lý Phim</a></li>
								<li class="nav-item"><a class="nav-link" href="MangerAccount"
									style="color: #5F264A; cursor: pointer;" class='bx bxs-heart'><i class='bx bxs-user-account'></i>Quản Lý Tài Khoản</a></li>
								<li class="nav-item"><a class="nav-link"
									href="VideoFavorite" style="color: #F7D060; cursor: pointer;"
									class='bx bxs-heart'><i class='bx bxs-book-content'></i>Thống
										Kê</a></li>
								<li class="nav-item"><a class="nav-link" href="Favorite"
									style="color: #D21312; cursor: pointer;" class='bx bxs-heart'><i
										class='bx bxs-heart'></i>Yêu Thích</a></li>
								<li class="nav-item"><a class="nav-link" href="logout"
									style="cursor: pointer;" class='bx bxs-heart'> <i
										class='bx bxs-log-out'></i>Đăng Xuất
								</a></li>
								<li class="nav-item"><a class="nav-link" href="index"
									href="index"><span><i class='bx bxs-film'></i></span>Phim
										Truyện </a></li>
							</c:when>
							<c:otherwise>
								<li class="nav-item"><a class="nav-link" href="login"><span><i
											class='bx bxs-contact'></i></span>Đăng Nhập</a></li>
								<li class="nav-item"><a class="nav-link" href="register"
									href=""><span><i class='bx bxs-log-in'></i></span>Đăng Ký</a></li>
								<li class="nav-item"><a class="nav-link" href="index"
									href="index"><span><i class='bx bxs-film'></i></span>Phim
										Truyện </a></li>
							</c:otherwise>
						</c:choose>





					</ul>
				</div>
			</nav>

		</div>
	</div>
	<div class="modal fade" id="vd" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="margin: 20px 14%" role="document">
			<div class="modal-content contentdialog">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">
						<span class="badge badge-warning"> Vip Action Movie&#169;</span>
					</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body ">
					<div class="container pay">
						<div>
							<h2>Gói Tháng</h2>
							<p>Trải nghiệm của bạn sẽ tuyệt vời hơn !</p>
							<div style="display: flex; justify-content: space-evenly;">
								<h4 style="text-decoration: line-through;">249.000 VND</h4>
								<button class="btn btn-light"
									style="border-radius: 10px; color: red;">Giảm 40%</button>
							</div>
							<hr>
							<h2>163.000 VND</h2>
							<h5 style="color: red;">Thời gian sử dụng : 30 Ngày</h5>
							<h4 style="font-weight: bold;">Các Quyền lợi khi mua vip</h4>
							<ul style="list-style: none;">
								<li>Xem Phim ở độ phẩn giải FULLHD 1080P 60fps</li>
								<li>Đặt quyền xem được những phim vip ở web</li>
								<li>Chia sẻ trên mọi nền tảng không bị giới hạn</li>
							</ul>
							<a class="btn btn-success" data-dismiss="modal"
								aria-label="Close">Mua Ngay</a>
						</div>
						<div>
							<h2>Gói Năm</h2>
							<p>Trải nghiệm của bạn sẽ tuyệt vời hơn !</p>
							<div style="display: flex; justify-content: space-evenly;">
								<h4 style="text-decoration: line-through;">1.249.000 VND</h4>
								<button class="btn btn-light"
									style="border-radius: 10px; color: red;">Giảm 50%</button>
							</div>
							<hr>
							<h2>623.000 VND</h2>
							<h5 style="color: red;">Thời gian sử dụng : 365 Ngày</h5>
							<h4 style="font-weight: bold;">Các Quyền lợi khi mua vip</h4>
							<ul style="list-style: none;">
								<li>Xem Phim ở độ phẩn giải 4K HDR 60fps</li>
								<li>Đặt quyền xem được những phim vip ở web</li>
								<li>Chia sẻ không bị giới hạn và lưu video yêu thích</li>

							</ul>
							<a class="btn btn-success" data-dismiss="modal"
								aria-label="Close">Mua Ngay</a>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>

