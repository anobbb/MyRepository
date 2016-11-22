<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--이명진--%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript">

		function getSelectValue(frm)
		{
 			frm.sname.value = frm.snameBox.options[frm.snameBox.selectedIndex].text;
 			frm.optionValue.value = frm.snameBox.options[frm.snameBox.selectedIndex].value;
		}
		</script>
	</head>
	<body>
		주문 하기1
		<hr/>
		
		<a href="allMenuSearch">전체</a>&nbsp;&nbsp;&nbsp;
		<a href="someMenuSearch?mgroup='커피'">커피</a>&nbsp;&nbsp;&nbsp;
		<a href="someMenuSearch?mgroup='티'">티</a><br/><br/><br/>
		
		<form method="post" action="/myweb/order/someMenuSearch">
			메뉴단어검색: <input type="text" name="mname" value="">&nbsp;&nbsp;&nbsp;
					   <input type="submit" value="검색"/>
		</form><br/><br/><br/>
		
		
	</body>
</html>