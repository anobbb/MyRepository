<%@ page contentType= "text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
  <head>
    <meta charset="utf-8">
    <style type="text/css">
			* {
				margin: 0px;
				padding: 0px;
			}
			
			#container {
				width: 100%
				border: 1px solid gray;
				display: flex;
				flex-direction: column;
				height: 97vh;
			}
			
			#header, #footer {
				padding: 1em;
				color: black;
				background-color: gold;
				text-align: center;
			}
			
			#content {
				flex: 1;
				display: flex;
				text
			}
			
			#content #menu {
				background-color: black;
				width: 150px;
				padding: 1em;
			}
			
			#content #menu ul {
				list-style-type: none;
				padding: 0;
			}
			
			
			#content #center {
				flex: 1;
				padding: 1em;
			}
			
			
		</style>
  </head>

  <body>
  	<div id="container">
			<div id="header"><h1>♥ LBN World ♥</h1></div>
			<div id="content">
				<div id="menu">
				<ul> 
				
					<li><a href="${pageContext.servletContext.contextPath}/member/login" target="iframe">로그인</a></li>
					<li><a href="${pageContext.servletContext.contextPath}/photoboard/list" target="iframe">포토게시판</a></li>
	
			    </ul>
				</div>
				<div id="center">
					<iframe name="iframe" style="width:100%; height:100%; border-width:0px;" src="home">
						
					</iframe>
				</div>
			</div>
			
			<div id="footer">Copyright © bnphotoapp.com</div>
		</div>
     
  </body>
</html>
