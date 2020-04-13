package com.adidas.interview.definitions.general;

import com.adidas.interview.models.ErrorResponse;
import net.serenitybdd.rest.SerenityRest;

public class Common {
    public static int getStatusCode() {
        return SerenityRest.lastResponse().getStatusCode();
    }

     public static String getErrorMessage() {
       return SerenityRest.lastResponse().as(ErrorResponse.class).getMessage();
    }
}
