$(function() {
    var shopId = getQueryString('shopId');
    var shopInfoUrl = '/myo2o/shopadmin/getshopmanagementinfo?shopId=' + shopId;
    $.getJSON(shopInfoUrl, function(data) {
        if (data.redirect) {

        } else {
            if (data.shopId != undefined && data.shopId != null) {
                shopId = data.shopId;
            }else {
                alert("店铺id不存在");
            }
            $('#shopInfo').attr('href', '/myo2o/shopadmin/shopoperation?shopId=' + shopId);
        }
    });
});