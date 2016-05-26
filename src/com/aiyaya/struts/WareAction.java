package com.aiyaya.struts;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.aiyaya.domain.Ware;
import com.aiyaya.service.LoginService;
import com.aiyaya.util.EncodeConvertUtil;

public class WareAction extends ActionSupport{
	
	private Log log = LogFactory.getLog(WareAction.class);
	private Ware ware;
	private LoginService loginService;
	private String FORWARD = null;
	private String result;
	private String queryWareCondition;
	private List<Ware> wareList;
	private String updateResult; //���ڸ��±��Ľ������
	private String updatePrice; //���ڴ洢�༭�۸�ʱ��ֵ
	private String addPrice; //���ڴ洢������Ʒʱ�ļ۸�ֵ
	
	/**
	 * ����������Ʒ��Ϣ����
	 * @return
	 */
	public String doTask(){
		int result = 0;
		
		if(null == ware){
			return SUCCESS;
		}
		
		//����У��
		if("".equals(ware.getSkuId()) || "".equals(ware.getWareName()) || "".equals(this.addPrice)){
			this.result = "��Ʒ��š����ƺͼ۸���Ϊ�գ�";
			return SUCCESS;
		}
		
		//У��۸��ֶ�
		try{
			this.ware.setPrice(Float.valueOf(this.addPrice));
		} catch(NumberFormatException e){
			this.result = "��Ʒ�۸��������󣬲���Ϊ  " + this.addPrice + " ������������.";
			this.ware.setPrice(null);
			return SUCCESS;
		}
		
		//�۸���С����
		if(this.ware.getPrice() < 0){
			this.result = "�۸���С���㣡���������롣";
			this.ware.setPrice(null);
			return SUCCESS;
		}
		
		//ִ�в������ݿ����
		try{
			result = loginService.insertWare(ware);
		}catch(Exception e){
			//�ظ��������
			if(e.getMessage().indexOf("for key 'PRIMARY") > 0){
				this.result = "��Ʒ��š�" + ware.getSkuId() + "���Ѿ����ڣ������ظ���ӣ�";
			}else{
				this.result = "������Ʒ��Ϣʱ�����쳣�����Ժ����ԣ�";
			}

			return SUCCESS;
		}finally{
			FORWARD = "success";
		}
		
		this.result = "�ɹ�����" + result + "����Ʒ��¼��";
		
		return FORWARD;
	}
	
	/**
	 * ��ѯ��Ʒ��Ϣ
	 * @return
	 */
	public String queryWare(){
		
		if(null == ware){
			return SUCCESS;
		}
		
		//��ѯ��Ʒ��Ϣ
		try{
			this.wareList = loginService.queryWareInfo(ware);
		} catch (Exception e){
			this.result = "��ѯ��Ʒ��Ϣʱ�����쳣�����Ժ����ԣ�";
		} finally{
			this.FORWARD = SUCCESS;
		}
		
		return FORWARD;
	} 
	
	/**
	 * ɾ����Ʒ��¼
	 * @return
	 */
	public String deleteWare(){
		int result;
		int index = -1;
		String deleteSkuId = ServletActionContext.getRequest().getParameter("deleteSkuId");
		try{
			result = loginService.deleteWare(deleteSkuId);
			
			//��ȡ��ǰɾ����sku��ӦskuList�б������
			for(int i = 0; i < this.wareList.size(); i++){
				if(deleteSkuId.equals(this.wareList.get(i).getSkuId().toString())){
					index = i;
					break;
				}
			}
			this.result = "�ɹ�ɾ����Ʒ���Ϊ" + deleteSkuId + "����Ʒ��¼��";
		}catch(Exception ex){
			this.result = "ɾ����Ʒ���Ϊ" + deleteSkuId + "����Ʒʱ�����쳣�����Ժ����ԣ�";
			return SUCCESS;
		}
		
		//��skuList���Ƴ���ǰɾ���˵�sku��ҳ�治����ʾɾ���˵�sku
		this.wareList.remove(index);
		
		return SUCCESS;
	}
	
	//�༭��Ʒ֮ǰ��ҳ���ʼ��
	public String initEditWare(){
		
		//��url�л�ȡ����ֵ
		String editSkuId = ServletActionContext.getRequest().getParameter("editSkuId");		
		String editWareName = ServletActionContext.getRequest().getParameter("editWareName");		
		String editPrice = ServletActionContext.getRequest().getParameter("editPrice");
		String editRemark = ServletActionContext.getRequest().getParameter("editRemark");	
		
		/**
		 * ����ת��
		 * TODO
		 * ��������ȡ��ע��
		 * ��������ע�͵�
		 */
		editSkuId = EncodeConvertUtil.ISOToUTF(editSkuId);
		editWareName = EncodeConvertUtil.ISOToUTF(editWareName);
		editPrice = EncodeConvertUtil.ISOToUTF(editPrice);
		editRemark = EncodeConvertUtil.ISOToUTF(editRemark);
		
		//����ֵset��ware������
		this.ware.setSkuId(editSkuId);
		this.ware.setWareName(editWareName);
		this.ware.setPrice(Float.valueOf(editPrice));
		this.ware.setRemark(editRemark);
		
		return SUCCESS;
	}
	
	
	public String editWare(){
		int result;
		
		//У��۸��ֶ������Ƿ�Ϸ�
		try{
			this.ware.setPrice(Float.valueOf(updatePrice));
		} catch(NumberFormatException e) {
			this.updateResult = "�����������󣬲���Ϊ " + updatePrice +" �����������롣";
			this.ware.setPrice(null);
			return SUCCESS;
		}
		
		//�۸���С����
		if(Float.valueOf(this.updatePrice) < 0){
			this.updateResult = "���۲���С���㣡���������롣";
			this.ware.setPrice(null);
			return SUCCESS;
		}
		
		try{
			result = loginService.updateWare(this.ware);
		} catch(Exception e) {
			this.updateResult = "������Ʒ���Ϊ" + ware.getSkuId() + "����Ʒ�쳣�����Ժ����ԣ�";
			e.printStackTrace();
			return SUCCESS;
		}
		
		this.updateResult = "�ɹ�������Ʒ���Ϊ" + ware.getSkuId() + "����Ʒ��Ϣ��";
		
		return SUCCESS;
	}

	public Ware getWare() {
		return ware;
	}

	public void setWare(Ware ware) {
		this.ware = ware;
	}
	
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getQueryWareCondition() {
		return queryWareCondition;
	}

	public void setQueryWareCondition(String queryWareCondition) {
		this.queryWareCondition = queryWareCondition;
	}

	public List<Ware> getWareList() {
		return wareList;
	}

	public void setWareList(List<Ware> wareList) {
		this.wareList = wareList;
	}

	public String getUpdateResult() {
		return updateResult;
	}

	public void setUpdateResult(String updateResult) {
		this.updateResult = updateResult;
	}

	public String getUpdatePrice() {
		return updatePrice;
	}

	public void setUpdatePrice(String updatePrice) {
		this.updatePrice = updatePrice;
	}

	public String getAddPrice() {
		return addPrice;
	}

	public void setAddPrice(String addPrice) {
		this.addPrice = addPrice;
	}
}
