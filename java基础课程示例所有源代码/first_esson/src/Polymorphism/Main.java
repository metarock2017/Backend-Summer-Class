package Polymorphism;

/**
 * Created by wang on 2017/7/31.
 */
public class Main {
    public static void main(String[] args) {
        Rodent[] rodents = new Rodent[3];
        rodents[0] = new Rodent();
        rodents[1] = new Mouse();
        rodents[2] = new Gerbil();

        //Rodent mouse = new Mouse();

        for (Rodent rodent : rodents) {
            rodent.run();
        }
    }
}
