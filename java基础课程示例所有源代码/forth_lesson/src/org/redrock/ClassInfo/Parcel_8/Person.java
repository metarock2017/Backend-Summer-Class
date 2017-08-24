package org.redrock.ClassInfo.Parcel_8;

/**
 * Created by wang on 2017/8/21.
 */
interface Null {}
public class Person {
    public final String name;
    public final String address;


    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String toString() {
        return "Person: " + name + " " + address;
    }

    public static class NullPerson extends Person implements Null {
        private NullPerson(){super("None", "None");}
        public String toString() {return "NullPerson";}
    }

    public static final Person Null = new NullPerson();
}
