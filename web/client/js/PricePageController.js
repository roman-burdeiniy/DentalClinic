/**
 * Created by IntelliJ IDEA.
 * User: roman_b
 * Date: 03/27/14
 * Time: 12:59 PM
 * To change this template use File | Settings | File Templates.
 */
$(document).ready(function() {

    $('#priceTable').dataTable({
        "bProcessing": true,
        "bLengthChange": false,
        "bPaginate": false,
        "bJQueryUI" : true,
        "bFilter" : false,
        "aoColumns": [
            { "mData": "group" },
            { "mData": "subGroup", "mDataProp" : "subGroup" },
            { "mData": "name" , "bSortable": false},
            { "mData": "price", "bSortable": false },
            { "mData": "guaranty", "bSortable": false }
        ],
        "fnCreatedRow": function( nRow, aData, iDataIndex ) {
            $(this).addClass('table-row');
        },
        "fnInitComplete": function(oSettings, json) {
            $("#priceTable_wrapper div").first().removeClass("ui-widget-header");
            $("#priceTable_wrapper div").first().addClass("table-header");
            $("#priceTable_wrapper div").last().removeClass("ui-widget-header");
            $("#priceTable_wrapper div").last().addClass("table-header");
            loadPrices();
        }
    }).rowGrouping({"bExpandableGrouping": true, "iGroupingColumnIndex2": 1, "bExpandableGrouping2": true});

});

function loadPrices()
{
   var allCategory = {id : 0, name : "All"};
   Common.LoadPriceService.loadPricesByCategories([allCategory.id], $('#priceTable'), "client", function(){
       $(document).trigger("content-ready");
   });
}