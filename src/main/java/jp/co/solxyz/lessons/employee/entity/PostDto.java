package jp.co.solxyz.lessons.employee.entity;

import java.io.Serializable;

/**
 * 役職情報のBean兼DTO
 * @author HISATO
 *
 */
public class PostDto implements Serializable{

	/**
	 * 役職ID
	 */
	private int id;

	/**
	 * 役職名
	 */
	private String name;

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id セットする id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * コンストラクタ
	 */
	public PostDto() {
	}

	/**
	 * コンストラクタ
	 * @param id 部署ID
	 * @param name 部署名
	 */
	public PostDto(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


}
