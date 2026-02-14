const baseUrl = "http://localhost:8080/api/v1/item";

$(document).ready(function () {
    getAllItems();
});

function saveItem() {

    const name = $('#itemName').val().trim();
    const qty = parseInt($('#itemQty').val());
    const price = parseFloat($('#itemPrice').val());

    if (!name) {
        alert("Item name is required!");
        return;
    }

    if (qty < 0) {
        alert("Quantity cannot be negative!");
        return;
    }

    if (price <= 0) {
        alert("Price must be positive!");
        return;
    }

    $.ajax({
        url: baseUrl,
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({ name, qty, price }),
        success: function (response) {
            alert(response.message);
            getAllItems();
            clearItem();
        },
        error: function (error) {
            showError(error);
        }
    });
}

function updateItem() {

    const id = $('#itemId').val();
    const name = $('#itemName').val().trim();
    const qty = parseInt($('#itemQty').val());
    const price = parseFloat($('#itemPrice').val());

    if (!id) {
        alert("Select item first!");
        return;
    }

    $.ajax({
        url: baseUrl,
        method: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify({ id, name, qty, price }),
        success: function (response) {
            alert(response.message);
            getAllItems();
            clearItem();
        },
        error: function (error) {
            showError(error);
        }
    });
}


function deleteItem() {

    const id = $('#itemId').val();

    if (!id) {
        alert("Select item first!");
        return;
    }

    $.ajax({
        url: baseUrl + "/" + id,
        method: 'DELETE',
        success: function (response) {
            alert(response.message);
            getAllItems();
            clearItem();
        },
        error: function (error) {
            showError(error);
        }
    });
}


function getAllItems() {

    $('#item-list').empty();

    $.ajax({
        url: baseUrl,
        method: 'GET',
        success: function (response) {

            for (let item of response) {

                const row =
                    `<tr onclick="selectItem('${item.id}','${item.name}',${item.qty},${item.price})">
                        <td>${item.id}</td>
                        <td>${item.name}</td>
                        <td>${item.qty}</td>
                        <td>${item.price}</td>
                    </tr>`;

                $('#item-list').append(row);
            }
        },
        error: function () {
            alert("Failed to load items!");
        }
    });
}


function selectItem(id, name, qty, price) {
    $('#itemId').val(id);
    $('#itemName').val(name);
    $('#itemQty').val(qty);
    $('#itemPrice').val(price);
}


function clearItem() {
    $('#itemId').val('');
    $('#itemName').val('');
    $('#itemQty').val('');
    $('#itemPrice').val('');
}


function showError(error) {

    if (error.responseJSON && error.responseJSON.data) {

        let messages = "";

        for (let key in error.responseJSON.data) {
            messages += error.responseJSON.data[key] + "\n";
        }

        alert(messages);

    } else if (error.responseJSON) {
        alert(error.responseJSON.message);
    } else {
        alert("Something went wrong!");
    }
}
