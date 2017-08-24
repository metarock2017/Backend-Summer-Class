package org.redrock.List;

import java.util.*;

/**
 * 作业：结合注释尝试解释每一个输出语句,重写pet中的equals方法，看对结果有何影响
 * Created by wang on 2017/8/6.
 */
public class Parcel3 {
    public static void main(String[] args) {
        List<Pet> pets = Pets.arrayList(7);
        System.out.println("1 :" + pets);

        Pet p = new Pet("鸽子");
        pets.add(p);
        System.out.println("2 :" + pets);
        //contains 方法来确定某个元素是否存在于list中
        System.out.println("3 :" + pets.contains(p));
        //remove 方法移除list中指定的元素 返回类型是 boolean
        pets.remove(p);
        //get 方法获取一个元素  以下表为参数 从 0 开始
        Pet p1 = pets.get(2);
        System.out.println("4 :" + p1 + " " + pets.indexOf(p1));

        Pet p2 = new Pet("小猪");
        //indexOf 方法 返回某个元素在list中的下表  没有返回 -1
        System.out.println("5 :" + pets.indexOf(p2));
        System.out.println("6 :" + pets.remove(p2));

        System.out.println("7 :" + pets.remove(p1));
        System.out.println("8 :" + pets);

        //在list中间插入元素，尽量不要这样做，这个操作的时间复杂度是n
        pets.add(3, new Pet("小老鼠"));
        System.out.println("9 :" + pets);

        //截取list中指定部分的元素给另外一个list  此方法受 equals 方法的影响
        List<Pet> sub = pets.subList(1, 4);
        System.out.println("sublist :" + sub);
        // containsAll 方法检查一个list是否在另一个list中
        System.out.println("10 :" + pets.containsAll(sub));

        //将一个list排序  需要元素的类实现 Comparable 接口
        Collections.sort(sub);
        System.out.println("sorted sublist :" + sub);
        System.out.println("11 :" + pets.containsAll(sub));

        Random rand = new Random(47);
        //随机打乱list中的元素顺序
        Collections.shuffle(sub, rand);
        System.out.println("12 :" + pets.containsAll(sub));

        List<Pet> copy = new ArrayList<>(pets);
        sub = Arrays.asList(pets.get(1), pets.get(4));
        System.out.println("sub :" + sub);
        System.out.println("copy :" + copy);
        // retainAll 方法保留两个list的交集  此方法受 equals 方法的影响
        copy.retainAll(sub);
        System.out.println("13 :" + copy);

        copy = new ArrayList<Pet>(pets); //get a fresh copy
        copy.remove(2);  //用索引删除不必担心 equals 方法
        System.out.println("14 :" + copy);
        //移除copy 中 在 sub 中的元素 此方法受 equals 方法的影响
        copy.removeAll(sub); // only remove exact element
        System.out.println("15 :" + copy);

        copy.set(1, new Pet("小羊")); //replace a element
        System.out.println("16 :" + copy);
        //在下表为2 的地方开始插入sub中的元素
        copy.addAll(2, sub);
        System.out.println("17 :" + copy);
        System.out.println("18 :" + copy.isEmpty());

        pets.clear(); //remove all element
        System.out.println("19 :" + pets);
        System.out.println("20 :" + pets.isEmpty());
        pets.addAll(Pets.arrayList(4));
        System.out.println("21 :" + pets);

        //toArray 方法默认返回一个object数组
        Object[] o = pets.toArray();
        System.out.println("22 :" + o[3]);
        //指定返回数组的类型，如果给定数组太小，toArray自动创建一个具有合适尺寸的数组
        Pet[] pa = pets.toArray(new Pet[0]);
        System.out.println("23 :" + pa[3].getName());
    }
}
