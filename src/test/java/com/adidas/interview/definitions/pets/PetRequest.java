package com.adidas.interview.definitions.pets;

import com.adidas.interview.models.Pet;
import net.serenitybdd.rest.SerenityRest;

import java.util.Arrays;
import java.util.List;

import static com.adidas.interview.constants.Header.API_KEY;
import static com.adidas.interview.constants.Header.CONTENT_TYPE;
import static com.adidas.interview.services.ServiceEndPoint.PETS;
import static com.adidas.interview.services.ServiceEndPoint.PETS_FIND_BY_STATUS;

public class PetRequest {
    public void createPet(String pet) {
        SerenityRest.rest().given()
                .header("Content-Type", CONTENT_TYPE)
                .body(pet)
                .post(PETS.getUrl());
    }

    public void findAPetById(long id) {
        SerenityRest.rest().given()
                .header("Content-Type", CONTENT_TYPE)
                .get(PETS.getUrl() + "/" + id);
    }

    public void findAPetByInvalidId(String id) {
        SerenityRest.rest().given()
                .header("Content-Type", CONTENT_TYPE)
                .get(PETS.getUrl() + "/" + id);
    }

    public void findPetsByStatus(String status) {
        SerenityRest.rest().given()
                .header("Content-Type", CONTENT_TYPE)
                .param("status", status)
                .get(PETS_FIND_BY_STATUS.getUrl());
    }

    public void findPetsByInvalidStatus(long status) {
        SerenityRest.rest().given()
                .header("Content-Type", CONTENT_TYPE)
                .param("status", status)
                .get(PETS_FIND_BY_STATUS.getUrl());
    }

    public void deletePetBy(long id) {
        SerenityRest.rest().given()
                .header("Content-Type", CONTENT_TYPE)
                .header("api_key", API_KEY)
                .delete(PETS.getUrl() + "/" + id);
    }

    public void deletePetByInvalid(String id) {
        SerenityRest.rest().given()
                .header("Content-Type", CONTENT_TYPE)
                .header("api_key", API_KEY)
                .delete(PETS.getUrl() + "/" + id);
    }

    public void updatePet(String pet) {
        SerenityRest.rest().given()
                .header("Content-Type", CONTENT_TYPE)
                .body(pet)
                .put(PETS.getUrl());
    }

    public Pet petInResponse() {
        return SerenityRest.lastResponse().as(Pet.class);
    }

    public long getPetIdInResponse() {
        return SerenityRest.lastResponse().as(Pet.class).getId();
    }

    public List<Pet> getPetsInResponse() {
        return Arrays.asList(SerenityRest.lastResponse().as(Pet[].class));
    }
}
