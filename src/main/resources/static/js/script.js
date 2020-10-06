$(document).ready(function () {
    loadUsers();
});

function showUsers(users) {
    let html = '<tr>\n' +
        '        <th class="col">User id</th>\n' +
        '        <th class="col">User name</th>\n' +
        '        <th class="col">User login</th>\n' +
        '        <th class="col">User email</th>\n' +
        '        <th class="col">Delete</th>\n' +
        '    </tr>';

    console.table(users);

    for (let i = 0; i < users.length; i++) {
        let user = users[i];
        html = html + '<tr><td>' + user.id + '</td>\n' +
            '        <td>' + user.name + '</td>\n' +
            '        <td>' + user.login + '</td>\n' +
            '        <td>' + user.email + '</td>' +
            '        <td><button onclick="deleteUser(' + user.id + ')">Delete</button></td></tr>';
    }

    document.getElementById("usersList").innerHTML = html;
}

function loadUsers() {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            let users = JSON.parse(this.responseText);
            showUsers(users);

        }
    };
    xhttp.open("GET", "/users/findAll", true);
    xhttp.send();
}

function createUser() {
    let userName  = document.getElementById("user_name").value;
    let userLogin = document.getElementById("user_login").value;
    let userEmail = document.getElementById("user_email").value;

    let xmlhttp = new XMLHttpRequest();   // new HttpRequest instance
    xmlhttp.open("POST", "/users/save");
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify({name: userName, login: userLogin, email: userEmail}));

    xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            loadUsers();
        }
    };
}

function searchByLogin() {
    let login = document.getElementById("search_field").value;
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            let answer = this.responseText;

            if (answer === "") {
                alert("Users not found!");
            } else {
                console.log(this.responseText)
                let user = JSON.parse(this.responseText);
                showUsers([user]);
            }
        }
    };
    xhttp.open("GET", "/users/findByLogin?login=" + login, true);
    xhttp.send();
}

function deleteUser(userId) {
    let xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", "/users/delete/" + userId, true);
    xhttp.send();
    loadUsers();
}
