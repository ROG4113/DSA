package Leetcode.LinkedList;

import java.util.ArrayList;

public class Main extends LL {
    public static void main(String[] args) {
        LL list=new LL();
        list.insertLast(2);
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(0);
        list.insertLast(2);
        list.insertLast(1);
        list.insertLast(2);
        list.display();
        // System.out.println(list.binary(head));
        list.removeElements(head, 2);
        list.display();
    }
}