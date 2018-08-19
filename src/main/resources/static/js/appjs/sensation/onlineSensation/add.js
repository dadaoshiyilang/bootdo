$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/sensation/onlineSensation/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	// 手机号码验证
	jQuery.validator.addMethod("isMobile", function(value, element) {
	    var length = value.length;
	    var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
	    return this.optional(element) || (length == 11 && mobile.test(value));
	}, "请正确填写您的手机号码");
	
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			whname : {
				required : true
			},
			whphone : {
				required : true,
				minlength : 11,
				isMobile : true
			},
			whaddress : {
				required : true
			},
			whemail : {
				required : true,
				email:true
			}
		},
		messages : {
			whname : {
				required : icon + "请输入网红公司名称"
			},
			whphone : {
				required : icon + "请输入网红公司手机联系方式",
		        minlength : icon + "确认手机不能小于11个字符",
		        isMobile : icon + "请正确填写您的手机号码"
			},
			whaddress : {
				required : icon + "请输入联系地址"
			},
			whemail : {
				required : icon + "请输入联系邮箱",
				email:icon + "请输入正常的邮箱"
			}
		}
	})
}