/**
 * Created with IntelliJ IDEA.
 * User: roman_b
 * Date: 4/10/14
 * Time: 7:07 PM
 * To change this template use File | Settings | File Templates.
 */
function StaffQueryBuilder(positions, prefix) {
    this.positions = positions;
    this.prefix = prefix;
};

PricesQueryBuilder.prototype.positions = undefined;
PricesQueryBuilder.prototype.prefix = undefined;


StaffQueryBuilder.prototype.buildParams = function () {
    var posList = this.positions.toString();
    return {actionName : 'loadStaffByPositions', 'positionsIds[]': posList};
};

StaffQueryBuilder.prototype.buildPath = function () {
    return "../" + this.prefix + "/servlet/staffServlet";
};