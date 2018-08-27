# LSG Project

## Objective

Help the group to organize the event, monitor some data that are vital in improving the team’s events.


*Note: The data type with asterisk(*) are required data.*

# REGISTRATION MODULE

## ADD GUEST API

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
* **middleName** – The middle name of the invited guest (if available).
* **lastName** – The last name of the invited guest.
* **age** – The age of the invited guest.
* **address** – The address of the invited guest.
* **mobileNo** – The mobile number of the invited guest.
* **email** – The email address of the invited guest.
* **invitedBy** – The C3 team member who invited the guest.

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



## GET GUEST API

### LINK: http://IP:port/lsg/registration/getGuests

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
            "invitedBy": String
        }
    ]
}
```
* **code** – The status code.
* **title**– The status title.
* **message** – The description of response.

* **id** – The id of the Guest.
* **name** – The name of the Guest.
* **age** – The age of the Guest.
* **address** – The address of the Guest.
* **mobileNo** – The mobile number of the Guest.
* **email** – The email address of the Guest(nullable).
* **invitedBy** – The member who invites the guest (nullable).



## ADD MEMBER API

### LINK: http://IP:port/lsg/registration/addMember

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



## GET MEMBER API

### LINK: http://IP:port/lsg/registration/getMembers

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

* **id** – The id of the Member.
* **firstName** – The first name of the member. 
* **middleName** – The middle name of the member.(nullable)
* **lastName** – The last name of the member.

