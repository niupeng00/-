<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${sysTitle}</title>
<link href="${commRoot}css/main.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${commRoot}css/zTreeStyle.css"
	type="text/css">

<script type="text/javascript" src="${commRoot}js/jquery.js"></script>
<script type="text/javascript" src="${commRoot}js/jquery.ztree.core.js"></script>

<script type="text/javascript">
	function resize() {
		var w = $(window).width() - $("#container").width()
				- $("#split").width();
		var h = $(window).height() - $("#header").height();
		o = $(".mainFrame");
		$("#container").height(h);
		$("#split").height(h);
		o.width(w - 1);
		o.height(h);
		$(".menu").height(h - 23);
	}

	var zTree;
	var demoIframe;

	var setting = {
		view : {
			dblClickExpand : false,
			showLine : true,
			selectedMulti : false,
			showTitle:true
		},
		data : {
			simpleData : {
				enable : true,
				idKey : "id",
				pIdKey : "parentId",

				rootPId : ""
			},
			key : {
				name : "moduleName",
				title : "url",
				url:"notfound"
			}
		},
		callback : {
			beforeClick : function(treeId, treeNode) {
				//console.log(treeNode.url );
				var zTree = $.fn.zTree.getZTreeObj("tree");
				if (treeNode.isParent) {
					zTree.expandNode(treeNode);
					return false;
				} else {
					demoIframe.attr("src", treeNode.url  );
					return true;
				}
			}
		}
	};

	//测试用静态数据
	var zNodes = [ {
		"iconurl" : "",
		"id" : 11,
		"moduleName" : "业务管理AAA",
		"parentId" : 0,
		"showorder" : "3",
		"url" : ""
	}  ];

	$(document).ready(function() {
		$(window).bind('resize', function() {
			resize();
		});
		$("#split").bind("click", function() {
			var addW0 = $(".mainPP .left").width();
			var addW = 0;
			var w = $("#container").width();
			var posi = '';
			if (w > 100) {
				addW = 0;
				posi = "-6";
			} else {
				addW = addW0;
				posi = "0";
			}
			$("#split").css("background-position", posi + "px center");
			$("#container").width(addW);
			resize();
		});
		resize();

		//发送ajax请求ztree数据，然后ztree初始化
		$.post("ztreeData.html", {}, function(ans) {

			//console.log(ans);

			var t = $("#tree");
			t = $.fn.zTree.init(t, setting,eval(ans) ); // zNodes);
			demoIframe = $("#mainFrame");

			//获得ztree对象
			var zTree = $.fn.zTree.getZTreeObj("tree");

			//默认展开node
			zTree.selectNode(zTree.getNodeByParam("id", 1));
		});

	});
</script>
</head>
<body class="mainPP">
	<div id="header">
		<div class="imglogo">
			<img src="${commRoot}images/logo.png" class="topMar" />
		</div>
		<div class="logotitle" style="margin-left: 20px;">${sysTitle }</div>
		<div class="imgicon">
			<div class="welcome">
				<font color="red">${user.userName}</font> 您好，欢迎登录${sysTitle }
			</div>

			<div>
				<a href="account/accInfoEdit.html" target="mainFrame" class="ico"
					title="修改我的信息"><em class="iconInfo"></em></a> <a
					href="account/help.html" target="_blank" title="帮助" class="ico"><em
					class="iconHelp"></em></a> <a href="logout.html" target="_top"
					class="ico" title="登出"><em class="iconQuit"></em></a>
			</div>
		</div>
	</div>

	<div>
		<div id="container" style="background: #f8f8fa; overflow: hidden;">
			<div id="main">
				<div id="maininner">
					<div class="left">
						<div class="tit">系统视图</div>
						<div class="menu" style="height: 100%;">
							<ul id="tree" class="ztree" style="width: 260px; overflow: auto;"></ul>
						</div>

					</div>
				</div>
			</div>
		</div>
		<div id="split"></div>
		<iframe id="mainFrame" name="mainFrame" src="${commRoot}blank.htm"
			class="mainFrame"></iframe>
	</div>

</body>
</html>