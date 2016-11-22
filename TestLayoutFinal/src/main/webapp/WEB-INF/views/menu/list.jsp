<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="">

		<title>Coffee House - Bootstrap 3 Template</title>

		<!-- Bootstrap -->
		<link href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

		<!-- Google Web Fonts -->
		<link href="http://fonts.googleapis.com/css?family=Alegreya:400italic,700italic,900italic,400,700,900" rel="stylesheet" type="text/css">
		<link href="http://fonts.googleapis.com/css?family=Abel" rel="stylesheet" type="text/css">
		<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900,200italic,300italic,400italic,600italic,700italic,900italic" rel="stylesheet" type="text/css">
		<link href="http://fonts.googleapis.com/css?family=Arimo:400,700,400italic,700italic" rel="stylesheet" type="text/css">

		<!-- Template CSS Files  -->
		<link href="${pageContext.servletContext.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet">
		<link href="${pageContext.servletContext.contextPath}/resources/css/animate.min.css" rel="stylesheet">
		<link href="${pageContext.servletContext.contextPath}/resources/css/camera.css" rel="stylesheet">
		<link href="${pageContext.servletContext.contextPath}/resources/css/magnific-popup.css" rel="stylesheet">
		<link href="${pageContext.servletContext.contextPath}/resources/css/style.css" rel="stylesheet">
		<link href="${pageContext.servletContext.contextPath}/resources/css/responsive.css" rel="stylesheet">

		<!-- Template JS Files -->
		<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-1.12.4.min.js"></script>
		<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-migrate-1.2.1.min.js"></script>	
		<script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script>
		<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.scrollTo.js"></script>
		<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.nav.js"></script>
		<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.mobile.customized.min.js"></script>
		<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.easing.1.3.js"></script>
		<script src="${pageContext.servletContext.contextPath}/resources/js/camera.min.js"></script>
		<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.shuffle.modernizr.min.js"></script>
		<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.magnific-popup.min.js"></script>
		<script src="${pageContext.servletContext.contextPath}/resources/js/wow.min.js"></script>
		<script src="https://maps.googleapis.com/maps/api/js?v=3&amp;sensor=false"></script>
		<script src="${pageContext.servletContext.contextPath}/resources/js/custom.js"></script>
		<script> new WOW().init(); </script>

		<!-- Fav and touch icons -->
		<link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/fav-144.png">
		<link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/fav-114.png">
		<link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/fav-72.png">
		<link rel="apple-touch-icon-precomposed" href="images/fav-57.png">
		<link rel="shortcut icon" href="images/fav.png">
	
	
	
	</head>
	<body>
	<!-- Preloader Starts -->
		<div class="loader"></div>
	<!-- preloader Ends -->
	
	
	<!-- Services Section Starts -->
		<section id="services" class="services">
		<!-- Container Starts -->
			<div class="container">
			<!-- Main Heading Starts -->
				<div class="text-center">
					<h2 class="wow fadeInDown">Services</h2>
					<p class="wow fadeInUp">
						It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using english.  
					</p>
				</div>
			</div>
		</section>
	<!-- Services Section Ends -->
	
	<!-- Gallery Section Starts -->
		<section id="gallery" class="gallery">
		<!-- Gallery Head Block Starts -->
			<div class="gallery-head">
				<div class="container">
					<h2 class="wow bounceInLeft">Coffee Gallery</h2>
				<!-- Gallery Filter Starts -->
					<ul id="gallery-filter" class="list-inline wow bounceInRight">
						<li>
							<a href="#" class="btn active" data-group="all">
								All
							</a>
						</li>
						<li>
							<a href="#" class="btn" data-group="커피">
								Coffee
							</a>
						</li>
						<li>
							<a href="#" class="btn" data-group="차">
								Tea
							</a>
						</li>
						<li>
							<a href="#" class="btn" data-group="디저트">
								Dessert
							</a>
						</li>
						<li>
							<a href="#" class="btn" data-group="기타">
								Etc
							</a>
						</li>
					</ul>
				<!-- Gallery Filter Ends -->
				</div>
			</div>
		<!-- Gallery Head Block Ends -->
		
		<!-- Gallery Container Starts -->
			<div class="container">
				<ul id="gallery-grid" class="row">
				<!-- Gallery Item #count Starts -->
				<c:forEach var="menu" items="${list}">
					<li class="col-md-3 col-sm-4 col-xs-6 gallery-grid" data-groups='["all", "${menu.mgroup}"]'>
						<div class="hover-content wow flipInX">
							<a href="info?mid=${menu.mid}">
								<img src="${pageContext.servletContext.contextPath}/menu/showPhoto?msavedfile=${menu.msavedfile}" alt="Gallery Image${menu.mid}" class="img-responsive">
								<div class="head-part">
									<i class="fa fa-search-plus"></i>
								</div>
								<div class="foot-part hidden-xs">
									<h5>${menu.mname} ${menu.hot_ice}</h5><br/>
									<h5>${menu.mprice} won</h5><br/>
								</div>
							</a>
						</div>
					</li>
				</c:forEach>
				<!-- Gallery Item #1 Ends -->
				</ul>
			</div>
			
			<div>
				<c:if test="${login!=null }">
   				<a href="${pageContext.servletContext.contextPath}/menu/register">[메뉴 등록]</a>
   				</c:if>
   				<a href="${pageContext.servletContext.contextPath}/index">[메인ㄱㄱ]</a>
			</div>
			
			
		<!-- Gallery Container Ends -->
		</section>
	<!-- Gallery Section Ends -->
	
			
	</body>
</html>