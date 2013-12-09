package com.adcowebsolutions;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: russell
 * Date: 18/11/2013
 * Time: 10:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class CardValidatorTest {

    @Test
    public void testValidateCardNumber() {
        assertEquals("Card is not valid when it should be", "valid", CardValidator.validate("4111111111111111"));
        assertEquals("Card is not valid when it should be", "invalid", CardValidator.validate("4111111111111"));
        assertEquals("Card is not valid when it should be", "valid", CardValidator.validate("4408041234567893"));
        assertEquals("Card is not valid when it should be", "valid", CardValidator.validate("4012888888881881"));
        assertEquals("Card is not valid when it should be", "valid", CardValidator.validate("378282246310005"));
        assertEquals("Card is not valid when it should be", "valid", CardValidator.validate("6011111111111117"));
        assertEquals("Card is not valid when it should be", "valid", CardValidator.validate("5105105105105100"));
        assertEquals("Card is not valid when it should be", "invalid", CardValidator.validate("5105105105105106"));
        assertEquals("Card is not valid when it should be", "invalid", CardValidator.validate("9111111111111111"));
        assertEquals("Card is not valid when it should be", "invalid", CardValidator.validate("4417123456789112"));
    }

    @Test
    public void testMultiplyNumber() {
        assertEquals("Number not multiplied correctly", 4, CardValidator.multiplyNumber(2));
        assertEquals("Number not multiplied correctly", 7, CardValidator.multiplyNumber(8));
        assertEquals("Number not multiplied correctly", 0, CardValidator.multiplyNumber(0));
        assertEquals("Number not multiplied correctly", 9, CardValidator.multiplyNumber(9));
    }
}
