<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ include file="/common/cssboostrap.jsp"%>
<style type="text/css">
td span i:hover {
	transform: scale(1.1);
	color: red;
	transition: all linear 0.5s;
}
</style>

<div class="container" style="margin: 20px auto;">
	<h5>Những Người Chia Sẻ   <span class="badge badge-warning">  ${film}<i class='bx bxs-film'></i></span></h5>
	<hr>


	<table class="table"
		style="width: 90%; margin: 0 auto; padding: 5px; border-radius: 5px; background: rgba(0, 0, 0, 0.2);">
		<thead>
			<tr>
				<th scope="col">Stt</th>
				<th scope="col">Username</th>
				<th scope="col">FullName</th>
				<th scope="col">Avatar</th>
				<th scope="col">Email</th>
				<th scope="col">Số Lần Chia Sẻ</th>
				<th scope="col">Ngày Chia Sẻ</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${not empty list}">
					<c:forEach items="${list}" var="item" varStatus="status">
						<tr>
							<th>${status.index}</th>
							<td>${item.user.username}</td>
							<td>${item.user.fullname}</td>
							<td><img src="/ASM-PS24083/images/${item.user.avatar}"
								alt="" style="width: 100px; height: 120px"></td>
							<td>${item.user.email}</td>
							<td>${item.number}</td>
							<td><fmt:formatDate value="${item.sharedate}"
									pattern="dd/MM/yyyy" /></td>
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
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
</body>

</html>