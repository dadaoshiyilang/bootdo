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
		url : "/banner/advertisePicture/update",
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
			picName : {
				required : true
			},
			picUrl : {
				required : true,
				url:true
			},
			sortNo : {
				required : true,
				digits:true
			},
			starttime : {
				required : true,
				dateISO:true
			},
			endtime : {
				required : true,
				dateISO:true,
				compareDate: "#starttime"
			}
		},
		messages : {
			picName : {
				required : icon + "请输入姓名"
			},
			picUrl : {
				required : icon + "请输入广告链接地址",
				url:"请输入正确的链接地址"
			},
			sortNo : {
				required : icon + "请输入排序顺序",
				digits : icon + "请输入整数"
			},
			starttime : {
				required : icon + "请输入上线时间",
				dateISO : icon + "请输入正确格式的日期"
			},
			endtime : {
				required : icon + "请输入结束时间",
				dateISO : icon + "请输入正确格式的日期",
				compareDate: "结束日期必须大于开始日期!"
			}
		}
	})
}