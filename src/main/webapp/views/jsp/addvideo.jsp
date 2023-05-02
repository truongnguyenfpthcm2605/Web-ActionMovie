<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cập Nhật</title>
<%@ include file="/common/cssboostrap.jsp"%>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="apps" id="actionMovie" style="width: 100%">
		<div class="container" style="margin: 10px auto;">
			<h2>Cập Nhật Video</h2>
			<hr>
			<form method="post" action="Addvideo" class="formaddvideo"
				enctype="multipart/form-data">
				<div class="form-group">
					<label for="exampleInputEmail1">Title</label> <input type="text"
						name="title" class="form-control" placeholder="Nhập tiêu đề video"
						value="${video.getTitle() }">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Ảnh Bìa</label> <br> <img
						id="avatar" src="/ASM-PS24083/images/${video.getPoster() }" alt=""
						style="width: 100px; height: 150px; box-shadow: rgba(0, 0, 0, 0.4) 0px 0px 10px;">
					<br> <br> <input id="poster-input" type="file"
						value="Chọn Ảnh Đại Diện" accept=".jpg,.png" onchange="loadFile()"
						name="imgPoster">
				</div>
				<c:set value="${video.getPoster() }" var="img" scope="session"></c:set>
				<c:set value="${video.getDescriptions() }" var="des" scope="session"></c:set>
				<c:set value="${video.getId() }" var="idvideo" scope="session"></c:set>
				<c:set value="${video.getViews() }" var="views" scope="session"></c:set>

				<div class="form-group">
					<label for="exampleInputEmail1">Link Video</label> <input
						type="text" class="form-control" placeholder="Link Video"
						name="link" value="${video.getLink() }">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Thời lượng</label> <input
						type="text" class="form-control" placeholder="Thời lượng video"
						name="times" value="${video.getTimes() }">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Chất Lượng</label> <br> <select
						name="quality" id="" style="text-align: left;"
						class="btn btn-dark">
						<option value="HD">HD</option>
						<option value="FULLHD">FULL HD</option>
						<option value="2K">2K</option>
						<option value="2K HDR">2K HDR</option>
						<option value="4K">4K</option>
					</select>
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Thể Loại</label> <br> <select
						name="genreid" id="" style="text-align: left;"
						class="btn btn-dark">
						
						<c:forEach var="item" items="${listgenre }">
							<option value="${item.getId() }"
								${item.getId() == checktype?'selected':'' }>${item.getTitle() }</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label for="" class="badge badge-success">Kích Hoạt Video</label> <br>
					<input type="radio" value="true" name="active"
						${video.getActive()?'checked':'' }> <label for="">Kích
						hoạt </label> <br> <input ${video.getActive()?'':'checked' }
						type="radio" name="active" value="false"> <label for="">Không
						Kích Hoạt</label>

				</div>
				<div class="form-group">
					<label for="" class="badge badge-warning">Kích Hoạt Vip</label> <br>
					<input type="radio" name="vip" value="1"
						${video.getVip()==1?'checked':'' }> <label for="">Kích
						hoạt </label> <br> <input ${video.getVip()==1?'':'checked' }
						type="radio" value="0" name="vip" checked> <label for="">Không
						Kích Hoạt</label>

				</div>
				<p>${video.getDescriptions() }</p>
				<div class="form-group">
					<label for="">Mô Tả</label>
					<textarea id="" cols="10" rows="5" name="descriptions"
						class="form-control"></textarea>
				</div>
				<button type="submit" class="btn btn-success">Cập Nhật
					Video</button>
			</form>
			<p>${message }</p>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<%@ include file="/common/jsboostrap.jsp"%>
	<script type="text/javascript">
		var defaultAvatar = "/ASM-PS24083/images/${user.getPoster()}";
		var id = document.getElementById('poster-input');
		var avatarImg = document.getElementById('avatar');
		function loadFile() {
			var file = id.files[0];
			var reader = new FileReader();
			reader.onload = function() {
				avatarImg.src = reader.result;
			}
			if (file
					&& (file.name.endsWith('.jpg') || file.name
							.endsWith('.png'))) {
				reader.readAsDataURL(file);
			} else {
				id.value = ''; // reset value của input file
				avatarImg.src = defaultAvatar;
				alert('Vui lòng chọn ảnh định dạng .jpg hoặc .png');
			}
		}
	</script>
</body>
</html>
