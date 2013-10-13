/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Amar Tursic
 */
public class User {
    
    private List<WorkHour> workHours;
    private int id;
    private String name;    
    private double brutoUurloon;
    private double nettoUurloon;
    
    /**
     *
     * @param name
     * @param brutoUurloon
     * @param nettoUurloon
     */
    public User(String name, double brutoUurloon, double nettoUurloon) {
        workHours = new ArrayList<WorkHour>();
        setName(name);
        setBrutoUurloon(brutoUurloon);
        setNettoUurloon(nettoUurloon);
    }
    
    /**
     *
     * @param id
     * @param name
     * @param brutoUurloon
     * @param nettoUurloon
     */
    public User(int id, String name, double brutoUurloon, double nettoUurloon) {
        this(name, brutoUurloon, nettoUurloon); // Roep constructor 1 op
        this.id = id;
    }

    /**
     * Adds a workhour to the user
     * @param workhour
     */
    public void addWorkHour(WorkHour w){
        workHours.add(w);
    }
    
    /**
     * gets all workhours
     * @return workhours
     */
    public List<WorkHour> getWorkHours() {
        Collections.sort(workHours);
        return workHours;
    }

    /**
     * sets the workhours
     * @param workHours
     */
    public void setWorkHours(List<WorkHour> workHours) {
        this.workHours = workHours;
    }

    /**
     * get user id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * set user id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * get user name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * set user name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get bruto loon
     * @return brutoUurLoon
     */
    public Double getBrutoUurloon() {
        return brutoUurloon;
    }

    /**
     * sets brutoUurloon
     * @param brutoUurloon
     */
    public void setBrutoUurloon(double brutoUurloon) {
        this.brutoUurloon = brutoUurloon;
    }

    /**
     * get netto uur loon
     * @return
     */
    public Double getNettoUurloon() {
        return nettoUurloon;
    }

    /**
     * set netto uur loon
     * @param nettoUurloon
     */
    public void setNettoUurloon(double nettoUurloon) {       
        this.nettoUurloon = nettoUurloon;
    }
   
    
     
}
