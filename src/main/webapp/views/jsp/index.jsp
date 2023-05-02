<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home - Action Moive</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<%@ include file="/common/cssboostrap.jsp"%>
<style>
.video-banner {
	width: 100%;
	margin: 0 auto;
	border-radius: 50px;
	display: flex;
	justify-content: center;
}

.video-banner video {
	margin: 0 auto;
	width: 90%;
	height: auto;
	border-radius: 20px;
}

.film {
	width: 80%;
	margin: 0 auto;
}

h2 {
	margin: 15px 0 15px 11%;
	color: #66347F;
	font-weight: bold;
}
/* card*/
.card:hover {
	transition: all linear 0.5s;
	transform: scale(1.05);
	background-color: rgba(0, 0, 0, 0.4);
}

.boxHover:hover {
	display: block;
}

.boxHover {
	display: none;
}

.boxHover:hover {
	display: block;
}



.card i {
	font-size: 20px;
	margin-right: 5px;
}

.card i:hover {
	transition: all linear 0.5s;
	transform: scale(1.3);
	color: #66347F;
}

.card a i {
	font-size: 15px;
}

.card {
	box-shadow: rgba(14, 30, 37, 0.12) 0px 2px 4px 0px,
		rgba(14, 30, 37, 0.32) 0px 2px 16px 0px;
	background-color: rgba(0, 0, 0, 0.2);
	margin-bottom: 20px;
	border-radius: 20px;
	
	
}
.card-body .card-title{

	font-weight: bold;
	color: black;
	font-size: 16px;
	
}
</style>
</head>
<body style="width: 100vw" >
	<jsp:include page="header.jsp"></jsp:include>
	<div class="apps" id="actionMovie" style="width: 100%">
			<jsp:include page="Allfilm.jsp"></jsp:include>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<%@ include file="/common/jsboostrap.jsp"%>
</body>
</html>