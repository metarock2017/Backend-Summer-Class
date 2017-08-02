package NestedClasses;

/**
 * Created by wang on 2017/8/2.
 */
// .this .new 用法
public class Parcel {
    class Contents {
        private int i = 11;
        public int value() { return i;}
    }

    class Destination {
        private String label;
        Destination(String whereTo) { label = whereTo; }
        String readLabel() {return label; }
    }

    public static void main(String[] args) {
        Parcel p = new Parcel();
        Parcel.Contents c = p.new Contents();
        Parcel.Destination d = p.new Destination("cq");
    }
}
