/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MovieAndPlayData;

/**
 *
 * @author moham
 */
public class Date {
    
    int day;
    int hour;
    int min;
    
    public Date(int d, int h, int m){
        day = d;
        hour = h;
        min = m;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
   
}
