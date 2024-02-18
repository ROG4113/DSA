package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueInbuilt {
    public static void main(String[] args) {
        // queue is a interface of linkedlist and not a class like stack
        Queue<Integer> queue=new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }
}
