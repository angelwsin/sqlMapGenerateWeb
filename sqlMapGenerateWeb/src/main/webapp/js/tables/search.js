$(function(){
	//页面加载完成之后执行
	/*$("#search").click(function(){
		alert(0)
		
		 $.ajax({
        type: "POST",
        url: "searchTable.json",
        //contentType: "application/json; charset=utf-8",
        data: {table:$("#table").val()},
        dataType: "json",
        success: function (message) {
            alert(message[0].columnName)
        },
        error: function (message) {
            $("#request-process-patent").html("提交数据失败！");
        }
    });
		
	});*/
	pageInit();

});
function pageInit(){
	//创建jqGrid组件
	jQuery("#list2").jqGrid(
			{
				url : 'searchTable.json?table=user',//组件创建完成之后请求数据的url
				datatype : "json",//请求数据返回的类型。可选json,xml,txt
				colNames : [  'x','字段名', '类型', '备注', 'bean类型','Total', 'Notes' ],//jqGrid的列显示名字
				colModel : [ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式....
				             {name : 'x',index : 'x',width : 90,edit:true,edittype:'checkbox'},
				             {name : 'columnName',index : 'columnName',width : 90}, 
				             {name : 'tabDataType',index : 'name asc, invdate',width : 100}, 
				             {name : 'columnComment',index : 'amount',width : 80,align : "right"}, 
				             {name : 'dataType',index : 'tax',width : 80,align : "right"}, 
				             {name : 'total',index : 'total',width : 80,align : "right"}, 
				             {name : 'note',index : 'note',width : 150,sortable : false} 
				           ],
				rowNum : 10,//一页显示多少条
				rowList : [ 10, 20, 30 ],//可供用户选择一页显示多少条
				pager : '#pager2',//表格页脚的占位符(一般是div)的id
				sortname : 'id',//初始化的时候排序的字段
				sortorder : "desc",//排序方式,可选desc,asc
				mtype : "post",//向后台请求数据的ajax的类型。可选post,get
				viewrecords : true,
				caption : "JSON Example"//表格的标题名字
			});
	/*创建jqGrid的操作按钮容器*/
	/*可以控制界面上增删改查的按钮是否显示 searchfunc*/
	jQuery("#list2").jqGrid('navGrid', '#pager2', {edit : false,add : false,del : false});
	var x = jQuery("#list2").jqGrid('from');
	alert(x)
}