package org.redrock.ClassInfo.Parcel_4;

/**
 * Created by wang on 2017/8/11.
 */
abstract class Individual {
    protected String id;
    Individual() {}
    Individual(String name) {};
    abstract String id();
}

public class Person extends Individual{
    public Person() {}
    public Person(String name) {super(name);}
    public String id() {return id;}
}
