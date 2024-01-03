// jQuery("document").ready(function(){

// });

//lnb
var navCurrentParam1;
var navCurrentParam2;
$(function() {
  var $topnav = $('#lnb .navmenu'),
    $topnavmn = $topnav.find('>li'),
    $topnavsbmn = $topnavmn.find('>ul');

	$topnavmn.children('a').click(function() {
    	if ($(this).parent().is('li:has("ul")')) {
	      if (!$(this).is('.on')) {
	        $topnavmn.children('a').removeClass('on');
	        $topnavsbmn.slideUp(250).find('>li >ul').show();
	        $(this).addClass('on');    
	        $(this).parent().find('>ul').slideDown(250).find('>li a').removeClass('on');
	    } else {
        $(this).removeClass('on');
        $(this).parent().find('>ul').slideUp(250);
      }
      return false;
    } else {
    	$topnavmn.children('a').removeClass('on');
    	$topnavsbmn.slideUp(250);
    	$(this).addClass('on');
    }
  });
  
    var $topnavmnDepth2 = $topnavsbmn.find('>li'),
    $topnavsbmnDepth2 = $topnavmnDepth2.find('>ul');
  $topnavmnDepth2.children('a').click(function() {
    if ($(this).parent().is('li:has("ul")')) {
      if (!$(this).is('.on')) {
        $topnavmnDepth2.children('a').removeClass('on');
        $topnavsbmnDepth2.slideUp(200);
        $(this).addClass('on');
        $(this).parent().find('>ul').slideDown(200).find('>li a').removeClass('on');
      } else {
        $(this).removeClass('on');
        $(this).parent().find('>ul').slideUp(200);
      }
      return false;
    } else {
      $topnavmnDepth2.children('a').removeClass('on');
      $topnavsbmnDepth2.slideUp(200);
      $(this).addClass('on');
    }
  });

  var $topnavCurrent1 = $topnav.find('.nvparam'+navCurrentParam1);
  var $topnavCurrent2 = $topnav.find('.nvparam'+navCurrentParam1+'_'+navCurrentParam2);
				  
  function currentReset() {
    if (!$topnavCurrent1.children('a').is('.on')) {
      $topnavmn.children('a').removeClass('on').parent().find('>ul').hide().find('>li a').removeClass('on');
      $topnavCurrent1.children('a').addClass('on').parent().find('>ul').show();
      $topnavCurrent2.children('a').addClass('on').parent().find('>ul').show();
    }
  }
  currentReset();
});