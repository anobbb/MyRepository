<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html> <!-- 문서 유형 스타일 -->
<html>    <!-- root tag or root element -->
	<head>                           
		<meta charset = "UTF-8">
		<script type="text/javascript">
			var v1 = 10;
			var v2 = "자바스크립트";
			var v3 = true;
			var v4 = { name: "홍길동", age: 27 }; 
			var v5 = function() { };
			var v6 = null;
			var v7 = new Date();
			var v8 = [1, 2, 3];
			
			/*
			* v1: 자바스크립트는 변수에 어떠한 값이 대입될 때 타입이 결정됨. 별도의 타입 선언 no 
			* v4: 자바스크립트에서 {}는 객체선언 및 대입 name: 필드 "홍길동": 필드값 
			* v8: [] : 자바스크립트에서의 배열
			v1: number
			v2: string
			v3: boolean
			v4: object
			v5: function
			v6: object
			v7: object
			v8: object
			*/
			
			console.log("v1: " + typeof(v1));
			console.log("v2: " + typeof(v2));
			console.log("v3: " + typeof(v3));
			console.log("v4: " + typeof(v4));
			console.log("v5: " + typeof(v5));
			console.log("v6: " + typeof(v6));
			console.log("v7: " + typeof(v7));
			console.log("v8: " + typeof(v8));
			
			v1 = 3.14;
			v1 = "Java"; // 또 다른 타입의 데이터가 들어가면 타입이 자동으로 바뀜
			v1 = "Java" + 8; // 문자열 결합-> "Java8"
			var x = 2 + 3 + "5"; // ->2+5=5, 5 + "5" = 55
			console.log("v1: " + typeof(v1));
		</script>
	</head>

	<body>
		데이터 타입
		<hr/>	
		
	</body>
	
</html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        