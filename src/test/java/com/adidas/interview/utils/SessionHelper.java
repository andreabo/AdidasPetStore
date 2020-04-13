package com.adidas.interview.utils;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.SessionMap;

public class SessionHelper {
    public enum Session {
        PET("pet"),
        PET_ID("pet_id"),
        PET_SAME_ID("pet_same_id"),
        NEW_PET("new_pet");


        private String value;

        Session(String value) {
            this.value = value;
        }
    }

    private static final SessionMap<Object, Object> serenitySession = Serenity.getCurrentSession();


    public static <T> T getFromSession(Session key) {
        return (T) serenitySession.get(key.value);
    }

    public static <T> T getFromSession(String key) {
        return (T) serenitySession.get(key);
    }

    public static <T> void setInSession(Session key, T value) {
        serenitySession.put(key.value, value);
    }

    public static <T> void setInSession(String key, T value) {
        serenitySession.put(key, value);
    }
}
