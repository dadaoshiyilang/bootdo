$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/ywms/ywmsPresentList/update",
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
	jQuery.validator.methods.compareDate = function(value, element, param) {
		var startDate = jQuery(param).val();
		var date1 = new Date(Date.parse(startDate.replace("-", "/")));
		var date2 = new Date(Date.parse(value.replace("-", "/")));
		return date1 < date2;
	};

	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			presentname : {
				required : true
			},
			avatar_file : {
				required : true
			},
			presentprice : {
				required : true
			},
			presentstatus : {
				required : true
			},

			starttime : {
				required : true,
				dateISO:true
			},
			endtime : {
				required : true,
				dateISO:true,
				compareDate: "#starttime"
			},
			ordernum : {
				required : true,
				digits:true
			}
		},
		messages : {
			presentname : {
				required : icon + "请输入礼物名称"
			},
			avatar_file : {
				required : icon + "请输入上传礼物图片"
			},
			presentprice : {
				required : icon + "请输入礼物价格"
			},
			presentstatus : {
				required : icon + "请输入礼物状态"
			},
			starttime : {
				required : icon + "请输入上线时间",
				dateISO : icon + "请输入正确格式的日期"
			},
			endtime : {
				required : icon + "请输入结束时间",
				dateISO : icon + "请输入正确格式的日期",
				compareDate: "结束日期必须大于开始日期!"
			},
			ordernum : {
				required : icon + "请输入排序顺序",
				digits : icon + "请输入整数"
			}
		}
	})
}