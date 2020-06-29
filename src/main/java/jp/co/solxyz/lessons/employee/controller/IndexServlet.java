package jp.co.solxyz.lessons.employee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Indexに相当するサーブレット
 * @author HISATO
 *
 */
@WebServlet("/")
public class IndexServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 強制的にlist(一覧画面)へ遷移
		resp.sendRedirect("list");
	}

}
