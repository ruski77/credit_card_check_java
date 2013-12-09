package com.adcowebsolutions;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import static org.junit.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: russell
 * Date: 17/11/2013
 * Time: 9:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class FileInputTest {

    @Test
    public void testReadInputFile() {
        try {
            URL file = getClass().getResource("/credit_cards.txt");
            assertNotNull("Credit card file missing", file);

            InputStream is = file.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line;
            while ( (line = br.readLine()) != null) {
                System.out.printf("%-30s  %-10s \n", CardType.determineCardType(line) + ": " + StringUtils.removeWhiteSpace(line), "(" + CardValidator.validate(line) + ")");
            }
            br.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
