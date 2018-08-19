
var prefix = "/review/authentication"
$(function() {
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/list", // 服务器数据的加载地址
						/*showRefresh : true,
						showToggle : true,
						showColumns : true,*/
						iconSize : 'outline',
						toolbar : '#exampleToolbar',
						striped : true, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
						pagination : true, // 设置为true会在底部显示分页条
						// queryParamsType : "limit",
						// //设置为limit则会发送符合RESTFull格式的参数
						singleSelect : false, // 设置为true将禁止多选
						// contentType : "application/x-www-form-urlencoded",
						// //发送到服务器的数据编码类型
						pageSize : 10, // 如果设置了分页，每页数据条数
						pageNumber : 1, // 如果设置了分布，首页页码
						//search : true, // 是否显示搜索框
						showColumns : false, // 是否显示内容下拉框（选择显示的列）
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
						queryParams : function(params) {
							return {
								//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
								limit: params.limit,
								offset:params.offset,
					            yyid:$('#yyid').val(),
					            phonenumber:$('#phonenumber').val(),
					            nickname:$('#nickname').val(),
					            usersex:$('#usersex').val(),
					            authstatus:$('#authstatus').val()
					           // username:$('#searchName').val()
							};
						},
						// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
						// queryParamsType = 'limit' ,返回参数必须包含
						// limit, offset, search, sort, order 否则, 需要包含:
						// pageSize, pageNumber, searchText, sortName,
						// sortOrder.
						// 返回false将会终止请求
						columns : [
								{
									checkbox : true
								},
																{
									visible : false,
									field : 'id', 
									title : '主键id' 
								},
																{
									visible : false,
									field : 'userid', 
									title : '用户id' 
								},
																{
									field : 'authpic1', 
									title : '认证图片',
									align : 'center',
									formatter: function(value,row,index){
										var s;
										if (row.authpic1 != null) {
											var url = "https://woyaoyue1221.oss-cn-shanghai.aliyuncs.com"+"/" + row.authpic1;
											s ='<a class = "view" href="javascript:void(0)" ><img style="width:200;height:100px;" src="'+url+'" /></a>';
										}
	                                    return s;
	                                },
	                                events: 'operateEvents'
								},
																{
									field : 'authpic2', 
									title : '认证视频',
									align : 'center',
									formatter: function(value,row,index){
										var tstr;
										if (row.authpic2 != null) {
											var url = "https://woyaoyue1221.oss-cn-shanghai.aliyuncs.com"+"/" + row.authpic2;
											tstr = '<video controls style="width:500px!important;height:300px!important;" ><source src="'+url+'" type="video/mp4" style="width:50px;height:50px;" autostart="false"><source src="movie.ogg" type="video/ogg"><source src="movie.webm" type="video/webm"></video>';
										}
	                                    return tstr;
	                                }
								},
								{
									field : 'usersex', 
									title : '性别',
									align : 'center',
									formatter : function(value, row, index) {
										if (value == '0') {
											return '<span class="label label-danger">女</span>';
										} else if (value == '1') {
											return '<span class="label label-primary">男</span>';
										}
									}
								},
								{
									field : 'portraiturl', 
									title : '网红头像',
									align : 'center',
									formatter: function(value,row,index){
										var s;
										if (row.portraiturl != null) {
											var url = "https://woyaoyue1221.oss-cn-shanghai.aliyuncs.com"+"/" + row.portraiturl;
											s ='<a class = "view" href="javascript:void(0)" ><img style="width:200;height:100px;" src="'+url+'" /></a>';
										}
	                                    return s;
	                                },
	                                events: 'operateEventUrl'
								},
								{
									field : 'yyid', 
									title : '眼缘ID' 
								},
								{
									field : 'nickname', 
									title : '网红昵称' 
								},
																{
									visible : false,
									field : 'authstatus', 
									title : '认证状态(0.认证失败,1.认证成功,2.认证中)' 
								},
																{
									field : 'createtime', 
									title : '创建时间' 
								},
																{
									visible : false,
									field : 'updatetime', 
									title : '修改时间' 
								},
																{
									visible : false,
									field : 'del', 
									title : '有效标记' 
								}
/*																{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {
										var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
												+ row.id
												+ '\')"><i class="fa fa-edit"></i></a> ';
										var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
												+ row.id
												+ '\')"><i class="fa fa-remove"></i></a> ';
										var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
												+ row.id
												+ '\')"><i class="fa fa-key"></i></a> ';
										return e + d ;
									}
								} */
							]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
function add() {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add' // iframe的url
	});
}
function edit(id) {
	layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id // iframe的url
	});
}
function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix+"/remove",
			type : "post",
			data : {
				'id' : id
			},
			success : function(r) {
				if (r.code==0) {
					layer.msg(r.msg);
					reLoad();
				}else{
					layer.msg(r.msg);
				}
			}
		});
	})
}

function resetPwd(id) {
}
function review(status, userstatus) {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要通过的数据");
		return;
	}
	layer.confirm("确认要通过选中的'" + rows.length + "'条数据吗?", {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		var users = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
		$.each(rows, function(i, row) {
			users[i] = row['userid'];
		});
		$.ajax({
			type : 'POST',
			data : {
				"users" : users,
				"status":status,
				"userstatus":userstatus
			},
			url : prefix + '/batchPass',
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	}, function() {

	});
}

function review1(status, userstatus) {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要不通过的数据");
		return;
	}
	layer.confirm("确认要不通过选中的'" + rows.length + "'条数据吗?", {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		var users = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
		$.each(rows, function(i, row) {
			users[i] = row['userid'];
		});
		$.ajax({
			type : 'POST',
			data : {
				"users" : users,
				"status":status,
				"userstatus":userstatus
			},
			url : prefix + '/batchPass',
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	}, function() {

	});
}

window.operateEvents = {
	    'click .view': function (e, value, row, index) {
	    	var rowurl = "https://woyaoyue1221.oss-cn-shanghai.aliyuncs.com"+"/" + row.authpic1;
	        layer.open({
	          type: 1,
	          title: false,
	          closeBtn: 0,
	          area: ['800px', '800px'],    //宽和高
	          skin: 'layui-layer-nobg', //没有背景色
	          shadeClose: true,
	          content: '<img style="width:100%;height:100%;" src="'+rowurl+'"/>'
	        });
	    },
	};

window.operateEventUrl = {
	    'click .view': function (e, value, row, index) {
	    	var rowurl = "https://woyaoyue1221.oss-cn-shanghai.aliyuncs.com"+"/" + row.portraiturl;
	        layer.open({
	          type: 1,
	          title: false,
	          closeBtn: 0,
	          area: ['800px', '800px'],    //宽和高
	          skin: 'layui-layer-nobg', //没有背景色
	          shadeClose: true,
	          content: '<img style="width:100%;height:100%;" src="'+rowurl+'"/>'
	        });
	    },
	};