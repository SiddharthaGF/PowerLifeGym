package com.jpgl.powerlifegym.logic.validation;

import org.jetbrains.annotations.NotNull;

import static java.lang.Integer.parseInt;
import static java.util.regex.Pattern.compile;

public class PersonValidator {

    private static final String PATRON_EMAIL = "^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)(\\.[A-Za-z]{2,})$";

    public static boolean Email(@NotNull String email) {
        var patron = compile(PATRON_EMAIL);
        var comparador = patron.matcher(email);
        return comparador.matches();
    }

    public static boolean cellphoneNumber(@NotNull String cellphoneNumber) {
        if (cellphoneNumber.length() == 10) {
            return cellphoneNumber.charAt(0) == '0' && cellphoneNumber.charAt(1) == '9';
        }
        return  false;
    }

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

}
