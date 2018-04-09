function validateLogin() {

    var username, password, text;
    //Get value from input field id = "Username" and id = "Password"
    username = document.getElementById("username").value;
    password = document.getElementById("password").value;
    //If username and password is null
    if (username === "" || username.length === 0) {
        text = "ERROR: Username is required.";
        document.getElementById("alert-error").innerHTML = text;
        document.getElementById("alert-error").className = "alert error";
        document.getElementById("username").focus();
        return false;
    }

    if (password === "" || password.length === 0) {
        text = "ERROR: Password is required.";
        document.getElementById("alert-error").innerHTML = text;
        document.getElementById("alert-error").className = "alert error";
        document.getElementById("password").focus();
        return false;
    }
    return true;
}

function validateRegister() {
    var email, phone, confirm_password, text;
    phone = document.getElementById("phone").value;
    email = document.getElementById("email").value;
    confirm_password = document.getElementById("confirm_password").value;

    if (!validateLogin()) {
        return false;
    }

    if (confirm_password !== document.getElementById("password").value || confirm_password.length === 0) {
        text = "ERROR: Confirm password not match.";
        document.getElementById("alert-error").innerHTML = text;
        document.getElementById("alert-error").className = "alert error";
        document.getElementById("confirm_password").focus();
        return false;
    }

    if (email === "" || email.length === 0) {
        text = "ERROR: Email is required.";
        document.getElementById("alert-error").innerHTML = text;
        document.getElementById("alert-error").className = "alert error";
        document.getElementById("email").focus();
        return false;
    }

    if (phone === "" || phone.length === 0) {
        text = "ERROR: Phone is required.";
        document.getElementById("alert-error").innerHTML = text;
        document.getElementById("alert-error").className = "alert error";
        document.getElementById("phone").focus();
        return false;
    }

    if (phone.length > 12 || phone.length < 11) {
        text = "ERROR: Phone number is between 11 and 12 number.";
        document.getElementById("alert-error").innerHTML = text;
        document.getElementById("alert-error").className = "alert error";
        document.getElementById("phone").focus();
        return false;
    }
}

function validateCreateTour() {
    var tourname, price, description, image, id, chekCategory, start, arrival, max, date;
    var check = false;
    id = document.getElementById("id").value;
    tourname = document.getElementById("tourname").value;
    price = document.getElementById("price").value;
    description = document.getElementById("description").value;
    image = document.getElementById("image").value;
    chekCategory = document.getElementsByName("chekCategory");
    start = document.getElementById("start").value;
    arrival = document.getElementById("arrival").value;
    max = document.getElementById("max").value;
    date = document.getElementById("date").value;

    if (id === "" || id.length === 0) {
        text = "ERROR: ID is required";
        document.getElementById("alert-error").innerHTML = text;
        document.getElementById("alert-error").className = "alert error";
        document.getElementById("id").focus();
        return false;
    }

    if (tourname === "" || tourname.length === 0) {
        text = "ERROR: Tour name is required";
        document.getElementById("alert-error").innerHTML = text;
        document.getElementById("alert-error").className = "alert error";
        document.getElementById("tourname").focus();
        return false;
    }

    if (start === "" || start.length === 0) {
        text = "ERROR: Start is required";
        document.getElementById("alert-error").innerHTML = text;
        document.getElementById("alert-error").className = "alert error";
        document.getElementById("start").focus();
        return false;
    }

    if (arrival === "" || arrival.length === 0) {
        text = "ERROR: Arrival is required";
        document.getElementById("alert-error").innerHTML = text;
        document.getElementById("alert-error").className = "alert error";
        document.getElementById("arrival").focus();
        return false;
    }

    if (max === "" || max.length === 0) {
        text = "ERROR: Max customer is required";
        document.getElementById("alert-error").innerHTML = text;
        document.getElementById("alert-error").className = "alert error";
        document.getElementById("max").focus();
        return false;
    }

    if (price === "" || price.length === 0) {
        text = "ERROR: Price is required";
        document.getElementById("alert-error").innerHTML = text;
        document.getElementById("alert-error").className = "alert error";
        document.getElementById("price").focus();
        return false;
    }

    if (description === "" || description.length === 0) {
        text = "ERROR: Description is required";
        document.getElementById("alert-error").innerHTML = text;
        document.getElementById("alert-error").className = "alert error";
        document.getElementById("description").focus();
        return false;
    }

    if (date === "" || date.length === 0) {
        text = "ERROR: Please choose a date";
        document.getElementById("alert-error").innerHTML = text;
        document.getElementById("alert-error").className = "alert error";
        document.getElementById("date").focus();
        return false;
    }
    for (var i = 0, l = chekCategory.length; i < l; i++) {
        check = false;
        if (chekCategory[i].checked) {
            check = true;
            break;
        }
    }
    if (!check) {
        text = "ERROR: Please check aleast 1 category.";
        document.getElementById("alert-error").innerHTML = text;
        document.getElementById("alert-error").className = "alert error";
        return false;
    }

    if (image === "" || image.length === 0) {
        text = "ERROR: Image is required";
        document.getElementById("alert-error").innerHTML = text;
        document.getElementById("alert-error").className = "alert error";
        document.getElementById("image").focus();
        return false;
    }
    return true;
}

function validateCreateTourCategory() {
    var id, name;
    id = document.getElementById("id").value;
    name = document.getElementById("name").value;

    if (id === "" || id.length === 0) {
        text = "ERROR: Id is required";
        document.getElementById("alert-error").innerHTML = text;
        document.getElementById("alert-error").className = "alert error";
        document.getElementById("id").focus();
        return false;
    }

    if (name === "" || name.length === 0) {
        text = "ERROR: Name is required";
        document.getElementById("alert-error").innerHTML = text;
        document.getElementById("alert-error").className = "alert error";
        document.getElementById("name").focus();
        return false;
    }
    return true;
}

function validateSearch() {
    var search;
    search = document.getElementById("search").value;
    if (search === "" || search.length === 0) {
        text = "ERROR: Search can't be blank";
        document.getElementById("alert-error").innerHTML = text;
        document.getElementById("alert-error").className = "alert error white";
        document.getElementById("search").focus();
        return false;
    }
    return true;
}

function validateUpdateTour() {
    var tourname, price, description, id, chekCategory, start, arrival, max, date;
    var check = false;
    id = document.getElementById("id").value;
    tourname = document.getElementById("tourname").value;
    price = document.getElementById("price").value;
    description = document.getElementById("description").value;
    chekCategory = document.getElementsByName("chekCategory");
    start = document.getElementById("start").value;
    arrival = document.getElementById("arrival").value;
    max = document.getElementById("max").value;
    date = document.getElementById("date").value;

    if (id === "" || id.length === 0) {
        text = "ERROR: ID is required";
        document.getElementById("alert-error").innerHTML = text;
        document.getElementById("alert-error").className = "alert error";
        document.getElementById("id").focus();
        return false;
    }

    if (tourname === "" || tourname.length === 0) {
        text = "ERROR: Tour name is required";
        document.getElementById("alert-error").innerHTML = text;
        document.getElementById("alert-error").className = "alert error";
        document.getElementById("tourname").focus();
        return false;
    }

    if (start === "" || start.length === 0) {
        text = "ERROR: Start is required";
        document.getElementById("alert-error").innerHTML = text;
        document.getElementById("alert-error").className = "alert error";
        document.getElementById("start").focus();
        return false;
    }

    if (arrival === "" || arrival.length === 0) {
        text = "ERROR: Arrival is required";
        document.getElementById("alert-error").innerHTML = text;
        document.getElementById("alert-error").className = "alert error";
        document.getElementById("arrival").focus();
        return false;
    }

    if (max === "" || max.length === 0) {
        text = "ERROR: Max customer is required";
        document.getElementById("alert-error").innerHTML = text;
        document.getElementById("alert-error").className = "alert error";
        document.getElementById("max").focus();
        return false;
    }

    if (price === "" || price.length === 0) {
        text = "ERROR: Price is required";
        document.getElementById("alert-error").innerHTML = text;
        document.getElementById("alert-error").className = "alert error";
        document.getElementById("price").focus();
        return false;
    }

    if (description === "" || description.length === 0) {
        text = "ERROR: Description is required";
        document.getElementById("alert-error").innerHTML = text;
        document.getElementById("alert-error").className = "alert error";
        document.getElementById("description").focus();
        return false;
    }

    if (date === "" || date.length === 0) {
        text = "ERROR: Please choose a date";
        document.getElementById("alert-error").innerHTML = text;
        document.getElementById("alert-error").className = "alert error";
        document.getElementById("date").focus();
        return false;
    }
    for (var i = 0, l = chekCategory.length; i < l; i++) {
        check = false;
        if (chekCategory[i].checked) {
            check = true;
            break;
        }
    }
    if (!check) {
        text = "ERROR: Please check aleast 1 category.";
        document.getElementById("alert-error").innerHTML = text;
        document.getElementById("alert-error").className = "alert error";
        document.getElementById("id").focus();
        return false;
    }
    return true;
}
