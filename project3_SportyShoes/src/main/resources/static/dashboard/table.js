$(document).ready( function () {
    var table = $('#productsTable').DataTable({
        "sAjaxSource": "/api/product/admin/dashboard/products-r",
        "sAjaxDataProp": "",
        "order": [[ 0, "asc" ]],
        "aoColumns": [
            { "mData": "id"},
            { "mData": "name" },
            { "mData": "price" },
            { "mData": "picture_url" },
            { "mData": "categories[0].name"},
            { "mData": "created_at"
                // ,data : 'dd'
            }
        ]
    })
    var data = table.rows().data();
    data.each(function (value, index) {
        console.log(`For index ${index}, data value is ${value}`);
    });
});

