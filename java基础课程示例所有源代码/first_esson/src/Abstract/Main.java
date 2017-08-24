package Abstract;

/**
 * Created by wang on 2017/7/31.
 */
class Test extends Print {

    public int i = 99;

    public void print() {
        System.out.println("i = " + this.i);
    }

    public int getInt() {
        return 1;
    }

}

class New_test extends Print {
    public int getRandomInt() {
        return 2;
    }

    public int getInt() {
        return 2;
    }
}
public class Main {
    public static void main(String[] args) {
        Print p = new New_test();
        p.getInt();
//        Test test = new Test();
//        test.getInt();
//        New_test test = new New_test();
//        test.getRandomInt();
        //test.print();
    }
}
