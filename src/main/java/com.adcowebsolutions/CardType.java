package com.adcowebsolutions;

/**
 * Created with IntelliJ IDEA.
 * User: russell
 * Date: 16/11/2013
 * Time: 5:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class CardType {

    public static String determineCardType(String cardNumber) {
        String cardType = "Unknown";
        if (cardNumber != null && cardNumber.length() > 0) {
            String strippedNumber = StringUtils.removeWhiteSpace(cardNumber);
            if ((strippedNumber.startsWith("4")) && (strippedNumber.length() == 13 || strippedNumber.length() == 16)) {
                cardType = "VISA";
            } else if (strippedNumber.startsWith("6011") && strippedNumber.length() == 16) {
                cardType = "Discover";
            } else if ((strippedNumber.startsWith("34") || strippedNumber.startsWith("37")) && (strippedNumber.length() == 15)) {
                cardType = "AMEX";
            } else if (strippedNumber.matches("^5[1-5].*") && strippedNumber.length() == 16) {
                cardType = "MasterCard";
            }
        }
        return cardType;
    }
}
