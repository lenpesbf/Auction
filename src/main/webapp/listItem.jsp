<%@page import="java.util.Collection"%>
<%@ page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ page import="model.*"%>
<%@ page import="service.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách các mục</title>
</head>
<body>

	<h3>Xin chào ${user.username}</h3>
	<table border="1">
		<thead>
			<tr>
				<th>Mặt hàng</th>
				<th>Giá</th>
			</tr>
		</thead>
		<tbody>
			<!-- Lặp qua danh sách các mặt hàng -->
			<c:forEach var="item" items="${listItem}">
				<tr>
					<!-- Cột Mặt hàng: Miêu tả -->
					
					<td>
					 <a href="showTopic?itemId=${item.id}">${item.description}</a>
					</td>
					
					
					<!-- Cột Giá: Hiển thị giá khởi đầu, giá hiện tại, và số lệnh đặt giá -->
					<td>${item.initialPrice} VND 
							<br>Giá hiện tại: ${item.currentPrice} VND
                            <br>Số lệnh đặt: ${item.bids.size()}
                        
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>
