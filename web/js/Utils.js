/**
 * Created with IntelliJ IDEA.
 * User: roman_b
 * Date: 4/4/14
 * Time: 12:32 PM
 * To change this template use File | Settings | File Templates.
 */
Common = {};
Common.Utils = (function() {

    function addCategoryToSelect(category, select, isSelected)
    {
        var option = $("<option></option>")
            .attr("value", category.id)
            .text(category.name);
        if (isSelected == true)
        {
            option.attr("selected", "selected");
        }
        select.append(option);
    }

    return {
        'addCategoryToSelect' : addCategoryToSelect
    };

})();
