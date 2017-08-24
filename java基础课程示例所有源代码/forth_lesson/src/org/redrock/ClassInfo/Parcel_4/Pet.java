package org.redrock.ClassInfo.Parcel_4;

/**
 * Created by wang on 2017/8/11.
 */
public class Pet extends Person {
    Pet(String name) {super(name);}
    Pet() {super();};

    public String toString() {
        return this.getClass().getSimpleName();
    }
}
