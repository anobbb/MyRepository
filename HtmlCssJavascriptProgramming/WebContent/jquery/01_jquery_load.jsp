<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html> <!-- 문서 유형 스타일 -->
<html>    <!-- root tag or root element -->
	<head>                           
		<meta charset = "UTF-8">
		<!--CDN 복사 
		<script
 			src="https://code.jquery.com/jquery-1.12.4.min.js"
  			integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
  			crossorigin="anonymous"></script> -->
		<!-- 애플리케이션을 갖다 놓고 사용 -->
  		<script type="text/javascript" src="../common/js/jquery-1.12.4.min.js"></script>
  		<script type="text/javascript">
  			/* window.onload = function(){
  				var btn1 = document.querySelector("#btn1");
  	  			btn1.addEventListener("click", function() {
  	  				var div1 = document.querySelector("#div1");
  	  				div1.innerHTML = "수정 내용";
  	  			});
  			}; */
  			
  			//jQuery ver.
  			$(function(){
  	  			$("#btn1").on("click", function() {
  	  				$("#div1").html("수정 내용");
  	  			});
  			});
  		</script>
	</head>

	<body>
		jQuery 라이브러리 로드
		<hr/>
		<button id="btn1">버튼1</button>
		<div id="div1">최초 내용</div>
		
	</body>
	
</html>