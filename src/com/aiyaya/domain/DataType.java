package com.aiyaya.domain;

public enum DataType {
	
	EFFECTIVE(1, "��Ч"),
	NOT_EFFECTIVE(0, "��Ч");
	
	private int dataType;
	
	private String desc;
	
	DataType(int dataType, String desc){
		this.setDataType(dataType);
		this.setDesc(desc);
	}

	public int getDataType() {
		return dataType;
	}

	public void setDataType(int dataType) {
		this.dataType = dataType;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
