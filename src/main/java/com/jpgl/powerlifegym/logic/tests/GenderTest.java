package com.jpgl.powerlifegym.logic.tests;

import com.jpgl.powerlifegym.logic.validation.GenderValidator;
import com.jpgl.powerlifegym.logic.validation.PersonValidator;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;

public class GenderTest {

    @Test
    public void testGencerExistsName() {
        String name = "Masculino";
        Boolean value = GenderValidator.ExistsName(name);
        Boolean expectValue = true;
        Assert.assertEquals(expectValue, value);
    }

    @Test
    public void testGencerExistsId() {
        int id = 1;
        Boolean value = GenderValidator.ExistsId(id);
        Boolean expectValue = true;
        Assert.assertEquals(expectValue, value);
    }

}
