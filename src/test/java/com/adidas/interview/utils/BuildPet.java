package com.adidas.interview.utils;

import com.adidas.interview.format.PetInformation;
import com.adidas.interview.models.Category;
import com.adidas.interview.models.Pet;
import com.adidas.interview.models.TagsItem;
import com.github.javafaker.Faker;
import net.thucydides.core.annotations.Steps;

import java.util.Arrays;

import static com.adidas.interview.constants.PetStatus.SOLD;
import static com.adidas.interview.constants.PhotoUrl.getRandomPhotoUrl;
import static com.adidas.interview.utils.SessionHelper.Session.*;
import static com.adidas.interview.utils.SessionHelper.getFromSession;
import static com.adidas.interview.utils.SessionHelper.setInSession;

public class BuildPet {

    @Steps
    private PetInformation petInformation;

    @Steps
    ReportPrint report;

    public void by(String type) {
        Pet pet = new Pet();
        if (type.equalsIgnoreCase("valid")) {
            setInSession(PET, petInformation.valid());
        } else if (type.equalsIgnoreCase("no")) {
            setInSession(PET, petInformation.empty());
        }
    }

    public String invalidInfoBy(String field) {
        switch (field) {
            case "id":
                return petInformation.invalidId().invalidIdToString();
            case "category":
                return petInformation.invalidCategory().invalidCategoryToString();
            case "photoUrls":
                return petInformation.invalidPhotoUrls().invalidPhotoUrlsToString();
            case "tags":
                return petInformation.invalidTags().invalidTagsToString();

        }
        return "";
    }

    public void without(String field) {
        Pet pet = getFromSession(PET);
        switch (field) {
            case "name":
                pet.setName(null);
                setInSession(PET, pet);
                break;
            case "category":
                pet.setCategory(null);
                setInSession(PET, pet);
                break;
            case "photoUrls":
                pet.setPhotoUrls(null);
                setInSession(PET, pet);
                break;
            case "tags":
                pet.setTags(null);
                setInSession(PET, pet);
                break;
            case "status":
                pet.setStatus(null);
                setInSession(PET, pet);
                break;
        }
    }

    public void withSpecificId(long id) {
        setInSession(PET_SAME_ID, petInformation.validWithSpecificId(id));
    }

    public Pet with(String status) {
        Pet pet = petInformation.valid();
        pet.setStatus(status);
        return pet;
    }

    public void update(String field, Pet pet) throws CloneNotSupportedException {
        Faker faker = new Faker();
        Pet.PetBuilder newPet = pet.toBuilder();
        switch (field) {
            case "name":
                newPet.name(faker.cat().name());
                setInSession(NEW_PET, newPet.build());
                break;
            case "category":
                newPet.category(new Category().builder().name(faker.animal().name()).build());
                setInSession(NEW_PET, newPet.build());
                break;
            case "photoUrls":
                newPet.photoUrls(Arrays.asList(getRandomPhotoUrl()));
                setInSession(NEW_PET, newPet.build());
                break;
            case "tags":
                newPet.tags(Arrays.asList(new TagsItem().builder().name(faker.funnyName().name()).build()));
                setInSession(NEW_PET, newPet.build());
                break;
            case "status":
                newPet.status(SOLD);
                setInSession(NEW_PET, newPet.build());
                break;
        }
    }

    public void updateStatus(Pet pet) {
        Faker faker = new Faker();
        Pet.PetBuilder newPet = pet.toBuilder();
        newPet.status(faker.name().firstName());
        setInSession(NEW_PET, newPet.build());
    }
}
