<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 추가</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>회원정보 추가</h1>
		<form method="post">
			<b>이름 : </b>
			<input type="text" class="form-control col-4" name="name" placeholder="이름을 입력해 주세요"/><br>
			<b>생일 : </b>
			<input type="text" class="form-control col-4" name="yyyymmdd" placeholder="ex>19950215"/><br>
			<b>이메일주소 : </b>
			<input type="text" class="form-control col-4" name="email" placeholder="이메일을 입력해 주세요"/><br>
			<b>자기소개 : </b>
			<textarea class="form-control" rows="10"cols="20" name="introduce"></textarea>
			
			<%-- <input type="submit" id="addBtn" class="btn btn-success mt-3 font-weight-bold" value="추가"/> --%>
			<button id="addBtn1" class="btn btn-success mt-3 font-weight-bold">추가</button> 
			<%--<a href="#" class="btn btn-info" id="aBtn">안녕</a> --%>
		</form>
	</div>
	
	
	<script>
		$(document).ready(function(){
			/*
			// (1). jQuery submit 기능 이용하기
			$('form').on('submit',function(e){
				// 이 함수의 기본 수행사항을 멈추게 하는함수
				// -- 기본으로 submit 동작 하는 것을 막는다
				// a태그의 경우 기본으로 페이지의 상단으로 이동하는 것을 막는다.
	
				//alert('추가 버튼 클릭!');

				//Validation check -- return 이 되더라도 submit이 되어버린다.
				var name=$('input[name=name]').val().trim();
				
				if(name==''){
					alert('이름을 입력해 주세요');
					
					return;
				}
				
				var yyyymmdd=$('input[name=yyyymmdd]').val().trim();
				
				if(yyyymmdd==''|| yyyymmdd.length!=8){
					alert('생년월일을 입력 해 주세요');
				 
					return;
				}
				//여기까지 도딜히먄 submit 이 된다.
			});
			*/

			// (2) jQuery의 AJAX 통신을 이용하기
			$('#addBtn1').on('click',function(e){
				
				var name=$('input[name=name]').val().trim();
				if(name==''){
					alert('이름을 입력해 주세요');
					return;
				}
				
				var yyyymmdd=$('input[name=yyyymmdd]').val().trim();
				
				if(yyyymmdd==''|| yyyymmdd.length!=8 ){
					alert('생년월일을 입력 해 주세요');
					return;
				}
				if(isNan(yyyymmdd)){
					alert('숫자만 입력하세요');
					return;
				}
				
				let email=$('input[name=email]').val().trim();
				
				let introduce=$('textarea[name=introduce]').val();
				
				alert('추가버튼 클릭');

				
				//AJAX :: from태그와 상관없이 비동기로 별도 요청
				$.ajax({
					type : 'POST'
					,url : '/lesson06/ex01/add_new_user'
					,data : {'name':name,'yyyymmdd':yyyymmdd,'email' : email,'introduce':introduce}
					,success:function(data){
						//server가 return 해준 값..
						alert(data);
						location.href="/lesson06/ex01/get_user";
					}
					,complete:function(data){//success 다른점 :::: 에러발생 성공 여부관계없이 '완료가 되었을 때 호출되는 함수'
						alert("완료");
					}
					,error: function(e){
						alert("error"+e);
					}
				});
				//submit    브라우저 -> 폼 , submit -> 브라우저 처리 -> 서버
				//AJAX 브라우저 - > AJAX -> 수동처리 -> 서버
				
			});
			
		});
	</script>
</body>
</html>