const customerUrl = "http://localhost:8080/api/v1/customer";
const itemUrl = "http://localhost:8080/api/v1/item";
const orderUrl = "http://localhost:8080/api/v1/order";

let itemsCache = [];

$(function () {
    initOrderPage();
});

// ===============================
// INITIALIZE PAGE
// ===============================
function initOrderPage() {
    loadCustomers();
    loadItems();
    getAllOrders();
    $("#order-item-list").empty();
    $("#order-total").text("0.00");
    $("#order-date").val("");
}

// ===============================
// LOAD CUSTOMERS
// ===============================
function loadCustomers() {
    $.get(customerUrl, function (response) {
        const dropdown = $("#order-customer").empty();
        dropdown.append("<option value=''>-- Select Customer --</option>");

        response.forEach(c => {
            dropdown.append(
                `<option value="${c.id}">${c.id} - ${c.name}</option>`
            );
        });
    });
}

// ===============================
// LOAD ITEMS
// ===============================
function loadItems() {
    $.get(itemUrl, function (response) {
        itemsCache = response;
    });
}

// ===============================
// LOAD ORDER HISTORY
// ===============================
function getAllOrders() {
    $.get(orderUrl, function (orders) {

        $('#order-history-list').empty();

        orders.forEach(order => {
            const row = `
                <tr>
                    <td>${order.id}</td>
                    <td>${order.customerId}</td>
                    <td>${order.date}</td>
                    <td>${order.total.toFixed(2)}</td>
                </tr>`;

            $('#order-history-list').append(row);
        });
    });
}

// ===============================
// ADD ITEM ROW
// ===============================
function addItemRow() {

    if (itemsCache.length === 0) {
        alert("No items available!");
        return;
    }

    const options = itemsCache.map(i =>
        `<option value="${i.id}" data-price="${i.price}">
            ${i.id} - ${i.name}
        </option>`
    ).join("");

    const row = `
        <tr>
            <td>
                <select class="item-row modern-select">
                    <option value="">-- Select Item --</option>
                    ${options}
                </select>
            </td>
            <td class="price">0.00</td>
            <td>
                <input type="number" class="qty modern-input" min="1" value="1">
            </td>
            <td class="subtotal">0.00</td>
            <td>
                <button class="btn btn-danger-outline" onclick="deleteItemRow(this)">
                    X
                </button>
            </td>
        </tr>`;

    $("#order-item-list").append(row);
}

// ===============================
// ITEM SELECT CHANGE
// ===============================
$(document).on("change", ".item-row", function () {

    const row = $(this).closest("tr");
    const selected = $(this).find("option:selected");
    const price = parseFloat(selected.data("price")) || 0;

    row.find(".price").text(price.toFixed(2));

    updateSubTotal(row);
});

// ===============================
// QTY CHANGE
// ===============================
$(document).on("input", ".qty", function () {
    updateSubTotal($(this).closest("tr"));
});

// ===============================
// DELETE ROW
// ===============================
function deleteItemRow(btn) {
    $(btn).closest("tr").remove();
    updateGrandTotal();
}

// ===============================
// UPDATE SUBTOTAL
// ===============================
function updateSubTotal(row) {

    const price = parseFloat(row.find(".price").text()) || 0;
    const qty = parseInt(row.find(".qty").val()) || 0;

    const subtotal = price * qty;

    row.find(".subtotal").text(subtotal.toFixed(2));

    updateGrandTotal();
}

// ===============================
// UPDATE GRAND TOTAL
// ===============================
function updateGrandTotal() {

    let total = 0;

    $("#order-item-list .subtotal").each(function () {
        total += parseFloat($(this).text()) || 0;
    });

    $("#order-total").text(total.toFixed(2));
}

// ===============================
// CLEAR ALL
// ===============================
function clearItems() {
    $("#order-item-list").empty();
    $("#order-total").text("0.00");
    $("#order-date").val("");
    $("#order-customer").val("");
}

// ===============================
// SAVE ORDER (NO ID SENT)
// ===============================
function saveOrder() {

    const customerId = $("#order-customer").val();
    const date = $("#order-date").val();

    if (!customerId) {
        alert("Please select a customer!");
        return;
    }

    if (!date) {
        alert("Please select order date!");
        return;
    }

    const rows = $("#order-item-list tr");

    if (rows.length === 0) {
        alert("Add at least one item!");
        return;
    }

    const items = [];

    let valid = true;

    rows.each(function () {

        const itemId = $(this).find(".item-row").val();
        const qty = parseInt($(this).find(".qty").val());

        if (!itemId) {
            alert("Please select valid item!");
            valid = false;
            return false;
        }

        if (qty <= 0) {
            alert("Quantity must be greater than 0!");
            valid = false;
            return false;
        }

        items.push({ itemId, qty });
    });

    if (!valid) return;

    const orderData = {
        customerId: customerId,
        date: date,
        items: items
    };

    $.ajax({
        url: orderUrl,
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(orderData),

        success: function (response) {

            alert(response.message || "Order placed successfully!");

            clearItems();
            getAllOrders();
            loadItems(); // refresh stock
        },

        error: function (err) {

            if (err.responseJSON?.message) {
                alert(err.responseJSON.message);
            } else {
                alert("Order failed! Check stock or validation.");
            }

            console.log(err);
        }
    });
}
