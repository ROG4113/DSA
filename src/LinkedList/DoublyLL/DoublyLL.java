package LinkedList.DoublyLL;

public class DoublyLL {
    private Node head;
    private Node tail;
    private int size;
    //method to insert at beginning
    public void insertBeginning(int value){
        Node a=new Node(value);
        if(head==null && tail==null){
            head=a;
            tail=a;
            a.next=null;
            a.prev=null;
            size++;
        }
        else{
            a.next=head;
            head.prev=a;
            a.prev=null;
            head=a;
            size++;
        }
    }
    //method to insert at Last
    public void insertLast(int value){
        Node a=new Node(value);
        if(head==null && tail==null){
            head=a;
            tail=a;
            a.next=null;
            a.prev=null;
            size++;
        }
        else{
            //without using tail variable O(n)
            // Node temp=head;
            // while(temp.next!=null){
            //     temp=temp.next;
            // }
            // temp.next=a;
            // a.next=null;
            // a.prev=temp;
            // tail=a;
            // size++;

            //using tail variable O(1)
            tail.next=a;
            a.next=null;
            a.prev=tail;
            tail=a;
            size++;
        }
    }
    public void display() {
        Node temp=head;
        while(temp.next!=null){
            System.out.print(temp.value + "->");
            temp=temp.next;
        }
        System.out.println(temp.value + "->" +"END");
    }
    public void displayRev(){
        Node temp=tail;
        while(temp.prev!=null){
            System.out.print(temp.value + "->");
            temp=temp.prev;
        }
        System.out.print(temp.value + "->" + "START");
    }
    public class Node{
        int value;
        Node next;
        Node prev;
        //constructor
        public Node(int value){
            this.value=value;
        }
        public Node(int value, Node next, Node prev){
            this.value=value;
            this.next=next;
            this.prev=prev;
        }

    }
}
