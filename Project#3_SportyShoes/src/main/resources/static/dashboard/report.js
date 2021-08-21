$(document).ready( function () {
    var product = "products";
    var table = $('#reportTable').DataTable({
        "sAjaxSource": "/api/order/all",
        "sAjaxDataProp": "",
        "order": [[ 0, "asc" ]],
        "aoColumns": [
            { "mData": "id"},
            { "mData": "user.username" },
            { "mData": "status" },
            { "mData": "total" },
            // { "mData": "products[,]"},
            // { "mData": "products[0].categories"},
            // { "mData": "created_at" }
        ]
    })

});

