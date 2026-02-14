const orderUrl = "http://localhost:8080/api/v1/order";
const customerUrl = "http://localhost:8080/api/v1/customer";
const itemUrl = "http://localhost:8080/api/v1/item";

let cart = [];

$(document).ready(function () {
    loadCustomers();
    loadItems();
    loadOrderHistory();
});


function loadCustomers() {

    $.get(customerUrl, function (customers) {

        $('#customerSelect').empty();

        for (let c of customers) {
            $('#customerSelect').append(
                `<option value="${c.id}">${c.id} - ${c.name}</option>`
            );
        }
    });
}


function loadItems() {

    $.get(itemUrl, function (items) {

        $('#itemSelect').empty();

        for (let i of items) {
            $('#itemSelect').append(
                `<option value="${i.id}">${i.id} - ${i.name} (Stock: ${i.qty})</option>`
            );
        }
    });
}


function addToCart() {

    const itemId = $('#itemSelect').val();
    const qty = parseInt($('#orderQty').val());

    if (!itemId || qty <= 0) {
        alert("Select item and enter valid qty");
        return;
    }

    cart.push({ itemId, qty });

    renderCart();
    $('#orderQty').val('');
}


function renderCart() {

    $('#cartTable').empty();

    cart.forEach((item, index) => {

        const row =
            `<tr>
                <td>${item.itemId}</td>
                <td>${item.qty}</td>
                <td>
                    <button onclick="removeFromCart(${index})">Remove</button>
                </td>
            </tr>`;

        $('#cartTable').append(row);
    });
}


function removeFromCart(index) {
    cart.splice(index, 1);
    renderCart();
}


function placeOrder() {

    const customerId = $('#customerSelect').val();
    const date = $('#orderDate').val();

    if (!customerId || !date) {
        alert("Customer and date required!");
        return;
    }

    if (cart.length === 0) {
        alert("Add at least one item!");
        return;
    }

    const orderData = {
        customerId,
        date,
        items: cart
    };

    $.ajax({
        url: orderUrl,
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(orderData),
        success: function (response) {
            alert(response.message);
            cart = [];
            renderCart();
            loadOrderHistory();
            loadItems(); // refresh stock
        },
        error: function (error) {

            if (error.responseJSON && error.responseJSON.message) {
                alert(error.responseJSON.message);
            } else {
                alert("Order failed!");
            }
        }
    });
}


function loadOrderHistory() {

    $('#orderHistory').empty();

    $.get(orderUrl, function (orders) {

        for (let o of orders) {

            const row =
                `<tr>
                    <td>${o.id}</td>
                    <td>${o.customerId}</td>
                    <td>${o.date}</td>
                    <td>${o.total}</td>
                </tr>`;

            $('#orderHistory').append(row);
        }
    });
}
