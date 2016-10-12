<%@ page contentType= "text/html;charset=UTF-8" %>
<%@ page import = "com.mycompany.myapp.exam07.*" %>
<%@ page import = "java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%-- <%@ : taglibrary 지시자, jstl: Java Standard Tag Library 제공 태그 선언 가능 
prefix~~~uri: 네임스페이스: 마크마다 똑같은 태그가 있을 때 그 태그가 누구 것인지 표현
xmlns~~~.... <- 모두 다 네임스페이스선언
c *** : core를 의미, 이 네임스페이스를 사용할 때에는 접두사를 c를 붙일 것을 선언
uri: 네임스페이스이름
--%>

<%-- 
<%@ %> : 지시자를 사용
<%= %> : 하나의 값 출력하는 기호
<% %> : 자바코드를 실행
--%>
<!DOCTYPE html> 
<html> 
	<head> 
		<meta charset="UTF-8">
	</head>
	
	<body> 
		데이터 찾기
		<hr/>
		[HttpServletRequest를 이용해서 찾기] <br/>
		데이터1: <%= (String)request.getAttribute("data1") %> <br/>
		데이터2: <%= (String)request.getAttribute("data2") %> <br/><br/>
		
		[HttpSession을 이용해서 찾기] <br/>
		데이터1: <%= (String)session.getAttribute("data1") %> <br/>
		데이터2: <%= (String)session.getAttribute("data2") %> <br/><br/>
		
		[EL을 이용해서 찾기] <br/>
		데이터1: ${data1} <br/>
		데이터2: ${data2} <br/><br/>
		
		[객체의 속성(필드) 값 얻기] <br/>
		<%Board board = (Board)request.getAttribute("board");%> <%-- 단순 실행 코드 --%>
		<%if(board != null) { %>
		번호: <%=board.getBno() %> <br/>  <%-- 세미콜론 붙이면 안 됨 --%>
		제목: <%=board.getTitle() %> <br/> 
		내용: <%=board.getContent() %> <br/> 
		조회수: <%=board.getHitcount() %> <br/> 
		<%} %>
		<%-- JAVA에서 .은 객체 메소드를 읽는 것이지만, EL내에서의 .은 getter method 호출 --%>
		<%-- request범위에서 저장된 board 객체를 찾아서 getBno()를 호출한 값을 넣은 것과 같음 --%> 
		
		<%-- 
		번호: ${board.bno} <br/>  
		제목: ${board.title} <br/> 
		내용: ${board.content} <br/> 
		조회수: ${board.hitcount} <br/> <br/>
		<%= : 표현식> 연산을 위한 자바코드가 아닌 하나의 값을 산출하는 코드가 들어감, 무조건 하나의 값이 나와야 함. 이 값을 넣어라
		<% %> : 자바코드
		--%>
		<br/>
		
		[컬렉션 이용하기] <br/>
		<table style= "border-collapse: collapse; border: 1px solid black; width: 600px";>
			<tr style="background-color: #ffcc00">
				<td style="border: 1px solid black">번호</td> 
				<td style="border: 1px solid black">제목</td> 
				<td style="border: 1px solid black">내용</td> 
				<td style="border: 1px solid black">조회수</td>				
			</tr>
			
			<%-- board는 있고 boardlist는 없는 경우 null --%>
			<%-- 
			<%List<Board> list = (List<Board>)request.getAttribute("boardlist");%>
			<%if(list != null) { %>
				<%for(Board b:list) { %>
					 <tr>
						<td style="border: 1px solid black"> <%=b.getBno() %> </td> 
						<td style="border: 1px solid black"> <%=b.getTitle() %> </td>
						<td style="border: 1px solid black"> <%=b.getContent() %> </td> 
						<td style="border: 1px solid black"> <%=b.getHitcount() %> </td>
					</tr>
				<%}%>
			<%}%> 
			  --%>
			 
			<%-- 
			forEach는 자동으로 null검사를 해줌 
			<c:forEach var = "b" items="${boardlist}">  => boardlist를 request에서 가져와서 b에 저장
			--%>
			<c:forEach var = "b" items="${boardlist}"> 
				<tr>
					<td style="border: 1px solid black"> ${b.bno}</td> 
					<td style="border: 1px solid black"> ${b.title} </td>
					<td style="border: 1px solid black"> ${b.content} </td> 
					<td style="border: 1px solid black"> ${b.hitcount} </td>
				</tr>
			</c:forEach>
			
		</table>
	</body>
</html>