<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--2016-11-16(수)--%>
<%--작성자: 이윤주--%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript">
			function pop(img) {
			 var win = window.open('', 'Detail', 'width=0, height=0, menubar=0, toolbar=0, directories=0, scrollbars=1, status=0, location=0, resizable=1');
			 op="<html><head><title>크게 보기</title></head>";
			 op+="<body leftmargin='0' topmargin='0'>";
			 op+="<img src='"+ img.src +"' border='0' style='cursor:pointer' onclick='window.close();' onload='window.resizeTo(this.width+30, this.height+90); window.moveTo( (screen.width-this.width)/2 ,  (screen.height-this.height)/2-50 )'>";
			 op+="</body></html>";

			 win.document.write(op);
			}

		</script>
	</head>
	<body>
		매장정보 확인
		<hr/>
		<form><%-- input type="file"일시 반드시 enctype="multipart/form-data 작성 --%>
			
			아이디: ${store.sid} <br/>
			
			이메일: ${store.semail}<br/>
			
			카페명: ${store.sname}<br/>
								
			지점명: ${store.slocal}<br/>
			
			주소: ${store.saddr}<br/>
			
			휴대전화: ${store.stel}<br/>
						
			오픈시간: <input type="time" name="sopen" value="${store.sopen}" readonly="readonly"><br/>
			
			마감시간: <input type="time" name="sclosed" value="${store.sclosed}" readonly="readonly"><br/>
			
			비콘번호: ${store.sbeacon}<br/>
		
			매장이미지:<br/><br/>
			<c:forEach var="sphoto" items="${list}">
				
				<%-- <div style="width:150px; height:170px; margin:5px; background-image:url(showPhoto?savedfile=${sphoto.spic_savedfile}); background-size: 150px 170px;display:inline-block;">
    			</div> --%> 
    			<img id="i1" width="170" height="150" src="showPhoto?savedfile=${sphoto.spic_savedfile}" onError="this.style.visibility='hidden'"  style="cursor:hand" onclick="pop(this)">
				
			</c:forEach><br/><br/>
			
			<a href="modify?sid=${store.sid}">[수정]</a>
			<a href="../index">[확인]</a>
			<a href="../index">취소</a>
		</form>
	</body>
</html>