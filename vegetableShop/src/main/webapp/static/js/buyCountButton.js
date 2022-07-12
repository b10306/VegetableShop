function minus(id){
	const form = document.forms['form' + id];
	const inputNum = form.elements.inputNum;
	if(inputNum.value < 0) inputNum.value = 0;
	else inputNum.value -= 1;
}

function add(id){
	const form = document.forms['form' + id];
	const inputNum = form.elements.inputNum;
	const totalCount = parseInt(form.elements.totalCount.value);
	if(parseInt(inputNum.value) >= totalCount) inputNum.value = totalCount
	else {
		inputNum.value = parseInt(inputNum.value) + 1;
	}
}