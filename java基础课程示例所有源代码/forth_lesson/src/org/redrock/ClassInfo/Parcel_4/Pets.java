package org.redrock.ClassInfo.Parcel_4;

import java.util.ArrayList;

/**
 * Created by wang on 2017/8/11.
 */
public class Pets {
    public static final PetCreator creator = new LiteralPetCreator();
    //外观模式
    public static Pet randomPet() {
        return creator.randomPet();
    }

    public static Pet[] createArray(int size) {
        return creator.createArray(size);
    }

    public static ArrayList<Pet> arrayList(int size) {
        return creator.arrayList(size);
    }
}

//狗及其派生类
class Dog extends Pet {
    Dog() {super();}
    Dog(String name) {super(name);}
}

class Mutt extends Dog { //杂交狗
    public Mutt() {super();}
    public Mutt(String name) {super(name);}
}

class Pug extends Dog {  //巴哥犬
    public Pug() {super();}
    public Pug(String name) {super(name);}
}

//猫及其派生类
class Cat extends Pet {
    Cat() {super();}
    Cat(String name) {super(name);}
}

class EgyptianMau extends Cat {  //埃及猫
    EgyptianMau() {super();}
    EgyptianMau(String name) {super(name);}
}

class Manx extends Cat {  //马恩岛猫
    Manx() {super();}
    Manx(String name) {super(name);}
}

//马恩岛猫的一个派生类
class Cymric extends Manx { //威尔士猫
    Cymric() {super();}
    Cymric(String name) {super(name);}
}

//啮齿动物及其派生类
class Rodent extends Pet {
    Rodent() {super();}
    Rodent(String name) {super(name);}
}

class Rat extends Rodent {  //大老鼠
    Rat() {super();}
    Rat(String name) {super(name);}
}

class Mouse extends Rodent {  //小老鼠
    Mouse() {super();}
    Mouse(String name) {super(name);}
}

class Hamster extends Rodent {  //仓鼠
    Hamster() {super();}
    Hamster(String name) {super(name);}
}