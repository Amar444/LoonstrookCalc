/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Amar Tursic
 */
public class WorkHour implements Comparable<WorkHour> {

    private int id;
    private int day;
    private int month;
    private int year;
    private double hours;
    private double euro;
    private int factor;
    
    /**
     *
     * @param day
     * @param month
     * @param year
     * @param hours
     * @param euro
     * @param factor
     */
    public WorkHour(int day, int month, int year, double hours, double euro, int factor) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hours = hours;
        this.euro = euro;
        this.factor = factor;
    }
    /**
     *
     * @param id
     * @param day
     * @param month
     * @param year
     * @param hours
     * @param euro
     * @param factor
     */
    public WorkHour(int id,int day, int month, int year, double hours, double euro, int factor){
        this(day,month,year,hours,euro,factor);
        this.id = id;
    }

    /**
     * get id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * set the id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * gets the day of creation
     * @return day
     */
    public int getDay() {
        return day;
    }

    /**
     * sets the day of creation
     * @param day
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * gets the month of creation
     * @return
     */
    public int getMonth() {
        return month;
    }

    /**
     * sets the month of creation
     * @param month
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * gets the year of creation
     * @return
     */
    public int getYear() {
        return year;
    }

    /**
     * sets the year of creation
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * get the amount of hours
     * @return hours
     */
    public double getHours() {
        return hours;
    }

    /**
     * sets the amount of hours
     * @param hours
     */
    public void setHours(double hours) {
        this.hours = hours;
    }

    /**
     * get the amount of euros
     * @return euro
     */
    public double getEuro() {
        return euro;
    }

    /**
     * sets the amount of euros
     * @param euro
     */
    public void setEuro(double euro) {
        this.euro = euro;
    }

    /**
     * gets the factor
     * @return factor
     */
    public int getFactor() {
        return factor;
    }

    /**
     * sets the factor
     * @param factor
     */
    public void setFactor(int factor) {
        this.factor = factor;
    }
    
    
    /**
     * Uses id of both workhours to sort the list by ids, called by Collections.sort(List)
     * @param workHour
     * @return compared
     */
    @Override
    public int compareTo(WorkHour workHour) {
        return workHour.id - id;
    }
    
    
    
    
}
