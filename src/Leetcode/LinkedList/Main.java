package Leetcode.LinkedList;

import java.util.Arrays;

public class Main extends LL {
    public static void main(String[] args) {
        LL list=new LL();
        list.insertLast(6);
        list.insertLast(8);
        list.insertLast(4);
        list.insertLast(1);
        list.insertLast(9);
        list.insertLast(6);
        list.insertLast(6);
        list.insertLast(10);
        list.insertLast(6);
        // list.insertLast(7); 6,8,4,1,9,6,6,10,6
        list.display();
        // System.out.println(list.binary(head));
        // list.removeElements(head, 2);
        // list.oddEvenList(head);
        // list.removeNthFromEnd(head, 1);
        // list.deleteMiddle(head);
        // list.oddEvenList(head);
        // list.partition(head, 3);
        // list.swapNodes(head, 2);
        System.out.println(Arrays.toString(list.nodesBetweenCriticalPoints(head)));
        // list.display();
        // 2, 
    }    
}