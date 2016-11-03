<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html> <!-- 문서 유형 스타일 -->
<html>    <!-- root tag or root element -->
	<head>                           
		<meta charset = "UTF-8">
		<script type="text/javascript">
			
			<%-- 
			function fun1() {
				console.log("window.onload");
			}
			window.onload = fun1;
			함수를 먼저 실행하고 그 리턴값을 대입하라는 의미, 
			but, fun1()으로 선언하면 안 됨.
			onload는 리터값을 대입하는 게 아닌 onload이벤트가 발생했을 때 이벤트를 발생시켜야 함, fun1으로 선언
			--%>
			
			<%-- window라는 객체에서 onload라는 속성에(이벤트가 발생했을 때) 함수라는 값을 줌(함수를 실행하겠다)
			별도의 함수 이름을 주지 않음
			window.onload = function() {
				console.log("window.onload");
			} 
			 --%>
			 
			 <%-- 끝까지 해석 후 #btn2를 찾을 수 있음-> 이 시점에는 해석 불가, => DOM을 만들고 난 후 실행 가능
			 #btn2는 null이 됨.
			 script가 언제 다 해석되는지 알 수 있는 방법: onload 이벤트가 발생했을 때 자동적으로 실행하는 함수 사용, 그 사이에 
			 btn2 처리를 넣으면 됨. 
			 ***** 이름이 없는 함수 대입(Java의 익명객체와 비슷)
			--%>
			/*
				window.onload = function(){
				var btn2 = document.getElementById("btn2");
				btn2.onclick = changeImg2;
			} */
			 
			 function changeImg1(){
					var img1 = document.querySelector("#img1");
					img1.src = "../common/image/photo1.jpg";
			}
			 
			 function changeImg2(){
					var img1 = document.querySelector("#img2");
					img1.src = "../common/image/photo2.jpg";
			}
			 
			<%--document.querySelector("#btn2").onclick = changeImg2; --%>
			
			function changeImg3(){
				var img3 = document.querySelector("#img3");
				img3.src = "../common/image/photo2.jpg";
			}
			
			window.onload = function(){
				var btn2 = document.querySelector("#btn2");
				btn2.onclick = changeImg2; // 앞으로 실행하겠다는 뜻
				
				var btn3 = document.querySelector("#btn3");
				/* btn3.addEventListener("click", function(){
					var img3 = document.querySelector("#img3");
					img3.src = "../common/image/photo3.jpg";
				}); */
				btn3.addEventListener("click", changeImg3); // (이벤트 이름, 핸들러) , 게임만들 때 많이 씀
			}
			
		</script>
	</head>

	<body> <%-- body onload="init()" 으로 하면 위에 function init(){} 으로 함수 이름 선언 --%>
		Event 처리 <%-- DOM(객체) 생성 --%>
		<hr/>	
		<h3>[how1]</h3>
		<button onclick="changeImg1()">버튼1</button> <%-- click이벤트가 발생할 때 함수 실행, ()가 있어야 실행됨 --%>
		<img id="img1" src="" width="100px"/> <%-- src없어도 실행 됨 --%>
		
		<h3>[how2]</h3>
		<button id="btn2">버튼2</button>
		<img id="img2" src="" width="100px"/>
		
		<h3>[how3]</h3>
		<button id="btn3">버튼3</button>
		<img id="img3" src="" width="100px"/>
	</body>
	
</html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        