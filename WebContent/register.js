function check(){
	if(form.sno.value == ""){
		alert("用户编号不能为空！");
		form.sno.focus();
		return false;
	}
	var regm = /^[0-9]+$/;//使用正则表达式，规定用户的编号只能由数字组成
	if(form.sno.value !="" && !form.sno.value.match(regm)){
		alert("用户编号格式不对，只能由数字组成！检查后请重新输入");
		form.sno.focus();
		return false;
	}
	
	if(form.sname.value == ""){
		alert("用户名不能为空！");
		form.sname.focus();
		return false;
	}
	
	if(form.classes.value == ""){
		alert("班级不能为空！");
		form.classes.focus();
		return false;
	}
	
	if(form.speciality.value == ""){
		alert("专业不能为空！");
		form.speciality.focus();
		return false;
	}
	
	if(form.password1.value == ""){
		alert("密码不能为空！");
		form.password1.focus();
		return false;
	}
	if(form.password2.value == ""){
		alert("请再次输入密码！");
		form.password2.focus();
		return false;
	}
	if(form.password1.value != form.password2.value){
		alert("两次密码输入不一致！请重新输入");
		form.password2.focus();
		return false;
	}
}



