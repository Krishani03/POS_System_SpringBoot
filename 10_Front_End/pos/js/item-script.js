const baseUrl = "http://localhost:8080/api/v1/item";

$(document).ready(function () {
    getAllItem();
});

function saveItem() {

    const name = $('#name').val();
    const qty = $('#qty').val();
    const price = $('#price').val();

    $.ajax({
        url: baseUrl,
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({ name, qty, price }),
        success: function (response) {
            alert(response.message);
            getAllItem();
            clearItem();
        },
        error: function (error) {
            showError(error);
        }
    });
}

function updateItem() {

    const id = $('#id').val();
    const name = $('#name').val();
    const qty = $('#qty').val();
    const price = $('#price').val();

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
            getAllItem();
            clearItem();
        },
        error: function (error) {
            showError(error);
        }
    });
}

function deleteItem() {

    const id = $('#id').val();

    if (!id) {
        alert("Select item first!");
        return;
    }

    $.ajax({
        url: baseUrl + "/" + id,
        method: 'DELETE',
        success: function (response) {
            alert(response.message);
            getAllItem();
            clearItem();
        },
        error: function (error) {
            showError(error);
        }
    });
}

function getAllItem() {

    $('#item-list').empty();

    $.ajax({
        url: baseUrl,
        method: 'GET',
        success: function (response) {

            for (let item of response) {

                const row =
                    `<tr onclick="selectItem('${item.id}','${item.name}','${item.qty}','${item.price}')">
                        <td>${item.id}</td>
                        <td>${item.name}</td>
                        <td>${item.qty}</td>
                        <td>${item.price}</td>
                    </tr>`;

                $('#item-list').append(row);
            }
        }
    });
}

function selectItem(id, name, qty, price) {
    $('#id').val(id);
    $('#name').val(name);
    $('#qty').val(qty);
    $('#price').val(price);
}

function clearItem() {
    $('#id').val('');
    $('#name').val('');
    $('#qty').val('');
    $('#price').val('');
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
