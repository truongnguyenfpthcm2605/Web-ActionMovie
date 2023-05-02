<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Detail Movie</title>
<%@ include file="/common/cssboostrap.jsp"%>
<script src="https://code.jquery.com/jquery-3.1.1.min.js">
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.slim.min.js">
</script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="apps" id="actionMovie" style="width: 100%">
		<div class="container">
			<h2>Chi Tiết Phim</h2>
			<div class="row">
				<div class="col-md-4">
					<img src="/ASM-PS24083/images/${video.getPoster() }"
						style="width: 90%; border-radius: 20px; margin: 10px auto; "
						alt="">
				</div>
				<div class="col-md-8">
					<h1>${video.getTitle() }</h1>
					<div class="ContentDetail">
						<h5 class="badge badge-secondary">Thể Loai :</h5>
						<span>${video.getGenre().getTitle() }</span> <br>
						<h5 class="badge badge-secondary">Chất Lượng :</h5>
						<span>${video.getQuality() }</span> <br>
						<h5 class="badge badge-secondary">Thời Lượng :</h5>
						<span>${video.getTimes() } phút </span> <br>
						<h5 class="badge badge-secondary">Ngày Đăng :</h5>
						<span><fmt:formatDate value="${video.getDayupload() }" pattern="dd/MM/yyyy" />
						</span> <br>
						<h5 class="badge bg-warning" style="font-style: 20px;">Vip
							Movie : ${video.getVip()==1?"Vip":"Không" }</h5>
						<hr>
						<h4>Thông tin thêm</h4>
						<p>${video.getDescriptions() }</p>
					</div>
				</div>
			</div>
			<h2>Xem Phim</h2>
			<hr>
			<div class="video-banner " style="height: 500px;">
				<iframe style="width: 100%; height: auto; border-radius: 10px;"
					src="https://www.youtube.com/embed/${video.getLink() }"
					title="YouTube video player" frameborder="0"
					allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
					allowfullscreen></iframe>

			</div>
			<hr>
			<div class="container ">
				<c:choose>
						<c:when test="${not empty sessionScope.currentUser }">
					<div class="reportvideo" style="text-align: left:;">
						<button id="likeunlike" class="btn "
							style="background-color: #CE5959; color: white;">
							<i class='bx bxs-heart'></i>
							<c:choose>
								<c:when test="${flaglike }">
												Bỏ Yêu Thích
										</c:when>
								<c:otherwise>
												Yêu Thích
										</c:otherwise>
							</c:choose>
						</button>
						<a class="btn"
							href='<c:url value="/Video?action=share&id=${video.getLink() }"></c:url>'
							style="background-color: #5D9C59; color: white;"><i
							class='bx bxs-share'></i>Chia Sẻ </a>
					</div>
				</c:when>
				<c:otherwise>
							<div class="reportvideo" style="text-align: left:;">
						<button id="likeunlike" class="btn " onclick="mes()"
							style="background-color: #CE5959; color: white;">
							<i class='bx bxs-heart'></i>
								Yêu Thích
						</button>
						<a class="btn" onclick="mes()"
							style="background-color: #5D9C59; color: white;">

							<i
							class='bx bxs-share'></i>Chia Sẻ </a>
					</div>
				</c:otherwise>
				</c:choose>
			</div>


			<hr>
			<h2>Phim Liên Quan</h2>
			<div class="row film">
				<c:choose>
					<c:when test="${not empty Listvideo}">
						<c:forEach var="item" items="${Listvideo }">
							<div class="col-md-3">
								<div class="card">
									<img src="/ASM-PS24083/images/${item.getPoster() }"
										class="card-img-top"
										style="border-radius: 20px 20px 0 0; height: 250px;" alt="...">
									<div class="card-body">
										<h5 class="card-title">${item.getTitle() }</h5>
										<div
											style="display: flex; justify-content: space-around; margin-bottom: 10px; align-items: center;">
												<span style="font-weight: 200;"><i class='bx bxs-show'></i>${item.getViews() }</span>
												<span><i class='bx bxs-heart'></i>${item.getTotalFavorites()}</span> <span><i
									class='bx bxs-share'></i> ${item.getTotalShares()}</span>
										</div>
										<a href='<c:url value="/Video?action=watch&id=${ item.getLink()}"></c:url>' class="btn btn-dark"> <span><i
									class='bx bx-play-circle'></i></span> Xem Ngay </a>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:when>
				</c:choose>
			</div>
		</div>
		<input type="hidden" id="videoid" value="${video.getLink() }">
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
	<%@ include file="/common/jsboostrap.jsp"%>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

	<script>
	function mes() {
		alert("Vui Lòng Đăng Nhập")
	}
		$('#likeunlike').click(function() {
			var videoid = $('#videoid').val();
			$.ajax({
				url : 'Video?action=like&id=' + videoid,
				type : 'GET',
				dataType : 'json'

			}).then(function(data) {
				console.log('ok')
				var text = $('#likeunlike').text();
				if (text.indexOf('Y') != -1) {
					$('#likeunlike').text('Bỏ Yêu Thích');
				} else {
					$('#likeunlike').text('Yêu Thích');
				}
			}).fail(function(error) {
				console.log('k ok')
				alert('Oops!! Please try again');
			});
		});
	</script>
</body>
</html>


