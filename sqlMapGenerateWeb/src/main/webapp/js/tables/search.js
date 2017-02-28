$(function(){
	
	//pageInit();
	//页面加载完成之后执行
	
	$("#javaBean").click(function(){
		 $.ajax({
        type: "POST",
        url: "javaBean.json",
        //contentType: "application/json; charset=utf-8",
        data: {tableName:$("#table").val(),colNames:foreachData("table tr"),outPath:$("#outPath").val()},
        dataType: "json",
        success: function (message) {
            alert(message)
        },
        error: function (message) {
            $("#request-process-patent").html("提交数据失败！");
        }
    });
		
	});
	
});
function foreachData(tag){
	var json = [];
	$(tag).each(function(){
		if($(this).children("td")[1]){
	    var option = $($(this).children("td")[1]);
	    var val = option.html();
	    var obj = {"colName":val};
	    json.push(obj);
		}
		
	});
	return JSON.stringify(json);
}