package com.jpgl.powerlifegym.tests;

import com.jpgl.powerlifegym.validation.CellPhoneNumberValidator;
import org.junit.Assert;
import org.junit.Test;

public class CellPhoneNumberTest {

    @Test
    public void testCellPhoneNumberExistsNumber() {
        String number = "0960800736";
        Boolean value = CellPhoneNumberValidator.Exists(number);
        Boolean expectValue = true;
        Assert.assertEquals(expectValue, value);
    }

    @Test
    public void testCellPhoneNumberNumber() {
        String number = "0960800736";
        Boolean value = CellPhoneNumberValidator.Number(number);
        Boolean expectValue = true;
        Assert.assertEquals(expectValue, value);
    }


}
