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
		if(confirm("确定要删除这些记录吗？")){
			location.href="updateAso?f=delall&allano="+allano;
		}
	}else{
			alert("至少选择一条记录才能批量删除！");
		}
}