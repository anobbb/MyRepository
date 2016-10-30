<%@ page contentType= "text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head> 
		<meta charset="UTF-8">
	</head>
	
	<body> 
		SpringFinalProgramming
		<hr/> 
		
		1. 
		<c:if test="${login == null}">
			<a href="<%=pageContext.getServletContext().getContextPath()%>/member/login">로그인</a>
		</c:if>
		<c:if test="${login != null}">
		<!-- 상대경로: /member/logout -->
			<a href="<%=pageContext.getServletContext().getContextPath()%>/member/logout">로그아웃</a><br/>
			2. <a href="${pageContext.servletContext.contextPath}/photoboard/list">포토 게시판</a><br/>
		</c:if>
		<br/>		
	</body>
</html>