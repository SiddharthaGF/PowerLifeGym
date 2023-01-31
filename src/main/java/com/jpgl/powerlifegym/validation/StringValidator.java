package com.jpgl.powerlifegym.validation;

import java.text.Normalizer;

public class StringValidator {

    public static String cleanString(String text) {
        text = Normalizer.normalize(text, Normalizer.Form.NFD);
        text = text.replaceAll("\\p{InCombiningDiacriticalMarks}", "");
        return text.toUpperCase();
    }

}
