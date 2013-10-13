/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.math.BigDecimal;
import static loonstrookcalc.MainFrame.createDateNotation;

/**
 *
 * @author Amar Tursic
 */
public class HelperFunctions {
    
    /**
     * Rounds a double by up to the specified places
     * @param value
     * @param places
     * @return roundedValue
     */
    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }
    
    /**
     * a wrapper that rounds a double to 2 digits
     * @param value
     * @return roundedValue
     */
    public static double round(double value) {
        return round(value, 2);
    }
    
     /**
     * converts a String to a double
     * @param inputLoon
     * @return convertedLoon
     */
    public static double convertToDouble(String inputLoon) {
        double loon = Double.parseDouble(inputLoon);
        return loon;
    }
     
     /**
     * converts ',' in a string to '.', so it matches currency
     * @param currency
     * @return
     */
    public static String convertToCurrency(String currency) {
         return currency.replace(',', '.');
     }
     
     /**
     * A wrapper that converts a string to currency, and then rounds it to 2 digits
     * @param currency
     * @return converted
     */
    public static double convertCurrencyToDoubleAndRound(String currency) {
         return round(convertToDouble(convertToCurrency(currency)));
     }
    
    public static String createDate(int dag, int maand, int jaar) {
        return createDateNotation(dag) + "-" + createDateNotation(maand) + "-" + jaar;
    }
     
     
}
