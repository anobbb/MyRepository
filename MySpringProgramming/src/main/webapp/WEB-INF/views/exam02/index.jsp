<%@ page contentType= "text/html;charset=UTF-8" %>

<!DOCTYPE html> 
<html> 
	<head> 
		<meta charset="UTF-8">
	</head>
	
	<body>
		Exam02
		<hr/>
		<!-- 요청내용? 요청파라메타(파라메타이름=파라메타값)&요청파라메타&요청파라메타로 데이터전달 -->
		<a href="/myapp/exam02/join?mid=user1&mname=홍길동&mage=25">가입</a><br/>
		<a href="/myapp/exam02/login?id=user1&password=12345">로그인</a><br/>
		<a href="/myapp/exam02/order?pid=5&pname=마우스&pprice=5000&pcompany=삼성">주문</a><br/>
		<a href="/myapp/exam02/write?bno=10&title=게시물제목&content=게시물내용">글쓰기</a><br/>
		<a href="/myapp/exam02/update?bno=10&title=게시물제목&content=게시물내용&count=3">글수정</a><br/>
		<a href="/myapp/exam02/send?bno=20&title=게시물제목&content=게시물내용&hitcount=5">보내기</a><br/>
	</body>
</html>