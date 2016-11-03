<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html> <!-- 문서 유형 스타일 -->
<html>    <!-- root tag or root element -->
	<head>                           
		<meta charset = "UTF-8">
  		<script type="text/javascript">
  			//함수(객체) 대입
  			var $ = function(selector) {
  				console.log("aaa");
  				return document.querySelectorAll(selector);
  			};
  			
  			// 동적 메소드 추가
  			$.ajax = function(){
				console.log("bbb");
			}
  			/* var $ = {
  				ajax: function(){
  					console.log("bbb");
  				}
  			}; */
  			
  			function test() {
  				//Selector일 때
  				//$("#div1").innerHTML = "수정 내용"; //함수의 리턴된 값.리턴된 객체의 innerHTML
  				
  				//SelectorAll일 때: 배열리턴
  				$("#div1")[0].innerHTML = "수정 내용";
  				$.ajax();
  			}
  		</script>
	</head>

	<body>
		$는 함수형 객체
		<hr/>
		<button onclick="test()">버튼</button>
		<div id="div1">최초 내용</div>
	</body>
	
</html>