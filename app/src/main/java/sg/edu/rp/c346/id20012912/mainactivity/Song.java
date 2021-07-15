package sg.edu.rp.c346.id20012912.mainactivity;

import java.io.Serializable;

public class Song implements Serializable
{
    private int _id;
    private String title;
    private String singers;
    private int year;
    private int stars;

    public Song(String title, String singers, int year, int stars)
    {
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }

    public int get_id() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getSingers() {
        return singers;
    }

    public int getYear() {
        return year;
    }

    public int getStars()
    {

        return stars;
    }

    public void setTitle(String toString)
    {
        this.title = title;
    }

    public void setSingers(String toString)
    {
        this.singers = singers;
    }

    public void setYear(String toString)
    {
        this.year = year;
    }

}
