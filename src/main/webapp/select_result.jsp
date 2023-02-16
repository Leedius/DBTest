<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${members }" var="member">
	<div>
		회원번호
	</div>
	<div>
		${member.memNum }
	</div>
	<div>
		회원이름
	</div>
	<div>
		${member.memName }
	</div>
	<div>
		회원나이
	</div>
	<div>
		${member.memAge }
	</div><br>
	</c:forEach>
</body>
</html>