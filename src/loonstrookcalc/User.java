/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package loonstrookcalc;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Amar Tursic
 */
public class User {
    
    private List<WorkHours> workHours;
    private int id;
    private String name;    
    private double brutoUurloon;
    private double nettoUurloon;
    
    public User(String name, double brutoUurloon, double nettoUurloon) {
        workHours = new ArrayList<WorkHours>();
        setName(name);
        setBrutoUurloon(brutoUurloon);
        setNettoUurloon(nettoUurloon);
    }

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
        if (trimmedNameIsEmpty(name)) 
            JOptionPane.showMessageDialog(null, "U heeft uw naam niet ingevuld");
        this.name = name;
    }

    public Double getBrutoUurloon() {
        return brutoUurloon;
    }

    public void setBrutoUurloon(double brutoUurloon) {
        this.brutoUurloon = brutoUurloon;
    }

    public Double getNettoUurloon() {
        return nettoUurloon;
    }

    public void setNettoUurloon(double nettoUurloon) {       
        this.nettoUurloon = nettoUurloon;
    }
    
    private boolean trimmedNameIsEmpty(String name) {
        return name.trim().isEmpty();
    }
    
     
}
