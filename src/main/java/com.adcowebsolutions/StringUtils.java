package com.adcowebsolutions;

/**
 * Created with IntelliJ IDEA.
 * User: russell
 * Date: 17/11/2013
 * Time: 7:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringUtils {

    public static String removeWhiteSpace(String value) {
        if (value == null) {
            return "";
        }
        return value.replaceAll("\\s+","");
    }

    public static boolean isEvenNumber(String number) {
        boolean isEven = false;
        if (number == null || number.length() == 0) {
            return isEven;
        }

        Integer numAsInt = Integer.parseInt(number);

        if (numAsInt == 0) {
            isEven = true;
        }

        if (numAsInt % 2 == 0) {
            isEven = true;
        }

        return isEven;
    }
}
