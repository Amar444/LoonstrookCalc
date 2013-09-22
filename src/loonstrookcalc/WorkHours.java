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

    public int workId;
    public int day;
    public int month;
    public int year;
    public double hours;
    public double euro;
    public int factor;
    
    
    public WorkHours(int day, int month, int year, double hours, double euro, int factor) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hours = hours;
        this.euro = euro;
        this.factor = factor;
    }
    
}
