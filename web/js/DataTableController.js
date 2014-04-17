/**
 * Created with IntelliJ IDEA.
 * User: roman_b
 * Date: 4/10/14
 * Time: 6:35 PM
 * To change this template use File | Settings | File Templates.
 */
function DataTableController(table) {
     this.table = table;
};

DataTableController.prototype.table = undefined;

DataTableController.prototype.loadData = function (queryBuilder) {
    var params = queryBuilder.buildParams();
    var path =  queryBuilder.buildPath();
    var table = this.table;
    $.ajax({
        type: "POST",
        url: path,
        data: params,
        dataType: "json",
        success: function(data) {
            table.dataTable().fnClearTable();
            table.dataTable().fnAddData(data.data);
        }
    });
};

