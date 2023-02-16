<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.member_input{
	padding-bottom: 5px;
}

</style>
</head>
<body>
	<form action="Insert03" method="get">
	<div class="member_wrap">
		<div class="member_Num">
			<div>회원번호</div>
			<div class=member_input>
				<input type="text" name="memberNum">
			</div>
		</div>
		<div class="member_Name">
			<div>회원이름</div>
			<div class=member_input>
				<input type="text" name="memberName">
			</div>
		</div>
		<div class="member_age">
			<div>나이</div>
			<div class=member_input>
				<input type="text" name="memberAge">
			</div>
		</div>
		<div class="member_trans">
			<input type="submit" value="전송">
		</div>
	</div>
	</form>
</body>
</html>