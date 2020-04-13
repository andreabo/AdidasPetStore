package com.adidas.interview.models;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Pet  {
    @JsonProperty("photoUrls")
    private List<String> photoUrls;

    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private long id;

    @JsonProperty("category")
    private Category category;

    @JsonProperty("tags")
    private List<TagsItem> tags;

    @JsonProperty("status")
    private String status;

    private String invalidId;
    private String invalidCategory;
    private String invalidTags;
    private String invalidPhotoUrls;

    private String listToPrint() {
        if (this.photoUrls.size() >= 1) {
            String print = "[";
            for (String url : this.photoUrls) {
                print = print + "\"" + url + "\", ";

            }
            print = print.substring(0, print.length() - 2) + "]";
            return print;
        } else {
            return "[]";
        }
    }

    public String invalidIdToString() {
        return
                "{" +
                        "\"id\" : \"" + invalidId + "\"" +
                        ",\"category\" : " + category +
                        ",\"name\" : \"" + name + "\"" +
                        ",\"photoUrls\" : " + listToPrint() +
                        ",\"tags\" : " + tags +
                        ",\"status\" : \"" + status + "\"" +
                        "}";
    }

    public String invalidCategoryToString() {
        return
                "{" +
                        "\"id\" : " + id +
                        ",\"category\" : \"" + invalidCategory + "\"" +
                        ",\"name\" : \"" + name + "\"" +
                        ",\"photoUrls\" : " + listToPrint() +
                        ",\"tags\" : " + tags +
                        ",\"status\" : \"" + status + "\"" +
                        "}";
    }

    public String invalidPhotoUrlsToString() {
        return
                "{" +
                        "\"id\" : " + id +
                        ",\"category\" : " + category +
                        ",\"name\" : \"" + name + "\"" +
                        ",\"photoUrls\" : \"" + invalidPhotoUrls + "\"" +
                        ",\"tags\" : " + tags +
                        ",\"status\" : \"" + status + "\"" +
                        "}";
    }

    public String invalidTagsToString() {
        return
                "{" +
                        "\"id\" : " + id +
                        ",\"category\" : " + category +
                        ",\"name\" : \"" + name + "\"" +
                        ",\"photoUrls\" : " + listToPrint() +
                        ",\"tags\" : \"" + invalidTags + "\"" +
                        ",\"status\" : \"" + status + "\"" +
                        "}";
    }

    @Override
    public String toString() {
        return
                "{" +
                        "\"id\" : " + id +
                        (category != null ? ",\"category\" : " + category : "") +
                        (name != null ? ",\"name\" : \"" + name + "\"" : "") +
                        (photoUrls != null ? ",\"photoUrls\" : " + listToPrint() : "") +
                        (tags != null ? ",\"tags\" : " + tags : "") +
                        (status != null ? ",\"status\" : \"" + status + "\"" : "") +
                        "}";
    }
}