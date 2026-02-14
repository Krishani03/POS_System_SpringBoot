const baseUrl = "http://localhost:8080/api/v1/customer";

$(document).ready(function () {
    getAllCustomer();
});

function saveCustomer() {

    const name = $('#name').val();
    const address = $('#address').val();

    $.ajax({
        url: baseUrl,
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({ name, address }),
        success: function (response) {
            alert(response.message);
            getAllCustomer();
            clearCustomer();
        },
        error: function (error) {
            showError(error);
        }
    });
}

function updateCustomer() {

    const id = $('#id').val();
    const name = $('#name').val();
    const address = $('#address').val();

    if (!id) {
        alert("Select customer first!");
        return;
    }

    $.ajax({
        url: baseUrl,
        method: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify({ id, name, address }),
        success: function (response) {
            alert(response.message);
            getAllCustomer();
            clearCustomer();
        },
        error: function (error) {
            showError(error);
        }
    });
}

function deleteCustomer() {

    const id = $('#id').val();

    if (!id) {
        alert("Select customer first!");
        return;
    }

    $.ajax({
        url: baseUrl + "/" + id,
        method: 'DELETE',
        success: function (response) {
            alert(response.message);
            getAllCustomer();
            clearCustomer();
        },
        error: function (error) {
            showError(error);
        }
    });
}

function getAllCustomer() {

    $('#customer-list').empty();

    $.ajax({
        url: baseUrl,
        method: 'GET',
        success: function (response) {

            for (let customer of response) {

                const row =
                    `<tr onclick="selectCustomer('${customer.id}','${customer.name}','${customer.address}')">
                        <td>${customer.id}</td>
                        <td>${customer.name}</td>
                        <td>${customer.address}</td>
                    </tr>`;

                $('#customer-list').append(row);
            }
        }
    });
}

function selectCustomer(id, name, address) {
    $('#id').val(id);
    $('#name').val(name);
    $('#address').val(address);
}

function clearCustomer() {
    $('#id').val('');
    $('#name').val('');
    $('#address').val('');
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
