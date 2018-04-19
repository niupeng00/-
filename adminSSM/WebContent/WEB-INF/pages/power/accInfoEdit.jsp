<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改我的账户信息</title>
<link href="${model.commRoot}/comm/css/main.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="${model.commRoot}/comm/js/jquery.js"></script>
<script type="text/javascript" src="${model.commRoot}/comm/js/main.js"></script>
</head>
<body class="pagePP"><div class="tit_01"><div>当前操作：</div><div>修改我的账户信息</div></div>
<form name="WF" id="WF" action="accInfoEditSave.html"  method="post"> 

<div class="editDD contCon tabCont">
<div class="menuD"><div class="it F">账户信息</div><a href="accPassEdit.html" class="it">修改密码</a></div>
<div class="editDDc bb">
<table align="center" cellpadding="1" cellspacing="0" class="w100">   
   <tr><td class="lab">用户名：</td><td>${model.user.userName}</td>
       <td class="lab">真实姓名：</td><td>${model.user.fullName}</td>
   </tr>
   <tr><td class="lab"><span class="red">*</span>手机：</td><td><input type="text" name="mobile" id="mobile" value="${model.user.mobile}" class="t21 f text" />
       </td>
       <td class="lab">email：</td><td><input type="text" name="email" id="email" value="${model.user.email}" class="t22 f text" />
       </td>
   </tr>
   <tr><td class="lab">QQ号：</td><td><input type="text" name="qq" id="qq" value="${model.user.qq}" class="t21 f text" />
       </td>
       <td class="lab">每页显示记录数：</td><td><input type="text" name="pagesize" id="pagesize" value="${model.user.pageSize}" class="text f t0" />
       </td>
   </tr>
   </table>
</div>
<div class="buttonD"><input type="submit" class="button" value="保存"/>
</div>
</div>


</form>
<script type="text/javascript">
$(document).ready(function(){
	$("#WF").bind("submit",function(){
		if(!checkValid([['#mobile','',true,'手机号'],['#pagesize','',true,'每页显示记录数']])){
			return false;
		}
		formSubmit('#WF',{},function(ans){});
		return false;
	});	
});
</script>
</body>
</html>
