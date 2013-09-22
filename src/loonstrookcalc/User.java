/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package loonstrookcalc;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amar Tursic
 */
public class User {

    public List<WorkHours> workHourList;
    public int userId;
    public String name;    
    public Double brutoUurloon;
    public Double nettoUurloon;
    
    public User(String name, double brutoUurloon, double nettoUurloon) {
        workHourList = new ArrayList<WorkHours>();
        this.name = name;
        this.brutoUurloon = brutoUurloon;
        this.nettoUurloon = nettoUurloon;
    }
    
}
