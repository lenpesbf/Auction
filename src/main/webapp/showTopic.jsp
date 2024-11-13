<%@page import="service.*"%>
<%@page import="model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Details</title>
<style>
body {
	font-family: Arial, sans-serif;
}

h3 {
	background-color: #d3f7d3;
	padding: 10px;
	margin: 0;
}

h3 a {
	color: blue;
	text-decoration: none;
}

table {
	width: 100%;
	border-collapse: collapse;
}

table, th, td {
	border: 1px solid black;
}

th {
	background-color: #00ffff;
	font-weight: bold;
}

td {
	padding: 10px;
	vertical-align: top;
}

.highlight {
	color: red;
	font-weight: bold;
}

.centered {
	text-align: center;
}

input[type="text"] {
	width: 80px;
	text-align: right;
}
</style>
</head>
<body>
	<%
	String itemIdParam = request.getParameter("itemId");
	Long itemId = Long.parseLong(itemIdParam);

	// Fetch the auction item by ID
	AuctionItem item = AuctionDatabase.getInstance().getAuctionItem(itemId);
	session.setAttribute("item", item);
	%>
	<h3>
		Xin chào <span style="color: blue;">${sessionScope.user.username}</span>
		| <a href="login.jsp">Thoát</a>
	</h3>

	<h2>${item.description}</h2>

	<table>
		<thead>
			<tr>
				<th>Sản phẩm</th>
				<th>Thông tin người bán</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<!-- Product Information -->
				<td>
					<p>
						Giá hiện tại: <span class="highlight">${item.currentPrice}
							VND</span>
					</p>
					<p>
						Người đặt: <span>${item.seller.username}</span> (có
						${item.bids.size()} đặt giá)
					</p>
					<p>Giá khởi điểm: ${item.initialPrice} VND</p>
					<p>Bước giá: ${item.priceStep} VND</p>
					<p>
						Bắt đầu lúc: <span class="highlight">${item.formattedStartDate}</span>
					</p>
					<p>
						Kết thúc lúc: <span>${item.formattedEndDate}</span>
					</p>

					<p>Thời gian còn: ${item.getDuration()}</p>
					<form action="setPrice" method="POST">
						<p>
							Giá đặt: <input type="number" name="bidPrice" required /> >=
							${item.currentPrice + item.priceStep} </br>
							<button type="submit"
								style="margin-left: 60px; margin-top: 10px;">Đặt giá</button>
						</p>
					</form>

				</td>

				<!-- Seller Information -->
				<td>
					<p>
						Tên tài khoản: <span>${item.seller.username}</span>
					</p>
					<p>
						Tên cửa hàng: <span>${item.seller.fullName}</span>
					</p>
					<p>
						Điện thoại: <span>${item.seller.phone}</span>
					</p>
					<p>
						Email: <span>${item.seller.email}</span>
					</p>
					<p>
						Địa chỉ: <span>${item.seller.address}</span>
					</p>
				</td>
			</tr>
		</tbody>
	</table>

	<a href="listItem.jsp?username=${username}"
		style="color: blue; margin-top: 10px;">Danh sách đấu giá</a>
</body>
</html>
