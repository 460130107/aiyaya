package com.aiyaya.struts;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.aiyaya.domain.DataType;
import com.aiyaya.domain.Member;
import com.aiyaya.service.LoginService;
import com.aiyaya.util.EncodeConvertUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import javax.servlet.ServletRequest;


/**
 * ��Ա��Ϣ����
 * @author YJM
 *
 */
public class MemberAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Log log = LogFactory.getLog(MemberAction.class);
	private LoginService loginService;
	private Member member;
	private String addMemberResult; //������Ա��Ϣ���
	private String updateMemberResult; //���»�Ա��Ϣ���
	private String deleteMemberResult; //ɾ����Ա��Ϣ���
	private List<Member> memberList; //��Ա��Ϣ�б�
/*	private boolean goAhead; //�û��Ƿ�����һҳ
	private boolean goBack; //�û��Ƿ�����һҳ
	*/
	/**
	 * ������Ա
	 * @return
	 */
	public String addMember(){
		this.addMemberResult = "";
		
		int result = 0;
		try{
			result = loginService.addMember(this.member);
		} catch (Exception e) {
			if(e.getMessage().indexOf("for key 'PRIMARY") > 0){
				this.addMemberResult = "��Ա���š�" + this.member.getMrCardId() + "���Ѿ����ڣ������ظ���ӣ�";
				return SUCCESS;
			}
			log.error("MemberAction.addMember.error", e);
			this.addMemberResult = "��ӻ�Ա��Ϣʱ�쳣�����Ժ����ԣ�";
			return SUCCESS;
		}
		if(result > 0){
			this.addMemberResult = "�ɹ����" + result + "����Ա��Ϣ��";
		}
			
		return SUCCESS;
	}
	
	/**
	 * ���»�Ա
	 * @return
	 */
	public String updateMember(){
		return SUCCESS;
	}
	
	/**
	 * ɾ����Ա
	 * @return
	 */
	public String deleteMember(){
		String mrCardId_del = ServletActionContext.getRequest().getParameter("mrCardId");
		int result = 0;
		try{
			result = loginService.deleteMember(mrCardId_del);
		} catch(Exception e) {
			log.error("MemberAction.deleteMember::error", e);
		}
		
		if(result > 0){
			for(int i = 0; i < this.memberList.size(); i++){
				if(mrCardId_del.equals(this.memberList.get(i).getMrCardId())){
					this.memberList.remove(i);
					break;
				}
			}
		}
		
		return SUCCESS;
	}
	
	/**
	 * ��ѯ��Ա��Ϣ
	 * @return
	 */
	public String queryMember(){
		if(this.member == null){
			this.member = new Member();
			this.member.setObjCount(0);
		}
		
		// ��ѯ������Ч������
		this.member.setYn(DataType.EFFECTIVE.getDataType());
		
		// name��Ϥ��ǰ̨������̨��ʱ�����룬��Ҫת��
		// ��������ע��
		/*if(!"".equals(this.member.getName())){
			this.member.setName(EncodeConvertUtil.ISOToUTF(this.member.getName()));
		}*/
		
		int memberCount = 0;
		try{
			memberCount = loginService.queryMemberCount(this.member);
		} catch(Exception e) {
			log.error("MemberAction.queryMemberCount.error", e);
			return SUCCESS;
		}
		
		// �����ܼ�¼��
		this.member.setObjCount(memberCount);
		
		// ��ʼ����ҳ����
		this.member.reset();
		
		// mySqlʹ��limit��ҳʱ�����Ǵ�0��ʼ�ģ����԰�member��pageIndxֵ��һ
		this.member.setBeginIdex(this.member.getBeginIdex() - 1);
		
		try{
			this.memberList = loginService.queryMemberInfo(this.member);
		}catch(Exception e){
			log.error("MemberAction.queryMember.error", e);
		}finally{
			this.member.setBeginIdex(this.member.getBeginIdex() + 1);
		}

		return SUCCESS;
	}
	
	/**
	 * ��ѯ��Ա��Ϊ��ҳ��ѯ��
	 * @return
	 */
	public String queryMemberForPagination(){
		
		// ��ѯ������Ч������
		/*this.member.setYn(DataType.EFFECTIVE.getDataType());
		
		int memberCount = 0;
		try{
			memberCount = loginService.queryMemberCount(this.member);
		} catch(Exception e) {
			log.error("MemberAction.queryMemberCount.error", e);
			return SUCCESS;
		}
		
		// �����ܼ�¼��
		this.member.setObjCount(memberCount);*/
		
		// ��ȡ�û���ѡ����һҳ�����ǡ���һҳ��
		boolean goAhead = "true".equals(ServletActionContext.getRequest().getParameter("goAhead"));;
		boolean goBack = "true".equals(ServletActionContext.getRequest().getParameter("goBack"));;
		
		// ����ҳ���С����Ҫ�ж��û��ǵ������һҳ�����ǡ���һҳ��
		if(goAhead && !this.member.isLastPage()){
			this.member.setPageIndex(this.member.getPageIndex() + 1);
		}
		if(goBack && !this.member.isFirstPage()){
			this.member.setPageIndex(this.member.getPageIndex() - 1);
		}
		
		// mySqlʹ��limit��ҳʱ�����Ǵ�0��ʼ�ģ����԰�member��pageIndxֵ��һ
		this.member.setBeginIdex(this.member.getBeginIdex() - 1);
		
		try{
			this.memberList = loginService.queryMemberInfo(this.member);
		}catch(Exception e){
			log.error("MemberAction.queryMember.error", e);
		}finally{
			this.member.setBeginIdex(this.member.getBeginIdex() + 1);
		}

		return SUCCESS;
	}
	
	
	public String initPage(){
		this.memberList = null;
		this.member = null;
		return SUCCESS;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getAddMemberResult() {
		return addMemberResult;
	}

	public void setAddMemberResult(String addMemberResult) {
		this.addMemberResult = addMemberResult;
	}

	public String getUpdateMemberResult() {
		return updateMemberResult;
	}

	public void setUpdateMemberResult(String updateMemberResult) {
		this.updateMemberResult = updateMemberResult;
	}

	public String getDeleteMemberResult() {
		return deleteMemberResult;
	}

	public void setDeleteMemberResult(String deleteMemberResult) {
		this.deleteMemberResult = deleteMemberResult;
	}

	public void setLoginService(LoginService service) {
		this.loginService = service;
	}

	public List<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}

	/*public boolean isGoAhead() {
		return goAhead;
	}

	public void setGoAhead(boolean goAhead) {
		this.goAhead = goAhead;
	}

	public boolean isGoBack() {
		return goBack;
	}

	public void setGoBack(boolean goBack) {
		this.goBack = goBack;
	}*/



}
