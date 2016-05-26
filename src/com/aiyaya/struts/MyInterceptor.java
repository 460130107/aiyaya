package com.aiyaya.struts;

import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.ActionInvocation;

public class MyInterceptor implements Interceptor{
	
	private static final long serialVersionUID = 123456789L;

	public void init(){
		System.out.println("�Զ���������MyInterceptor��ʼ��...");
	}
	
	public void destroy(){
		System.out.println("�Զ���������MyInterceptor����...");
	}
	
	public String intercept(ActionInvocation invocation) throws Exception{
		return invocation.invoke();
	}

}
