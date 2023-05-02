

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Change Password</title>
<%@ include file="/common/cssboostrap.jsp"%>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="apps" id="actionMovie" style="width: 100%">
		<div class="container" style="width: 60%; margin: 10px auto;">
			<h2>Đổi Mật Khẩu</h2>
			<hr>
			<form action="changepass" method="post">
				<div class="form-group">
					<label for="exampleInputEmail1">Mật Khẩu Cũ</label> <input
						type="text" class="form-control"   required="required"
						value="${oldpass }"name="oldpass">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Mật Khẩu Mới</label> <input
						type="text" class="form-control"  required="required"
						value="${newpass }" name="newpass">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Xác Nhận Mật Khẩu Mới</label> <input
						type="text" class="form-control"   required="required"
						value="${confirm }" name="confirm">
				</div>
				<div style="display: flex; justify-content: end;">
					<button class="btn btn-dark">Lưu Thay Đổi</button>
				</div>
			</form>
			<p style="color: #D21312">${error }</p>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<%@ include file="/common/jsboostrap.jsp"%>
</body>
</html>
