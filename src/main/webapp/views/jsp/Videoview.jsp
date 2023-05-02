<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ include file="/common/cssboostrap.jsp"%>
<div class="controller" style="width: 80%; margin: 0 auto;">
	<h2>Lượt Xem</h2>
	<hr>

	<table class="table">
		<thead>
			<tr>
				<th scope="col">Stt</th>
				<th scope="col">Title</th>
				<th scope="col">Poster</th>
				<th scope="col">Views</th>
				<th scope="col">access</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${not empty listVieoView }">
					<c:forEach items="${listVieoView }" var="item"
						varStatus="status">
						<tr>
							<th>${status.index }</th>
							<td style="font-weight: bold; font-style: italic;">${item.getTitle() }</td>
							<td><img alt=""
								src="/ASM-PS24083/images/${item.getPoster() }"
								style="width: 150px; height: 150px; border-radius: 5px"></td>
							<td>${item.getViews() }</td>
							<td><a href='<c:url value="/Video?action=watch&id=${ item.getLink()}"></c:url>'><i class='bx bx-right-arrow-alt'></i></a></td>
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