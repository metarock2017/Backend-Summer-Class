package NestedClasses;

/**
 * Created by wang on 2017/8/2.
 */
interface Selector {
    boolean end();
    Object current();
    void next();
}
public class Sequence {
    private Object[] items;
    private int next = 0;
    public Sequence(int size) {items = new Object[size];}
    public void add(Object x) {
        if (next < items.length)
            items[next++] = x;
    }

    private class SequenceSelector implements Selector {
        private  int i = 0;
        public boolean end() {
            return i == items.length;
        }

        public Object current() {
            return items[i];
        }

        public void next() {
            if (i < items.length)
                i++;
        }

        public Sequence getSequence() {
            return Sequence.this;
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));

        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + "  ");
            selector.next();
        }
    }

    //创建内部类对象时，此对象必定会秘密地捕获到一个指向外围类对象地引用（内部类非static）

    //静态内部类的访问范围
}
