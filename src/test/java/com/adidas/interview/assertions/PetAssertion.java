package com.adidas.interview.assertions;

import com.adidas.interview.definitions.pets.PetRequest;
import com.adidas.interview.models.Pet;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import static org.assertj.core.api.Assertions.assertThat;

public class PetAssertion {

    @Steps
    PetRequest petRequest;

    @Step("The list size should be greater than {0}")
    public void assertPetListSizeShouldBeGreaterThan(int size) {
        assertThat(petRequest.getPetsInResponse().size()).isGreaterThan(size);
    }

    @Step("The Pet status should be equals to {0}")
    public void assertPetStatusShouldBeEqualsTo(String status, Pet pet) {
        assertThat(pet.getStatus())
                .withFailMessage("Expected status: %s , but was: %s", status, pet.getStatus())
                .isEqualTo(status);
    }

    @Step("The Pet should be equals to {0}")
    public void assertPetShouldBeEqualsTo(Pet pet) {
        assertThat(petRequest.petInResponse().toString())
                .withFailMessage("Expected pet: %s , but was: %s", pet.toString(), petRequest.petInResponse().toString())
                .isEqualTo(pet.toString());
    }

    @Step("The Pet should not be equals to {0}")
    public void assertPetShouldNotBeEqualsTo(Pet pet) {
        assertThat(petRequest.petInResponse().toString())
                .withFailMessage("Expected pet: %s , but was: %s", pet.toString(), petRequest.petInResponse().toString())
                .isNotEqualTo(pet.toString());
    }

    @Step("The Pet ID should not be equals to {0}")
    public void assertPetIdShouldBeEqualsTo(long id) {
        assertThat(petRequest.petInResponse().getId())
                .withFailMessage("Expected pet: %s , but was: %s", id, petRequest.petInResponse().getId())
                .isEqualTo(id);

    }

    public void assertFieldShouldNotBeEqualsTo(Pet pet, String field) {
        switch (field) {
            case "name":
                assertPetNameShouldNotBeEqualsTo(pet.getName());
                break;
            case "category":
                assertPetCategoryShouldNotBeEqualsTo(pet.getCategory().toString());
                break;
            case "tags":
                assertPetTagsShouldNotBeEqualsTo(pet.getTags().toString());
                break;
            case "photoUrls":
                assertPetTagsShouldNotBeEqualsTo(pet.getPhotoUrls().toString());
                break;
            case "status":
                assertPetStatusShouldNotBeEqualsTo(pet.getStatus());
                break;
        }
    }

    @Step("The Pet name should not be equals to {0}")
    private void assertPetNameShouldNotBeEqualsTo(String name) {
        assertThat(petRequest.petInResponse().getName())
                .withFailMessage("Expected pet: %s , but was: %s", name, petRequest.petInResponse().getName())
                .isNotEqualTo(name);
    }

    @Step("The Pet category should not be equals to {0}")
    private void assertPetCategoryShouldNotBeEqualsTo(String category) {
        assertThat(petRequest.petInResponse().getCategory().toString())
                .withFailMessage("Expected pet: %s , but was: %s", category, petRequest.petInResponse().getCategory().toString())
                .isNotEqualTo(category);
    }

    @Step("The Pet photoUrls should not be equals to {0}")
    private void assertPetPhotoUrlsShouldNotBeEqualsTo(String photoUrls) {
        assertThat(petRequest.petInResponse().getPhotoUrls().toString())
                .withFailMessage("Expected pet: %s , but was: %s", photoUrls, petRequest.petInResponse().getPhotoUrls().toString())
                .isNotEqualTo(photoUrls);
    }

    @Step("The Pet tags should not be equals to {0}")
    private void assertPetTagsShouldNotBeEqualsTo(String tags) {
        assertThat(petRequest.petInResponse().getTags().toString())
                .withFailMessage("Expected pet: %s , but was: %s", tags, petRequest.petInResponse().getTags().toString())
                .isNotEqualTo(tags);
    }

    @Step("The Pet status should not be equals to {0}")
    private void assertPetStatusShouldNotBeEqualsTo(String status) {
        assertThat(petRequest.petInResponse().getStatus())
                .withFailMessage("Expected pet: %s , but was: %s", status, petRequest.petInResponse().getStatus())
                .isNotEqualTo(status);
    }
}
