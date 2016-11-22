(function($) {

	"use strict";
	
	// PRELOADER
	$(window).load(function() {
		$(".loader").fadeOut(400);
	});
	
	// REMOVE # FROM URL
	$( 'a[href="#"]' ).click( function(e) {
		e.preventDefault();
	});

	// STICKY NAV
	var stickyHeaderTop = $(".sticky-nav").offset().top;

    $(window).scroll(function() {
        if ($(window).scrollTop() > stickyHeaderTop) {
            $(".sticky-nav").css({position: "fixed", top: "0px"});
            $(".sticky-nav").css("display", "block");
			$(".sticky-nav").addClass("fixednav");
        } else {
            $(".sticky-nav").css({position: "static", top: "0px"});
			$(".sticky-nav").removeClass("fixednav");
        }
    });
	
	// ONE PAGE NAV
	$("#nav").onePageNav({
		currentClass: 'current',
		changeHash: false,
		scrollSpeed: 750,
		scrollThreshold: 0.5,
		filter: '',
		easing: 'swing',
		begin: function() {
			//I get fired when the animation is starting
		},
		end: function() {
			//I get fired when the animation is ending
		},
		scrollChange: function($currentListItem) {
			//I get fired when you enter a section and I pass the list item of the section
		}
	});

	// CAMERA SLIDER
	$("#camera_wrap_1").camera({
		alignment: 'center',
		autoAdvance: true,
		mobileAutoAdvance: true,
		barDirection: 'leftToRight',
		barPosition: 'bottom',
		loader: 'bar',
		cols: 12,
		height: '40%',
		playPause: false,
		pagination: false,
		imagePath: '../images/'
	});
	
	// TESTIMONIAL CAROUSEL
	$("#quote-carousel").carousel({
		pause: "hover",
		wrap: false,
		interval: 6000
	});
	
	// Modal Window
	$('.popup-with-zoom-anim').magnificPopup({
		type: 'inline',

		fixedContentPos: false,
		fixedBgPos: true,

		overflowY: 'auto',

		closeBtnInside: true,
		preloader: false,
		
		midClick: true,
		removalDelay: 300,
		mainClass: 'my-mfp-zoom-in'
	});
	
	// Gallery FILTERS
	var $grid = $('#gallery-grid');
	$grid.shuffle({
		itemSelector: '.gallery-grid', // the selector for the items in the grid
		speed: 500 // Transition/animation speed (milliseconds)
	});
	/* reshuffle when user clicks a filter item */
	$('#gallery-filter li a').click(function (e) {
		// set active class
		$('#gallery-filter li a').removeClass('active');
		$(this).addClass('active');
		// get group name from clicked item
		var groupName = $(this).attr('data-group');
		// reshuffle grid
		$grid.shuffle('shuffle', groupName );
	});
	
	//MAGNIFIC POPUP
	$('#gallery-grid').magnificPopup({
		delegate: 'a', 
		type: 'image',
		gallery: {
			enabled: true
		}
	});
	
	//AJAX CONTACT FORM
	$(".contact-form").submit(function() {
		var rd = this;
		var url = "sendemail.php"; // the script where you handle the form input.
		$.ajax({
		type: "POST",
		url: url,
		data: $(".contact-form").serialize(), // serializes the form's elements.
		success: function(data)
		{
		//alert("Mail sent!"); // show response from the php script.
		$(rd).prev().text(data.message).fadeIn().delay(3000).fadeOut();
		}
		});
		return false; // avoid to execute the actual submit of the form.
	}); 
    
	// GOOGLE MAP
	$(".map").height(300);
	function initialize($) {
		var mapOptions = {	
			zoom: 8,
			center: new google.maps.LatLng(17.421306, 78.457553),
			disableDefaultUI: true
		};
		var map = new google.maps.Map(document.querySelector('.map'), mapOptions);
	}
	google.maps.event.addDomListener(window, 'load', initialize);
	
})(jQuery);