package org.redrock.Parcel_1;

/**
 * Created by wang on 2017/8/23.
 */
public class LinkedStack<T> {
    private static class Node<U> {
        U item;
        Node<U> next;
        Node() {item = null; next = null;}
        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {return item==null && next == null;}
    }

    private Node<T> top = new Node<T>();
    public void push(T item) {top = new Node<T>(item, top);}
    public T pop() {
        T result = top.item;
        if (!top.end())
            top = top.next;
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> lss = new LinkedStack<>();
        for (String s : "Hello world !!".split(" "))
            lss.push(s);

        String s;
        while((s = lss.pop()) != null)
            System.out.println(s);
    }
}
