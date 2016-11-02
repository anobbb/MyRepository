<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html> <!-- 문서 유형 스타일 -->
<html>    <!-- root tag or root element -->
	<head> <%-- 선선언 후호출, 매개변수 타입&리턴타입X --%>                           
		<meta charset = "UTF-8">
		<script type="text/javascript">
			function sum(from, to){
				var sum = 0;
				for(var i=from; i<=to; i++){
					sum += i;
				}
				return sum;
			}
		</script>
	</head>

	<body>
		함수 선언
		<hr/>
		<script type="text/javascript">
			console.log("1부터 10까지의 합: " + sum(1, 10));
		</script>
		
	</body>
	
</html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        