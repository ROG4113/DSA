package LinkedList.DoublyLL;

public class Main {
    public static void main(String[] args) {
        DoublyLL list=new DoublyLL();
        list.insertBeginning(2);
        list.insertBeginning(1);
        list.insertBeginning(0);
        list.insertLast(4);
        list.display();
        list.displayRev();
    }
}
