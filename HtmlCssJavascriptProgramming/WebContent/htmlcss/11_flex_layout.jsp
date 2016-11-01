<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html> <!-- 문서 유형 스타일 -->
<html>    <!-- root tag or root element -->
	<head>                           
		<meta charset = "UTF-8">
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
				color: white;
				background-color: black;
				text-align: center;
			}
			
			#content {
				flex: 1;
				display: flex;
				text
			}
			
			#content #menu {
				background-color: orange;
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
			<div id="header"><h1>City Gallary</h1></div>
			<div id="content">
				<div id="menu">
				<ul>
					<li><a href="#">London</a></li>
					<li><a href="#">Paris</a></li>
					<li><a href="#">Tokyo</a></li>
					<li><a href="#">Tokyo</a></li>
					<li><a href="#">Tokyo</a></li>
					<li><a href="#">Tokyo</a></li>
					<li><a href="#">Tokyo</a></li>
					<li><a href="#">Tokyo</a></li>
					<li><a href="#">Tokyo</a></li>
					<li><a href="#">Tokyo</a></li>
					<li><a href="#">Tokyo</a></li>
					<li><a href="#">Tokyo</a></li>
			</ul>
				</div>
				<div id="center">
					<h1>London</h1>
					<p>London is the capital city of England. It is the most populous
						city in the United Kingdom, with a metropolitan area of over 13
						million inhabitants.</p>
					<p>Standing on the River Thames, London has been a major
						settlement for two millennia, its history going back to its founding
						by the Romans, who named it Londinium.</p>
				</div>
			</div>
			<div id="footer">Copyright © W3Schools.com</div>
		</div>
	</body>
	
</html>