<%@ page contentType= "text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
	<head> 
		<meta charset="UTF-8">
	</head>
	
	<body> 
		SpringFinalProgramming
		<hr/> 
		<!-- context root가 바뀔 수 있으므로 myweb을 언급하지 않고 쓸 수 있는 경우?
		 동적으로 context이름을 알아서 넣는 방법 사용
		 %= : 표현식
		 $: 표현언어
		 el에서 .은 getter 호출하는 역할
		 -->
		1. <a href="<%=pageContext.getServletContext().getContextPath()%>/member/login">로그인</a><br/>
		2. <a href="${pageContext.servletContext.contextPath}/freeboard/list">자유 게시판</a><br/>
		3. <a href="${pageContext.servletContext.contextPath}/photoboard/list">포토 게시판</a><br/>
	</body>
</html>