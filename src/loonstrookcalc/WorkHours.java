/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package loonstrookcalc;

/**
 *
 * @author Amar Tursic
 */
public class WorkHours {

    private int id;
    private int day;
    private int month;
    private int year;
    private double hours;
    private double euro;
    private int factor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getEuro() {
        return euro;
    }

    public void setEuro(double euro) {
        this.euro = euro;
    }

    public int getFactor() {
        return factor;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }
    
    
    public WorkHours(int day, int month, int year, double hours, double euro, int factor) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hours = hours;
        this.euro = euro;
        this.factor = factor;
    }
    
}
