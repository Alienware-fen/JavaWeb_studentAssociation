function allcheck(){
	var oCheck = document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		oCheck[i].checked=true;
	}
}

function delAllAso(){
	var allano = new Array();
	var flag = false;
	var oCheck = document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		if(oCheck[i].checked){
		allano.push(oCheck[i].value);
		flag=true;
		}
	}
	if(flag){
		if(confirm("ȷ��Ҫɾ����Щ��¼��")){
			location.href="updateAso?f=delall&allano="+allano;
		}
	}else{
			alert("����ѡ��һ����¼��������ɾ����");
		}
}