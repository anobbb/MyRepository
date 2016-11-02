<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html> <!-- 문서 유형 스타일 -->
<html>    <!-- root tag or root element -->
	<head>                           
		<meta charset = "UTF-8">
		<script type="text/javascript">
			function onClickButton1() {
				console.log("onClickButton1() 실행");
				/* var div1 = document.getElementById("div1"); */
				var div1 = document.querySelector("#div1");
				console.log(div1);
				div1.innerHTML = "수정 내용";
			}
			
			function onClickButton2() {
				var imgArr = document.querySelectorAll(".photo");
				imgArr[0].src="../common/image/photo2.jpg";
			}
			
			function onClickButton3() {
				
				var mid;
				var mpassword;
				
				//******* how1
				
				//var mid = document.querySelector("[name=mid]").value;
				
				/* var inputMid = document.querySelector("[name=mid]");
				var mid = inputMid.value; */
				//var mid = document.querySelector("#mid").value;
				//var mid = document.querySelector("#form1 [name=mid]").value;
				
				//var mpassword = document.querySelector("[name=mpassword]").value;
				/* var inputMpassword = document.querySelector("[name=mpassword]");
				var mpassword = inputMpassword.value; */
				//var mpassword = document.querySelector("#mpassword").value;
				//var mid = document.querySelector("#form1 [name=mpassword]").value;
				
				//******* how2 (비추)
				mid = document.form1.mid.value;
				mpassword = document.form1.mpassword.value;
				
				// 1차 유효성 검사(client단에서의 검사)
				if(mid == ""){ //"" != null, 널이 아닌 빈 문자열, 자바스크립트는 equals가 아닌 == 사용
					alert("아이디를 입력하세요.");
				} else if(mpassword == ""){
					alert("비밀번호를 입력하세요.");
				}
				
				// 서버 전송
				var form1 = document.querySelector("#form1");
				form1.submit();
				//document.querySelector("#form1").submit();
				//document.form1.submit();
				
			}
		</script>
	</head>

	<body>
		DOM 사용
		<hr/>	
		<button onclick="onClickButton1()">버튼1</button>
		<div id="div1">최초 내용</div>
		
		<button onclick="onClickButton2()">버튼2</button>
		<div>
			<img class="photo" src="../common/image/photo1.jpg" width="200"/>
		</div>
		
		<button onclick="onClickButton3()">버튼3</button>
		<div>
			<form id="form1" name="form1">
				아이디: <input id="mid" type="text" name="mid"/> <br/>
				비밀번호: <input id="mpassword" type="password" name="mpassword"/><br/>
			</form>
		
			<!-- <form id="form1">
				아이디: <input type="text" name="mid"/> <br/>
				비밀번호: <input type="password" name="mpassword"/><br/>
			</form> -->
		</div>
	</body>
	
</html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        