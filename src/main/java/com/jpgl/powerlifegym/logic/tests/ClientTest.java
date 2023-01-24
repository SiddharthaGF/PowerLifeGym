package com.jpgl.powerlifegym.logic.tests;

import com.jpgl.powerlifegym.logic.validation.GenderValidator;
import com.jpgl.powerlifegym.logic.validation.PersonValidator;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;

public class ClientTest {

    @Test
    public void testClientDni(){
        String dni = "1805206479";
        Boolean value = PersonValidator.Dni(dni);
        Boolean expectValue = true;
        Assert.assertEquals(expectValue, value);
    }

    @Test
    public void testClientExists(){
        String dni = "1805206479";
        Boolean value = PersonValidator.Exists(dni, "client");
        Boolean expectValue = true;
        Assert.assertEquals(expectValue, value);
    }

    @Test
    public void testClientBirthdate(){
        Date date = Date.valueOf("1999-04-13");
        Boolean value = PersonValidator.Birthdate(date);
        Boolean expectValue = true;
        Assert.assertEquals(expectValue, value);
    }

    @Test
    public void testStringAccents() {
        String value = PersonValidator.cleanString("áéíóú");
        String expect = "aeiou";
        Assert.assertEquals(expect, value);
    }

}
