package org.redrock.ClassInfo;

/**
 * Created by wang on 2017/8/10.
 */
public class Parcel_3 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<Fancytoy> ftClass = Fancytoy.class;
        //可以获取到精确类型
        Fancytoy fancytoy = ftClass.newInstance();

        //使用指定类型的Class对象时，需要对getSuperClass的结果强转
        Class<Toy> tClass = (Class<Toy>) ftClass.getSuperclass();
        Toy obj = tClass.newInstance();

        //由以下方法获得的对象不是精确类型，只是Object（因为<? super Fancytoy>该语句的含糊性），如果需要使用对象，需要将其强转
        Class<? super Fancytoy> tClass1 = ftClass.getSuperclass();
        Object obj1 = tClass1.newInstance();

        //对于无法使用普通转型的情况非常有用
        Toy toy = new Fancytoy();
        Class<Fancytoy> fancytoyClass = Fancytoy.class;
        Fancytoy fancytoy1 = fancytoyClass.cast(toy);
        //以上三句等价于下面一句....
        fancytoy1 = (Fancytoy) toy;

        //小结
        // 1) 传统的类型转换
        // 2）代表对象的类型的Class对象，获取运行时所需要的信息
        // 3）instanceof 某个对象是不是某个特定类型的实例
    }
}
