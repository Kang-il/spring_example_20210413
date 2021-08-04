<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이름 추가하기(중복체크)</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>        


<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</head>
<body>

	<div class="container">
		<b>이름:</b>
		<div class="d-flex justify-content-start">
			<input type="text" id="name" class="form-control col-3" placeholder="이름을 입력하세요"/> 
			<button type="button" class="btn btn-info ml-3" id="nameCheckBtn">중복확인</button>
			<br>
		</div>
		<%--이벤트 발생(중복확인 버튼 클릭)시 채워지는 곳 --%>
		<div id="statusArea" class="mt-2"></div>
		<button type="button" id="joinBtn" class="btn btn-success mt-3">가입하기</button>
	</div>
	
	<script>
		$(document).ready(function(){
			//중복확인 버튼 클릭
			$('#nameCheckBtn').on('click',function(){
				let name = $('#name').val().trim();
				//div 태그 안에 있는 모든 태그를 비운다 (초기화 시킨다.)
				$('#statusArea').empty();
				
				if(name==''){
					$('#statusArea').append('<small class="restriction text-danger">이름이 비어있습니다.</small>');//덧붙이기
					return;
				}
				
				//이름 중복되는지 확인 (DB에서 조회) -- AJAX 통신
				$.ajax({
					type:'GET'
					,data:{'name':name}
					,url:'/lesson06/ex02/is_duplication'
					,success:function(data){
						if(data.is_duplication===true){//data 에 true 가 담겨있다면 DB에 해당 이름이 있다는 뜻
						$('#statusArea').append('<small class="restriction text-danger">이름이 중복됩니다.</small>');
						}else if(data.is_duplication===false){//data 에 false 가 담겨있다면 DB에 해당 이름이 없다는 뜻
						$('#statusArea').append('<small class="text-success">사용 가능합니다.</small>');
						}
					}
					,error:function(e){
						alert("error:"+e);
					}
				});
				
			});//중복확인 닫는 부분
			
			$('#joinBtn').on('click',function(e){
				//바로 submit 되는 것을 방지한다.
				e.preventDefault();
				console.log($('#statusArea').children());
				
				/*
					 html
					  ㄴ head
					  ㄴ body
					  	ㄴ div
					  		ㄴ div
					  			ㄴ small
				
				*/
				
				//만약 #statusArea 에 아무 자식노드가 없으면 submit을 한다.
				if($('#statusArea').children().hasClass('restriction')===true){
					alert('submit 불가능');
				}else{
					alert('submit 가능');
				}
			});
			
			
			
			
		});
	</script>

</body>
</html>