package jp.co.solxyz.lessons.employee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.solxyz.lessons.employee.dao.DeptDao;
import jp.co.solxyz.lessons.employee.dao.EmployeeDao;
import jp.co.solxyz.lessons.employee.dao.PostDao;
import jp.co.solxyz.lessons.employee.entity.EmployeeDto;

/**
 * 新規画面のサーブレット
 * @author HISATO
 *
 */
@WebServlet("/new")
public class NewServlet extends HttpServlet{

	private static final String JSP = "/WEB-INF/jsp/new.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("posts", new PostDao().getAllPost());
		req.setAttribute("depts", new DeptDao().getAllDept());

		req.getRequestDispatcher(JSP).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		EmployeeDto dto = new EmployeeDto(
				0,
				req.getParameter("lastname"),
				req.getParameter("firstname"),
				req.getParameter("postal"),
				req.getParameter("address"),
				Integer.parseInt(req.getParameter("dept")),
				"",
				Integer.parseInt(req.getParameter("post")),
				"");

		if (new EmployeeDao().insertEmployee(dto)) {
			resp.sendRedirect("list");
		} else {
			req.setAttribute("message", "エラーが発生しました。");
			req.getRequestDispatcher(JSP).forward(req, resp);
		}

	}
}
