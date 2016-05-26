package com.aiyaya.domain;

import java.util.Date;


/**
 * ��Ա��Ϣʵ����
 * @author YJM
 *
 */
public class Member extends PaginationBase {
	
	/**
	 * ��Ա����
	 */
	private String mrCardId;
	
	/**
	 * �ֻ���
	 */
	private String phone;
	
	/**
	 * ����
	 */
	private String name;
	
	/**
	 * ����
	 */
	private String grade;
	
	/**
	 * �Ա�
	 */
	private String sex;
	
	/**
	 * ����
	 */
	private Date birthday;
	
	/**
	 * Ƥ������
	 */
	private String skinType;
	
	/**
	 * QQ����
	 */
	private String qq;
	
	/**
	 * �����ʼ�
	 */
	private String email;
	
	/**
	 * �Ƽ���
	 */
	private String recommender;
	
	/**
	 * �Ƽ����ֻ�����
	 */
	private String recommenderPhone;
	
	/**
	 * ����
	 */
	private String suggest;
	
	/**
	 * ��ע
	 */
	private String remark;
	
	/**
	 * ��Ч�Ա�־
	 */
	private int yn;
	
	/**
	 * ����
	 */
	private int point;
	
	public Member(){
		
	}
	
	public Member(String mrCardId){
		this.mrCardId = mrCardId;
	}


	public String getMrCardId() {
		return mrCardId;
	}

	public void setMrCardId(String mrCardId) {
		this.mrCardId = mrCardId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		/*SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		this.birthday = format.format(birthday);*/
		this.birthday = birthday;
	}

	public String getSkinType() {
		return skinType;
	}

	public void setSkinType(String skinType) {
		this.skinType = skinType;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRecommender() {
		return recommender;
	}

	public void setRecommender(String recommender) {
		this.recommender = recommender;
	}

	public String getRecommenderPhone() {
		return recommenderPhone;
	}

	public void setRecommenderPhone(String recommenderPhone) {
		this.recommenderPhone = recommenderPhone;
	}

	public String getSuggest() {
		return suggest;
	}

	public void setSuggest(String suggest) {
		this.suggest = suggest;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getYn() {
		return yn;
	}

	public void setYn(int yn) {
		this.yn = yn;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

}
