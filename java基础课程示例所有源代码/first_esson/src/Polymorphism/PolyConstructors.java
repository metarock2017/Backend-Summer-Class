package Polymorphism;

/**
 * Created by wang on 2017/7/31.
 */
class Glyph {
    void draw() {
        System.out.println("Glyph.draw() 1");
    }

    Glyph() {
        System.out.println("Glyph() before draw() 2 " );
        draw();
        System.out.println("Glyph() after draw() 3" );
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;
    private String name;
    RoundGlyph(int r) {
        radius = 1;
        System.out.println("RoundGlyph.RoundGlyph(), radius =  4" + radius +  "   " +this.name);
    }

    void  draw() {
        System.out.println("RoundGlyph.draw(), radius = " + radius + "   " + "5");
    }
}

public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}

//在构造器内唯一能够安全调用的那些方法时基类中的private/final方法

//向上转型和向下转型