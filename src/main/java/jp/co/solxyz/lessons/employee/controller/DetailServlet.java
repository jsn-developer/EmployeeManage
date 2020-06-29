package jp.co.solxyz.lessons.employee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.solxyz.lessons.employee.dao.EmployeeDao;
import jp.co.solxyz.lessons.employee.entity.EmployeeDto;

/**
 * 詳細画面のサーブレット
 * @author HISATO
 *
 */
@WebServlet("/detail")
public class DetailServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String param = req.getParameter("id");

		EmployeeDao dao = new EmployeeDao();
		EmployeeDto dto = dao.getEmployeeById(param);

		req.setAttribute("bean", dto);

		req.getRequestDispatcher("/WEB-INF/jsp/detail.jsp").forward(req, resp);
	}

}
