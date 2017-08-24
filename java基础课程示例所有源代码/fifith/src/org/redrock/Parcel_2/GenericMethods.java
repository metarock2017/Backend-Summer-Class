package org.redrock.Parcel_2;

/**
 * Created by wang on 2017/8/23.
 */
public class GenericMethods {
    public <T> void f(T x) {
        System.out.println(x.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        //类型参数推断,如果将一个泛型方法的结果作为参数传递给另一个方法，编译器不回执行类型判断（返回值被认为是Object类型）
        gm.f("");
        gm.f(1);
        gm.f(1.0);
        gm.f(1.0F);
        gm.f("c");
        gm.f(gm);

        //显示类型说明，必须在点操作符与方法名之间插入尖括号，然后吧类型置于尖括号里面
        //如果是静态方法，必须在点操作符之前加上类名
    }
}
