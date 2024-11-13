<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<style>
body {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}
</style>

	<form action="login" method="POST">
		<div class="login"
			style="width: 350px; height: 250px; margin: 100px auto; border: 1px solid black; font-family: Arial, sans-serif;">
			<div class="title"
				style="background-color: cyan; text-align: center; padding: 5px;">
				<h3 style="margin: 0;">Đăng nhập</h3>
			</div>
			<div class="form-login" style="padding: 10px;">
				<label for="username">Tên đăng nhập</label> <input type="text"
					name="username" id="username" style="width: 100%; margin: 5px 0;">
				<label for="password">Mật khẩu</label> <input type="password"
					name="password" id="password" style="width: 100%; margin: 5px 0;">
				<c:if test="${not empty errorMessage}">
					<p class="error-message">${errorMessage}</p>
				</c:if>
				<button type="submit" style="width: 100%; margin-top: 10px;">Đăng
					nhập</button>

			</div>

		</div>
	</form>

</body>
</html>