package Interface;

/**
 * Created by wang on 2017/8/2.
 */
class Meal {
    private String name;
    private int price;
    private String[] detial;
}
public class Store {
    private int meal;
    public Meal getCook(String name) {
        if (name.equals("@@@")) {
            //
        } else if (name.equals("555")) {
            //
        } else if (name.equals("sdasd")) {
            //
        } else {

        }
        return new Meal();
    }

    public void shangcai() {
        Meal meal = getCook("555");
    }

}
