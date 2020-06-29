package jp.co.solxyz.lessons.employee.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jp.co.solxyz.lessons.employee.entity.PostDto;

/**
 * 役職情報のDAO
 * @author HISATO
 *
 */
public class PostDao extends AbstractDao{

	/**
	 * 役職の全件取得
	 * @return 役職一覧
	 */
	public List<PostDto> getAllPost() {

		List<PostDto> list = new ArrayList<>();

		try(Connection con = getConnection();
				Statement st = con.createStatement()) {

			ResultSet set = st.executeQuery("SELECT ID, NAME FROM POST order by id");

			while(set.next()) {
				list.add(new PostDto(set.getInt("ID"), set.getString("NAME")));
			}


		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return list;

	}
}
