// JavaScript Document
//Ԫ�ص����������
function showHide(obj){
    var obj=document.getElementById(obj);
	obj.style.display=obj.style.display=="block"?"none":"block";
}

//��ʼ���¼���
function int(){
	$("#status").html("");
	$('.div_topic').removeClass('odd');
	$('.div_topic:even').addClass('odd');
	$('.div_topic p').click(function(){
		if($(this).find('input[type="radio"]').val() != undefined){				
			$(this).find('input[type="radio"]').attr('checked','checked');				
			var name = $(this).find('input[type="radio"]').attr('name');//�������
			$('input[type="radio"][name="' + name + '"]').parents("p").removeClass('selected');
			$('input[type="radio"][name="' + name + '"]:checked').parents("p").addClass('selected');
		}
	});
	
	$("#check_answer").click(function(){
		$("#status").html("");
		$("h4").css("color","#22536A");						  
		var answer_this_tip,set_answer,_temp_tip;
		_temp_tip = "yes";
		
		var tall = 0;
		
		$(".div_topic").each(function(i){
			if($(this).find('input[type="radio"]:checked').val() == undefined){
				_temp_tip = "no";
				$(this).find("h4").css("color","green");
			}		
			tall++;
		});
		
		if(_temp_tip == "no"){
			$("#status").html("������Ŀû��ɣ�");
			return;
		}
		
		var err = 0;

		$(".div_topic").each(function(i){
			answer_this_tip = $(this).find(".answer_this_tip").html();	
			set_answer = $(this).find('input[type="radio"]:checked').val();
			//$(this).find('input[type="radio"]').val() != undefined
			if(answer_this_tip != set_answer){
				$(this).find("h4").css("color","red");
				err++;
			}	
		});
		$("h4 span").show();
		
		$("#status").html("����" + err + "���������ʣ�" + (err / tall * 100).toFixed(2) + "%");
	});
	
	

}

function set_str_len(str,len){
	str = str + "";
	var temp = "";
	for(i = 0; i < (len - str.length); i++){
		temp += "0";
	}
	
	return temp + str;
}

//�漴����һ����Χ�������
function Grandom(m,n){
	return Math.round(Math.random() * (n - m) + m);
}


function get_topic(_arr_topic,_topic_num){
	
	var _all_num, //����Ŀ��
	_this_num, //�����漴һ����
	_topic, //��Ŀ
	_topic_temp, //��ʱ��Ŀ
	_topic_str, //��Ŀ�ַ���
	i, //��ǰ��Ŀ��
	
	_arr_answer,  //������
	_arr_answer_length, //�𰸳���
	_this_answer_num, //���漴һ����
	_temp_answer,  //��ʱ��
	_arr_answer_last, //���մ�����
	_answer_last_str,//���մ��ַ���
	_answer_str, //���ַ���
	_answer_tip, //��ǰͷ��ABCD
	_answer_this_tip,//��ǰ��Ŀ�Ĵ�
	_arr_answer_type;
	
	_all_num = _arr_topic.length;  //����Ŀ��
	_arr_answer_last = new Array();//���մ�����
	
	_topic_str = "";
	for(y = 0; y < _topic_num; y++){
		i = y + 1; //��ǰ��Ŀ��
	
		_this_num = Grandom(0,(_arr_topic.length - 1)); //�漴һ����
		
		_topic_temp = _arr_topic.splice(_this_num,1);
		_topic = _topic_temp[0][0]; //��Ŀ

		_arr_answer = _topic_temp[0][1];//������

		_arr_answer_length = _arr_answer.length; //�𰸳���
		
		//��ô��ַ��� begin  _answer_str  _answer_this_tip
		_answer_str = "";
		if(_arr_answer_length == 4){		
			for(j = 0; j < 4; j++){
				try{
					_this_answer_num = Grandom(0,(_arr_answer.length - 1));
					_temp_answer = _arr_answer.splice(_this_answer_num,1);
		
					switch (j) {
					   case 0 :
						   _answer_tip = "A";break;
					   case 1 :
						   _answer_tip = "B";break;
					   case 2 :
						   _answer_tip = "C";break;
					   case 3 :
						   _answer_tip = "D";break;
					}
					
					if(_temp_answer[0][1] == "yes"){
						_answer_this_tip = _answer_tip;				
					}
		
					_answer_str += '<p><input name="topic' + i + '" type="radio" value="' + _answer_tip + '">' + _answer_tip + '��' + _temp_answer[0][0] + '</p>';
				}catch(e){
					alert(e);
				}
			}
			
		}else{
			try{
				if(_arr_answer[0][1] == "yes"){_answer_this_tip = "A";}
				if(_arr_answer[1][1] == "yes"){_answer_this_tip = "B";}
				
				_answer_str = '<p><input name="topic' + i + '" type="radio" value="A">A��' + _arr_answer[0][0] + '</p><p><input name="topic' + i + '" type="radio" value="B">B��' + _arr_answer[1][0] + '</p>';
	    	}catch(e){
				alert(e);
			}
		}
		
		_arr_answer_last.push(_answer_this_tip);
		//��ô��ַ��� end
		
		//�����Ŀ�ַ��� begin
		_topic_str = '<div id="topic' + i + '" class="div_topic"><h4>' + i + '��' + _topic + '<span>�𰸣�<span class="answer_this_tip">' + _answer_this_tip + '</span></span></h4>' + _answer_str + '</div>';
		
		$(_topic_str).appendTo("#topic_all"); 
		//�����Ŀ�ַ��� end
	}
	
	//���last���ַ��� begin _arr_answer_last _answer_last_str
	
	var _answer_last_str = "";
	
	var tap10 = 1;
	
	var _answer_all_num =  _arr_answer_last.length;
	
	for(z = 0; z < _answer_all_num; z++){
		y = z + 1;
		
		if(y == 1){
			if(_answer_all_num == 1){
				_answer_last_str = '<p>001'
				_answer_last_str += '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>'
			}else{
				_answer_last_str = '<p>001-';
				if(_answer_all_num <= 10){
					_answer_last_str += set_str_len(_answer_all_num,3) + ' <b>';
					
				}else{
					_answer_last_str += '010 <b>';
				}
			}
		}
		
		if(y%10 == 0){
			if(_answer_all_num > 10 && y < _answer_all_num){

				_answer_last_str += '</b></p>\n';
				_answer_last_str += '<p>' + set_str_len((tap10 * 10 + 1),3);
			
				if((tap10 * 10 + 1) == _answer_all_num){
					_answer_last_str += '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>'
					
				}else if(_answer_all_num < ((tap10 + 1) * 10)){
					_answer_last_str += '-' + set_str_len(_answer_all_num,3) + ' <b>';
					
				}else{
					_answer_last_str += '-' + set_str_len(((tap10 + 1) * 10),3) + ' <b>';
					tap10++;
				}
			}			
			
		}else if(y%5 == 0){
			_answer_last_str += _arr_answer_last[z] + " ";
		}else{
			_answer_last_str += _arr_answer_last[z];
		}

	}
	
	_answer_last_str += '</b></p>\n';
	
	$("#answer_last").html("");
	$("#answer_last").hide();
	//���last���ַ��� end
	$("#answer_last").html(_answer_last_str);
	
/*	function ajaxtest(index) {  
		  
	    var datapar = {  
	        "text" : $("#input" + index).val(),  
	        "index" : index  
	    };  
	  
	    var options = {  
	        url : "",  
	        type : "post",  
	        data : datapar,  
	        success : function(data) {  
	            //alert(data);  
	            var topic = $("textarea[id*='output" + index + "']");  
	            topic.val(data);  
	        }  
	    };  
	    $.ajax(options);  
	}  */

}