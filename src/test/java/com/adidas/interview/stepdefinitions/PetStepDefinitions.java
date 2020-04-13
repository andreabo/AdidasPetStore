package com.adidas.interview.stepdefinitions;

import com.adidas.interview.assertions.CommonAssertion;
import com.adidas.interview.assertions.PetAssertion;
import com.adidas.interview.definitions.pets.PetRequest;
import com.adidas.interview.models.Pet;
import com.adidas.interview.utils.BuildPet;
import com.adidas.interview.utils.ReportPrint;
import cucumber.api.java.en.*;
import net.thucydides.core.annotations.Steps;

import java.util.ArrayList;

import static com.adidas.interview.utils.Helper.generateRandom;
import static com.adidas.interview.utils.Helper.generateRandomString;
import static com.adidas.interview.utils.SessionHelper.Session.*;
import static com.adidas.interview.utils.SessionHelper.getFromSession;
import static com.adidas.interview.utils.SessionHelper.setInSession;

public class PetStepDefinitions {

    @Steps
    PetRequest petRequest;

    @Steps
    CommonAssertion commonAssertion;

    @Steps
    ReportPrint report;

    @Steps
    BuildPet buildPet;

    @Steps
    PetAssertion petAssertion;

    @Given("I have {word} pet information")
    public void iHaveValidPetInformation(String infoType) {
        buildPet.by(infoType);
    }

    @Then("The service status code should be {int}")
    public void theServiceStatusCodeShouldBe(int statusCode) {
        commonAssertion.assertStatusCode(statusCode);
    }

    @When("I create a new pet")
    public void iCreateANewPet() {
        String pet = getFromSession(PET).toString();
        report.print("Pet: \n " + pet);
        petRequest.createPet(pet);
    }

    @When("I request for a pet")
    public void iRequestForAPet() {
        petRequest.findAPetById(426748);
    }

    @And("The response body should contains the new pet information")
    public void theResponseBodyShouldContainsTheNewPetInformation() {
        petAssertion.assertPetShouldBeEqualsTo(getFromSession(PET));
    }


    @And("Pet status is {word}")
    public void petStatusIs(String status) {
        Pet pet = getFromSession(PET);
        pet.setStatus(status);
        setInSession(PET, pet);
    }

    @Given("I have invalid pet information on {string}")
    public void iHaveInvalidPetInformationOnField(String field) {
        setInSession(PET, buildPet.invalidInfoBy(field));

    }


    @And("The message should be {string}")
    public void theMessageShouldBe(String errorMessage) {
        commonAssertion.assertErrorMessage(errorMessage);

    }

    @But("without {string}")
    public void without(String field) {
        buildPet.without(field);
    }

    @And("The response body should contains the new pet information without {string}")
    public void theResponseBodyShyouldContainsTheNewPetInformationWithout(String field) {
        if (field.equalsIgnoreCase("tags")) {
            Pet pet = (Pet) getFromSession(PET);
            pet.setTags(new ArrayList<>());
            setInSession(PET, pet);

        } else if (field.equalsIgnoreCase("photoUrls")) {
            Pet pet = (Pet) getFromSession(PET);
            pet.setPhotoUrls(new ArrayList<>());
            setInSession(PET, pet);
        }
        petAssertion.assertPetShouldBeEqualsTo(getFromSession(PET));

    }

    @Given("There is a pet already create")
    public void thereIsAPetAlreadyCreate() {
        iHaveValidPetInformation("valid");
        iCreateANewPet();
        commonAssertion.assertStatusCode(200);
    }

    @And("I have the pet {word}")
    public void iHaveThePetId(String id) {
        long petId = petRequest.getPetIdInResponse();
        setInSession(PET_ID, petId);
        report.print("Pet Id: " + petId);
    }

    @When("I request for the pet by {word}")
    public void iRequestForThePetById(String option) {
        petRequest.findAPetById(getFromSession(PET_ID));
    }

    @And("The response body should contains the pet information")
    public void theResponseBodyShouldContainsThePetInformation() {
        petAssertion.assertPetShouldBeEqualsTo(getFromSession(PET));
    }

    @When("I request for a non existed pet by id")
    public void iRequestForANonExistedPetById() {
        long id = generateRandom();
        if (id <= 0) {
            id = (id * (-1));
        }
        petRequest.findAPetById(id);
        report.print("Random ID: " + id);
    }

    @When("I request for a {word} pet by id")
    public void iRequestForANegativePetById(String type) {
        long id = generateRandom();
        if (id >= 0) {
            id = (id * (-1));
        }
        petRequest.findAPetById(id);
        report.print("Random ID: " + id);
    }

    @When("I request for a pet with an invalid id")
    public void iRequestForAPetWithAnInvalidId() {
        String invalidId = generateRandomString();
        petRequest.findAPetByInvalidId(invalidId);
        report.print("Invalid ID: " + invalidId);
    }

    @When("I create a new pet with same id")
    public void iCreateANewPetWithSameId() {
        buildPet.withSpecificId(getFromSession(PET_ID));
        petRequest.createPet(((Pet) getFromSession(PET_SAME_ID)).toString());
    }

    @Then("The pet already create should not change with the new one")
    public void thePetAlreadyCreateShouldNotChangeWithTheNewOne() {
        petRequest.findAPetById(getFromSession(PET_ID));
        petAssertion.assertPetShouldBeEqualsTo(getFromSession(PET));
    }

    @Given("There are pets already create with {word}")
    public void thereArePetsAlreadyCreateWith(String status) {
        for (int i = 0; i <= 5; i++) {
            petRequest.createPet(buildPet.with(status).toString());
            commonAssertion.assertStatusCode(200);
        }
    }

    @When("I request for pets {word}")
    public void iRequestForPets(String status) {
        petRequest.findPetsByStatus(status);
    }

    @And("All the pets should have {word} as status value")
    public void allThePetsShouldHaveAsStatusValue(String status) {
        for (Pet pet : petRequest.getPetsInResponse()) {
            petAssertion.assertPetStatusShouldBeEqualsTo(status, pet);
        }
    }

    @And("The response should contains a lists of pets")
    public void theResponseShouldContainsAListsOfPets() {
        petAssertion.assertPetListSizeShouldBeGreaterThan(1);
    }

    @When("I request for a invalid pets status")
    public void iRequestForAInvalidPetsStatus() {
        petRequest.findPetsByInvalidStatus(generateRandom());
    }

    @When("I request for a non existed pets status")
    public void iRequestForANonExistedPetsStatus() {
        petRequest.findPetsByStatus(generateRandomString());
    }

    @When("I delete the pet")
    public void iDeleteThePet() {
        petRequest.deletePetBy(getFromSession(PET_ID));
    }

    @And("The pet should be deleted")
    public void thePetShouldBeDeleted() {
        petRequest.findAPetById(getFromSession(PET_ID));
        commonAssertion.assertStatusCode(404);
        commonAssertion.assertErrorMessage("Pet not found");
    }

    @When("I request to delete a pet with a non existed id")
    public void iRequestToDeleteAPetWithANonExistedId() {
        petRequest.deletePetBy(generateRandom());
    }

    @When("I request to delete a pet with an invalid id")
    public void iRequestToDeleteAPetWithAnInvalidId() {
        petRequest.deletePetByInvalid(generateRandomString());
    }

    @And("I change the {word}")
    public void iChangeTheField(String field) throws CloneNotSupportedException {
        buildPet.update(field, getFromSession(PET));
        buildPet.updateStatus(getFromSession(PET));
    }

    @When("I update the pet")
    public void iUpdateThePet() {
        report.print(getFromSession(NEW_PET).toString());
        petRequest.updatePet(getFromSession(NEW_PET).toString());
    }

    @And("The pet {word} should be updated")
    public void thePetShouldBeUpdated(String field) {
        Pet pet = getFromSession(PET);
        petAssertion.assertPetIdShouldBeEqualsTo(pet.getId());
        petAssertion.assertFieldShouldNotBeEqualsTo(pet, field);
        petAssertion.assertPetShouldNotBeEqualsTo(pet);
    }

    @And("I have an non existed status")
    public void iHaveAnNonExistedStatus() throws CloneNotSupportedException {
        buildPet.updateStatus(getFromSession(PET));
    }
}
