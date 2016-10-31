<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>    
	<head>                           
		<meta charset = "UTF-8">
		<!-- External Style Sheet -->
		<link rel="stylesheet" type="text/css" href="05_style.css">
		
		<!-- Internal Style Sheet -->
		<style type="text/css">
			.menu{
				background-color: #ffffff;
			}
			.menu li {
				color: orange;
			} 
		</style>
	</head>

	<body>
		CSS Location
		<hr/>
		
		<header>제목</header>
		<p>내용</p>
		
		<a href="http://tomcat.apache.org">톰캣</a>
		<div class="menu">
			<ul>
				<li>manu1</li>
				<li>manu2</li>
				<li>manu3</li>
			</ul>
		</div>
		
		<!-- In-line Style Sheet: 재사용 불가-->
		<div style="background-color: silver; text-align: center">
			본문 내용입니다.
		</div>
	</body>
	
</html>