package org.redrock.Iterator;

import org.redrock.List.Pet;
import org.redrock.List.Pets;

import java.util.Iterator;
import java.util.List;

/**
 * java的迭代器只能单向移动
 * 1）使用方法iterator()要求容器返回一个Iterator,他将准备好返回序列的第一个元素
 * 2）使用next() 获得序列中的下一个元素
 * 3）使用hasNext() 检查序列中是否还有元素
 * 4）使用remove() 将迭代器新返回的数据删除
 * Created by wang on 2017/8/6.
 */
public class Parcel4 {
    public static void main(String[] args) {
        List<Pet> pets = Pets.arrayList(12);
        Iterator<Pet> iterator = pets.iterator();
        while (iterator.hasNext()) {
            Pet p = iterator.next();
            System.out.println("{name :" + p.getName() + "} ");
        }
        System.out.println("-----分割-----");
        for (Pet p : pets) {
            System.out.println("{name :" + p.getName() + "} ");
        }
    }
}
