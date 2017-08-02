package Interface;

/**
 * Created by wang on 2017/7/31.
 */
//hero
interface canFight {
    void fight();
}

interface canSwim {
    void swim();
}

interface canFly {
    void fly();
}

class ActionCharacter {
    public void fight() {}
}

class Hero extends ActionCharacter implements canFight,canFly,canSwim {
    public void swim() {}
    public void fly() {}
    public void fight() {}
}

//monster
interface Monster {
    void menace();  //有威胁的
}

interface DangerousMonster extends Monster {
    void destroy(); //破坏性的
}

interface Lethal {
    void kill(); //致命的
}

//吸血鬼
interface Vampire extends  DangerousMonster, Lethal {
    void drinkBlood();
}
public class Adventure {
    public static void t(canFly x) {x.fly(); }
    public static void u(canSwim x) {x.swim(); }
    public static void v(canFight x) {x.fight(); }
    public static void w(ActionCharacter x) {x.fight(); }

    public static void main(String[] args) {
        Hero h = new Hero();
        t(h);
        u(h);
        v(h);
        w(h);
    }
}
