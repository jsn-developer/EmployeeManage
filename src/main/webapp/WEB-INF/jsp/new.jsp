<%@page import="jp.co.solxyz.lessons.employee.entity.PostDto"%>
<%@page import="jp.co.solxyz.lessons.employee.entity.DeptDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>新しい従業員を追加</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <header>
        <a href="./list">従業員管理システム</a>
    </header>
    <!-- ヘッダ分下にずらす必要がある(これがないとヘッダ分上にずれる) -->
    <div class="spacer"></div>

    <main role="main">
        <h2>新しい従業員</h2>

		<%
			if (request.getAttribute("message") != null) {
		%>
			<%= request.getAttribute("message") %>
		<%} %>

        <form action="new" method="POST">
            <div class="form-parts">
                <h4>氏名</h4>
                <input type="text" name="lastname" class="half" placeholder="姓">
                <input type="text" name="firstname" class="half" placeholder="名">
            </div>
            <div class="form-parts">
                <h4>郵便番号</h4>
                <input type="text" name="postal" placeholder="郵便番号をハイフンなしで入力">
            </div>
            <div class="form-parts">
                <h4>住所</h4>
                <input type="text" name="address" placeholder="住所">
            </div>
            <div class="form-parts">
                <h4>部署</h4>
                <select name="dept" id="dept">
                <%
                	List<DeptDto> depts = (List<DeptDto>)request.getAttribute("depts");

                	for (DeptDto dept : depts) {
                %>
                	<option value="<%=dept.getId() %>"><%=dept.getName() %></option>

                <% } %>
                </select>
            </div>
            <div class="form-parts">
                <h4>役職</h4>
                <select name="post" id="post">
                <%
                	List<PostDto> posts = (List<PostDto>)request.getAttribute("posts");

                	for(PostDto post : posts) {
                %>
                	<option value="<%=post.getId() %>"><%=post.getName() %></option>
                <% } %>
                </select>
            </div>
            <span>&nbsp;</span>
            <input type="submit" value="登録">
        </form>

    </main>

</body>
</html>