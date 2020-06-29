package jp.co.solxyz.lessons.employee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.solxyz.lessons.employee.dao.EmployeeDao;
import jp.co.solxyz.lessons.employee.entity.EmployeeDto;

/**
 * 一覧画面のサーブレット
 * @author HISATO
 *
 */
@WebServlet("/list")
public class ListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<EmployeeDto> list = new EmployeeDao().selectAllEmployee();

		req.setAttribute("list", list);

		req.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(req, resp);

	}

}
