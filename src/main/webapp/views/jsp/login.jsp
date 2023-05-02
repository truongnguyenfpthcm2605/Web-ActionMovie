<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login - Action Moive</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<%@ include file="/common/cssboostrap.jsp"%>
<style type="text/css">
		label {
	font-weight: bold;
	
}
	form{
			width: 60%;
			margin: auto auto;
			height: 350px;
	}
	h2{
		text-align: center;
	}
</style>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<div class="apps" id="actionMovie" style="width: 100%">
		<div class="container" style="width: 80%; margin: 30px auto;">
		<h2 style="margin-left: -10px">Đăng Nhập</h2>
		<hr>
			<form action="login" method="post" >
				<div class="form-group valid">
					<label for="exampleInputEmail1" >Tên
						Tài Khoản</label> <input type="text" class="form-control" value="${user}" name="username"
						id="exampleInputEmail1" placeholder="Nhập tên tài khoản" required>
					<span></span>

				</div>
				<div class="form-group valid">
					<label >Mật Khẩu</label>
					<div class="controller">
						<div class="input-group mb-3" style="margin: 0; padding: 0">
							<input type="password" class="form-control" value="${pass}" name="password"
								aria-label="Recipient's username" id="password-field" required="required"
								aria-describedby="button-addon2 " placeholder="Nhập mật khẩu">
							<div class="input-group-append">
								<button class="btn btn-light" type="button"
									id="button-addon2">
									<i class='bx bx-show-alt'></i>
								</button>
							</div>

						</div>
						<span></span>

					</div>

				</div>
				<div class="form-group form-check">
					<input type="checkbox" name="checklogin" checked="checked" value="true" class="form-check-input" id="exampleCheck1">
					<label for="exampleCheck1" >Nhớ
						tài khoản?</label>
				</div>
				<hr>

				<div class="controller" style="text-align: center;">
					<button class="btn btn-dark" >Đăng
						Nhập</button>
				</div>

			</form>
		<p style="text-align: center; color: red">${message}</p>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<%@ include file="/common/jsboostrap.jsp"%>
	<script type="text/javascript">
		var passwordField = document.getElementById("password-field");
		var showPasswordButton = document
				.getElementById("button-addon2");

		showPasswordButton.addEventListener("click", function() {
			if (passwordField.type === "password") {
				passwordField.type = "text";
				showPasswordButton.innerHTML = "<i class='bx bx-low-vision'></i>";
			} else {
				passwordField.type = "password";
				showPasswordButton.innerHTML = "<i class='bx bx-show-alt'></i>";
			}
		});
		
	</script>
</body>
</html>