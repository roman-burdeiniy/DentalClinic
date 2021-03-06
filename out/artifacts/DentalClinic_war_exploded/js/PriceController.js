/**
 * Created by IntelliJ IDEA.
 * User: roman_b
 * Date: 10/17/13
 * Time: 3:09 PM
 * To change this template use File | Settings | File Templates.
 */
Admin.PriceController = (function() {

    function configPriceTable()
    {
        $('#treatmentsTable').dataTable({
            "bServerSide": true,
            "sAjaxSource": "/admin/servlet/treatmentServlet",
            "bProcessing": true,
            "bLengthChange": false,
            "bPaginate": false,
            "bJQueryUI" : true,
            "bFilter" : false,
            "aoColumns": [
                { "mData": "group" },
                { "mData": "name" },
                { "mData": "lowPrice", "bSortable": false },
                { "mData": "topPrice", "bSortable": false },
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


            },
            "fnCreatedRow": function( nRow, aData, iDataIndex ) {
                $(this).addClass('table-row');
            }
        }).rowGrouping({bExpandableGrouping: true});
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
        $.post("admin/servlet/treatmentServlet", data, function(data){

            var categories = $.parseJSON(data).categories;

            for (var i = 0; i < categories.length; i++) {
                var category = categories[i];
                addCategoryToSelect(category, $('#treatmentCategorySelect'))
            }
            $("#treatmentCategorySelect").multiselect('refresh');
        })
    }

    function loadPricesByCategories(categories)
    {
        var catList = categories.toString();
        var data = {actionName : 'loadPricesByCategories', 'categoryIds[]': catList};
        $.post("admin/servlet/treatmentServlet", data, function(data){

          var a = 1;
        })
    }

    function addCategoryToSelect(category, select)
    {
        select.append($("<option></option>")
                .attr("value", category.id)
                .text(category.name));
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

