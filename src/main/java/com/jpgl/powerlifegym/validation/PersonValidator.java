package com.jpgl.powerlifegym.validation;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import static java.lang.Integer.parseInt;

public class PersonValidator extends StringValidator {

    static RestTemplate restTemplate = new RestTemplate();

    public static boolean Dni(@NotNull String dni) {
        if (dni.length() != 10) {
            return false;
        }
        int tercerDigito = parseInt(dni.substring(2, 3));
        if (tercerDigito >= 6) {
            return false;
        }
        int[] coefficients = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
        int verificador = parseInt(dni.substring(9,10));
        int sum = 0;
        int digit = 0;
        int n = dni.length() - 1;
        for (int i = 0; i < n; i++) {
            digit = parseInt(dni.substring(i, i + 1)) * coefficients[i];
            sum += ((digit % 10) + (digit / 10));
        }
        return (sum % 10 == 0) && (0 == verificador) || (10 - (sum % 10)) == verificador;
    }

    public static boolean Exists(Object idOrDni, String tableName) {
        String url = "http://localhost:8080/api/v1/" + tableName + "/exists/" + idOrDni;
        Boolean response = restTemplate.getForObject(url, Boolean.class);
        return Boolean.TRUE.equals(response);
    }

    public static boolean Exists(String dni, String tableName) {
        String url = "http://localhost:8080/api/v1/" + tableName + "/exists/" + dni;
        Boolean response = restTemplate.getForObject(url, Boolean.class);
        return Boolean.TRUE.equals(response);
    }

    public static boolean Birthdate(@NotNull Date date) {
        LocalDate today = LocalDate.now();
        int years = Period.between(date.toLocalDate(), today).getYears();
        return years >= 7;
    }

    public static boolean NameOrLastname(String nameOrLastname) {
        return nameOrLastname == null || nameOrLastname.isBlank();
    }


}
