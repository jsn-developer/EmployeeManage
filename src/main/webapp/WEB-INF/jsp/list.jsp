<%@page import="jp.co.solxyz.lessons.employee.entity.EmployeeDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<header>
		<a href="./list">従業員管理システム</a>
	</header>
	<!-- ヘッダ分下にずらす必要がある(これがないとヘッダ分上にずれる) -->
	<div class="spacer"></div>

	<a class="action" href="./new"> <span>＋</span>
	</a>
	<main role="main">
	<div class="container">
		<%
			List<EmployeeDto> list = (List<EmployeeDto>) request.getAttribute("list");

			for (EmployeeDto dto : list) {
		%>
		<div class="card">
			<h2><%= dto.getLastName() %>&nbsp;<%= dto.getFirstName() %></h2>
			<p><%=dto.getDeptName() %> / <%=dto.getPostName() %></p>
			<a href="./detail?id=<%=dto.getId() %>">詳細はこちら</a>
		</div>
		<%
			}
		%>
	</div>
	</main>

</body>
</html>