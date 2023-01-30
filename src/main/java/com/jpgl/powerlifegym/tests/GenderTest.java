package com.jpgl.powerlifegym.tests;

import com.jpgl.powerlifegym.validation.GenderValidator;
import org.junit.Assert;
import org.junit.Test;

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
