<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>部门代码管理</title>
<link href="../../comm/css/main.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="../../comm/js/jquery.js"></script>
<script type="text/javascript" src="../../comm/js/main.js"></script>

<script type="text/javascript">

 
$(document).ready(function(){
	 
	$("#cbDel").on("click",function(){//删除
		
		 
		var os=$(":checkbox[name=ch]");
        if($(":checkbox[name=ch]:checked").length==0){
        	alert("请先选择要删除的记录");
        	return false;
        }
         
        
        console.log($(":checkbox[name=ch]").serializeArray());
        
        $.post("deleteDepartment.html",
        		  $(":checkbox[name=ch]").serializeArray() ,
        		function(){
        	
        });
    });
});
</script>

</head>
<body class="pagePP"><div class="tit_01"><div>当前操作：</div><div>数据字典管理</div><div class="jt"></div><div>部门代码管理</div></div>
<div class="queryDD">
<span class="rightMar2"></span>
  <input type="button" class="button" value="新增" onclick="document.location='departmentEdit.html';"/>
    <input type="button" class="button" value="排序" onclick="document.location='departmentSort.html';"/>
  <input class="button" type="button" id="cbDel" value="删除"/>
</div>

<div id="myList" class="gridDD topMar">   <table align="center" cellpadding="1" cellspacing="1" class="w100">
     <tr class="head">      
   	  <th><input id="chAll" type="checkbox" value="全选" onclick="selectAll(this,'ch')"/></th>
   	  <th>部门id</th>
      <th>名称</th>
         <th>排序</th>
      <th>操作</th>     
     </tr>
     <c:forEach items="${list}" var="row" varStatus="status">
      <tr class="row${status.index%2}">         
         <td noWrap class="tdwM"><input name="ch" type="checkbox" value="${row.id}"/></td>
         <td nowrap class="tdwM">${row.id}</td>
         <td nowrap class="tdwL">${row.description}</td>
          <td nowrap class="tdwM">${row.sortNo}</td>
         <td nowrap class="tdwM">
           [<a href="departmentEdit.html?id=${row.id}" >编辑</a>]
         </td>         
       </tr>
       </c:forEach>
     
        </table>
        <div class="pagenum">${page}</div>
   
  </div>
   
</body>
</html>
