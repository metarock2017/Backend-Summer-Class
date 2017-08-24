package org.redrock.ClassInfo.Parcel_8;

/**
 * Created by wang on 2017/8/21.
 */
public class Position {
    private String title;
    private Person person;

    public Position(String jobTitle, Person employee) {
        this.title = jobTitle;
        this.person = employee;
        if (person == null)
            person = Person.Null;
    }

    public Position(String jobTitle) {
        this.title = jobTitle;
        this.person = Person.Null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
        if (this.person == null)
            this.person = Person.Null;
    }

    public String toString() {
        return "Position: " + title + " " + person;
    }
}
