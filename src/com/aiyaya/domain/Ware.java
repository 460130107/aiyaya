package com.aiyaya.domain;

import java.util.Date;

/**
 * ��Ʒ��Ϣʵ����
 * @author YJM
 *
 */
public class Ware {

	/**
	 * ��Ʒ���
	 */
	private String skuId;
	
	/**
	 * ��Ʒ����
	 */
	private String wareName;
	
	/**
	 * ��Ʒ�۸�
	 */
	private Float price;
	
	/**
	 * ��Ʒ��ע
	 */
	private String remark;
	
	/**
	 * ����ʱ��
	 */
	private Date created;
	
	/**
	 * ����޸�ʱ��
	 */
	private Date modified;
	
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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

}
