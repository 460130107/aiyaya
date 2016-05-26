package com.aiyaya.domain;

/**
 * ��ҳ����
 * @author YJM
 *
 */
public class PaginationBase {
	
	/**
	 * ��ҳ������ܼ�¼��
	 */
	private int objCount;
	
	/**
	 * ��ǰҳ����
	 */
	private int pageIndex;
	
	/**
	 * ҳ����
	 */
	private int pageCount;
	
	/**
	 * ÿҳ����ʾ������
	 */
	private int pageSize;
	
	/**
	 * ҳ��ʼ����
	 */
	private int beginIdex;
	
	/**
	 * ҳ��������
	 */
	private int endIndex;
	
	/**
	 * �Ƿ��ǵ�һҳ
	 */
	private boolean isFirstPage;
	
	/**
	 * �Ƿ������һҳ
	 */
	private boolean isLastPage;
	
	public PaginationBase(){
		this.pageIndex = 1;
		this.pageSize = 30;
		this.beginIdex = 1;
		this.endIndex = this.pageSize;
	}
	
	public PaginationBase(int pageSize, int pageIndex){
		this.pageSize = pageSize;
		this.pageIndex = pageIndex;
	}
	
	public void reset(){
		this.setPageIndex(1);
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
		this.setBeginIdex();
		this.setEndIndex();
		this.setFirstPage();
		this.setLastPage();
	}

	public int getPageCount() {
		return pageCount;
	}
	
	public void setPageCount(){
		this.pageCount = (this.objCount % this.pageSize == 0) ? this.objCount / this.pageSize : this.objCount / this.pageSize + 1;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getBeginIdex() {
		return beginIdex;
	}

	public void setBeginIdex(){
		this.beginIdex = (this.pageIndex - 1) * this.pageSize + 1;
	}
	
	public void setBeginIdex(int beginIdex) {
		this.beginIdex = beginIdex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(){
		this.endIndex = this.pageIndex * this.pageSize;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public boolean isFirstPage() {
		return isFirstPage;
	}
	
	public void setFirstPage(){
		this.isFirstPage = this.pageIndex == 1;
	}

	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}

	public boolean isLastPage() {
		return isLastPage;
	}
	
	public void setLastPage(){
		this.isLastPage = this.pageIndex == this.pageCount;
	}

	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}

	public int getObjCount() {
		return objCount;
	}

	public void setObjCount(int objCount) {
		this.objCount = objCount;
		this.setPageCount();
		this.setBeginIdex();
		this.setEndIndex();
		this.setFirstPage();
		this.setLastPage();
	}
}
