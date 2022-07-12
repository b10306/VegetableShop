function isUserRepeat(flag){
	const p = document.getElementById('hint');
	const uname = document.getElementById('uname');
	if(flag){
		p.innerHTML = '使用者名稱重複';
		uname.value = '';
	}else{
		p.innerHTML = '可用的名稱';
	}
}

function submitForm(){
	const form = document.forms['form'];
	const uname = form.elements.uname.value;
	const pwd = form.elements.pwd.value;
	if(uname.length != 0 && pwd.length != 0){
		form.submit();
	}else {
		alert("使用者名稱以及密碼不能為空");
	}
}

function isUserExist(userName, execFunction){
	const xhr = new XMLHttpRequest();
	let flag;
	xhr.open('GET', '/bookShop/customer?uname=' + userName, true);
	xhr.send();
	xhr.onreadystatechange = function(){
			if(xhr.readyState === 4 && xhr.status === 200){
				if(xhr.response == "使用者已存在") flag = true;
				else flag = false;
				execFunction(flag);
			}
	}
}