<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>W2UI Demo: grid/1</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript" src="http://rawgit.com/vitmalina/w2ui/master/dist/w2ui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="http://rawgit.com/vitmalina/w2ui/master/dist/w2ui.min.css" />
</head>
<body>


<div id="grid" style="width: 100%; height: 350px;"></div>

<script type="text/javascript">
$(document).ready(function () {
    $('#grid').w2grid({ 
        name: 'grid',
        show: {
        	header:true,
        	toolbar:true,
        	footer:true,
        	columnHeaders:true,
        	lineNumbers:true,
        	expandColumn:true,
        	selectColumn:true,
        	emptyReload:true,
        	toolbarReload:true,
        	toolbarColumns:true,
        	toolbarSearch:true,
        	toolbarAdd:false,
        	toolbarDelete:false,
        	toolbarSave:false,
        	toolbarEdit :true
        },
        recid:'FLOWMTR_ID',
        url: 'wuiViewdata',
        method: 'POST', // need this to avoid 412 error on Safari
        columns: [                
                  { field: 'FLOWMTR_ID', caption: 'FLOWMTR_ID', size: '3%' },
                  { field: 'NAME', caption: 'NAME', size: '3%', editable:{type:'text',min:4,max:12}},
                  { field: 'INST_DATE', caption: 'INST_DATE', size: '4%', editable:{type:'text'} },
                  { field: 'FMETE_FORM', caption: 'FMETE_FORM', size: '3%', editable:{type:'text'} },
                  { field: 'FMETE_TYPE', caption: 'FMETE_TYPE', size: '3%', editable:{type:'text'} },
                  { field: 'WTRSYS', caption: 'WTRSYS', size: '3%', editable:{type:'text'} },
                  { field: 'AUTO_TYPE', caption: 'AUTO_TYPE', size: '3%', editable:{type:'text'} },
                  { field: 'PIPE_DIA', caption: 'PIPE_DIA', size: '3%', editable:{type:'text'} },
                  { field: 'PIPE_ID', caption: 'PIPE_ID', size: '3%', editable:{type:'text'} },
                  { field: 'IN_AREA', caption: 'IN_AREA', size: '3%', editable:{type:'text'} },
                  { field: 'OUT_AREA', caption: 'OUT_AREA', size: '3%', editable:{type:'text'} },
                  { field: 'ADDR', caption: 'ADDR', size: '3%', editable:{type:'text'} },
                  { field: 'REMARK', caption: 'REMARK', size: '3%', editable:{type:'text'} },
                  { field: 'SBLOCK_ID', caption: 'SBLOCK_ID', size: '4%', editable:{type:'text'} },
                  { field: 'OFFICE_ID', caption: 'OFFICE_ID', size: '3%', editable:{type:'text'} },
                  { field: 'STD_WHMR_V', caption: 'STD_WHMR_V', size: '3%', editable:{type:'text'} },
                  { field: 'FAC_NAME', caption: 'FAC_NAME', size: '3%', editable:{type:'text'} },
                  { field: 'DATA_TYPE', caption: 'DATA_TYPE', size: '4%', editable:{type:'text'} },
                  { field: 'OUT_ZONE', caption: 'OUT_ZONE', size: '3%', editable:{type:'text'} },
                  { field: 'FLSY_NAME', caption: 'FLSY_NAME', size: '3%', editable:{type:'text'} },
                  { field: 'GIS_CODE', caption: 'GIS_CODE', size: '3%', editable:{type:'text'} },
                  { field: 'TSMTR_DATE', caption: 'TSMTR_DATE', size: '3%', editable:{type:'text'} },
                  { field: 'OFFICE', caption: 'OFFICE', size: '3%', editable:{type:'text'} },
                  { field: 'J_BLOCK', caption: 'J_BLOCK', size: '4%', editable:{type:'text'} },
                  { field: 'S_BLOCK', caption: 'S_BLOCK', size: '3%', editable:{type:'text'} },
                  { field: 'STD_WHMR', caption: 'STD_WHMR', size: '3%', editable:{type:'text'} },
                  { field: 'USE_CLA', caption: 'USE_CLA', size: '3%', editable:{type:'text'} },
                  { field: 'REP_CHK', caption: 'REP_CHK', size: '3%', editable:{type:'text'} },
                  { field: 'CMC_ERR_VALUE', caption: 'CMC_ERR_VALUE', size: '4%', editable:{type:'text'} }        
        ],
/*         toolbar: {
            items: [
                { id: 'edit', type: 'button', text: 'edit', icon: 'w2ui-icon-plus' }
            ],
            onClick: function (event) {
                if (event.target == 'edit') {
                  	var changeData = JSON.stringify(w2ui['grid'].getChanges());
                    $.ajax({
                 	type:"post",
                 	url:"/wuiEdit",
                 	data: {list: changeData},
                 	success:function(response){
                 		alert('success!!!'+response);	
                 		 
                 	}, 
                 	error:function(){
                 		alert('Error while request...');
                 	}            	
                 })            
             	console.log(event);
                }
            }
        }, */
    
     /*   records:data */
       onEdit: function(event) {
     	
        	var changeData = JSON.stringify(w2ui['grid'].getChanges());
               $.ajax({
            	type:"post",
            	url:"/wuiEdit",
            	data: {list: changeData},
            	success:function(response){
            		alert('success!!!'+response);	
            		 
            	}, 
            	error:function(){
            		alert('Error while request...');
            	}            	
            })            
        	console.log(event);  

        },  
        onChange : function(event){//웹에서 유효성 검사       	
        	var sn = /^[가-힝0-9]{3,32}$/ //자바스크립트 정규식 한글과 숫자만 입력하고 4~12글자 적기
        	var sn1 = /^[가-힝0-9]{3,20}$/
        	var sn2 = /^[가-힝]{3,255}$/
        	var sn3 = /^[가-힝]{3,50}$/
        	var sn4 = /^[가-힝]{3,64}$/
        	var nul=/^[/\s/]$/
        	var num= /^[0-9]$/ //숫자만 가능
        	var record = this.get(event.recid);//value값 들고오기->db에 있는 원본값만 들고 온다    		
       		var data=event.value_new; //웹상에서 변경된 데이터를 들고 온다.
        	 console.log("data: "+data); 
        	 console.log("record : "+JSON.stringify(event));
        	
        	
        	console.log(event);
        	console.log($(this));
        	 if(event.column==1 || event.column==9 || event.column==10 || event.column==16 || event.column==18
        			 || event.column==22 || event.column==23 ){        		        	 
	         	if(!sn.test(data)){
	        		
	        		console.log("AAAA"+record.NAME);
	        		 
	        		//$('#grid_grid_data_0_1').css('background-color','green');        		
	        	 	//$('#grid_grid_toolbar').hide();
	        		//$('#grid_grid_toolbar').text("다시 작성해 주십시오");
	        		/*  $('#grid_grid_rec_'+record.FLOWMTR_ID).focusout(function() {}) */ 
	        		   	
	        			w2alert('주소는 3~32자의 한글과 숫자로 입력해주세요');
	        			//$('#grid_grid_frec_21103011').children().eq(1).removeAttr('checked');
	        			$('#grid_grid_rec_'+record.FLOWMTR_ID).css('color','red');
	        			$("#edit").hide();
	        		
	        		return false;
	         			
	         	}else{
	        		w2alert('등록가능한 주소입니다.');
	        		$('#grid_grid_toolbar').show();
	        	}  
        	 }else if(event.column==2 || event.column==3 || event.column==4 || event.column==5
        			 || event.column==6 || event.column==7 || event.column==8 || event.column==13
        			 || event.column==14 || event.column==20 || event.column==21 || event.column==22){//event.column 번호로 구분
        		 	if(!sn1.test(data)){
    				w2alert('3~20자로 입력해주세요');
    				$('#grid_grid_rec_'+record.FLOWMTR_ID).css('color','red'); 
	        		
         		return false;
    			}else{
    				w2alert('등록가능');
    			} 
		 
        	 }else if(event.column==11 || event.column==12){
        		 if(!sn2.test(data)){
 	        		w2alert('3~32자로 입력해주세요');
 	        		$('#grid_grid_rec_'+record.FLOWMTR_ID).css('background-color','green'); 
	        	
 	        		       		
 	        		return false;
 	             		
 	        	}else{
 	        		w2alert('등록가능!');
 	        	} 
        		 
        	 }else if(event.column==15 || event.column==25 || event.column==28){
        		 if(!num.test(data)){
  	        		w2alert('숫자만 가능합니다!');
  	        		$('#grid_grid_rec_'+record.FLOWMTR_ID).css('background-color','green'); 
	        				
  	        		return false;
  	             		
  	        	}else{
  	        		w2alert('등록가능!');
  	        	}
        	 }else if(event.column==17){
        		 if(!sn3.test(data)){
  	        		w2alert('3~50자로 입력해주세요');
  	        		$('#grid_grid_rec_'+record.FLOWMTR_ID).css('background-color','green'); 
	        		  		
  	        		return false;
  	             		
  	        	}else{
  	        		w2alert('등록가능!');
  	        	} 
        	 }else if(event.column==19){
        		 if(!sn4.test(data)){
   	        		w2alert('3~64자로 입력해주세요');
   	        		$('#grid_grid_rec_'+record.FLOWMTR_ID).css('background-color','green'); 
	        	
   	        			        		       		
   	        		return false;
   	             		
   	        	}else{
   	        		w2alert('등록가능!');
   	        	} 
        	 }else if(event.column==27){
        		 if(data=!"Y" || data!="N"){
    	        		w2alert('y 또는 N만 입력가능합니다.');
    	        		$('#grid_grid_rec_'+record.FLOWMTR_ID).css('background-color','green'); 
    	        		
    	        		
    	        		return false;
    	             		
    	        	}else{
    	        		w2alert('등록가능!');
    	        	} 
        	 }
   		        },


    });
});

</script>

</body>
</html>