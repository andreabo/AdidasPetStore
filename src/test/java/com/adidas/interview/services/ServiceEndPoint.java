package com.adidas.interview.services;

public enum ServiceEndPoint {
    PETS("/pet"),
    PETS_FIND_BY_STATUS("/pet/findByStatus");


    private final String url;

    private final String baseUrl = "https://petstore.swagger.io/v2";

    ServiceEndPoint(String url) {
        this.url = baseUrl + "" + url;
    }

    public String getUrl() {
        return url;
    }

}
