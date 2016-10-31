<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html> <!-- 문서 유형 스타일 -->
<html>    <!-- root tag or root element -->
	<head>                           
		<meta charset = "UTF-8">
		<style type="text/css">
			/* *{ color: red; } */
			
			div { background-color: yellow; }
			#div2 { background-color: aqua; }
			.div3 { background-color: olive; }
			
			#div4, #p1, #h1 { background-color: teal; }
			
			#div5 p { background-color: silver; }
			#div6 > p { background-color: blue; }
			#div7 + p { background-color: lime; }
			
			[checked] { color: blue; }
			[selected=true] { color: green; }
			#form1 [checked] {background-color: green;}
			
			a { color: black; text-decoration: none; }
			a: hover { color: black; text-decoration: underline; }
			a:active { color: red; }
			/* a:link { color: green; } */
			a:hover { color: green; }
		</style>
	</head>

	<body>
		CSS 선택자
		<hr/>
		<div>A</div>
		<div id="div2" class="div3">B</div>
		<div class="div3">C</div>
		<div class="div3">D</div>
		
		<br/>
		
		<div id="div4">E</div>
		<p id="p1">F</p>
		<h3 id="h1">G</h3>
		
		<br/>
		
		<div id="div5">
			<p>A</p>
			<p>A</p>
		</div>
		
		<br/>
		
		<div id="div6">
			<div><p>A</p></div>
			<p>A</p>
		</div>
		
		<br/>
		
		<div id="div7"></div>
			<p>A</p>
			<p>B</p>
			
		<br/>	
		
		<div>
			<div checked="true">A</div>
			<div checked="false">B</div>
			
			<div selected="false">C</div>
			<div selected="true">C</div>
			<div selected="true">C</div>
		</div>
		
		<form id="form1">
			<div checked="true">A</div>
			<div checked="false">B</div>
		</form>
		
		<br/>
		
		<div style="background-color: white">
			<a href="http://www.naver.com">네이버</a><br/>
			<a href="http://tomcat.apache.org">톰캣</a><br/>
			<a href="http://www.w3c.org">W3C</a><br/>
		</div>
		
		
	</body>
	
</html>