function allcheck(){//复选框
	var oCheck = document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		oCheck[i].checked=true;//选中选框
	}
}

function delAllStu(){//批量删除事件
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
			location.href="updateStu?f=delall&allsno="+allsno;
		}
	}else{
			alert("至少选择一条记录才能批量删除！");
		}
}