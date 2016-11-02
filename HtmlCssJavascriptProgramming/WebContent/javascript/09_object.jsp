<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html> <!-- 문서 유형 스타일 -->
<html>    <!-- root tag or root element -->
	<head>                           
		<meta charset = "UTF-8">
	</head>

	<body>
		객체
		<hr/>	
		<script type="text/javascript">
			var car = {
				model: "승용차",
				company: "현대",
				cc: 3000,
				speed: 0,
				start: function() {
					console.log("시동을 겁니다.");
				}, 
				stop: function() {
					console.log("멈춥니다.");
				},
				setSpeed: function(speed) {
					this.speed = speed;
				},
				getSpeed: function(){
					return this.speed;
				}
			};
			
			console.log("car.model: " + car.model);
			console.log("car.company: " + car.company);
			console.log("car.cc: " + car.cc);
			console.log("car.speed: " + car.speed);
			
			//필드(속성) 값 변경
			car.model = "자율주행";
			car.speed = 60;
			console.log(car);
			
			//메소드 호출
			car.start();
			car.setSpeed(100);
			console.log("현재 속도: " + car.getSpeed());
			car.stop();
		</script>
	</body>
	
</html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        