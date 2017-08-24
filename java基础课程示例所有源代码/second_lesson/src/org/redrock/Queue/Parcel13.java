package org.redrock.Queue;

import java.util.*;

/**
 * 优先级队列：下一个弹出的是优先级最高的元素
 * 作业：为Pet类书写一个Comparator，按照自己喜爱的宠物程度将其排序，并用PriorityQueue容器存放它们
 * 可参照最下面的MyComparator
 * Created by wang on 2017/8/7.
 */
public class Parcel13 {
    public static void main(String[] args) {
        //MyComparator comparator = new MyComparator();
        //PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(comarator);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Random rand = new Random(76);
        System.out.print("1: ");
        for (int i = 0; i < 10; i++) {
            priorityQueue.offer(rand.nextInt(i + 10));
        }

        Parcel12.printQ(priorityQueue);

        //
        List<Integer> ints = Arrays.asList(23, 54, 2, 4, 65, 23, 3, 8, 87, 23, 53);
        priorityQueue = new PriorityQueue<Integer>(ints);
        System.out.print("2: ");
        Parcel12.printQ(priorityQueue);

        //
        priorityQueue = new PriorityQueue<Integer>(
                ints.size(), Collections.reverseOrder()
        );
        priorityQueue.addAll(ints);
        System.out.print("3: ");
        Parcel12.printQ(priorityQueue);

        //
        String fact = "education should eschew obfuscation";
        List<String> strings = Arrays.asList(fact.split(" "));
        PriorityQueue<String> stringQueue = new PriorityQueue<String>(strings);
        System.out.print("4: ");
        Parcel12.printQ(stringQueue);

        //
        stringQueue = new PriorityQueue<String>(
                strings.size(), Collections.reverseOrder()
        );
        stringQueue.addAll(strings);
        System.out.print("5: ");
        Parcel12.printQ(stringQueue);

        //
        Set<Character> characterSet = new HashSet<Character>();
        for (char c : fact.toCharArray()) {
            characterSet.add(c);
        }
        PriorityQueue<Character> pc = new PriorityQueue<Character>(characterSet);
        System.out.print("6: ");
        Parcel12.printQ(pc);
    }
}

class MyComparator implements Comparator {

    /**
     * 实现Comparator接口，将1设置为最大值
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Object o1, Object o2) {
        Integer int1 = (Integer) o1;
        Integer int2 = (Integer) o2;
        if (int1.intValue() == 1 )
            return 1;
        else if (int2.intValue() == 1)
            return -1;

        return int1.intValue() - int2.intValue();
    }
}
