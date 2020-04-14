# Test notes
This document contains bugs found, confusion with some APIs, some skipped tests, endpoints covered.

### Total Test Cases: 31

# Bug found:

## Store:
* It is possible to create an order with a petId that does not exist
* The service to create an order also allows updating it.
* it is possible to create an order with an existing orderId

## Pets

### Create:
* For the service to create a new pet, if the fields id, category, photosUrl and tags are sent with a different format, the api responds with a status 500, for this type of cases, the correct status code must be 400 Bad Request. Test case related C03-Create a pet with invalid data 
* The status field accept values other than available, pending, sold. Test case related **C06-Create a pet with a status different to the existed**
* It is possible to create a pet with the same id, overwriting the previous existing pet with the new values. Test case related **C07-Create a pet with an existed id**
* It is possible to create a pet without status. Test case related. **C05-Create a pet without status**

### Delete:
* When sending an id as string and / or with special characters, the service returns in the response message an uncontrolled excepecions. Test case related **D03-Delete a pet with an invalid id.** 
  > "java.lang.NumberFormatException: For input string: \"db.pets.drop()\""
* When trying to delete a pet that does not exist, the service responds with a status code 404, but without a response body. Test case related **D02-Delete a pet with a non existed id**

### Find:
* When looking for a pet by an id with an invalid format, the service responds with a 404 error and with an unhandled exception. Test case related **F04-Find a pet with a invalid id.**
  > "java.lang.NumberFormatException: For input string: \"Ruthanne\""
* It is possible to search for an invalid status. Test case related **F06-Find pets by a invalid status.**
*. It is possible to search for an status that does not exist. Test case related **F07-Find pets by a non existed status.**

### Update:
* It is possible to update the status with a value that does not exist or that is different to “*available, pending, sold*”. Test case related **U02-Update a pet with a non existed status**

# Confusion / Questions

## Pets:

### UploadImage:
* The information that is uploaded by the upload Image service is not displayed when the pet is consulted. What is this service used for?

# Skipped

* Pruebas de seguridad con inyección sql. Mi enfoque para hacer esta prueba fue incluir en el cuerpo de la mascota algunas oraciones sql, sobre el nombre, las categorías, el estado, sin embargo, hace un tiempo no estaba realizando este tipo de pruebas, por lo que preferí priorizar la prueba funcional.
* I didn't include test over endpoint pet/{pet Id} using method post, because it was really similar to the service to update a pet, I found redundant this service and preferred to skip it

# End Point tested:

| Method | Path |
| ------ | ------ |
| post   | /pet |
| put    | /pet |
| delete | /pet |
| get    | pet/{petId} |
| get    | pet/findByStatus |

## Not included:

| Method | Path |
| ------ | ------ |
| post |  /pet/{petId}/uploadImage |
| post |  /pet/{petId}  |


