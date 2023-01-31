package com.jpgl.powerlifegym.validation;

import org.jetbrains.annotations.NotNull;

public class CellPhoneNumberValidator {

    public static boolean Number(@NotNull String number) {
        if (number.length() != 10)
            return false;
        return number.startsWith("09");
    }

    public static boolean Exists(@NotNull String number) {
        String url = "http://localhost:8080/api/v1/user/exists/cellPhoneNumber/" + number;
        Boolean response = PersonValidator.restTemplate.getForObject(url, Boolean.class);
        return Boolean.TRUE.equals(response);
    }

}
