/**
 * Created with IntelliJ IDEA.
 * User: roman_b
 * Date: 2/18/14
 * Time: 5:03 PM
 * To change this template use File | Settings | File Templates.
 */

var activeMenuButton;
var currentMarkedButton;

$(document).ready(function() {
    $("#menu").menubar({
        create: function( event, ui )
        {
            activeMenuButton = $("#menu li:first-child");
            setButtonActive(activeMenuButton);
        }
    });
    $("#menu li").hover(function(){
                animateMenuMarker($(this));
        },
        function(){
            animateMenuMarker(activeMenuButton);
        });
    $("#menu li").click(function(e){
        setButtonNonActive(activeMenuButton);
        activeMenuButton = $(this);
        setButtonActive(activeMenuButton);
    });

    $(".ui-menubar-link").click(function(e){
        e.preventDefault();
        $("#mainContentSection").load($(this).attr("href"));
    });
    $("#mainContentSection").load('client/main.html');

    $("#scheduleAppButton").hover(function(){
        $(this).animateGradient('linear-gradient(#FF7011, #FF7011)', 300);
    },function(){
        $(this).animateGradient('linear-gradient(#FF7011, #D45400)', 300);
    });
});


function animateMenuMarker(nextButton)
{
    var newPos = nextButton.position();
    var currentPos = $("#marker").position();
    var delta = Math.abs(currentPos.left - newPos.left);
    var duration = (delta / 300) * 1000;
    $("#marker").stop().animate({left: newPos.left, width: nextButton.width()}, 800, "easeInOutQuad", function(){

    });
}

function setButtonActive(button)
{
    button.children("a").addClass("ui-button-active");
}

function setButtonNonActive(button)
{
    button.children("a").removeClass("ui-button-active");
}

