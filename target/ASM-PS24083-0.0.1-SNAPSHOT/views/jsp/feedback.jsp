<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/common/taglib.jsp" %>
<div class="container" style="height: auto;">
	<h2>Phản Hồi Của Bạn</h2>
	<div class="row justify-content-center" style="border-radius: 20px;">
		<div class="col-md-12">
			<div class="wrapper">
				<div class="row no-gutters">
					<div
						class="col-lg-8 col-md-7 order-md-last d-flex align-items-stretch">
						<div class="contact-wrap w-100 p-md-5 p-4">
							<h3 class="mb-4">Liên hệ</h3>

							<div id="form-message-success"
								style="font-weight: bold; color: green;" class="mb-4">
								Chúng tôi sẽ trả lời bạn trong thời gian sớm nhất!</div>
							<form method="POST" id="contactForm" name="contactForm"
								class="contactForm">
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label class="label" for="name">Họ và tên</label> <input
												type="text" class="form-control" name="name" id="name"
												placeholder="Tên">
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label class="label" for="email">Email</label> <input
												type="email" class="form-control" name="email" id="email"
												placeholder="Email">
										</div>
									</div>
									<div class="col-md-6">
										<label for="exampleInputEmail1">Tiêu Đề</label> <br> <select
											name="" id="" style="text-align: left;" class="btn btn-dark">
											<option value="0">Không Thể Thay Đổi Thông Tin</option>
											<option value="1">Lỗi Xem Phim</option>
											<option value="2">Không Thể Chia Sẻ</option>
											<option value="3">Lỗi Network</option>
											<option value="4">Trải Nghiệm Không Tốt</option>

										</select>
									</div>
									<div class="col-md-12">
										<div class="form-group">
											<label class="label" for="#">Nội dung</label>
											<textarea name="message" class="form-control" id="message"
												cols="30" rows="4" placeholder="Nội dung"></textarea>
										</div>
									</div>
									<div class="col-md-12">
										<div class="form-group">
											<input type="submit" value="Gửi Chúng Tôi"
												class="btn  btn-dark">
											<div class="submitting"></div>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="col-lg-4 col-md-5 d-flex align-items-stretch"
						style="background-color: black; color: white;">
						<div class="info-wrap  w-100 p-md-5 p-4">
							<h3>Thông tin liên hệ</h3>

							<div class="dbox w-100 d-flex align-items-start">
								<div
									class="icon d-flex align-items-center justify-content-center">
									<span class="fa fa-map-marker"></span>
								</div>
								<div class="text pl-3">
									<p>
										<span>Địa chỉ:</span> Địa chỉ văn phòng: 350-352 Võ Văn Kiệt,
										Phường Cô Giang, Quận 1, Thành phố Hồ Chí Minh, Việt Nam. Điện
										thoại: 028.7108.9666.
									</p>
								</div>
							</div>
							<div class="dbox w-100 d-flex align-items-center">
								<div
									class="icon d-flex align-items-center justify-content-center">
									<span class="fa fa-phone"></span>
								</div>
								<div class="text pl-3">
									<p>
										<span>Điện thoại:</span> 028 6252 3434
									</p>
								</div>
							</div>
							<div class="dbox w-100 d-flex align-items-center">
								<div
									class="icon d-flex align-items-center justify-content-center">
									<span class="fa fa-paper-plane"></span>
								</div>
								<div class="text pl-3">
									<p>
										<span>Email:</span> thanhlcps15305@fpt.edu.vn.com
									</p>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-12" style="margin-top: 20px;">
			<iframe
				src="https://www.google.com/maps/d/u/0/embed?mid=1nXEJkeV-5vhbp-OknMYYHt3dVT08bZE&ehbc=2E312F"
				width="100%" height="480px"
				style="border: none; border-radius: 20px;"></iframe>
		</div>
	</div>
</div>

