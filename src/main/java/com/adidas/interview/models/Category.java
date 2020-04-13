package com.adidas.interview.models;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


//@Generated("com.robohorse.robopojogenerator")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private int id;


    @Override
    public String toString() {
        return
                "{" +
                        "\"name\" : \"" + name + "\"" +
                        ",\"id\" : " + id +
                        "}";
    }
}