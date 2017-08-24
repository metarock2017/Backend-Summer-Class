package org.redrock.Parcel_3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wang on 2017/8/23.
 */
public class FilledListMaker<T> {
    //在运行时，这个类的内部没有任何<T>
    List<T> create(T t, int n) {
        List<T> result = new ArrayList<T>();
        for (int i = 0; i < n; i++) {
            result.add(t);
        }

        return result;
    }

    public static void main(String[] args) {
        FilledListMaker<String> stringMaker = new FilledListMaker();
        //擦除在方法体中移除了类型信息，问题的关键在与边界：即对象进入和离开方法的地点。
        //这些正式编译器在编译期执行类型检查并插入转型代码的地点
        List<String> list = stringMaker.create("Hello", 4);
        System.out.println(list);
    }
}
