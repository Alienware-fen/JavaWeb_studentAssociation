function allcheck(){//��ѡ��
	var oCheck = document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		oCheck[i].checked=true;//ѡ��ѡ��
	}
}

function delAllStu(){//����ɾ���¼�
	var allsno = new Array();
	var flag = false;
	var oCheck = document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		if(oCheck[i].checked){
		allsno.push(oCheck[i].value);
		flag=true;
		}
	}
	if(flag){
		if(confirm("ȷ��Ҫɾ����Щ��¼��")){
			location.href="updateStu?f=delall&allsno="+allsno;
		}
	}else{
			alert("����ѡ��һ����¼��������ɾ����");
		}
}