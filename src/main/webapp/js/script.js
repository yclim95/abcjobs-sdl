/* Template: ABC Jobs (SDL Module - ASSIGNMENT)
   Author: Lim Yao Cheng
   Created: 2020
   Description: Custom JS

Table Of Contents:

01. jQuery to collapse the navbar on scroll
02. closes the responsive menu on menu item click
04. Back to Top
05. Remove long Focus Button
*/


(function($) {
    "use strict"; 
	
	/* Navbar Scripts */
	// jQuery to collapse the navbar on scroll
    $(window).on('scroll load', function() {
		if ($(".navbar").offset().top > 20) {
			$(".fixed-top").addClass("top-nav-collapse");
		} else {
			$(".fixed-top").removeClass("top-nav-collapse");
		}
    });


    // closes the responsive menu on menu item click
    $(".navbar-nav li a").on("click", function(event) {
    if (!$(this).parent().hasClass('dropdown'))
        $(".navbar-collapse").collapse('hide');
	});
	
	// Tooltip
	  $('[data-toggle="tooltip"]').tooltip();
	
    
    /* Back To Top Button */
    // create the back to top button
    $('body').prepend('<a href="" class="back-to-top page-scroll">Back to Top</a>');
    var amountScrolled = 700;
    $(window).scroll(function() {
        if ($(window).scrollTop() > amountScrolled) {
			$('a.back-to-top').css("display", "block");
			$('a.back-to-top').fadeIn('500');
        } else {
			$('a.back-to-top').css("display", "none");
			$('a.back-to-top').fadeOut('500');
        }
	});
	

	/* Removes Long Focus On Buttons */
	$(".button, a, button").mouseup(function() {
		$(this).blur();
	});

})(jQuery);