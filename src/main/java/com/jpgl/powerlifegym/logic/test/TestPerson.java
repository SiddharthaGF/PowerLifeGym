package com.jpgl.powerlifegym.logic.test;

import com.jpgl.powerlifegym.logic.service.ConfigService;
import com.jpgl.powerlifegym.logic.validation.PersonValidator;
import org.junit.Assert;
import org.junit.Test;

public class TestPerson {

    @Test
    public void testPersonDni(){
        String dni = "1805206479";
        Boolean value = PersonValidator.Dni(dni);
        Boolean expectValue = true;
        Assert.assertEquals(expectValue, value);
    }

    @Test
    public void testPersonEmail(){
        String email = "pablo.guerra@espoch.edu.ec";
        Boolean value = PersonValidator.Email(email);
        Boolean expectValue = true;
        Assert.assertEquals(expectValue, value);
    }

    @Test
    public void testPersonCellphoneNumber(){
        String cellphoneNumber = "0960800736";
        Boolean value = PersonValidator.cellphoneNumber(cellphoneNumber);
        Boolean expectValue = true;
        Assert.assertEquals(expectValue, value);
    }

    @Test
    public void testExistsPerson(){

    }

}
