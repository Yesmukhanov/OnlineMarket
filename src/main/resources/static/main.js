
function loadUsers(){

    const httpRequest = new XMLHttpRequest();
    httpRequest.open("GET", "/admin", true);

    httpRequest.onreadystatechange = function (){
        if (httpRequest.readyState === XMLHttpRequest.DONE && httpRequest.status === 200){

            let userList = JSON.parse(httpRequest.responseText);

            let tableContent = "";
            for (let i = 0; i < userList.length; i++){
                let id = userList[i].id;
                tableContent += "<tr>";
                tableContent += "<td>" + userList[i].id + "</td>";
                tableContent += "<td>" + userList[i].email + "</td>";
                tableContent += "<td>" + userList[i].fullName + "</td>";
                tableContent += "<td><button class='btn btn-primary btn-sm' onclick='getUser(" + userList[i].id + ")'>Details</button></td>";
                tableContent += "</tr>";
            }
            document.getElementById("userListBody").innerHTML = tableContent;
        }
    };

    httpRequest.send();
}

function getUser(id){
    window.open("/details/" + id, "_self");

    const http = new XMLHttpRequest();

    http.open("GET", "admin/" + id, true);

    let email = document.getElementById("email");
    let fullName = document.getElementById("fullName");
    let status = document.getElementById("status");
    let role = document.getElementById("role");

    http.onreadystatechange = function (){
        if (http.readyState === XMLHttpRequest.DONE && http.status === 200){
            let result = JSON.parse(http.responseText);

            email.value = result.email;
            fullName.value = result.fullName;
            status.value = result.status;
            role.value = result.role;

        }
    }

    http.send();

}