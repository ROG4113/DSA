package Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Dequeue {
    public static void main(String[] args) {
        Deque<Integer> deque=new ArrayDeque<>();
        deque.add(1);
        deque.addFirst(2);
        deque.addLast(3);
        System.out.println(deque.remove());
        System.out.println(deque.remove());
        System.out.println(deque.remove());
    }
}
