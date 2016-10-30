<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<style type="text/css">
			a{
				text-decoration:none;
				color:black;
			}
			/* a태그 위로 마우스가 올라갔을 때 */
			a:HOVER{
				color:green;
			}
		</style>
	</head>
	<body>
		<h2>자유 게시판</h2>
		<hr/>
		
		<c:if test="${login!=null}">
			<a href="write">[글쓰기]</a>
		</c:if>		
		
		<table style= "border-collapse: collapse; border: 1px solid black; width: 600px">
			<tr style="background-color: pink"> <!-- #ffcc00 -->
				<td style="border: 1px solid black">번호</td> 
				<td style="border: 1px solid black">제목</td> 
				<td style="border: 1px solid black">글쓴이</td>		
				<td style="border: 1px solid black">조회수</td>	
				<td style="border: 1px solid black">날짜</td>			
			</tr>
			
			<c:forEach var = "freeBoard" items="${list}"> <!-- Board 객체 수 만큼 반복 -->
			<!-- Controller가 request에서 검색한 후 없으면 session에서 검색 후 찾아서 jsp에 넘김 -->
				<tr>
					<td style="border: 1px solid black"> ${freeBoard.bno} </td> 
					<td style="border: 1px solid black"> 
						<a href="info?bno=${freeBoard.bno}">${freeBoard.btitle}</a> 
					</td>
					<td style="border: 1px solid black"> ${freeBoard.bwriter} </td> 
					<td style="border: 1px solid black"> ${freeBoard.bhitcount} </td> 
					<td style="border: 1px solid black"> ${freeBoard.bdate} </td> 
				</tr>
			</c:forEach>	
		</table>
		<!-- 
		groupNo
		1,2,3,4,5 G1
		6,7,8,9,10 G2
		11,12,13,14,15 G3
		 -->
		 
		 <!-- 
		 <a href="#"> 1&nbsp;</a>
		 <a href="#">2&nbsp;</a>
		 <a href="#" style="color:red">3&nbsp;</a>
		 <a href="#">4&nbsp;</a>
		 <a href="#">5&nbsp;</a>
		  -->
		  
		 <div style="width: 600px">
			<a href="list?pageNo=1">[처음]</a>
			<c:if test="${groupNo>1}">
				<a href="list?pageNo=${startPageNo-1}">[이전]</a>
			</c:if> <!-- 그룹번호가 1이상일때는 이전이 나오게 함 -->
			
			<c:forEach var="i" begin="${startPageNo}" end="${endPageNo}">
				<a href="list?pageNo=${i}" 
					<c:if test="${pageNo==i}">style="color:red"</c:if>
				>${i}</a>
			</c:forEach>
			
			<c:if test="${groupNo<totalGroupNo}">
				<a href="list?pageNo=${endPageNo+1}">[다음]</a>
			</c:if>			
			<a href="list?pageNo=${totalPageNo}">[맨끝]</a>
		</div> 
	</body>
</html>