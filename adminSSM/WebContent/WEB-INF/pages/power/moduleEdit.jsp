<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>﻿<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>模块编辑</title>
<link href="${commRoot}/css/main.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="${commRoot}/js/jquery.js"></script>
<script type="text/javascript" src="${commRoot}/js/main.js"></script>
</head>
<body class="pagePP"><c:set var="obj" value="${model.obj}"/>
<div class="tit_01"><div>当前操作：</div><div>系统管理</div><div class="jt"></div><div>模块管理</div><div class="jt"></div><div>模块编辑</div></div>
<form method="post" name="WF" id="WF">
<div class="editDD contCon">
<div class="titleD">模块编辑</div>
<div class="editDDc bb">
<table align="center" cellpadding="1" cellspacing="0" class="w100">
 
   
   <tr><td class="lab">父菜单：</td>
           
       <td>
	       <input type="hidden" name="treekey" id="id" class="text t3 f" value="${module.id }"/>
	       
	       
	       <select  name="parentId"  >
		       <c:forEach items="${topModuleList}" var="row">
			         <option   <c:if test="${row.id==module.parentId}" > checked=checked </c:if> value="${row.id}">${row.id} ${row.moduleName}</option>
			   </c:forEach>
		   </select>
      
       <span class="red">*</span></td>
   </tr>
   <tr><td class="lab">模块名称：</td>  
       <td><input type="text" name="moduleName" id="modulename" class="text t3 f" value="${module.moduleName }"/><span class="red">*</span></td>
   </tr>
   <tr><td class="lab">url：</td>  
       <td><input type="text" name="url" id="act" class="text t3 f" value="${module.url }"/>（格式如：dic/logType/list.html）</td>
   </tr>   
   <tr><td class="lab">图标url：</td>  
       <td><input type="text" name="iconurl" id="target" class="text t3 f" value="${module.iconurl }"/>（格式如：common/imgs/abc.jpg）</td>
   </tr>
   <tr><td class="lab">显示次序：</td>  
       <td><input type="text" name="showorder" id="target" class="text t3 f" value="${module.showorder }"/> </td>
   </tr>
   </table>
</div>
<div class="buttonD"><input type="submit" class="button" value="保存"/> <a href="list.html?treeKey=${model.treeKey}" class="button">返回</a>
  
</div>
</div>

</form>


<div class="endDD"></div>
<script type="text/javascript">
$(document).ready(function(){
	$("#WF").on("submit",function(){
		//表单验证
		
		//用ajax提交保存请求
		var data=$("#WF").serializeArray();
		$.post("../../sys/module/saveEdit.html?id=${module.id}",data,function(ans){});//ajax提交
		return false;//注意要return false，否则系统会继续往下执行默认的自动提交
	});
});
</script>
</body>
</html>