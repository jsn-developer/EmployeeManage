package jp.co.solxyz.lessons.employee.entity;

import java.io.Serializable;

/**
 * 部署情報のBean兼DTO
 * @author HISATO
 *
 */
public class DeptDto implements Serializable{

	/**
	 * 部署ID
	 */
	private int id;

	/**
	 * 部署名
	 */
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * コンストラクタ
	 */
	public DeptDto() {

	}

	/**
	 * コンストラクタ
	 * @param id 部署ID
	 * @param name 部署名
	 */
	public DeptDto(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}



}
