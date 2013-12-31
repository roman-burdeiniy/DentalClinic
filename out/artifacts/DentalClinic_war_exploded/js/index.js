/**
 * Created by IntelliJ IDEA.
 * User: roman_b
 * Date: 10/21/13
 * Time: 5:53 PM
 * To change this template use File | Settings | File Templates.
 */

Admin = {};

$(document).ready(function() {
    $("#navigationTabs").tabs({
        heightStyle: "fill",
        load: function( event, ui ) {
            var currentTabId = $(ui.tab).attr('id');
            switch (currentTabId)
            {
                case 'priceTab':
                {
                    Admin.PriceController.configPriceCategory();
                    Admin.PriceController.loadCategories();
                    Admin.PriceController.configPriceTable();
                    break;
                }
            }
        }
    });

    $(".descriptionLabel").tooltip();
});