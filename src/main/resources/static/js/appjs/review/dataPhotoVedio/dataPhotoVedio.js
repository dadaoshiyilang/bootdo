
var prefix = "/review/dataPhotoVedio"
$(function() {
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/list", // 服务器数据的加载地址
						showRefresh : true,
						showToggle : true,
						showColumns : true,
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
								yyid:$('#yyid').val()
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
									field : 'yyid', 
									title : '眼缘id',
									align: 'center'
								},
																{
									visible : false,
									field : 'newsid', 
									title : '动态id' 
								},
								                                {
									field : 'freetolook', 
									title : '免费',
									align: 'center'
								},
								                                {
									field : 'size', 
									title : '全部',
									align: 'center'
								},
								                                {
									field : 'costtolook', 
									title : '动态价格',
									align: 'center'
								},
								                                {
									field : 'remark', 
									title : '动态描述',
									align: 'center'
								},
								                                {
									field : 'newstags', 
									title : '动态标签',
									align: 'center'
								},
																{
									field : 'createtime', 
									title : '创建时间',
									align: 'center'
								},
								{
									field : 'thumbnailurl', 
									title : '动态封面',
									align: 'center',
									formatter: function(value,row,index){
										var s;
										if (row.thumbnailurl != null) {
											var url = "https://woyaoyue1221.oss-cn-shanghai.aliyuncs.com"+"/" + row.thumbnailurl;
											s ='<a class = "view" href="javascript:void(0)" ><img style="width:200;height:100px;" src="'+url+'" /></a>';
										}
	                                    return s;
	                                },
	                                events: 'operateEvents'
								},
								{
									field : 'dataurl', 
									title : '动态详情',
									align: 'center',
									height:100,
									formatter: function(value,row,index){
										var tstr = "";
										if (row.datatype == '1') {
							                if (row.dataurl != null){
							                    var ts = row.dataurl.split(",");
							                    var str = row.strDid.split(",");
							                    if (ts != null && ts.length > 0) {
							                    	tstr = tstr +' <span class="data_images">'
							                        for (var i=0; i<ts.length; i++) {
							                        	var url = "https://woyaoyue1221.oss-cn-shanghai.aliyuncs.com"+"/" + ts[i];
							                        	tstr = tstr +'<a  class = "view1" href="javascript:void(0)" style="margin-left:10px;float:left;width:100px;height:100px;display:inline-block"><span style="position:relative"><button data-id ="'+str[i]+'" style="position: absolute;right: 0px;opacity: 0.5;" class="btn btn-danger btn-xs">×</button><img style="width:100%;height:100%;" src="'+url+'" /></span></a>';
							                        }
							                    	tstr = tstr +'</span>'
							                    }
							                }
										} else if (row.datatype == '2') {
											var url = "https://woyaoyue1221.oss-cn-shanghai.aliyuncs.com"+"/" + row.dataurl;
											tstr = '<div><video controls style="width:500px!important;height:400px!important;" ><source src="'+url+'" type="video/mp4" style="width:50px;height:50px;" autostart="false"><source src="movie.ogg" type="video/ogg"><source src="movie.webm" type="video/webm"> <source src="movie.mp4" type="video/mp4"></video></div>';
										}
	                                    return tstr;
	                                },
	                                cellStyle:{
	                            		css:{'display':'block','overflow-x': 'hidden',  'width':'auto' }
	                            	}
								}
//								{
//									title : '操作',
//									field : 'id',
//									align : 'center',
//									formatter : function(value, row, index) {
//										var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
//												+ row.did
//												+ '\')"><i class="fa fa-edit"></i></a> ';
//										var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
//												+ row.did
//												+ '\')"><i class="fa fa-remove"></i></a> ';
//										var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
//												+ row.did
//												+ '\')"><i class="fa fa-key"></i></a> ';
//										return e + d ;
//									}
//								} 
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
				'did' : id
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
// 删除单个图片
$('body').on('click','tr>td:nth-child(10) button',function(){
	var id = $(this).data('id');
	remove(id);
})
$('body').on('click','tr>td:nth-child(10) img',function(){
	 var wValue=($('body').width()) * 0.5;
	 var hValue=($('body').height()) * 0.8;
     layer.open({
         type: 1,
         title: false,
         closeBtn: 0,
         area: [wValue+'px',hValue+'px'],    //宽和高
         skin: 'layui-layer-nobg', //没有背景色
         shadeClose: true,
         content: '<img style="width:100%;height:100%;" src="'+$(this).context.currentSrc+'"/>'
       });
     
})
function resetPwd(id) {
}
function batchPass(status) {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要通过的数据");
		return;
	}
	layer.confirm("确认要通过选中的'" + rows.length + "'条数据吗?", {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		var ids = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
		$.each(rows, function(i, row) {
			ids[i] = row['newsid'];
		});
		$.ajax({
			type : 'POST',
			data : {
				"ids" : ids,
				"status":status,
				"reason":"正常审核通过"
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

function batchRemove1(status) {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要处理的数据");
		return;
	}
	layer.confirm("确认要处理选中的'" + rows.length + "'条数据吗?", {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		var ids = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
		$.each(rows, function(i, row) {
			ids[i] = row['newsid'];
		});
		$.ajax({
			type : 'POST',
			data : {
				"ids" : ids,
				"status":status,
				"reason":"暴露或低俗"
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

function batchRemove2(status) {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要处理的数据");
		return;
	}
	layer.confirm("确认要处理选中的'" + rows.length + "'条数据吗?", {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		var ids = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
		$.each(rows, function(i, row) {
			ids[i] = row['newsid'];
		});
		$.ajax({
			type : 'POST',
			data : {
				"ids" : ids,
				"status":status,
				"reason":"广告"
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

function batchRemove3(status) {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要处理的数据");
		return;
	}
	layer.confirm("确认要处理选中的'" + rows.length + "'条数据吗?", {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		var ids = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
		$.each(rows, function(i, row) {
			ids[i] = row['newsid'];
		});
		$.ajax({
			type : 'POST',
			data : {
				"ids" : ids,
				"status":status,
				"reason":"不可选"
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
	    	var rowurl = "https://woyaoyue1221.oss-cn-shanghai.aliyuncs.com"+"/" + row.thumbnailurl;
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