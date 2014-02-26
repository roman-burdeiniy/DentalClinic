/**
 * Created with IntelliJ IDEA.
 * User: roman_b
 * Date: 2/18/14
 * Time: 5:03 PM
 * To change this template use File | Settings | File Templates.
 */

var activeMenuButton;

$(document).ready(function() {
    $("#menu").menubar({
        create: function( event, ui )
        {
            activeMenuButton = $("#menu li:first-child");
            positionMenuMarker(activeMenuButton);
            setButtonActive(activeMenuButton);
        }
    });
    $("#menu li").hover(function(){
            positionMenuMarker($(this));
        },
        function(){
            positionMenuMarker(activeMenuButton);
        });
    $("#menu li").click(function(){
        setButtonNonActive(activeMenuButton);
        activeMenuButton = $(this);
        setButtonActive(activeMenuButton);
    });
});

function positionMenuMarker(button)
{
    var pos = button.offset();
    $("#markerTop").offset({ top: pos.top, left: pos.left});
    $("#markerTop").width(button.width() - 1);
    $("#markerTop").css("display", "block");
    $("#markerBottom").offset({ top: pos.top + button.height() - 1, left: pos.left});
    $("#markerBottom").width(button.width() - 1);
    $("#markerBottom").css("display", "block");

    $("#marker").offset({ top: pos.top, left: pos.left});
    $("#marker").width(button.width());
    $("#marker").height(button.height());
    $("#marker").css("display", "block");
}


function setButtonActive(button)
{
    button.children("a").addClass("ui-button-active");
}

function setButtonNonActive(button)
{
    button.children("a").removeClass("ui-button-active");
}
