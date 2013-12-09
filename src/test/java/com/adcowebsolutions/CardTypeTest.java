package com.adcowebsolutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: russell
 * Date: 16/11/2013
 * Time: 12:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class CardTypeTest {

    @Test
    public void testVisaCardType() {
        String cardType = CardType.determineCardType("4111111111111111");
        assertEquals("Card is Not a VISA", "VISA", cardType);

        cardType = CardType.determineCardType("4111111111111");
        assertEquals("Card is Not a VISA", "VISA", cardType);

        cardType = CardType.determineCardType("4012888888881881");
        assertEquals("Card is Not a VISA", "VISA", cardType);

        cardType = CardType.determineCardType("41111111111111");
        assertEquals("Card is Not Unknown", "Unknown", cardType);

        cardType = CardType.determineCardType("3111111111111111");
        assertEquals("Card is Not Unknown", "Unknown", cardType);
    }

    @Test
    public void testDiscoverCardType() {
        String cardType = CardType.determineCardType("6011111111111117");
        assertEquals("Card is Not a Discover", "Discover", cardType);

        cardType = CardType.determineCardType("60111111111111117");
        assertEquals("Card is Not a Unknown", "Unknown", cardType);

        cardType = CardType.determineCardType("6111111111111117");
        assertEquals("Card is Not a Unknown", "Unknown", cardType);
    }

    @Test
    public void testAmexCardType() {
        String cardType = CardType.determineCardType("378282246310005");
        assertEquals("Card is Not a AMEX", "AMEX", cardType);

        cardType = CardType.determineCardType("348282246310005");
        assertEquals("Card is Not a AMEX", "AMEX", cardType);

        cardType = CardType.determineCardType("34828224631005");
        assertEquals("Card is Not a Unknown", "Unknown", cardType);

        cardType = CardType.determineCardType("3782822463100005");
        assertEquals("Card is Not a Unknown", "Unknown", cardType);
    }

    @Test
    public void testMasterCardType() {
        String cardType = CardType.determineCardType("5105105105105100");
        assertEquals("Card is Not a MasterCard", "MasterCard", cardType);

        cardType = CardType.determineCardType("5205105105105100");
        assertEquals("Card is Not a MasterCard", "MasterCard", cardType);

        cardType = CardType.determineCardType("5305105105105100");
        assertEquals("Card is Not a MasterCard", "MasterCard", cardType);

        cardType = CardType.determineCardType("5405105105105100");
        assertEquals("Card is Not a MasterCard", "MasterCard", cardType);

        cardType = CardType.determineCardType("5505105105105100");
        assertEquals("Card is Not a MasterCard", "MasterCard", cardType);

        cardType = CardType.determineCardType("5105 1051 0510 5106");
        assertEquals("Card is Not a MasterCard", "MasterCard", cardType);

        cardType = CardType.determineCardType("5005105105105100");
        assertEquals("Card is Not Unknown", "Unknown", cardType);

        cardType = CardType.determineCardType("5605105105105100");
        assertEquals("Card is Not Unknown", "Unknown", cardType);
    }

    @Test
    public void testUnknownCardType() {
        String cardType = CardType.determineCardType("9111111111111111");
        assertEquals("Card is Not Unknown", "Unknown", cardType);

        cardType = CardType.determineCardType(null);
        assertEquals("Card is Not Unknown", "Unknown", cardType);

        cardType = CardType.determineCardType("");
        assertEquals("Card is Not Unknown", "Unknown", cardType);
    }
}
