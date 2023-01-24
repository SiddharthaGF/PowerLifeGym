package com.jpgl.powerlifegym.logic.validation;

import org.jetbrains.annotations.NotNull;

import static com.jpgl.powerlifegym.logic.validation.PersonValidator.restTemplate;

public class CellPhoneNumberValidator {

    public static boolean Number(@NotNull String number) {
        if (number.length() != 10)
            return false;
        return number.startsWith("09");
    }

    public static boolean Exists(@NotNull String number) {
        String url = "http://localhost:8080/api/v1/cellphoneNumber/exists/" + number;
        Boolean response = restTemplate.getForObject(url, Boolean.class);
        return Boolean.TRUE.equals(response);
    }

    public static boolean Exists(int number) {
        String url = "http://localhost:8080/api/v1/cellphoneNumber/exists/" + number;
        Boolean response = restTemplate.getForObject(url, Boolean.class);
        return Boolean.TRUE.equals(response);
    }

}
