/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.math.BigDecimal;

/**
 *
 * @author Amar Tursic
 */
public class HelperFunctions {

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }
    
     public static double convertToDouble(String inputLoon) {
        double loon = Double.parseDouble(inputLoon);
        return loon;
    }
}
