var royImgRoot="/images/";
function royUploadFile(projectName,objType,fileElementId,callBackMethod,appRoot,myFold,myName){
	var fObj=document.getElementById(fileElementId);
	if(!validateUpload(fObj,objType))return false;
	royImgRoot=appRoot+"/comm/images/";
	if(appRoot.indexOf("http://")<0){
		appRoot="http://"+location.host+appRoot;
	}
	var body=document.getElementsByTagName('body')[0];
	var div=document.createElement("div");
	var fId=fileElementId;
	div.setAttribute("id","royD"+fId);
	fObj.parentNode.insertBefore(div,fObj);
	var width=fObj.clientWidth;	
	var s='<div style="BORDER: #ccc 1px solid; TEXT-ALIGN: left;BACKGROUND: url('+royImgRoot+'uploadbg.gif) white no-repeat center;width:'+width+'px;">'+
		'<input type="text" id="royS'+fId+'" style="BACKGROUND: url('+royImgRoot+'uploadloadding.gif) white repeat-x left;TEXT-ALIGN: center;LINE-HEIGHT:0px;border:0px;WIDTH:0px; HEIGHT: 6px"/></div>';
	div.innerHTML=s;
	
	var fDiv=document.createElement("div");
	if(objType!="P"){
		objType="F";
	}
	s='<form target="royI'+fId+'" action="http://iserver.qingmei.co/uploadservice?retType=3&id='+fId+'&projectName='+projectName+'&objType='+objType+'&myFold='+myFold+'&myName='+myName+'&callBackMethod='+callBackMethod+'&backUrl='+appRoot+'service/uploadAgent" method="POST" id="royF'+fId+'" enctype="multipart/form-data"></form>'+
		'<iframe name="royI'+fId+'" style="width:40px;height:40px;"></iframe>';
	body.appendChild(fDiv);
	fDiv.innerHTML=s;
	fDiv.setAttribute("id","royH"+fId);
	document.getElementById("royF"+fId).appendChild(fObj);
	fObj.setAttribute("name","fileItemName");
	fDiv.style.display="none";
	fDiv.style.position="absolute";
	document.getElementById("royF"+fId).submit();
	uploadProg(width,document.getElementById("royS"+fId), 1);
}
var royUploadEnd=function(fileElementId){
	var fObj=document.getElementById(fileElementId);
	var fId=fileElementId;
	document.getElementById("royF"+fId).reset();
	var div=document.getElementById("royD"+fId);
	div.parentNode.insertBefore(fObj,div);
	var body=document.getElementsByTagName('body')[0];
	div.parentNode.removeChild(div);
	body.removeChild(document.getElementById("royH"+fId));
}
var uploadProg = function(width,obj, totaltime) {
	totalcount = Math.ceil(width * (1.0 - (8 / (totaltime + 8))))
	obj.style.width=totalcount + 'px';
	currentCounter = setTimeout(function() { uploadProg(width,obj, ++totaltime) }, 100);
}
var imageREs= [ /.jpg$/, /.gif$/, /.png$/ , /.jpeg$/, /.bmp$/];
var vedioREs=[ /.flv$/ ];
var flashREs=[/.swf$/];
var rarRES=[/.rar$/,/.zip$/];
function validateUpload(input,t){
	var boo=false;
	if(t=="V"){
	 for(var i=0;i<vedioREs.length;i++){
			if (vedioREs[i].exec(input.value.toLowerCase())){
				boo=true;
				break;
			}
		}
		if(!boo){
			alert("对不起，视频不支持这种文件类型.");
			 if(isFirefox=navigator.userAgent.indexOf("Firefox")>0){  
         	input.value="";
    		}  
    		else
			 input.outerHTML = input.outerHTML;
			return false;
		}
	}else 
	if(t=="H"){
	 for(var i=0;i<flashREs.length;i++){
			if (flashREs[i].exec(input.value.toLowerCase())){
				boo=true;
				break;
			}
		}
		if(!boo){
			alert("对不起，flash不支持这种文件类型.");
			 if(isFirefox=navigator.userAgent.indexOf("Firefox")>0){  
         	input.value="";
    		}  
    		else
			 input.outerHTML = input.outerHTML;
			return false;
		}
	}
	else
	if(t=="F"){
	 for(var i=0;i<rarRES.length;i++){
			if (rarRES[i].exec(input.value.toLowerCase())){
				boo=true;
				break;
			}
		}
		if(!boo){
			alert("对不起，壓縮文件不支持这种文件类型.");
			 if(isFirefox=navigator.userAgent.indexOf("Firefox")>0){  
         	input.value="";
    		}  
    		else
			 input.outerHTML = input.outerHTML;
			return false;
		}
	}
	else{
	for(var i=0;i<imageREs.length;i++){
		if(imageREs[i].exec(input.value.toLowerCase())){
				boo=true;
				break;
			}
	}
	
		if(!boo){
			alert("对不起，图片不支持这种文件类型.");
		 if(isFirefox=navigator.userAgent.indexOf("Firefox")>0){  
         	input.value="";
    		}  
    		else
			 input.outerHTML = input.outerHTML;
			return false;
		}
	}
	return true;
}