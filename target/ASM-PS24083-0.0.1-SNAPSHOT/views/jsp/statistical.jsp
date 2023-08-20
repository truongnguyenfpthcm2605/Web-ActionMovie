<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thống Kê</title>
<%@ include file="/common/cssboostrap.jsp"%>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="apps" id="actionMovie" style="width: 100%;">
		<div class="container"
			style="margin: 10px auto; border-radius: 10px; width: 80%;">
			<nav class="navbar navbar-expand-lg navbar-light bg-light"
				style="border-radius: 10px;">
				<div class="collapse navbar-collapse" id="navbarTogglerDemo02"
					style="text-align: center;">
					<ul class="navbar-nav mr-auto mt-2 mt-lg-0"
						style="text-align: center; width: 100%">
						<li class="nav-item active"><a class="nav-link" href="#">
						</a></li>
						<li class="nav-item active"><a class="nav-link" style="color: #5D9C59"
							href="VideoShare"><i class='bx bxs-share' ></i>Chia Sẻ</a></li>
						<li class="nav-item active"><a class="nav-link " style="color: #DF2E38"
							href="VideoFavorite"><i class='bx bxs-heart' ></i> Yêu Thích</a></li>
						<li class="nav-item active"><a class="nav-link " style="color: #B8621B"
						 href="Videoview"><i class='bx bx-slideshow' ></i>Lượt Xem </a>
						</li>
						<li class="nav-item active"><a class="nav-link "  style="color: #2E4F4F"
						href="VideoUserFavorite"><i class='bx bxl-youtube'></i>Người Dùng Thích</a>
						</li>
						<li class="nav-item active"><a class="nav-link " style="color: #FFBF9B"
						href="VieoFavoriteAndSahre"><i class='bx bxs-wallet-alt'></i>Tổng Hợp</a>
						</li>
					</ul>
				</div>
			</nav>
		</div>
		<div class="container">
								<jsp:include page="${view}"></jsp:include>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<%@ include file="/common/jsboostrap.jsp"%>
</body>
</html>