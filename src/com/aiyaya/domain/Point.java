package com.aiyaya.domain;

import java.util.List;

/**
 * ��Ա����
 * @author YJM
 *
 */

public class Point {
	
	/**
	 * ���ֱ���������ID
	 */
	private int pId;
	
	/**
	 * ��Ա����
	 */
	private String mrCardId;
	
	/**
	 * �ܻ���
	 */
	private int totalPoint;
	
	/**
	 * ���ֶһ���ϸ
	 */
	private List<PointDetail> pointDetails;

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getMrCardId() {
		return mrCardId;
	}

	public void setMrCardId(String mrCardId) {
		this.mrCardId = mrCardId;
	}

	public int getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}

	public List<PointDetail> getPointDetails() {
		return pointDetails;
	}

	public void setPointDetails(List<PointDetail> pointDetails) {
		this.pointDetails = pointDetails;
	}
}
