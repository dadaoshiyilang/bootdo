
var prefix = "/ywms/ywmsWithdrawalRecord"
var prefix1 = "/ywms/ywmsUser"
$(function() {
	document.getElementById('start').valueAsDate = new Date();
	load();
	load1(0);
});


function load1(time) {
	$.ajax({
		type:'get',
		url: prefix + "/list1",
		//请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
		//contentType:'application/json;charset=utf-8',
		//数据格式是json串，商品信息
		data:{
			"time":time,
			yyid:$('#searchyyid').val(),
			phonenumber:$('#searchphonenumber').val(),
			nickname:$('#searchnickname').val(),
			usersex:$('#searchusersex option:selected').val(),
			withdrawstatus:$('#searchwithdrawstatus option:selected').val(),
			withdrawtype:$('#searchwithdrawtype option:selected').val(),
			start:$('#start').val(),
			end:$('#end').val(),
		},
		success:function(data){//返回json结果
			$("#today").html("总充值金额:&nbsp"+data.allmoneywithdrawnum+"&nbsp总充值人数:&nbsp"+data.alluserwithdrawnum+"&nbsp&nbsp&nbsp&nbsp当天充值金额:&nbsp"+data.todaymoneywithdrawnum+"&nbsp当天充值人数:&nbsp"+data.todayuserwithdrawnum);
		}
	});
}

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
						showColumns : true, // 是否显示内容下拉框（选择显示的列）
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"

						queryParams : function(params) {
							var s = $('#start').val();
							var e = $('#end').val();
							if(e!=null&&e!=''){
								if(s==null||s==''){
									alert("请选择起始日期");
								}else if(s1=null||s!=''){
									var s1= s.split("-");
									var e1= e.split("-");
									if (e1[0]*10000+e1[1]*100+e1[2]<s1[0]*10000+s1[1]*100+s1[2]){
										alert("截止日期要大于或等于起始日期");
									}
								}
							}
							if(s!=null&&s!=''){
								$("#today").html("还没做");
								load1(0);
							}
							return {
								//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
								limit: params.limit,
								offset:params.offset,
								yyid:$('#searchyyid').val(),
								phonenumber:$('#searchphonenumber').val(),
								nickname:$('#searchnickname').val(),
								usersex:$('#searchusersex option:selected').val(),
								withdrawstatus:$('#searchwithdrawstatus option:selected').val(),
								withdrawtype:$('#searchwithdrawtype option:selected').val(),
								start:$('#start').val(),
								end:$('#end').val(),

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
								title : '眼缘ID',
								formatter : function(value, row, index) {
									if(value!=null && value!=''){
										var d = '<a  href="#" mce_href="#" title="查看用户详情" onclick="look(\''+ row.userid+ '\')">'+value+'</a> ';
									}else{
										var d = '<a  href="#" mce_href="#" title="查看用户详情" onclick="look(\''+ row.userid+ '\')">'+'未设置'+'</a> ';
									}

									return d;
								}
							},
							{
								field : 'nickname',
								title : '用户昵称'
							},
							{
								field : 'usersex',
								title : '性别',
								formatter : function(value, row, index) {
									if (value == '1') {
										return '<span class="label label-danger">男</span>';
									} else if (value == '0') {
										return '<span class="label label-primary">女</span>';
									}
								}
							},

							{
								visible : false,
								field : 'outBizNo',
								title : '商户转账唯一订单号(提现单号)'
							},
							{
								visible : false,
								field : 'userid',
								title : '用户id'
							},
							{
								field : 'yuanbi',
								title : '提现的缘币'
							},
							{
								field : 'amount',
								title : '提现金额'
							},
							{
								field : 'withdrawtype',
								title : '提现方式',
								formatter : function(value, row, index) {
									if (value == '1') {
										return '<span>支付宝</span>';
									} else if (value == '2') {
										return '<span>微信</span>';
									}
								}
							},
							{
								field : 'payaccount',
								title : '提现账号'
							},

							{
								field : 'createtime',
								title : '申请日期'
							},
							{
								field : 'updatetime',
								title : '更新日期'
							},

							{
								field : 'allamount',
								title : '累计提现'
							},
							{
								field : 'recharge',
								title : '缘豆余额'
							},
							{
								field : 'withdraw',
								title : '缘豆余额'
							},

							{

								field : 'deleteflag',
								title : '用户的状态',
								formatter : function(value, row, index) {
									if (value == '1') {
										return '<span class="label label-danger">正常</span>';
									} else if (value == '0') {
										return '<span class="label label-primary">停用</span>';
									}
								}
							},
							{
								field : 'usercreatetime',
								title : '用户注册时间'
							},


							{
								field : 'lastonlinetime',
								title : '最后一次上线时间'
							},


							{
								title : '操作',
								field : 'id',
								align : 'center',
								formatter : function(value, row, index) {

									var d = '<a class="btn btn-primary btn-sm  '+s_look_h+'" href="#" mce_href="#" title="查看" onclick="look(\''
											+ row.userid
											+ '\')"><i class="fa fa-eye"></i></a> ';
								return d ;

								}
								} ]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
	load1(0);
}


function look(id) {
	layer.open({
		type : 2,
		title : '查看',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '1200px', '700px' ],
		content : prefix1 + '/look/' + id // iframe的url
	});
}


