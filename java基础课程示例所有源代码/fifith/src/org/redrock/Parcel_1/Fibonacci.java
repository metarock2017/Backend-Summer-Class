package org.redrock.Parcel_1;

import java.util.Iterator;

/**
 * 泛型接口
 * 自动打包与拆包
 * Created by wang on 2017/8/23.
 */
interface Generator<T> {T next();}
public class Fibonacci implements Generator<Integer> {
    private int count;
    public Integer next() {
        return fib(count++);
    }

    private int fib(int i) {
        if (i < 2) return 1;
        return fib(i-2) + fib(i-1);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 0; i < 18; i++) {
            System.out.println(fibonacci.next()  + " ");
        }
        for (int i: new IterableFibonacci(18))
            System.out.println(i);
    }
}

/**
 * 利用继承实现适配器
 * 如何利用组合实现？
 */
class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
    private int n;
    public IterableFibonacci(int count) {n = count;}

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return IterableFibonacci.this.next();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
