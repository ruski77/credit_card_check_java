package com.adcowebsolutions;

/**
 * Created with IntelliJ IDEA.
 * User: russell
 * Date: 18/11/2013
 * Time: 10:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class CardValidator {

    public static String validate(String number) {
        String result = "invalid";
        if (number != null && number.length() > 0) {
            int count = 1;
            int total = 0;
            int current = 0;

            for (int i = (number.length() - 1); i >= 0; i--) {

                current = Character.getNumericValue(number.charAt(i));

                if (StringUtils.isEvenNumber(new Integer(count).toString())) {
                    total = total + multiplyNumber(current);
                } else {
                    total = total + current;
                }
                count++;
            }
            if (total % 10 == 0) {
                result = "valid";
            }
        }
        return result;
    }

    public static int multiplyNumber(int number) {

        Integer count = number * 2;
        String countAsString = count.toString();
        int val = 0;
        if (countAsString.length() > 1) {
            for (int j = 0; j < countAsString.length(); j++) {
                val = val + Character.getNumericValue(countAsString.charAt(j));
            }
            count = val;
        }
        return count;
    }
}
