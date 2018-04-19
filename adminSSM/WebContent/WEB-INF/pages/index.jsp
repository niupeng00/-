<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${sysTitle}</title>
<link href="${commRoot}/css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${commRoot}/js/jquery.js"></script>
<script type="text/javascript" src="${commRoot}/js/main.js"></script>
<script type="text/javascript">
	if (self != top)
		top.location = self.location;
</script>
</head>
<body>
	<div class="text f loginPD">
		<form action="${mainRoot}login.html" method="post" name="WF" id="WF">
			<div class="bb">
				<img src="${commRoot}/images/logo.png" /><span class="tit">后台管理系统</span>
			</div>

			<div class="rowD topMar3">
				<label>用户名：</label><input type="text" name="username" id="username"
					class="text f t22" />
			</div>
			<div class="rowD">
				<label>密 码：</label><input type="password" name="pwd" id="pwd"
					class="text f t22" />
			</div>
			<div class="rowD">
				<label>验证码：</label><input type="text" id="checkc" name="checkc"
					class="text f t1" /> <img id="secodar" src="varifyImage.html"
					class="icon" /> <a href="javascript:renewSec();">看不清？换一张</a>
			</div>

			<div class="rowD topMar2">
				<label></label><input type="submit" class="button" id="s" name="s"
					value="确 定" />
			</div>

		</form>
	</div>
	<script type="text/javascript">
		function renewSec() {
			//为了让url串  发生变化。
			$("#secodar").attr("src",
					'varifyImage.html?a=' + ((new Date()).getTime()));
			$("#checkc").select();
			$("#checkc").focus();
		}
		$(document).ready(
				function() {
					$("#WF").bind(
							"submit",
							function() {
								if (!checkValid([
										[ '#username', '', true, '请输入用户名' ],
										[ '#pwd', '', true, '请输入密码' ] ])) {//,['#checkc','',true,'请输入验证码']
									return false;
								}
								formSubmit('#WF', {}, function(ans) {
								});
								return false;
							});
					$("#username").focus();
				});
	</script>
</body>
</html>