package com.adidas.interview.assertions;

import com.adidas.interview.definitions.general.Common;
import net.thucydides.core.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class CommonAssertion {
    @Step("The Status code should be {0}")
    public void assertStatusCode(int statusCode) {
        assertThat(Common.getStatusCode())
                .withFailMessage("Expected: %s but was: %s", statusCode, Common.getStatusCode())
                .isEqualTo(statusCode);
    }

    @Step("The Error message should be {0}")
    public void assertErrorMessage(String errorMessage) {
        assertThat(Common.getErrorMessage())
                .withFailMessage("Expected: %s but was: %s", errorMessage, Common.getErrorMessage())
                .isEqualTo(errorMessage);
    }
}
