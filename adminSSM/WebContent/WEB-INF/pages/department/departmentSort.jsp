<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>部门代码排序 - 后台管理系统</title>
<link href="../../comm/css/main.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="../../comm/js/jquery.js"></script>
<script type="text/javascript" src="../../comm/js/jquery.json-2.2.min.js"></script>
<script type="text/javascript" src="../../comm/js/main.js"></script>
</head>
<body class="pagePP">
<div class="tit_01"><div>当前操作：</div><div>数据字典管理</div><div class="jt"></div><div>部门代码管理</div><div class="jt"></div><div>部门代码排序</div></div>

<div class="editDD contCon">
<div class="titleD">部门代码排序</div>
<div class="editDDc bb">
<table align="center" cellpadding="1" cellspacing="0" class="w100">
   
   <tr><td class="lab">排序：</td>  
       <td><select name="sort" id="sort" size="15" style="min-width:200px;">
         <c:forEach items="${list}" var="row">
       		    <option value="${row.id}"  data-sort="${row.sortNo}">${row.description }</option>
       	 </c:forEach></select>
           <input type="button" name="upMove" value="上移" onclick="moveUp($('#sort')[0]);"/>
           <input type="button" name="downMove" value="下移" onclick="moveDown($('#sort')[0]);"/>
       </td>
   </tr>
   </table>
</div>
<div class="buttonD"><input type="button" class="button" id="cbSave" value="保存"/> <input type="button" class="button" id="cbBack" value="返回"/>
  
</div>
</div>



<div class="endDD"></div>
<script type="text/javascript">
$(document).ready(function(){
	$("#cbBack").on("click",function(){
		document.location='list.html';
	});
    $("#cbSave").on("click",function(){
        var os=$("#sort option");         
        var data=new Array();
        for(var i=0;i<os.length;i++){  //update dempetnt set sortNo=? where id =
            o=$(os[i]);  //<option  value="row.id"    >
            newSort= o.index()+1; //1 ,2...
            id= o.attr("value");
            if(o.value != newSort){            	 
                data.push(   {'id':id,'sortNo':newSort,'description':os[i].innerText});
            }
        }
        /* if(data.length==0){
            alert("顺序没变化，不需要保存");
            return false;
        } */
        console.log($.toJSON(data));
        $.ajax(
        		{   type:'post',
        			url:'saveDepartOrders.html', 
        			data: {departs:   JSON.stringify(data) },//$.toJSON(data)}, //$.toJSON(data) },
        			//contentType : 'application/json;charset=utf-8',  
                    dataType:'text', //json
                    success:function(sss){
                    	 
                    }
        			  
        		});
        return false;
    });
});
</script>
</body>
</html>