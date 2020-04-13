package com.adidas.interview.format;

import com.adidas.interview.models.Category;
import com.adidas.interview.models.Pet;
import com.adidas.interview.models.TagsItem;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Arrays;

import static com.adidas.interview.constants.PetStatus.AVAILABLE;
import static com.adidas.interview.constants.PhotoUrl.getRandomPhotoUrl;

public class PetInformation {

    Faker faker = new Faker();

    public Pet valid() {
        return new Pet()
                .builder()
                .id(faker.number().randomNumber() + 20)
                .name(faker.dog().name())
                .category(new Category().builder().id(0).name(faker.animal().name()).build())
                .photoUrls(Arrays.asList(getRandomPhotoUrl()))
                .tags(Arrays.asList(new TagsItem().builder().id(0).name("tag").build()))
                .status(AVAILABLE)
                .build();
    }

    public Pet validWithSpecificId(long id) {
        return new Pet()
                .builder()
                .id(id)
                .name(faker.dog().name())
                .category(new Category().builder().id(0).name(faker.animal().name()).build())
                .photoUrls(Arrays.asList(getRandomPhotoUrl()))
                .tags(Arrays.asList(new TagsItem().builder().id(0).name("tag").build()))
                .status(AVAILABLE)
                .build();
    }

    public Pet empty() {
        return new Pet()
                .builder()
                .id(faker.number().randomNumber())
                .name("")
                .category(new Category().builder().name("").build())
                .photoUrls(new ArrayList<>())
                .tags(new ArrayList<>())
                .status("")
                .build();
    }

    public Pet invalidId() {
        return new Pet()
                .builder()
                .invalidId(faker.beer().name().trim())
                .name(faker.dog().name())
                .category(new Category().builder().id(0).name(faker.animal().name()).build())
                .photoUrls(Arrays.asList(getRandomPhotoUrl()))
                .tags(Arrays.asList(new TagsItem().builder().id(0).name("tag").build()))
                .status(AVAILABLE)
                .build();
    }

    public Pet invalidCategory() {
        return new Pet()
                .builder()
                .id(faker.number().randomNumber())
                .name(faker.dog().name())
                .invalidCategory(faker.color().name())
                .photoUrls(Arrays.asList(getRandomPhotoUrl()))
                .tags(Arrays.asList(new TagsItem().builder().id(0).name("tag").build()))
                .status(AVAILABLE)
                .build();
    }

    public Pet invalidPhotoUrls() {
        return new Pet()
                .builder()
                .id(faker.number().randomNumber())
                .name(faker.dog().name())
                .category(new Category().builder().id(0).name(faker.animal().name()).build())
                .invalidPhotoUrls(faker.hobbit().character().trim())
                .tags(Arrays.asList(new TagsItem().builder().id(0).name("tag").build()))
                .status(AVAILABLE)
                .build();
    }

    public Pet invalidTags() {
        return new Pet()
                .builder()
                .id(faker.number().randomNumber())
                .name(faker.dog().name())
                .category(new Category().builder().id(0).name(faker.animal().name()).build())
                .photoUrls(Arrays.asList(getRandomPhotoUrl()))
                .invalidTags(faker.friends().character())
                .status(AVAILABLE)
                .build();
    }
}
