<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>模块管理 </title>
<link href="${commRoot}/css/main.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="${commRoot}/js/jquery.js"></script>
<script type="text/javascript" src="${commRoot}/js/main.js"></script>
</head>
<body class="pagePP">
<div class="tit_01"><div>当前操作：</div><div>系统管理</div><div class="jt"></div><div>模块管理</div></div>

<div class="queryDD">
   一级目录：<select id="treeKey">
   <option value="">==全部==</option>
   <c:forEach items="${treeKeyA}" var="row">
     <option value="${row.id}">${row.id} ${row.moduleName}</option>
   </c:forEach></select>
 
  <input type="button" value="添加" id="cbAdd" class="button leftMar2"/>
  <input type="button" value="删除" id="cbDel" class="button"/>
</div>

<div id="myList" class="gridDD topMar">   <table align="center" cellpadding="1" cellspacing="1" class="w100">
     <tr class="head">
   	  <th><input id="chs" type="checkbox"/></th>
   	   
   	  <th>id</th>
   	  <th>父id</th>
   	  <th>模块名称</th>
   	  <th>URL</th>
   	  <th>显示次序</th>
      <th>图标url</th>
      <th>操作</th>
     </tr><c:set var="index" value="0"/>
     <c:forEach items="${list}" var="row"><c:set var="index" value="${index+1}"/>
       <tr class="row${index%2}">		                
         <td noWrap class="tdwM"><input name="ch" type="checkbox" value="${row.id}"/></td>
         <td nowrap class="tdwL">${row.id}</td>
         <td nowrap class="tdwL">${row.parentId}</td>
         <td nowrap class="tdwL">${row.moduleName}</td>
         <td nowrap class="tdwL">${row.url}</td>
         <td nowrap class="tdwL">${row.showorder}</td>         
         <td nowrap class="tdwM">
      	   [<a href="edit.html?id=${row.id}" >编辑</a>]
      	   [<a href="javascript:void(0);" class="aDel" data-id="${row.id}" >删除</a>]
  	     </td>
       </tr>
   </c:forEach>
   </table>
   <div class="pagenum">${pages}</div>
  </div>
   
<script type="text/javascript">
$(document).ready(function(){
	$("#chs").on("click",function(){//全选
        $(":checkbox[name=ch]").prop("checked",$(this).prop("checked"));
    });
	$(".aDel").on("click",function(){//单个删除
        $(":checkbox[name=ch]").prop("checked",false);//把全部复选框都不选中
        $(this).parent().parent().find(":checkbox").prop("checked",true);//选中当前行的复选框
        $("#cbDel").click();//触发删除按钮
    });
	$("#cbDel").on("click",function(){//删除
		var os=$(":checkbox[name=ch]");
        if($(":checkbox[name=ch]:checked").length==0){
        	alert("请先选择要删除的记录");
        	return false;
        }
        $.post("delete.html?treeKey=${treeKey}",$(":checkbox[name=ch]").serializeArray(),function(){});
    });
	$("#cbAdd").on("click",function(){//新增
        document.location="getEdit.html?id=${treeKey}";
    });
    $("#treeKey").on("change",function(){//查询提交
        document.location="list.html?treeKey="+$(this).val();
    });
    $("#treeKey").val("${treeKey}");//页码调出时就把查询条件当前值置上
})
</script>
</body>
</html>