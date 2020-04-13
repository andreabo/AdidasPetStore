# AdidasPetStore
Adidas Interview - Carol Bohorquez

# Requirements
1. Maven and Java installed and configured

# How to Run
To execute the tests just clone the project and if all the requirements are done, go to the root folder of the clone project and type 'mvn clean verify' this will run all the tests.

# Report 
When the execution finishes you can find the project on {PROJECT_DIRECTORY}/target/site/serenity/index.html.

# Approach

## Tools
For this solution I decided to create an automation framework using Java as programming language, also I’m using Serenity to the reports. I used Cucumber to implement the Test cases wrote on Gherkin, and to manage  the Rest API requests I used RestAssured.

The reason to choose these tools stack is because I have more experience using this combination of tools, so for a 4 days challenge , I feel  comfortable to use the tools that I already know.

## API choice:
The user API has operations that can be performed with the user, but these operations are not related to the other APIs, likewise, the other APIs are not related to information regarding a user in order to function, for this reason, from a business perspective and considering the priorities, the user API is not critical to the operation of PetStore.

Store API is related to the pet's information, therefore, the pet's information must exist to be able to use the services of “/ store / order” and “/ store / inventory”, however, it is in exploratory tests that I made to understand better the APIS I could see that an order can be created with a request that does not exist, more however I find that the Pets API is necessary for the Store api to work correctly, that's why I chose the Pets api as API criticizes for testing.
