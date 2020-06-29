<%@page import="jp.co.solxyz.lessons.employee.entity.EmployeeDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	EmployeeDto dto = (EmployeeDto) request.getAttribute("bean");
%>
<title><%=dto.getLastName() %> <%=dto.getFirstName() %></title>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>

	<header>
		<a href="./list">従業員管理システム</a>
	</header>
	<!-- ヘッダ分下にずらす必要がある(これがないとヘッダ分上にずれる) -->
	<div class="spacer"></div>

	<main role="main">
	<h2>従業員情報</h2>

	<form action="./list" method="GET">
		<div class="form-parts">
			<h4>氏名</h4>
			<p><%=dto.getLastName()%>&nbsp;<%=dto.getFirstName()%></p>
		</div>
		<div class="form-parts">
			<h4>郵便番号</h4>
			<p>
				<%=dto.getPostal()%>
			</p>
		</div>
		<div class="form-parts">
			<h4>住所</h4>
			<p>
				<%=dto.getAddress()%>
			</p>
		</div>
		<div class="form-parts">
			<h4>部署</h4>
			<p>
				<%=dto.getDeptName()%>
			</p>
		</div>
		<div class="form-parts">
			<h4>役職</h4>
			<p>
				<%=dto.getPostName()%>
			</p>
		</div>
		<span>&nbsp;</span>
        <input type="submit" value="戻る">
	</form>
	</main>
</body>
</html>