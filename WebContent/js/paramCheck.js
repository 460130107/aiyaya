/*
 * �ؼ�����ֵУ��
 * 
 */
 
/*
 * �ֻ���У��
 * 1����ֵ��2������Ϊ11λ
 */
function checkPhone(id){
		var obj = document.getElementById(id);
		if(obj.value != "" && (!/^[0-9]*$/.test(obj.value) || !/^\d{11}$/.test(obj.value))){
			alert("��������ȷ�ֻ��ţ�");
			obj.focus();
			
		}
	}

/*
 * emailУ��
 */
function checkEmail(id){
	var obj = document.getElementById(id);
	if(obj.value != "" && (!/^\w+[-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(obj.value))){
		alert("��������ȷ��email��ַ��");
		obj.focus();
	}
}

//У����
function checkMoney(id){
	var obj = document.getElementById(id);
	if(obj.value != "" && !/^\d+(\.\d+)?$/.test(obj.value)){
		alert("��������ȷ�Ľ�");
		obj.focus();
	}
}