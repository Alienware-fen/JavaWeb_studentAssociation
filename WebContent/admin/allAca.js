function allcheck(){
	var oCheck = document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		oCheck[i].checked=true;
	}
}

function delAllAca(){
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
		if(confirm("确定要删除这些记录吗？")){
			location.href="updateAca?f=delall&allsno="+allsno;
		}
	}else{
			alert("至少选择一条记录才能批量删除！");
		}
}