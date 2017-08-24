package NestedClasses;

/**
 * Created by wang on 2017/8/2.
 */
class Parcel1 {
    private class Contents {
        private int i = 11;
        public int value() { return i;}
    }

     protected class Destination {
        private String label;
        Destination(String whereTo) { label = whereTo; }
        String readLabel() {return label; }
    }

    public Contents getContents() { return new Contents();}
    public Destination getDestination() { return new Destination("cq"); }
}

public class TestParcel1 {
    public static void main(String[] args) {
        Parcel1 p = new Parcel1();
        //Parcel1.Contents c = p.getContents();
        Parcel1.Destination d = p.getDestination();
        System.out.print(d.readLabel());
    }
}
