<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>权限编辑 - ${sysTitle}</title>
<link href="${commRoot}/css/main.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${commRoot}/js/jquery.js"></script>
<script type="text/javascript" src="${commRoot}/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="${commRoot}/js/jquery.ztree.excheck.js"></script>

<script type="text/javascript" src="${commRoot}/js/main.js"></script>
<style type="text/css">
</style>
<link rel="stylesheet" href="${commRoot}/css/zTreeStyle.css"
	type="text/css">
	
<script language="JavaScript" type="text/javascript">
 
	
var setting = {
		check: { //启用checkBOx
			enable: true
		},
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
		} 
	};

	 
	
	//加载全部猜对数据
	var getTreeData=function(){
		//发送ajax请求ztree数据，然后ztree初始化
		$.post("getRolePower.html", {"id":"${nowRole.id}" }, function(ddd) {
			//console.log(ans);
			 
			var zNodes = eval(ddd); 
			 
			
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);

			//checked形式设定
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");	
			//zTree.setting.check.chkboxType = { "Y":"ps", "N":"ps"};
			//zTree.setting.check.chkboxType = { "Y":"", "N":""};
			 
			
			 
            var nodes = zTree.getNodes();
            for (var i = 0; i < nodes.length; i++) { //设置节点展开
            	zTree.expandNode(nodes[i], true, false, false);
            }
			 
		});
	};
	
	 
    

	$(document).ready(function(){
		
		getTreeData();
	});

 
	
	//查询树的checked=true的 所有id 给后台保存
	var getCheckedNodes = function() {
		var treeObj = $.fn.zTree.getZTreeObj("treeDemo"), 
		nodes = treeObj.getCheckedNodes(true),
		v = "";
		for (var i = 0; i < nodes.length; i++) {
			v += nodes[i].id + ",";
			//alert(nodes[i].id); //获取选中节点的值
		}
		
		$.post("powerSave.html", 
				 {   "rId":"${nowRole.id}",
				     "modules":v  }, 
				function(ddd) {
				    /*  alert("角色权限保存完成");
				      document.location = 'list.html'; 
					*/
				}
		); 
	}
	
</script>
</head>
<body class="pagePP">
	<div class="tit_01">
		<div>当前操作：</div>
		<div>系统管理</div>
		<div class="jt"></div>
		<div>权限管理</div>
		<div class="jt"></div>
		<div>权限编辑</div>
	</div>
	<div class="editDD contCon">
		<div class="titleD">权限编辑</div>
		<div class="editDDc bb">
			<table align="center" cellpadding="1" cellspacing="0" class="w100">
				<tr>
					<td class="">角色【<span class="red">${nowRole.roleName}</span>】的权限<br />
						<ul id="treeDemo" class="ztree"></ul>
					</td>
				</tr>
			</table>
		</div>
		<div class="buttonD">
			<input type="submit" class="button" id="cbSave"
			     value="保存"  onclick="getCheckedNodes()" /> <input
				type="button" class="button" id="cbBack" value="返回" />

		</div>
	</div>


	<div class="endDD"></div>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#cbBack").bind("click", function() {
				document.location = 'list.html';
			});
		});
	</script>
</body>
</html>