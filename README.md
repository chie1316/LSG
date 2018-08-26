# LSG Project

## Objective

Help the group to organize the event, monitor some data that are vital in improving the team’s events.

```
Give examples
```
### REGISTRATION

### ADD GUEST

### LINK: http://<ip>:<port>/lsg/registration/addGuest

### REQUEST:
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

firstName – The first name of the invited guest.
middleName – The middle name of the invited guest (if available).
lastName – The last name of the invited guest.
age – The age of the invited guest.
address – The address of the invited guest.
mobileNo – The mobile number of the invited guest.
email – The email address of the invited guest.
invitedBy – The C3 team member who invited the guest.

### RESPONSE:
{
    "code": int,
    "title": String,
    "message": String
}
code – The status code.
title – The status title.
message – The description of response.
