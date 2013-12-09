package com.adcowebsolutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: russell
 * Date: 17/11/2013
 * Time: 7:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringUtilsTest {

    @Test
    public void testRemoveWhiteSpace() {
        String result = StringUtils.removeWhiteSpace("5105 1051 0510 5106");
        assertEquals("Did not remove white space correctly", "5105105105105106", result);

        result = StringUtils.removeWhiteSpace(null);
        assertEquals("Did not remove white space correctly for null", "", result);
    }

    @Test
    public void testForEvenNumber() {
        boolean result = StringUtils.isEvenNumber("1");
        assertFalse("Number is not odd", result);

        result = StringUtils.isEvenNumber("2");
        assertTrue("Number is not even", result);

        result = StringUtils.isEvenNumber("32");
        assertTrue("Number is not even", result);

        result = StringUtils.isEvenNumber("77");
        assertFalse("Number is not odd", result);

        result = StringUtils.isEvenNumber("0");
        assertTrue("Zero should come be considered even", result);
    }
}
