package com.jpgl.powerlifegym.logic.validation;

import org.jetbrains.annotations.NotNull;

import static java.util.regex.Pattern.compile;

public class EmailValidator {

    public static boolean Email(@NotNull String email) {
        var patron = compile("^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)(\\.[A-Za-z]{2,})$");
        var comparador = patron.matcher(email);
        return comparador.matches();
    }

    public static boolean ExistsEmail(@NotNull String email) {
        return true;
    }

}
