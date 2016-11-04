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
	  <div class="jumbotron">
        <h1>Spring Final Programming</h1>
        <p class="lead">Java, SQL, JDBC, HTML5, CSS3, JavaScript, jQuery, AJAX, JSP, Spring</p>
        <p><a class="btn btn-lg btn-success" href="#" role="button"> 많이 배웠네ㅎㅎㅎㅎㅎ</a></p>
      </div>
	<%--  
		SpringFinalProgramming
		<hr/> 
		<!-- context root가 바뀔 수 있으므로 myweb을 언급하지 않고 쓸 수 있는 경우?
		 동적으로 context이름을 알아서 넣는 방법 사용
		 %= : 표현식
		 $: 표현언어
		 el에서 .은 getter 호출하는 역할
		 -->
		1. 
		<c:if test="${login == null}">
			<a href="<%=pageContext.getServletContext().getContextPath()%>/member/login">로그인</a>
		</c:if>
		<c:if test="${login != null}">
		<!-- 상대경로: /member/logout -->
			<a href="<%=pageContext.getServletContext().getContextPath()%>/member/logout">로그아웃</a><br/>
			2. <a href="${pageContext.servletContext.contextPath}/freeboard/list">자유 게시판</a><br/>
			3. <a href="${pageContext.servletContext.contextPath}/photoboard/list">포토 게시판</a><br/>
		</c:if>
		<br/>		 
	--%>
	</body>
</html>