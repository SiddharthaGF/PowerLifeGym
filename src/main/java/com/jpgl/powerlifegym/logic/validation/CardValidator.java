package com.jpgl.powerlifegym.logic.validation;

public class CardValidator {

    public static boolean isValidCard(String cardNumber) {
        if (cardNumber == null || cardNumber.length() < 13 || cardNumber.length() > 19) {
            return false;
        }
        try {
            Long.parseLong(cardNumber);
        } catch (NumberFormatException e) {
            return false;
        }
        int sum = 0;
        boolean shouldDouble = false;
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int digit = Integer.parseInt(cardNumber.substring(i, i + 1));
            if (shouldDouble) {
                digit *= 2;
                if (digit > 9) {
                    digit = (digit % 10) + 1;
                }
            }
            sum += digit;
            shouldDouble = !shouldDouble;
        }
        return sum % 10 == 0;
    }

}