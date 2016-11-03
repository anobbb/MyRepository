<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html> <!-- 문서 유형 스타일 -->
<html>    <!-- root tag or root element -->
	<head>                           
		<meta charset = "UTF-8">
		<script type="text/javascript">
			function checkMid(){
				var mid = document.querySelector("#mid");
				mid.value = mid.value.toLowerCase();
								
			}
			
			window.onload = function(){
				document.querySelector("#mid").addEventListener("keypress", checkMid);
				document.querySelector("#mid").addEventListener("change", checkMid);
			}
			
			function changeImg(img){
				if(event.type == "mouseover"){
					img.src="../common/image/photo2.jpg"
				} else if(event.type == "mouseout"){
					img.src="../common/image/photo1.jpg"
				}
			}
			
			function changeImg2(img){ 
				// addEventListener함수를 사용하려면 매개변수를 안 주거나 event를 객체로 받아야 함
				var img = event.target; // 이벤트를 통해서 받음
				if(event.type == "mouseover"){
					img.src="../common/image/photo2.jpg"
				} else if(event.type == "mouseout"){
					img.src="../common/image/photo1.jpg"
				}
			}
			
			window.addEventListener("load", function(){
				var img2 = document.querySelector("#img2");
			
				img2.addEventListener("mouseover", changeImg2);
				img2.addEventListener("mouseout", changeImg2);
			});
					
			function changeColor(div){
				if(event.type == "mouseover"){
					div.style.backgroundColor = "blue";
				} else if(event.type == "mouseout"){
					div.style.backgroundColor = "red";
				}
			}
			
		</script>
	</head>

	<body>
		다양한 Event 처리
		<hr/>	
		<h3>[Ex1]</h3>
		<form>
			<!-- <input id="mid" type="text" name="mid" onkeypress="checkMid()" onchange="checkMid()" /> -->
			<input id="mid" type="text" name="mid" />
		</form>
		 
		<br/><br/>
		 
		<h3>[Ex2]</h3>
		<%-- this를 넣으면 현재 실행할 event source를 받아옴 --%> 
		<img id="img1" src="../common/image/photo1.jpg" width="200px" onmouseover="changeImg(this)" onmouseout="changeImg(this)"/>
		<img id="img2" src="../common/image/photo1.jpg" width="200px"/>
		
		<br/><br/>
		
		<h3>[Ex3]</h3>
		<div id="div1" style="width:200px; height:200px; background-color:red;" onmouseover="changeColor(this)" onmouseout="changeColor(this)"></div>
	</body>
	
</html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        