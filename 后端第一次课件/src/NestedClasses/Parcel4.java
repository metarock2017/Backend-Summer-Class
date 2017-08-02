package NestedClasses;

/**
 * 匿名内部类 Parcel3 的等效实现
 * Created by wang on 2017/8/2.
 */
public class Parcel4 {
    class MyContents implements Contents {
        private int i  = 11;
        public int value() {
            return i;
        }
    }

    public Contents getContents() {
        return new MyContents();
    }

    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        System.out.print(p.getContents().value());
    }
}

//匿名类没有构造器,因为它根本没有名字

//问题：如果基类需要一个有参数的构造器，应该怎么办？
