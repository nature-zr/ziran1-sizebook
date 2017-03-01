package ca.ualberta.ziran1.ziran1_sizebook;

/**
 * Created by nature on 06/02/17.
 */


public class Person {
    public String name;
    public String date;
    public String neck;
    public String bust;
    public String chest;
    public String waist;
    public String hip;
    public String inseam;
    public String comment;

    public Person(String name, String date, String neck, String bust, String chest,
                  String waist, String hip, String inseam, String comment) {
        this.name = name;
        this.date = date;
        this.neck = neck;
        this.bust = bust;
        this.chest = chest;
        this.waist = waist;
        this.hip = hip;
        this.inseam = inseam;
        this.comment = comment;
    }

}
