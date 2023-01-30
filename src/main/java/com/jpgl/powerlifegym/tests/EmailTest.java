package com.jpgl.powerlifegym.tests;

import com.jpgl.powerlifegym.validation.EmailValidator;
import org.junit.Assert;
import org.junit.Test;

public class EmailTest {

    @Test
    public void testEmailEmail(){
        String email = "pablo.guerra@espoch.edu.ec";
        Boolean value = EmailValidator.Email(email);
        Boolean expectValue = true;
        Assert.assertEquals(expectValue, value);
    }

}
