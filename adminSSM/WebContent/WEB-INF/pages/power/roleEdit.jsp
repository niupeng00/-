<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html>
<head>
<meta  charset="utf-8" />
<title>角色编辑 - ${model.sysTitle }</title>
<link href="${model.commRoot}/comm/css/main.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="${model.commRoot}/comm/js/jquery.js"></script>
<script type="text/javascript" src="${model.commRoot}/comm/js/main.js"></script>
</head>
<body class="pagePP">
<div class="tit_01"><div>当前操作：</div><div>系统管理</div><div class="jt"></div><div>角色管理</div><div class="jt"></div><div>角色编辑</div></div>
<form id="WF">
<div class="editDD contCon">
<div class="titleD">角色编辑</div>
<div class="editDDc bb">
<table align="center" cellpadding="1" cellspacing="0" class="w100">
   
   <tr><td class="lab">角色名称：</td>
       <td><input type="text" name="rolename" id="rolename" value="${model.obj.roleName}" class="text f t3" /><span class="red">*</span></td>
   </tr>
   <tr><td class="lab">备注：</td>  
       <td><textarea id="note" name="note" rows="5" cols="60" class="text f">${model.obj.note}</textarea></td>
   </tr>
   </table>
</div>
<div class="buttonD"><input type="submit" class="button" value="保存"/> <input type="button" class="button" id="cbBack" value="返回"/>
  
</div>
</div>

</form>


<div class="endDD"></div>
<script type="text/javascript">
$(document).ready(function(){
	$("#cbBack").bind("click",function(){
		document.location='list.html';
	});
	$("#WF").on("submit",function(){
		if($("#rolename").val()==''){
			alert("请输入角色名称");
			$("#rolename").focus();
			return false;
		}
		$.post("editSave.html?id=${model.obj.id}",$("#WF").serializeArray(),function(){});
		return false;
	})
	
});
</script>
</body>
</html>