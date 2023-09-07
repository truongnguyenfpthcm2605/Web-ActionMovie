<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Quản Lý Tài Khoản</title>
 <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css
" rel="stylesheet"> 
	<%@ include file="/common/cssboostrap.jsp"%>

<style type="text/css">
td span i:hover {
	transform: scale(1.1);
	color: red;
	transition: all linear 0.5s;
}

tr td {
	color: black;
	font-size: 15px;
}

tr:hover {
	transform: scale(1.02);
	background-color: white;
	transition: all linear 0.5s;
}

tr {
	margin-bottom: 30px;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="apps" id="actionMovie" style="width: 100%">
		<div class="container" style="margin: 20px auto;">
			<h2>
				Danh Sách Người Dùng <i class='bx bxs-user-circle'></i>
			</h2>
			<hr>
			<div class="container styleChoose" style="width: 100%">
				<form action="MangerAccount" method="post"
					style="display: flex; justify-content: space-between;">
					<div class="form-group">
						<label >Năm Đăng Ký</label> <br> <select
							name="year" id="" style="text-align: left;" class="btn btn-dark">
							<option value="-1" selected="selected">Tất Cả</option>
							<c:forEach var="item" items="${years }">
								<option value="${item }" ${item == check?'selected':'' }>${item}</option>
							</c:forEach>
						</select>
					</div>
					<div>
						<label for="">Tìm Kiếm</label> <br>
						<div style="display: flex; justify-content: space-between;">
							<input style="width: 65%;" type="search" name="searchAccount"
								class="form-control" placeholder="username,fullname,email" value="${key }">
							<button class="btn btn-dark">Tìm Kiếm</button>
						</div>
					</div>
					<div>
						<label for="">Tài Khoản</label> <br> <a href="AccountActive"
							style="background-color: green;" class="btn btn-light "> Đang
							Sử Dụng<i class='bx bxs-user-check'></i>
						</a>
					</div>
					<div>
						<label for="">Tài Khoản</label> <br> <a
							href="AccountUnActive" style="background-color: #B0A4A4;"
							class="btn btn-light ">Vô Hiệu Hóa<i class='bx bxs-user-x'></i>
						</a>
					</div>
					<div>
						<label for="">Export</label> <br> <a href="/ASM-PS24083/Export/Account.xlsx"
							style="background-color: #7AA874;" class="btn btn-light ">Excel<i class="fas fa-file-excel"></i>
						</a>
					</div>

				</form>
			</div>

			<table class="table table-hover"
				style="width: 100%; margin: 0 auto; padding: 5px; border-radius: 5px; background-color: white;">
				<thead>
					<tr style="background-color: #9384D1">
						<th scope="col">Stt</th>
						<th scope="col">Id</th>
						<th scope="col">Username</th>
						<th scope="col">FullName</th>
						<th scope="col">Birth</th>
						<th scope="col">Avatar</th>
						<th scope="col">Starday</th>
						<th scope="col">Vip</th>
						<th scope="col">Email</th>
						<th scope="col">Role</th>
						<th scope="col">Active</th>
					
						<th scope="col">Remove</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty list}">
							<c:forEach items="${list}" var="item" varStatus="status">
								<tr>
									<th>${status.index}</th>
									<td>${item.getId()}</td>
									<td>${item.getUsername()}</td>
									<td>${item.getFullname()}</td>
									<td><fmt:formatDate value="${item.getBirth()}"
											pattern="dd/MM/yyyy" /></td>
									<td><img src="/ASM-PS24083/images/${item.getAvatar()}"
										alt="" style="width: 40px; height: 40px; border-radius: 50%"></td>
									<td><fmt:formatDate value="${item.getStarday()}"
											pattern="dd/MM/yyyy" /></td>
									<td>${item.getVip()==1?"Active":"No"}</td>
									<td>${item.getEmail()}</td>
									<td><c:choose>
											<c:when test="${item.getAdmin() }">
												<span class="badge badge-success">Admin</span>
											</c:when>
											<c:otherwise>
												<span class="badge badge-warning">User</span>
											</c:otherwise>
										</c:choose></td>
									<td><c:choose>
											<c:when test="${item.getActive()}">
												<span class="badge badge-success">Đang Sử Dụng</span>
											</c:when>
											<c:otherwise>
												<span class="badge badge-danger">Đã Khóa</span>
											</c:otherwise>
										</c:choose></td>
								
									<c:choose>
										<c:when test="${item.getActive() }">
											<td><a style="color: red;"
												href='<c:url value="/DeleteAccount?id=${ item.getId()}"></c:url>'><i
													class='bx bxs-trash-alt'></i></a></td>
										</c:when>
										<c:otherwise>
											<td><a style="color: green;"
												href='<c:url value="/restoreAccount?id=${ item.getId()}"></c:url>'><i
													class='bx bxs-data'></i></a></td>
										</c:otherwise>
									</c:choose>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<p>Danh Sách Trống</p>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>

		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<%@ include file="/common/jsboostrap.jsp"%>
</body>
</html>
