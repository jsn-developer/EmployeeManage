package jp.co.solxyz.lessons.employee.entity;

import java.io.Serializable;

/**
 * 従業員情報のBean兼DTO
 * @author HISATO
 *
 */
public class EmployeeDto implements Serializable{

	/**
	 * ID
	 */
	private int id;

	/**
	 * 姓
	 */
	private String lastName;

	/**
	 * 名
	 */
	private String firstName;

	/**
	 * 郵便番号
	 */
	private String postal;

	/**
	 * 住所
	 */
	private String address;

	/**
	 * 部署ID
	 */
	private int deptId;

	/**
	 * 部署名
	 */
	private String deptName;

	/**
	 * 役職ID
	 */
	private int postId;

	/**
	 * 役職名
	 */
	private String postName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public EmployeeDto() {

	}

	public EmployeeDto(int id, String lastName, String firstName, String postal, String address, int deptId,
			String deptName, int postId, String postName) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.postal = postal;
		this.address = address;
		this.deptId = deptId;
		this.deptName = deptName;
		this.postId = postId;
		this.postName = postName;
	}



}
