<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html> <!-- 문서 유형 스타일 -->
<html>    <!-- root tag or root element -->
	<head>                           
		<meta charset = "UTF-8">
		<script type="text/javascript">
			var v1 = "A";
			
			function fun1(){
				var v2 = "B";
				v3 = "C"; // var를 사용하지 않고 변수 사용하면 전역변수로 자동 선언됨 
				console.log("v1: " + v1);
				console.log("v2: " + v2);
				console.log("v3: " + v3);
			}
			
			function fun2(){
				console.log("v1: " + v1);
				console.log("v3: " + v3);
				console.log("v2: " + v2);
			}
			
			function fun3() {
				if(true){
					var v4 = "D";
				}
				console.log("v4: " + v4);
			}
		</script>
	</head>
	<%-- 자바스크립트는 블록단위의 지역변수는 없지만 함수단위의 지역변수는 있음, 함수 내에서 자유롭게 사용 가능
		var없이 변수 사용하면 전역변수로 자동 선언되어서 사용됨
	 --%>
	<body>
		지역 변수와 전역변수
		<hr/>	
		<script type="text/javascript">
			fun1();
			console.log("-------");
			fun2();
			fun3();
		</script>
	</body>
	
</html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        