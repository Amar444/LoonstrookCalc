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

    private List<WorkHours> workHours;
    private int id;
    private String name;    
    private Double brutoUurloon;
    private Double nettoUurloon;

    public List<WorkHours> getWorkHours() {
        return workHours;
    }

    public void setWorkHours(List<WorkHours> workHours) {
        this.workHours = workHours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBrutoUurloon() {
        return brutoUurloon;
    }

    public void setBrutoUurloon(Double brutoUurloon) {
        this.brutoUurloon = brutoUurloon;
    }

    public Double getNettoUurloon() {
        return nettoUurloon;
    }

    public void setNettoUurloon(Double nettoUurloon) {
        this.nettoUurloon = nettoUurloon;
    }
    
    
    public User(String name, double brutoUurloon, double nettoUurloon) {
        workHours = new ArrayList<WorkHours>();
        this.name = name;
        this.brutoUurloon = brutoUurloon;
        this.nettoUurloon = nettoUurloon;
    }
    
}
