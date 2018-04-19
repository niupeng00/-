var g_loading=null;
function jsEx(str){
	var reg = '<script[^>]*>([\\S\\s]*?)<\/script>';
	var str = str.match(new RegExp(reg,'img'));
	try{
		try{
			if(str!=null){
				for (var i = 0,num = str.length;i < num;i++) {
					eval(str[i].match(new RegExp(reg,'im'))[1]);
				}
			}
		}catch(e){alert(e)}
		g_loading.unmask();
		renewEvent();
	}catch(e){
		alert(5)
	}
}
function js(str){
	if(str.length<3)return;
	try{
		eval(str);
	}catch(e){
		alert('error: '+str);
	}
	g_loading.unmask();
	renewEvent();
}
function getPhotoThumb(url,pre){
	var rep=pre==''? '$1':"$1_"+pre;
	var ret=url.replace(/(.*)_([\w]{1})([.]{1})([^.]+)/g,"$1.$4").replace(/(.*)([.]{1})([^.]+)/g,rep+".$3");
	return ret;
}
function addDay(dayStr,add){
	var year =dayStr.substring(0,4);
	var month =dayStr.substring(5,7)*1 -1;
	var day =dayStr.substring(8,10);
	d=new Date(year,month,day);
	d.setTime(d.getTime()+add*24*60*60*1000);
	var cm=(d.getMonth()+1)+"";
	if(cm.length==1)cm="0"+cm;
	var cd=d.getDate()+"";
	if(cd.length==1)cd="0"+cd;
	s = d.getFullYear()+"-" + cm + "-" + cd;
	return s;
}
function addMonth(dateStr,add){
	add=add*1;
	var year =dateStr.substring(0,4)*1;
	var month =dateStr.substring(5,7)*1;
	var d=year*12+month+add;
	year=Math.floor(d/12);
	month=d%12;
	if(month==0){
		year--;
		month=12;
	}
	return year+'-'+(month>9 ? month :'0'+month);
}
function getMonthDay(t,d){
	if(t=='first')return d.substring(0,8)+'01';
	if(t=='last'){
		var dd='';
		var mm=d.substring(5,7)*1;
		switch(mm){
			case 1:
				dd=31;
				break;
			case 2:
				var yy=d.substring(0,4)*1;
				dd=yy%4==0 ?29 :28;
				break;
			case 3:
				dd=31;
				break;
			case 4:
				dd=30;
				break;
			case 5:
				dd=31;
				break;
			case 6:
				dd=30;
				break;
			case 7:
				dd=31;
				break;
			case 8:
				dd=31;
				break;
			case 9:
				dd=30;
				break;
			case 10:
				dd=31;
				break;
			case 11:
				dd=30;
				break;
			case 12:
				dd=31;
				break;
		}
		return d.substring(0,8)+dd;
	}
	return d;
}
var urlEncode=function(s){
	if(typeof (encodeURIComponent)!="undefined"){
		return encodeURIComponent(s).replace(/\'/g,"%27");
	}else{
		return escape(s).replace(/\+/g,"%2B").replace(/\"/g,"%22").rval.replace(/\'/g,"%27");
	}
}
function messBox(type,mess){
	alert((type==1 ? "系统提示" : "错误")+"：\n\n"+mess);
}
function nullCheck(obj,mess){
	if($.trim(obj.val())==""){
		messBox(1,mess);obj.focus();return false;
	}
	return true;
}
function moveUp(object){
	var obj=$(object).get(0);
	var i=obj.selectedIndex;
	if(i==0)return;
	optionReplace(obj,i,i-1);
}
function moveDown(object){
	var obj=$(object).get(0);
	var i=obj.selectedIndex;
	if(i==obj.options.length)return;
	optionReplace(obj,i,i+1);
}

 




//
function optionReplace(obj,xIndex,yIndex){
	var os=$(obj.options[xIndex]).clone();
	$(obj.options[xIndex]).replaceWith($(obj.options[yIndex]).clone());
	$(obj.options[yIndex]).replaceWith(os);
	obj.selectedIndex=yIndex;
}
function createElement(parent,tagname){
	var elem=document.createElement(tagname);
	if(parent)parent.appendChild(elem);
	return elem;
}
function reNewSelect(url,myactions,type,value,obj,optionsAdd,defaultValue,evals) {
	if(value=="" || value=="0"){
		obj.innerHTML=optionsAdd;
		return false;
	}
	actionPost(url,{myactions : myactions,type : type,now:1,value : value},
		function(ans){
			setOptions(obj,ans,optionsAdd);
			if(defaultValue)obj.value=defaultValue;
			if(evals)eval(evals);
		});
	return false;
}
function setOptions(obj,options,optionsAdd){
	$(obj).html(optionsAdd+options);
}
function regObjs(a){
	var retA=new Array();
	for(var k in a){
		retA.push({id: a[k][0],type: a[k][1],checkNull : a[k][2],mess : a[k][3]});
	}
	return retA;
}
function checkValid(parss){
	var aA,obj,value;
	var regobjsA=regObjs(parss);
	for(var k in regobjsA){
		aA=regobjsA[k];
		if(!aA.id)continue;
		obj=$(aA.id);
		value=$.trim(obj.val());
		if(aA.checkNull){
			if(!nullCheck(obj,aA.mess+(obj.get(0).type.indexOf("select")==0? "必选":"必填")))return false;
		}
		switch(aA.type){
			case "int":
				if(!(value>=0)){
					messBox(2,aA.mess+"必须为数字");obj.focus();
					return false;
				}
				break;
			case "date":
				break;
		}
	}
	return true;
}
function formSubmit(formId,parA,callBack,obj){
	var fObj=$(formId);
	if(!checkValid())return false;
	try{
		if(!checkValidOther())return false;
	}catch(e){}
	var pA=getFormValues(fObj,parA);
	var obj,t;	
	//loadings(true,obj);
	actionPost(fObj.attr("action"),pA,callBack);
}

function actionPost(a,p,callBack,obj,w){
	actionPost_sub(a,p,
			function(ans){
				try{
					if(!p['now']){
						g_loading.unmask();
					}
					callBack(ans);
					rowHover();
				}catch(e){
					alert(ans)
				}
				
			});
}
function actionPost_sub(a,p,b){
	//for(o in p)p[o]=urlEncode(p[o]);
	if(a=='')a=window.location.pathname;
	if(!p['now']){
		g_loading.mask("请等待...");
	}
	$.post(a,p,b).error(function(){
		messBox(2,"网络异常，请重试");
		if(!p['now']){
			g_loading.unmask();
		}
	});
}
function getFormValue(or){
	o=$(or);
	t=o.attr("title");
	if(t!='' && t.substring(0,1)=='*' && t.substring(1)==o.val()){
		return '';
	}
	return o.val();
}
function getFormValues(fObj,aA){
	var pA=(aA) ? aA : {};
	var obj,t;
	var objs=$("input",fObj);
	for(var k=0; k<objs.length;k++){
		t=objs[k].getAttribute("type").toLowerCase();
		if(!objs[k].name || t=="button" || t=="submit")continue;
		if((t=="checkbox" || t=="radio") && !objs[k].checked)continue;
		pA[objs[k].name]=$.trim(objs[k].value);
	}
	objs=$("select",fObj);
	for(var k=0; k<objs.length;k++){
		if(!objs[k].name)continue;
		pA[objs[k].name]=$.trim(objs[k].value);
	}
	objs=$("textarea",fObj);
	for(var k=0; k<objs.length;k++){
		if(!objs[k].name)continue;
		pA[objs[k].name]=$.trim(objs[k].value);
	}
	return pA;
}

function loadings(boo,obj){
	try{
		if(boo){
			if(!loadingD){
				loadingD=createElement(document.body,"img");
				loadingD.src=(parent.root ? parent.root : "")+"comm/images/loading.gif";
				loadingD.style.position="absolute";
				loadingD.style.zIndex="100";
			}
			var left,top;
			if(obj){
				var pp=getElementPosition(obj);
				left=pp.left;
				top=pp.top;
			}else{
				left=(document.documentElement.clientWidth/2);
				top=(document.documentElement.scrollTop+document.documentElement.clientHeight/2);
			}
			loadingD.style.left=left+"px";
			loadingD.style.top=top+"px";
		}else{
			if(!loadingD)return;
		}
		disableNeed(boo);
		if(loadingD)loadingD.style.display=boo ? "block" : "none";
	}catch(e){}
}
function getDelStr(name){
	var str="";
	$("input[name='"+name+"']:checked").each(function(){
			if(str!='')str+=',';
			str+=$(this).attr("value");
	});
	return str;
}
function selectAll(obj,name){	
	$("input[name='"+name+"']").attr("checked",
			obj.checked ? true :false);
}
function rowHover(){
	$("table:not(.nofocus) tr:not(:first):not(.nofocus)").unbind("hover,unhover");
	$("table:not(.nofocus) tr:not(:first):not(.nofocus)").hover(function(){
	    if(!($(this).parent().parent().find("tr:first th").length>0))return false;
	    if($(this).find("td").length==1)return false;
	    $(this).addClass("rowFocus");
	},function(){
		if(!($(this).parent().parent().find("tr:first th").length>0))return false;
		if($(this).find("td").length==1)return false;
		$(this).removeClass("rowFocus");
	}) 
}
function evalKeyEnter(objs,cbObj){
	for(var i=0;i<objs.length;i++){
		obj=$(objs[i]);
		obj.keypress(function(e){ 
			if(e.which==13){
				cbObj.click();
				return false;
			}
		});
	}
}

function setCopy(_sTxt){
    try{
        if(window.clipboardData) {
            window.clipboardData.setData("Text", _sTxt);
        } else if(window.netscape) {
            netscape.security.PrivilegeManager.enablePrivilege('UniversalXPConnect');
            var clip = Components.classes['@mozilla.org/widget/clipboard;1'].createInstance(Components.interfaces.nsIClipboard);
            if(!clip) return;
            var trans = Components.classes['@mozilla.org/widget/transferable;1'].createInstance(Components.interfaces.nsITransferable);
            if(!trans) return;
            trans.addDataFlavor('text/unicode');
            var str = new Object();
            var len = new Object();
            var str = Components.classes["@mozilla.org/supports-string;1"].createInstance(Components.interfaces.nsISupportsString);
            var copytext = _sTxt;
            str.data = copytext;
            trans.setTransferData("text/unicode", str, copytext.length*2);
            var clipid = Components.interfaces.nsIClipboard;
            if (!clip) return false;
            clip.setData(trans, null, clipid.kGlobalClipboard);
        }
    }catch(e){
     alert("被浏览器拒绝！n请在浏览器地址栏输入'about:config'并回车n然后将 'signed.applets.codebase_principal_support'设置为'true'");
    }
}
function showError(mess,isPlay){
	var obj=$(".errorMess");
	var body=document.getElementsByTagName('body')[0];
	if(obj.length==0){
		$("body").append('<div class="errorMess"></div>');
		obj=$(".errorMess");
	}
	obj.html(mess);
	obj.show();
	if(isPlay){
		try{play('error');}catch(e){}
	}
}
function hideError(){
	$(".errorMess").hide();	
}

function implode(glue,pieces){
	var i='',retVal='',tGlue='';
	if(arguments.length===1){
		pieces=glue;
		glue='';
	}
	if(typeof pieces==='object'){
		if(Object.prototype.toString.call(pieces)==='[object Array]'){
			return pieces.join(glue);
		}
		for(i in pieces){
			retVal+=tGlue+pieces[i];
			tGlue=glue;
		}
		return retVal;
	}
	return pieces;
}
function markerHover(marker,index,panto){
	var offX=-30*(index);
	var siz =new BMap.Size(offX,-44);
	var ico =marker.getIcon();
	ico.setImageOffset(siz);
	marker.setIcon(ico);
	marker.setTop(true);
	if(panto){
		map=marker.getMap();
		po=marker.getPosition();
		x=po.lng;
		y=po.lat;
		       
		  
		var bs = map.getBounds();   //获取可视区域
		var bssw = bs.getSouthWest();   //可视区域左下角
		var bsne = bs.getNorthEast();   //可视区域右上角		
		if(x<bssw.lng || x>bsne.lng || y<bssw.lat || y>bsne.lat)map.panTo(marker.getPosition());
	}
}
function markerOut(marker,index){
	var offX=-30*(index);
	var siz =new BMap.Size(offX,0);
	var ico =marker.getIcon();
	ico.setImageOffset(siz);
	marker.setIcon(ico);
	marker.setTop(false);
}
function addMarker(parA){// 编写自定义函数,创建标注
	var point = new BMap.Point(parA['x'],parA['y']);
	if(parA['index']>=0){
		var offX=-30*(parA['index']);
		var size =new BMap.Size(offX,0);
		var myIcon = new BMap.Icon("/images/icons_map.png", new BMap.Size(30,44),{imageOffset:size,anchor:new BMap.Size(15,44)});

		var marker = new BMap.Marker(point,{icon:myIcon});
		marker.setTitle(parA['title']);
		marker.addEventListener("mouseover", function(e) {
			markerHover(this,parA['index']);
			if(typeof(listHover)!=undefined)listHover(parA['index']);
		});
		marker.addEventListener("mouseout",function(e){
			markerOut(this,parA['index']);
			if(typeof(listOut)!=undefined)listOut(parA['index']);
		});
		
	}
	g_map.addOverlay(marker);
    return marker;
}
function getDayTitle(d){
	switch(d){
		case '1':
			return '周一';
			break;
		case '2':
			return '周二';
			break;
		case '3':
			return '周三';
			break;
		case '4':
			return '周四';
			break;
		case '5':
			return '周五';
			break;
		case '6':
			return '周六';
			break;
		case '7':
			return '周日';
			break;
		default:
			return '';
			break;
	}
}
function isDate(str){             
    var reg=/^(\d+)-(\d{1,2})-(\d{1,2})$/;
    var r=str.match(reg);
    if(r==null)return false;
    r[2]=r[2]-1;
    var d=new Date(r[1],r[2],r[3]);
    if(d.getFullYear()!=r[1]*1)return false;
    if(d.getMonth()!=r[2]*1)return false;
    if(d.getDate()!=r[3]*1)return false;
    return true;
}
function isTime(str){             
    var reg=/^(\d+)-(\d{1,2})-(\d{1,2}) (\d{1,2}):(\d{1,2})$/;
    var r=str.match(reg);
    if(r==null)return false;
    r[2]=r[2]-1;
    var d=new Date(r[1],r[2],r[3]);
    if(d.getFullYear()!=r[1]*1)return false;
    if(d.getMonth()!=r[2]*1)return false;
    if(d.getDate()!=r[3]*1)return false;
    return true;
}
function isIdCardNo(num){
	var factorArr=new Array(7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2,1);
	var error;
	var varArray=new Array();
	var intValue;
	var lngProduct=0;
	var intCheckDigit;
	var intStrLen=num.length;
	var idNumber=num;
	if (intStrLen!=18){
		return false;
	}
	for(i=0;i<intStrLen;i++) {
		varArray[i]=idNumber.charAt(i);
		if ((varArray[i] < '0' || varArray[i] > '9') && (i != 17)) {
			return false;
		} else if (i < 17) {
			varArray[i]=varArray[i]*factorArr[i];
		}
	}
	if (intStrLen == 18) {
		//check date
		var date8=idNumber.substring(6,14);
		date8=date8.substr(0,4)+'-'+date8.substr(4,2)+'-'+date8.substr(6,2);
		if (isDate(date8)==false) {alert(date8)
			return false;
		}        
		// calculate the sum of the products
		for(i=0;i<17;i++) {
			lngProduct=lngProduct + varArray[i];
		}
		//calculate the check digit
		intCheckDigit=12 - lngProduct % 11;
		switch (intCheckDigit) {
			case 10:
				intCheckDigit='X';
				break;
			case 11:
				intCheckDigit=0;
				break;
			case 12:
				intCheckDigit=1;
				break;
		}
		// check last digit
		if (varArray[17].toUpperCase() != intCheckDigit) {
			return false;
		}
	}else{
		return false;
	}
	return true;
} 
jQuery.fn.roypop =function(options){
	pa=$(this).attr('param');
	if(pa!=undefined)eval('options='+pa);
	options=jQuery.extend({
        activateAction: "mouseover",
        deactivateAction: "mouseleave",
        shadow_size: 3,
        mm_timeout: 500,
        ajaxUrl:'',
        height:50
    }, options);
	_this=this;
	_this$=$(this);
	if( options.activate_action == "click" ) options.mm_timeout=0;
	var menuPop=$(this).find('.roypopPop');
	if(menuPop.length==0){
		_this$.append('<div class="roypopPop"><div class="co"><em class="arrow arrow1"></em><div class="uld"></div></div></div>');
		menuPop=$(this).find('.roypopPop');
	}
	var link=$(this).find('.roypopIt');
	options.ajaxUrl=_this$.attr('ajaxUrl');
	var event=_this$.attr('devent');
	if(event!=undefined){
		options.activateAction=event;
		
	}
	var $mm_timer=0;
	jQuery(document).bind("click", function(){
      $(".roypopPop").hide();
      $(".roypopIt").removeClass('itFoc');;
    });
	jQuery(this).bind("click", function(e){
      e.stopPropagation();
    });
	link.bind(options.activateAction,function(e){
		e.stopPropagation();
		clearTimeout($mm_timer);
		$mm_timer=setTimeout(function(){
			if(options.ajaxUrl!=undefined){
				var liNum=menuPop.find('li');
				if(liNum.length==0){//
					//reload
					u=menuPop.find(".uld");
					loadNow(u,2);
					var url=options.ajaxUrl;
					var para={};
					actionPost_sub(url,para,function(ans){
						u.html(ans);
						
						u.find(".close").bind("click",function(){
							hideMenuPop();
						});
					});
				}
			}
			menuPop.css({
		        'top': 25 +"px",
		        'left': (link.outerWidth()/2 -40) + 'px'
		      });
			menuPop.show();
			link.addClass('itFoc');
		},options.mm_timeout);
	});
	
	var hideMenuPop=function(){
		o=$('.roypopPop');
		o.slideUp('fast');
		link.removeClass('itFoc');
	}
	if(event!='click'){
		$(this).bind(options.deactivateAction,function(e){
			e.stopPropagation();
			clearTimeout($mm_timer);
			$mm_timer=setTimeout(function(){
				hideMenuPop();
			},options.mm_timeout);
		});
	}
	menuPop.find('a.select').bind('click',function(){
		link.find('span').text($(this).text());
		hideMenuPop();
	});
};
function footer(){
	var f=$(".footCont");
	if(f.length>0){
		var ad=parseInt($(window).height()-f.position().top -35 -f.height());
		if(ad>0){
			f.css("margin-top",ad+"px");
		}		
	}
	$(".goBackIcon").css("left",($(window).width()-60)+'px');
}
/**
* 中国正常GCJ02坐标---->百度地图BD09坐标
*/
function Convert_GCJ02_To_BD09(lat,lng){
        x_pi=3.14159265358979324 * 3000.0 / 180.0;
        x=lng;
        y=lat;
        z =Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
        theta=Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
        lng=z * Math.cos(theta) + 0.0065;
        lat=z * Math.sin(theta) + 0.006;
        return {'lng':lng,'lat':lat};
}

/**
* 百度地图BD09坐标---->中国正常GCJ02坐标
*/
function Convert_BD09_To_GCJ02(lat,lng){
        x_pi=3.14159265358979324 * 3000.0 / 180.0;
        x=lng - 0.0065;
        y=lat - 0.006;
        z=Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_pi);
        theta=Math.atan2(y, x) - 0.000003 * Math.cos(x * x_pi);
        lng=z * Math.cos(theta);
        lat=z * Math.sin(theta);
        return {'lng':lng,'lat':lat};
}
function renewEvent(){
	rowHover();
	footer();
	if($('.tablesorter').length>0 && window.tablesorter){
		tablesorter();
	}
}
$(document).ready(function(){
	$("input[type='text'],input[type='file']").each(function(){
		if($(this).attr("class")=='')$(this).addClass("text");
	});
	$(window).bind('resize',function(){
		footer();
	});
	$(".disable").attr("readonly","readonly");
	g_loading=$("body");
	renewEvent();
});