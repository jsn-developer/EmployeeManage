package jp.co.solxyz.lessons.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.solxyz.lessons.employee.entity.EmployeeDto;

/**
 * 従業員情報のDAO
 * @author HISATO
 *
 */
public class EmployeeDao extends AbstractDao{


	/**
	 * すべての従業員を取得
	 * @return 従業員情報
	 */
	public List<EmployeeDto> selectAllEmployee() {

		List<EmployeeDto> list = new ArrayList<>();

		String sql = "select e.ID, e.LASTNAME, e.FIRSTNAME, e.POSTAL, e.ADDRESS, e.POSTID, p.NAME as POSTNAME, e.DEPTID, d.NAME as DEPTNAME " +
				" from empdb.employee e " +
				"    inner join empdb.dept d on e.DEPTID = d.ID " +
				"    inner join empdb.post p on e.POSTID = p.ID ";

		try(Connection con = getConnection();
				PreparedStatement st = con.prepareStatement(sql)) {

			ResultSet set = st.executeQuery();

			// 詰め替え作業
			while(set.next()) {
				EmployeeDto dto = new EmployeeDto(
						set.getInt("ID"),
						set.getString("LASTNAME"),
						set.getString("FIRSTNAME"),
						set.getString("POSTAL"),
						set.getString("ADDRESS"),
						set.getInt("DEPTID"),
						set.getString("DEPTNAME"),
						set.getInt("POSTID"),
						set.getString("POSTNAME"));
				list.add(dto);
			}


		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	/**
	 * 従業員情報の単票を取得
	 * @param id
	 * @return
	 */
	public EmployeeDto getEmployeeById(String id) {

		String sql = "select e.ID, e.LASTNAME, e.FIRSTNAME, e.POSTAL, e.ADDRESS, e.POSTID, p.NAME as POSTNAME, e.DEPTID, d.NAME as DEPTNAME " +
				" from empdb.employee e " +
				"    inner join empdb.dept d on e.DEPTID = d.ID " +
				"    inner join empdb.post p on e.POSTID = p.ID " +
				" where e.ID = ?";

		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement(sql)){

			// 検索用にString -> int変換して代入
			int _id = Integer.parseInt(id);
			st.setInt(1, _id);

			ResultSet set = st.executeQuery();

			// 今回は１件取得なので、
			// next()をして取得できればOK
			if(set.next()) {

				// DBから値を取得してDTOを返却
				EmployeeDto dto = new EmployeeDto(
						set.getInt("ID"),
						set.getString("LASTNAME"),
						set.getString("FIRSTNAME"),
						set.getString("POSTAL"),
						set.getString("ADDRESS"),
						set.getInt("DEPTID"),
						set.getString("DEPTNAME"),
						set.getInt("POSTID"),
						set.getString("POSTNAME"));

				return dto;
			}


		} catch (ClassNotFoundException | SQLException e) {
			// SQLに関するエラーが発生
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// パラメータエラーが発生
			e.printStackTrace();
		}

		return null;

	}

	/**
	 * 従業員の登録
	 * @param dto 登録する従業員情報
	 * @return 成功ならtrueを返却
	 */
	public boolean insertEmployee(EmployeeDto dto) {

		String sql = "insert into EMPLOYEE "
				+ " (lastname, firstname, postal, address, deptid, postid) "
				+ " values(?, ?, ?, ?, ?, ?)";

		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement(sql);) {

//			st.setInt(1, dto.getId());
			st.setString(1, dto.getLastName());
			st.setString(2, dto.getFirstName());
			st.setString(3, dto.getPostal());
			st.setString(4, dto.getAddress());
			st.setInt(5, dto.getDeptId());
			st.setInt(6, dto.getPostId());

			int result = st.executeUpdate();

			return result > 0;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}


		return true;

	}
}
