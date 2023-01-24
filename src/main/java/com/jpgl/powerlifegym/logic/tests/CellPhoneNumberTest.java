package com.jpgl.powerlifegym.logic.tests;

import com.jpgl.powerlifegym.logic.validation.CellPhoneNumberValidator;
import com.jpgl.powerlifegym.logic.validation.GenderValidator;
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
    public void testCellPhoneNumberExistsId() {
        int id = 1;
        Boolean value = CellPhoneNumberValidator.Exists(id);
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
