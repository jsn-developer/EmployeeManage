package jp.co.solxyz.lessons.employee.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jp.co.solxyz.lessons.employee.entity.DeptDto;

/**
 * 部署情報のDAO
 * @author HISATO
 *
 */
public class DeptDao extends AbstractDao{

	/**
	 * 部署の全件取得
	 * @return 部署一覧
	 */
	public List<DeptDto> getAllDept() {

		List<DeptDto> list = new ArrayList<>();

		try(Connection con = getConnection();
				Statement st = con.createStatement()){

			ResultSet set = st.executeQuery("SELECT ID, NAME from DEPT order by ID");

			while(set.next()) {
				list.add(new DeptDto(set.getInt("ID"), set.getString("NAME")));
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return list;

	}
}
