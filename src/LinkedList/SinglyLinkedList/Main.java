package LinkedList.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLL list=new SinglyLL();
        list.insertFirst(2);
        list.insertFirst(1);
        list.insertFirst(0);
        list.insertLast(3);
        list.insertLast(5);
        list.insertLast(8);
        list.insertRandom(4, 4);
        list.insertRandom(6, 6);
        list.insertRandom(7, 7);
        list.insertFirst(100);
        list.insertLast(99);
        list.insertRandom(98, 4);
        list.display();
        System.out.println(list.deleteBeginning());
        System.out.println(list.deleteLast());
        list.display();
        System.out.println(list.deleteRan(4));
        list.display();
        System.out.println(list.get(4));
    }
}
