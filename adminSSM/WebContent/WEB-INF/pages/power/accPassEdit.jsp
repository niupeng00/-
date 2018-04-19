<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改密码</title>
<link href="${model.commRoot}/comm/css/main.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="${model.commRoot}/comm/js/jquery.js"></script>
<script type="text/javascript" src="${model.commRoot}/comm/js/main.js"></script>
</head>
<body class="pagePP"><div class="tit_01"><div>当前操作：</div><div>修改密码</div></div>
<form name="WF" id="WF" action="accPassEditSave.html"  method="post"  autocomplete="off"> 

<div class="editDD contCon tabCont">
<div class="menuD"><a href="accInfoEdit.html" class="it">账户信息</a><div class="it F">修改密码</div></div>
<div class="editDDc bb">
<table align="center" cellpadding="1" cellspacing="0" class="w100">   
   
   <tr><td class="lab" width="250"><span class="red">*</span>原密码：</td><td><input type="password" name="oldPass" id="oldPass" value="" class="t22 f text" />
       </td>
   </tr>
   <tr><td class="lab"><span class="red">*</span>新密码：</td><td><input type="password" name="pass" id="pass" value="" class="t22 f text" />
       </td>
   </tr>
   <tr><td class="lab"><span class="red">*</span>确认新密码：</td><td><input type="password" name="pass2" id="pass2" value="" class="t22 f text"/>
       </td>
   </tr>
   </table>
</div>
<div class="buttonD"><input type="submit" class="button" value="保存新密码"/>
</div>
</div>

</form>
<script type="text/javascript">
$(document).ready(function(){
	$("#WF").bind("submit",function(){
		if(!checkValid([['#oldPass','',true,'原密码'],['#pass','',true,'新密码']])){
			return false;
		}
		if($("#pass").val()!=$("#pass2").val()){
			messBox(1,"两次新密码输入不一致，请重新输入");
			return false;
		}
		formSubmit('#WF',{},function(ans){});
		return false;
	});	
});
</script>
</body>
</html>
