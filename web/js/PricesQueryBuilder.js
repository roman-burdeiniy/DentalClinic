/**
 * Created with IntelliJ IDEA.
 * User: roman_b
 * Date: 4/10/14
 * Time: 7:02 PM
 * To change this template use File | Settings | File Templates.
 */
function PricesQueryBuilder(categories, prefix) {
    this.categories = categories;
    this.prefix = prefix;
};
PricesQueryBuilder.prototype.categories = undefined;
PricesQueryBuilder.prototype.prefix = undefined;


PricesQueryBuilder.prototype.buildParams = function () {
    var catList = this.categories.toString();
    return {actionName : 'loadPricesByCategories', 'categoryIds[]': catList};
};

PricesQueryBuilder.prototype.buildPath = function () {
    return "../" + this.prefix + "/servlet/priceServlet";
};
