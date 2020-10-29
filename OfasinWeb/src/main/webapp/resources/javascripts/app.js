$(document).ready(function() {
	
	$('.js-toggle').bind('click', function() {
		$('.js-sidebar').toggleClass('is-toggled');
		$('.js-content').toggleClass('is-toggled');
	});
	$(".classLi").on("click", function(event){
  var li = jQuery(event.target);

  li.parent().find(".classLi").removeClass("is-selected");
  li.addClass("is-selected");
});
});