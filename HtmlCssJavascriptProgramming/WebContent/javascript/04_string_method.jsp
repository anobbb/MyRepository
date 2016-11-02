<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html> <!-- 문서 유형 스타일 -->
<html>    <!-- root tag or root element -->
	<head>                           
		<meta charset = "UTF-8">
	</head>

	<body>
		String 객체의 메소드
		<hr/>	
		<script type="text/javascript">
			var v1 = "abc";
			console.log(v1.length); //length: 필드
			
			var v2 = "JavaScript is easy";
			console.log(v2.indexOf("easy"));
			console.log(v2.indexOf("spring"));
			console.log(v2.search("easy"));
			
			var v3 = "123456-9876543";
			console.log(v3.substring(7, 14)); // 끝 인덱스
			console.log(v3.substr(7,7)); // 가져올 만큼의 길이
			console.log(v3.charAt(7));
			
			var v4 = "Please visit Microsoft!";
			var v5 = v4.replace("Microsoft", "W3Schools");
			console.log("v5: " + v5);
			
			var v6 = "10:20:30";
			var v7 = v6.split(":"); // 리턴타입: 배열
			console.log(v7[0]);
			console.log(v7[1]);
			console.log(v7[2]);
			
			
		</script>
	</body>
	
</html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        