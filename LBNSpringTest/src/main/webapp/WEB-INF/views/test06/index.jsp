<%@ page contentType= "text/html;charset=UTF-8" %>

<!DOCTYPE html> 
<html> 
	<head> 
		<meta charset="UTF-8">
	</head>
	
	<body> 
		Test06
		<hr/>
		1) 개별 파라미터 값을 받을 수 있는 변수 선언 <br/>
		2) @RequestParam 어노테이션 선언 <br/>
		3) 커맨드 객체(파라미터 값을 객체로 받음) 선언 <br/>
		4) <a href="/lbnapptest/test06/method1?mid=xxx&mname=yyy"> HttpServletRequest 변수 선언</a><br/>
		5) <a href="/lbnapptest/test06/method2"> HttpServletResponse 변수 선언 </a><br/>
		6) <a href="/lbnapptest/test06/method2"> RequestHeader 변수 선언 </a><br/>
		
		7-1) <a href="/lbnapptest/test06/method4CreateCookie"> Cookie 생성 </a> <br/>
		7-2) <a href="/lbnapptest/test06/method4ReceiveCookieHow1"> Cookie 받기(방법1) </a> <br/>
		7-3) <a href="/lbnapptest/test06/method4ReceiveCookieHow2"> Cookie 받기(방법2) </a> <br/>
		7-4) <a href="/lbnapptest/test06/method4DeleteCookie"> Cookie 삭제 </a> <br/>
		
		8-1) <a href="/lbnapptest/test06/method5SetObject"> HttpSession에 객체 저장 </a> <br/>
		8-2) <a href="/lbnapptest/test06/method5GetObject"> HttpSession에서 객체 얻기</a> <br/>
		8-3) <a href="/lbnapptest/test06/method5RemoveObject"> HttpSession 객체 제거</a> <br/>
		
		
	</body>
</html>