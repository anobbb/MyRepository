<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>index</title>
	<meta name="viewport"
		content="width=device-width, initial-scale=1, maximum-scale=1, user-scaleable=no">
	<link rel="stylesheet" type="text/css"
		href="../common/bootstrap-3.3/css/bootstrap.min.css">
	<script type="text/javascript" src="../common/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript"
		src="../common/bootstrap-3.3/js/bootstrap.min.js"></script>
	<style>
		#header, #footer {
			background-color: black;
			color: white;
		}
		
		#content #menu {
				background-color: orange;
				/*width: 150px; */
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
		
		#container {
			height: 96vh;
		}
	</style>
	
</head>

<body>
<div id="container" class="container-fluid">
	<div id="header" class="row">
		<div class="col-md-12"><h1>City Gallary</h1></div>
	</div>
	<div id="content" class="row">
		<div id="menu" class="con-xs-12 col-md-3">
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
		<div id="center" class="col-md-9">
			<h1>London</h1>
				<p>London is the capital city of England. It is the most populous
					city in the United Kingdom, with a metropolitan area of over 13
					million inhabitants.</p>
				<p>Standing on the River Thames, London has been a major
					settlement for two millennia, its history going back to its founding
					by the Romans, who named it Londinium.</p>
		</div>
	</div>
	<div id="footer" class="row">
		<div class="col-md-12">Copyright © W3Schools.com</div>
	</div>
</div>
</body>
</html>