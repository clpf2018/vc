<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link href="//cdn.kendostatic.com/2013.1.319/styles/kendo.common.min.css" rel="stylesheet" />
    <link href="//cdn.kendostatic.com/2013.1.319/styles/kendo.default.min.css" rel="stylesheet" />
    <link href="http://cdn.kendostatic.com/2012.1.322/styles/kendo.mobile.all.min.css" rel="stylesheet" />
    <link href="styles/kendo.web.plugins.css" rel="stylesheet" />
    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
    <script src="../../js/jquery.min.js"></script>
    <script src="http://cdn.kendostatic.com/2014.1.416/js/kendo.all.min.js"></script>
</head>
<body>
        <div id="example">
            <div id="grid"></div>

            <script>
                $(document).ready(function () {
                    var crudServiceBaseUrl = "https://demos.telerik.com/kendo-ui/service",
                        dataSource = new kendo.data.DataSource({
                            transport: {
                                read:  {
                                    url: crudServiceBaseUrl + "/Products",
                                    dataType: "jsonp"
                                },
                                update: {
                                    url: crudServiceBaseUrl + "/Products/Update",
                                    dataType: "jsonp"
                                },
                                destroy: {
                                    url: crudServiceBaseUrl + "/Products/Destroy",
                                    dataType: "jsonp"
                                },
                                create: {
                                    url: crudServiceBaseUrl + "/Products/Create",
                                    dataType: "jsonp"
                                },
                                parameterMap: function(options, operation) {
                                    if (operation !== "read" && options.models) {
                                        return {models: kendo.stringify(options.models)};
                                    }
                                }
                            },
                            batch: true,
                            pageSize: 10,
                            schema: {
                                model: {
                                    id: "ProductID",
                                    fields: {
                                        ProductID: { editable: false, nullable: true },
                                        ProductName: { validation: { required: true,
                                                productnamevalidation: function (input) {
                                                    if (input.is("[name='ProductName']") && input.val() != "") {
                                                        input.attr("data-productnamevalidation-msg", "Product Name should start with capital letter");
                                                        return /^[A-Z]/.test(input.val());
                                                    }

                                                    return true;
                                                } } },
                                        UnitPrice: { type: "number", validation: { required: true, min: 1} },
                                        Discontinued: { type: "boolean" },
                                        UnitsInStock: { type: "number", validation: { min: 0, required: true } }
                                    }
                                }
                            }
                        });

                    $("#grid").kendoGrid({
                        dataSource: dataSource,
                        navigatable: true,
                        pageable: true,
                        filterable: {
                            mode: "row"
                        },
                        sortable: true,
                        height: 550,
                        toolbar: ["create", "save", "cancel"],
                        columns: [
                            { field: "ProductName", title: "Product Name"},
                            { field: "UnitPrice", title: "Unit Price", format: "{0:c}", width: 120 },
                            { field: "UnitsInStock", title: "Units In Stock", width: 120 },
                            { field: "Discontinued", width: 120, editor: customBoolEditor },
                            { command: "destroy", title: "&nbsp;", width: 150 }],
                        editable: true
                    });
                });

                function customBoolEditor(container, options) {
                    $('<input class="k-checkbox" type="checkbox" name="Discontinued" data-type="boolean" data-bind="checked:Discontinued">').appendTo(container);
                    $('<label class="k-checkbox-label">&#8203;</label>').appendTo(container);
                }
            </script>
        </div>


</body>
</html>