package com.aiyaya.domain;

import java.util.Date;

/**
 * ��Ա���ֶһ���ϸ
 * @author YJM
 *
 */

public class PointDetail {
	
	/**
	 * ���ֱ���������
	 */
	private int pId;
	
	/**
	 * �һ��Ļ�������
	 */
	private int exchangePoint;
	
	/**
	 * �һ�����
	 */
	private Date exchangeDate;

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getExchangePoint() {
		return exchangePoint;
	}

	public void setExchangePoint(int exchangePoint) {
		this.exchangePoint = exchangePoint;
	}

	public Date getExchangeDate() {
		return exchangeDate;
	}

	public void setExchangeDate(Date exchangeDate) {
		this.exchangeDate = exchangeDate;
	}

}
