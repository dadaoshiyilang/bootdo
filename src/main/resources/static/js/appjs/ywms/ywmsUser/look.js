
var prefix = "/ywms/ywmsUser"

$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});

function look1() {
	var id = document.getElementById("userid").value;

	layer.open({
		type : 2,
		title : '查看',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/look/' + id // iframe的url
	});
}

function lookrecharge(id) {
	var id = document.getElementById("userid").value;
	layer.open({
		type : 2,
		title : '查看',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : ['800px', '520px' ],
		content : prefix + '/lookrecharge/' + id // iframe的url
	});
}

function lookwithdraw(id) {
	var id = document.getElementById("userid").value;
	layer.open({
		type : 2,
		title : '查看',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : ['800px', '520px' ],
		content : prefix + '/lookwithdraw/' + id // iframe的url
	});
}

