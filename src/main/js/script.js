function choice(){
    var choice = document.getElementById("func").value;
    if (choice === "POST") {
        window.location.replace("../html/insert.html");
    } else if (choice === "GET") {
        window.location.replace("../html/fetch.html");
    } else if (choice === "PUT") {
        window.location.replace("../html/update.html");
    } else if (choice === "DELETE") {
        window.location.replace("../html/delete.html"); 
    }else{
        window.location.replace("../html/error.html");
    }
}