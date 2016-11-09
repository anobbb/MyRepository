<%@ page contentType= "text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head> 
		<meta charset="UTF-8">
		<link href="${pageContext.servletContext.contextPath}/resources/bootstrap-3.3/css/bootstrap.min.css" rel="stylesheet">
	    <link href="${pageContext.servletContext.contextPath}/resources/css/justified-nav.css" rel="stylesheet">
	  	<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery-1.12.4.min.js"></script>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/bootstrap-3.3/js/bootstrap.min.js"></script>
	</head>
	
	<body> 
		<h1>Welcome to the LBN World ^~^</h1>
		<hr/> 
		
						
		 
		<c:if test="${login == null}">
			<p> 어서와 로그인부터 해브아~</p>
		</c:if>
		<c:if test="${login != null}">
		<!-- 상대경로: /member/logout -->
			1. <a href="<%=pageContext.getServletContext().getContextPath()%>/member/logout">로그아웃</a><br/>
			2. <a href="${pageContext.servletContext.contextPath}/photoboard/list">포토 게시판</a><br/>
		</c:if>
		<br/>		
	</body>
</html>