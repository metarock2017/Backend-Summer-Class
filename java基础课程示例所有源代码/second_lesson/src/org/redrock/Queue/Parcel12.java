package org.redrock.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * 队列：先进先出容器(FIFO)
 * LinkedList实现了Queue接口，他们可相互转型
 * offer()方法经一个元素插入到队尾
 * peek() & element() 方法都在不移除的情况下返回队列的头部元素
 * poll() & remove() 将移除并返回队头
 * Created by wang on 2017/8/7.
 */
public class Parcel12 {
    public static void printQ(Queue queue) {
        while (queue.peek() != null) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> q =  new LinkedList<Integer>();
        Random rand = new Random(66);
        for (int i = 0; i < 10; i++) {
            q.offer(rand.nextInt(i + 10));
        }
        printQ(q);

        Queue<Character> qc = new LinkedList<Character>();
        for (char c : "Brontosaurus".toCharArray())
            qc.offer(c);
        printQ(qc);
    }
}
