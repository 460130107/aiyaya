package com.aiyaya.domain;

/**
 * ���ۼ�¼ʵ����
 * @author YJM
 *
 */
public class SellRecord {
	
	/**
	 * id,������
	 */
	private int sId;
	
	/**
	 * ��Ա����
	 */
	private String mrCardId;
	
	/**
	 * ��Ʒ���
	 */
	private String skuId;
	
	/**
	 * ��Ʒ����
	 */
	private String wareName;
	
	/**
	 * �۸�
	 */
	private float price;
	
	/**
	 * ����
	 */
	private int num;
	
	/**
	 * �ܽ��
	 */
	private float totalMoney;
	
	/**
	 * ��������
	 */
	private String date;
	
	private int yn;
	
	/**
	 * ��ע
	 */
	private String remark;

	public int getsId() {
		return sId;
	}
	
	public int getSId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}
	
	public void setSId(int sId) {
		this.sId = sId;
	}

	public String getMrCardId() {
		return mrCardId;
	}

	public void setMrCardId(String mrCardId) {
		this.mrCardId = mrCardId;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getWareName() {
		return wareName;
	}

	public void setWareName(String wareName) {
		this.wareName = wareName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public float getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(float totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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
	
}
