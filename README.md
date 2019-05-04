# LSG Project

## Objective

Help the group to organize the event, monitor some data that are vital in improving the team’s events.


*Note: The data type with asterisk(*) are required data.*

# REGISTRATION MODULE

## ADD GUEST API (POST)

### LINK: http://IP:port/lsg/registration/addGuest

### REQUEST:
```
{
	"firstName": String*, 
	"middleName": String,
	"lastName": String*,
	"age": int*,
	"address": String*,
	"mobileNo": String*,
	"email": String,
	"invitedBy": String
}
```
* **firstName** – The first name of the invited guest.
* **middleName** – The middle name of the invited guest.
* **lastName** – The last name of the invited guest.
* **age** – The age of the invited guest.
* **address** – The address of the invited guest.
* **mobileNo** – The mobile number of the invited guest.
* **email** – The email address of the invited guest.
* **invitedById** – The id of member who invited the guest.

### RESPONSE:
```
{
    "code": int,
    "title": String,
    "message": String
}
```
* **code** – The status code.
* **title** – The status title.
* **message** – The description of response.



## GET GUESTS API (GET)

### LINK: http://IP:port/lsg/registration/getGuests

### HEADERS:
```
Content-Type: application/json
```

### REQUEST:
```
N/A
```

### RESPONSE:
```
{
    "code": int,
    "title": String,
    "message": String,
    "data": [
        {
            "id": String,
            "name": String,
            "age": int,
            "address": String
            "mobileNo": String,
            "email": String,
            "invitedBy": {
             	"id": String,
                "name": String
            }
        }
    ]
}
```
* **code** – The status code.
* **title**– The status title.
* **message** – The description of response.
* **data** – Contains list of Guests and its details.

* **id** – The id of the Guest.
* **name** – The name of the Guest.
* **age** – The age of the Guest.
* **address** – The address of the Guest.
* **mobileNo** – The mobile number of the Guest.
* **email** – The email address of the Guest.
* **invitedBy** – Contains details of the member who invited the guest.

* **id** – The id of the Member.
* **name** – The Name of the Member.



## UPDATE GUEST API (UPDATE)

### LINK: http://IP:port/lsg/registration/updateGuest

### HEADERS:
```
Content-Type: application/json
```

### REQUEST:
```
{
	"id":String,
	"firstName":String,
	"middleName":String,
	"lastName":String,
	"age":int,
	"address":String,
	"mobileNo":String,
	"email":String,
	"invitedById":String
}
```
* **id** – The id of the Guest.
* **firstName** – The firstName of the Guest.
* **middleName** – The middleName of the Guest.
* **lastName** – The lastName of the Guest.
* **age** – The age of the Guest.
* **address** – The address of the Guest.
* **mobileNo** – The mobile number of the Guest.
* **email** – The email of the Guest.
* **invitedById** – The id of the Member who invited the Guest.

### RESPONSE:
```
{
    "code": int,
    "title": String,
    "message": String,
}
```
* **code** – The status code.
* **title**– The status title.
* **message** – The description of response.



## GET GUEST DETAILS BY ID (GET)

### LINK: http://localhost:8080/lsg/registration/getGuestDetailsById?id=<id>
*Note: The <id> indicated in the link was the Guest's id query parameter.*

### HEADERS:
```
Content-Type: application/json
```

### REQUEST:
```
N/A
```

### RESPONSE:
```
{
    "code": int,
    "title": String,
    "message": String,
    "data": {
        "id": String,
        "firstName": String,
        "middleName": String,
        "lastName": String,
        "age": int,
        "address": String,
        "mobileNo": String,
        "email": String,
        "invitedBy": {
            "id": String,
            "name": String
        }
    }
}
```
* **code** – The status code.
* **title**– The status title.
* **message** – The description of response.
* **data** – Contains details of the Guest.

* **id** – The id of the Guest.
* **firstName** – The firstName of the Guest.
* **middleName** – The middleName of the Guest.
* **lastName** – The lastName of the Guest.
* **age** – The age of the Guest.
* **address** – The address of the Guest.
* **mobileNo** – The mobile number of the Guest.
* **email** – The email of the Guest.
* **invitedBy** – Contains details of the member who invited the guest.

* **id** – The id of the Member.
* **name** – The Name of the Member.



## REMOVE GUEST (DELETE)

### LINK: http://localhost:8080/lsg/registration/removeGuest?id=<id>
*Note: The <id> indicated in the link was the Guest's id query parameter.*

### HEADERS:
```
Content-Type: application/json
```

### REQUEST:
```
N/A
```

### RESPONSE:
```
{
    "code": int,
    "title": String,
    "message": String,
}
```
* **code** – The status code.
* **title**– The status title.
* **message** – The description of response.



# MEMBER MODULE

## ADD MEMBER API (POST)

### LINK: http://IP:port/lsg/registration/addMember

### HEADERS:
```
Content-Type: application/json
```

### REQUEST:
```
{
	"firstName":String*,
	"middleName": String,
	"lastName": String*
}
```

### RESPONSE:
```
{
    "code": int,
    "title": String,
    "message": String,
}
```
* **code** – The status code.
* **title**– The status title.
* **message** – The description of response.



## GET MEMBERS API (GET)

### LINK: http://IP:port/lsg/registration/getMembers

### HEADERS:
```
Content-Type: application/json
```

### REQUEST:
```
N/A
```

### RESPONSE:
```
{
    "code": int,
    "title": String,
    "message": String,
    "data": [
        {
            "id": String, 
            "firstName": String,
            "middleName": String,
            "lastName": String
        }
    ]
}
```
* **code** – The status code.
* **title** – The status title.
* **message** – The description of response.
* **data** – Contains details of the Member.

* **id** – The id of the Member.
* **firstName** – The first name of the member. 
* **middleName** – The middle name of the member.
* **lastName** – The last name of the member.

