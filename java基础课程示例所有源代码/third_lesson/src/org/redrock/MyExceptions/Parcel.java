package org.redrock.MyExceptions;

/**
 * 当异常被抛出后，异常处理机制将负责搜寻参数与异常类型相匹配的第一个处理程序
 * 然后进入catch字句，此时认为异常异常得到了处理，一旦catch字句执行结束，异常处理程序的查找过程结束
 * 这与switch的字句有何不同？
 * 异常处理的两种模型：终止与恢复
 * Created by wang on 2017/8/8.
 */
class FirstException extends Exception {}

public class Parcel {
    public void f() throws FirstException {
        System.out.println("Throw Exception from f()");
        throw new FirstException();
    }

    public static void main(String[] args) {
        Parcel p = new Parcel();
        try {
            p.f();
        } catch (FirstException e) {
            System.out.println("caught it");
        } finally {
            System.out.println("finally");
        }
        //TODO 作业：1) 编写能产生 ArrayIndexOutOfBoundException 异常的代码; 2) 编写异常类，以字符串为参数的构造器并调用测试
    }
}
