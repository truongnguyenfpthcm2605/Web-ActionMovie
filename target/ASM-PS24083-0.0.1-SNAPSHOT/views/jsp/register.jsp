<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register - Action Movie</title>
<%@ include file="/common/cssboostrap.jsp"%>

<style type="text/css">
label {
	font-weight: bold;
}

form {
	width: 60%;
	margin: auto auto;
	height: 800px;
}

h2 {
	text-align: center;
}

.error {
	font-size: 10px;
	color: red;
}

.forms span {
	color: red;
	font-size: 12px;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="apps" id="actionMovie" style="width: 100%">
		<div class="container " id="register" ng-app="myApp"
			ng-controller="registerCtrl" style="width: 80%; margin: 30px auto;">
			<h2 style="margin-left: -10px">Đăng Ký</h2>
			<hr>
			<form action="register" method="post" name="form1" class="forms">
				<div class="form-group valid">
					<label for="exampleInputEmail1">Nhập Họ Và Tên</label> <input value="${user.getFullname() }"
						type="text" class="form-control" name="fullname" required
						ng-model="fullname" placeholder="Nhập họ và tên"> <span
						ng-hide="form1.fullname.$untouched || form1.fullname.$valid">Vui
						lòng nhập họ và tên</span>

				</div>
				<div class="form-group valid">
					<label for="exampleInputEmail1">Tên Tài Khoản</label> <input value="${user.getUsername() }"
						type="text" class="form-control" name="username" required
						ng-model="username" placeholder="Nhập tên tài khoản"
						ng-pattern="/^(?=.*[a-zA-Z])(?=.*\d).{5,}$/"> <span
						ng-show="form1.username.$error.pattern">Tên tài khoản gồm
						ít nhất một chữ cái thường và số có độ dài ít nhất 5 kí tự</span>
				</div>

				<div class="form-group valid">
					<label>Mật Khẩu</label>
					<div class="controller">
						<div class="input-group mb-3" style="margin: 0; padding: 0">
							<input type="password" class="form-control pass" name="pass" value="${user.getPass() }"
								required ng-model="pass"
								ng-pattern="/(?=.*[A-Z])(?=.*[a-z])(?=.*\d).{8,}$/"
								aria-label="Recipient's username" id="password-field"
								aria-describedby="button-addon2 " placeholder="Nhập mật khẩu"
								ng-change="checkPasswordMatch()">
							<div class="input-group-append">
								<button class="btn btn-light" type="button" id="button-addon2">
									<i class='bx bx-show-alt'></i>
								</button>
							</div>

						</div>
						<span ng-show="form1.pass.$error.pattern"> Mật khẩu có ít
							nhất một chữ Hoa, một chữ thường và có độ dài ít nhất 8 kí tự </span>

					</div>

				</div>
				<div class="form-group valid">
					<label>Xác Nhận Mật Khẩu</label>
					<div class="controller">
						<div class="input-group mb-3" style="margin: 0; padding: 0">
							<input type="password" class="form-control pass" name="confirm"
								required ng-model="confirm" aria-label="Recipient's username"
								id="confirm-field" aria-describedby="button-addon3"
								placeholder="Nhập xác nhận mật khẩu"
								ng-change="checkPasswordMatch()">
							<div class="input-group-append">
								<button class="btn btn-light" type="button" id="button-addon3">
									<i class='bx bx-show-alt'></i>
								</button>
							</div>

						</div>
						<span ng-show="form1.confirm.$error.match">Mật khẩu không
							khớp</span> <span
							ng-hide="form1.confirm.$untouched || form1.confirm.$valid">Vui
							lòng nhập xác nhận mật khẩu</span>
					</div>
				</div>

				<div class="form-group valid">
					<label for="exampleInputEmail1">Ngày Sinh</label> <input 
						ng-model="birthday" type="date" class="form-control" 	value="<fmt:formatDate
						value="${user.getBirth()}" pattern="yyyy-MM-dd" />"
						name="birthday" required> <span
						ng-hide="form1.birthday.$untouched || form1.birthday.$valid">Vui
						lòng chọn ngày sinh</span>

				</div>
				<div class="form-group valid">
					<label for="exampleInputEmail1">Email</label> <input type="email"
						required ng-model="email" class="form-control" name="email" value="${user.getEmail() }"
						placeholder="Nhập email "> <span
						ng-hide="form1.email.$untouched || form1.email.$valid">Nhập
						sai định dang email</span>

				</div>
				<p  >${errorUsername }</p>
				<div class="controller" style="text-align: center;">
					<button ng-disabled="form1.$invalid " class="btn btn-dark "
						style="width: 200px;" type="submit">Đăng Ký</button>
				</div>


			</form>

		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<%@ include file="/common/jsboostrap.jsp"%>

	<script type="text/javascript">
		var app = angular.module("myApp", []);
		app.controller("registerCtrl", function($scope) {
			$scope.fullname = ""
			$scope.username = ""
			$scope.pass = ""
			$scope.confirm = ""
			$scope.birthday = ""
			$scope.email = ""
			$scope.checkPasswordMatch = function() {
				if ($scope.pass !== $scope.confirm) {
					$scope.form1.confirm.$setValidity("match", false);
				} else {
					$scope.form1.confirm.$setValidity("match", true);
				}
			};

		});

		var passwordField = document.getElementById("password-field");
		var showPasswordButton = document.getElementById("button-addon2");

		showPasswordButton
				.addEventListener(
						"click",
						function() {
							if (passwordField.type === "password") {
								passwordField.type = "text";
								showPasswordButton.innerHTML = "<i class='bx bx-low-vision'></i>";
							} else {
								passwordField.type = "password";
								showPasswordButton.innerHTML = "<i class='bx bx-show-alt'></i>";
							}
						});

		var confirmField = document.getElementById("confitm-field");
		var showConfirmButton = document.getElementById("button-addon3");

		showConfirmButton
				.addEventListener(
						"click",
						function() {
							if (confirmField.type === "password") {
								confirmField.type = "text";
								showConfirmButton.innerHTML = "<i class='bx bx-low-vision'></i>";
							} else {
								confirmField.type = "password";
								showConfirmButton.innerHTML = "<i class='bx bx-show-alt'></i>";
							}
						});
	</script>


</body>
</html>
