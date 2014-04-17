/**
 * Created with IntelliJ IDEA.
 * User: roman_b
 * Date: 4/4/14
 * Time: 11:34 AM
 * To change this template use File | Settings | File Templates.
 */
Admin.DoctorsController = (function() {

    var staffTableController;
    var doctorsTable;

    var gender = [{id : 1, name : 'Чол.'}, {id : 2, name : 'Жін.'}];

    function init()
    {
        registerToAddNewEmployye();
        registerToAddNewEmployeeClick();
    }

    function loadStaff()
    {
        var positions = {id : 0, name : "All"};
        staffTableController.loadData(new StaffQueryBuilder([positions], "admin"));
    }

    function registerToAddNewEmployeeClick()
    {
        $("#addNewTextSection, #addImage").click(function(){
            if($('#doctorsCardContent').is(':hidden')){
                $("#addImage").rotate({animateTo : 90});
                $("#doctorsCardContent").slideDown();
            }
            else{
                $("#doctorsCardContent").slideUp();
                $("#addImage").rotate({animateTo : 0});
            }
        });
    }

    function registerEditRemoveEmployeeClick(row)
    {
        var sData;
        row.click(function(event) {
            if ($(event.target).hasClass("rowRemoveIcon")){
                removeItem(this);
            }else if ($(event.target).hasClass("rowEditIcon")){
                sData = doctorsTable.fnGetData(this);
            }

        });
    }

    function removeItem(row)
    {
        var sData = doctorsTable.fnGetData(row);
        var nameLabel = $(row).find(".nameLabel");
        var alertTooltip = nameLabel.tooltip({
                position: { my: "center bottom-33", at: "center top",
                    using: function (position, feedback) {
                        $(this).css(position);
                        $("<div>")
                            .addClass("arrow")
                            .addClass(feedback.vertical)
                            .addClass(feedback.horizontal)
                            .appendTo(this);
                        $("<input id='confirmRemoveButton' type='button' class='alert-button' value='Ok'/>").appendTo(this);
                        $("<input id='cancelRemoveButton' type='button' class='alert-button' value='Cancel'/>").appendTo(this);
                        $("#confirmRemoveButton").click(function(){
                            postRemoveEmployee(sData.id, row);
                            removeDeleteAlert(nameLabel);
                        });
                        $("#cancelRemoveButton").click(function(){
                            removeDeleteAlert(nameLabel);
                        });
                    }},
                tooltipClass: "nameLabel-remove-tooltip-styling"}).on('mouseout focusout mouseover focusin', function(event) {
                event.stopImmediatePropagation();

            }
        );
        nameLabel.attr("title", 'The record will be completely removed.')
        nameLabel.tooltip("open");
    }

    function removeDeleteAlert(label)
    {
        label.tooltip("close");
        label.removeAttr('title');
    }

    function postRemoveEmployee(id, row)
    {
        var data = {actionName : 'removeEmployee', id : id};
        $.post("../admin/servlet/staffServlet", data, function(data){
            var position = doctorsTable.fnGetPosition(row);
            doctorsTable.fnDeleteRow(position);
        })
    }

    function configDoctorsTable()
    {
        doctorsTable = $('#doctorsTable').dataTable({
            "bProcessing": true,
            "bLengthChange": false,
            "bPaginate": false,
            "bJQueryUI" : true,
            "bFilter" : false,
            "aoColumns": [
                { "mData": "position", "bSortable": true , "mRender" : function(data, type, full){
                    return "<td><div class='rowIconDiv'><img class='rowIcon rowRemoveIcon' src='../admin/images/remove-button-16x16.png'/>" +
                        "<img class='rowIcon rowEditIcon' src='../admin/images/edit-button-16x16.png'/></div><div class='rowTextDiv'>" +
                        data + "</div></td>";
                } },
                { "mData": "name", "mRender" : function(data, type, full){
                    return '<label class="nameLabel">' + data + '</label>';
                }},
                { "mData": "speciality"},
                {"mData" : "gender", "mRender" : function(data, type, full){
                    return '<td>' + getGenderNameById(data) + '</td>';
                }},
                {"mData" : "mobNumber"},
                { "mData": "education", "bSortable": false,
                    "mRender" : function(data, type, full){
                    return '<label class="educationLabel">' + data + '</label>';
                } }
            ],
            "fnDrawCallback": function(oSettings, json) {
                var labels = $(".educationLabel").each(function()
                {
                    if (this.scrollWidth >  this.clientWidth)
                    {
                        $(this).attr("title", $(this).text())
                            .tooltip({
                                position: { my: "left top", at: "right top"},
                                tooltipClass: "educationLabel-tooltip-styling"});
                    }
                });

                staffTableController = new DataTableController($('#doctorsTable'));
            },
            "fnCreatedRow": function( nRow, aData, iDataIndex ) {
                $(nRow).addClass('table-row');
                registerEditRemoveEmployeeClick($(nRow));
            }
        });
    }

    function getGenderNameById(id)
    {
        for (var i = 0; i < gender.length; i++) {
             if (gender[i].id == id)
             {
                 return gender[i].name;
             }
        }
        return null;
    }

    function configPositions()
    {
        $("#positionSelect").multiselect({
            multiple: false,
            minWidth: 185,
            header: "Select an option",
            noneSelectedText: "Select an Option",
            selectedList: 1,
            open: function(event, ui){
               var list = $(".ui-multiselect-checkboxes label");
                list.removeClass("ui-state-hover-multiselect");
            }
        })
    }

    function loadPositions()
    {
        var data = {actionName : 'loadPositions'};
        $.post("../admin/servlet/staffServlet", data, function(data){

            var positions = $.parseJSON(data).data;
            for (var i = 0; i < positions.length; i++) {
                var position = positions[i];
                Common.Utils.addCategoryToSelect(position, $('#positionSelect'), false);
            }
            $("#positionSelect").multiselect('refresh');
        });
    }

    function registerToAddNewEmployye()
    {
        $("#addEmployeeForm").submit(function(){
            var data = $(this).serialize();
            var button = $("#submitAddEmployee");
            data = data + '&' + 'actionName=' + button.attr("name");
            $.post($(this).attr("action"), data, function(data){
                loadStaff();
                $("#addEmployeeForm").reset();
            });
            return false;
        })
    }

    return {
        'configDoctorsTable': configDoctorsTable,
        'configPositions' : configPositions,
        'loadPositions' : loadPositions,
        'init': init,
        'loadStaff' : loadStaff
    };

})();