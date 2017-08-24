package org.redrock.ClassInfo.Parcel_4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by wang on 2017/8/11.
 */
public class LiteralPetCreator extends PetCreator {
    @SuppressWarnings("uncecked")
    public static final List<Class<? extends Pet>> allTypes = Collections.unmodifiableList(Arrays.asList(
            Pet.class, Dog.class, Cat.class, Rat.class, Rodent.class, Mutt.class,
            Pug.class, Manx.class, EgyptianMau.class, Mouse.class, Hamster.class
    ));

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }

    //重点关注如何初始化Types这个List的,这里直接使用 .class 语法,然后剪切了一部分
    private static final List<Class<? extends Pet>> types = allTypes.subList(allTypes.indexOf(Mutt.class), allTypes.size());

    public static void main(String[] args) {
        System.out.println(types);
    }
}
