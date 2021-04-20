package AddOns;

import java.io.Serializable;


public class Rating implements Serializable{
    
    private int movie;
    private int picture;
    private int audio;
    private int threeD;
    private int comfort;
    private int overall;
    private String extra;
  
    public Rating(){
        
    }

    public Rating(int m, int p, int a, int td, int c, int oa, String e){
        movie = m;
        picture = p;
        audio = a;
        threeD = td;
        comfort = c;
        overall = oa;
        extra = e;
    }

     public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
    
    public int getMovie() {
        return movie;
    }

    public void setMovie(int movie) {
        this.movie = movie;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public int getAudio() {
        return audio;
    }

    public void setAudio(int audio) {
        this.audio = audio;
    }

    public int getThreeD() {
        return threeD;
    }

    public void setThreeD(int threeD) {
        this.threeD = threeD;
    }

    public int getComfort() {
        return comfort;
    }

    public void setComfort(int comfort) {
        this.comfort = comfort;
    }

    public int getOverall() {
        return overall;
    }

    public void setOverall(int overall) {
        this.overall = overall;
    }
    
}
