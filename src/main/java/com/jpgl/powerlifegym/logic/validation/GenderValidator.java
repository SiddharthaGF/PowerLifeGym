package com.jpgl.powerlifegym.logic.validation;

import static com.jpgl.powerlifegym.logic.validation.PersonValidator.restTemplate;

public class GenderValidator {

    public static boolean ExistsId(int id) {
        String url = "http://localhost:8080/api/v1/gender/exists/" + id;
        Boolean response = restTemplate.getForObject(url, Boolean.class);
        return Boolean.TRUE.equals(response);
    }

    public static boolean ExistsName(String name) {
        String url = "http://localhost:8080/api/v1/gender/exists/" + name;
        Boolean response = restTemplate.getForObject(url, Boolean.class);
        return Boolean.TRUE.equals(response);
    }


}
