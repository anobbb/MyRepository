<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html> <!-- 문서 유형 스타일 -->
<html>    <!-- root tag or root element -->
	<head>                           
		<meta charset = "UTF-8">
		<script type="text/javascript" src="14_library.js"></script>
		<script type="text/javascript">
			function calculator() {
				var x = parseInt(document.querySelector("#x").value);
				var y = parseInt(document.querySelector("#y").value);
				var result = $.sum(x, y); //변수.메소드
				document.querySelector("#result").value = result;
			}
			
		</script>
	</head>

	<body>
		외부 자바스크립트 파일 로딩
		<hr/>	
		<input type="text" id="x"/> 에서
		<input type="text" id="y"/> 까지의 합
		<button onclick="calculator()">계산</button>
		<input type="text" id="result" readonly/>
		
	</body>
	
</html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        