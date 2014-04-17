/**
 * Created by IntelliJ IDEA.
 * User: roman_b
 * Date: 10/17/13
 * Time: 3:09 PM
 * To change this template use File | Settings | File Templates.
 */
Admin.PriceController = (function() {

    var pricesTableController;

    function configPriceTable()
    {
        $('#treatmentsTable').dataTable({
            "bProcessing": true,
            "bLengthChange": false,
            "bPaginate": false,
            "bJQueryUI" : true,
            "bFilter" : false,
            "aoColumns": [
                { "mData": "group" },
                { "mData": "subGroup", "mDataProp" : "subGroup" },
                { "mData": "name" },
                { "mData": "price", "bSortable": false },
                { "mData": "guaranty", "bSortable": false },
                { "mData": "description", "bSortable": false, "mRender" : function(data, type, full){
                    return '<label class="descriptionLabel">' + data + '</label>';
                } }
            ],
            "fnDrawCallback": function(oSettings, json) {
                var labels = $(".descriptionLabel").each(function()
                {
                    if (this.scrollWidth >  this.clientWidth)
                    {
                        $(this).attr("title", $(this).text())
                            .tooltip({
                                position: { my: "left top", at: "right top"},
                                tooltipClass: "description-tooltip-styling"});
                    }
                });
                pricesTableController = new DataTableController($('#treatmentsTable'))

            },
            "fnCreatedRow": function( nRow, aData, iDataIndex ) {
                $(this).addClass('table-row');
            }
        }).rowGrouping({"bExpandableGrouping": true, "iGroupingColumnIndex2": 1, "bExpandableGrouping2": true});
    }

    function configPriceCategory()
    {
        $("#treatmentCategorySelect").multiselect({
            selectedList: 4,
            close: function(event, ui)
            {
                var selectedCategories = $(this).multiselect("getChecked").map(function(){
                    return this.value;
                }).get();
                loadPricesByCategories(selectedCategories);
            }
        });
    }

    function loadCategories()
    {
        var data = {actionName : 'loadCategories'};
        $.post("../admin/servlet/priceServlet", data, function(data){

            var categories = $.parseJSON(data).data;
            var allCategory = {id : 0, name : "All"};
            Common.Utils.addCategoryToSelect(allCategory, $('#treatmentCategorySelect'), true);
            for (var i = 0; i < categories.length; i++) {
                var category = categories[i];
                Common.Utils.addCategoryToSelect(category, $('#treatmentCategorySelect'));
            }
            $("#treatmentCategorySelect").multiselect('refresh');
            loadPricesByCategories([allCategory.id]);
        })
    }

    function loadPricesByCategories(categories)
    {
        pricesTableController.loadData(new PricesQueryBuilder(categories, "admin"));
    }

    function addNewCategory()
    {
        $("#addCategoryForm").submit(function(){
            var data = $(this).serialize();
            var button = $("#submitAddCategory");
            data = data + '&' + 'actionName=' + button.attr("name");
            $.post($(this).attr("action"), data, function(data){
                var jsonData = $.parseJSON(data);
                $('#addSubCategorySelect')
                    .append($("<option></option>")
                        .attr("value", jsonData.categoryId)
                        .text(jsonData.categoryName));
                $('#categoryName').val('');
            });
            return false;
        })
    }

    return {
        'configPriceCategory' : configPriceCategory,
        'configPriceTable' : configPriceTable,
        'loadCategories': loadCategories
    };

})();

