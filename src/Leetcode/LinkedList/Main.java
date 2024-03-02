package Leetcode.LinkedList;

import java.util.ArrayList;

public class Main extends LL {
    public static void main(String[] args) {
        LL list=new LL();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        // list.insertLast(6);
        // list.insertLast(7);
        list.display();
        // System.out.println(list.binary(head));
        // list.removeElements(head, 2);
        // list.oddEvenList(head);
        list.removeNthFromEnd(head, 1);
        list.display();
    }
}