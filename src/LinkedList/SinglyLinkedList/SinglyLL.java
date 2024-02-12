package LinkedList.SinglyLinkedList;

public class SinglyLL {
    private Node head;
    private Node tail;
    private int size;
    //constructor
    public SinglyLL(){
        this.size=size;
    }
    //method to insert at beginning
    public void insertFirst(int value){
        Node a=new Node(value);
        //if there is no node
        if(head==null && tail==null){
            head=a;
            tail=a;
            size++;
        }
        else{
            a.next=head;
            head=a;
            size++;
        }
    }
    //method to insert at last
    public void insertLast(int value){
        Node a=new Node(value);
        //if there is no node
        if(head==null && tail==null){
            head=a;
            tail=a;
            size++;
        }
        else{
            //if you do not have tail variable O(n)
            // Node temp=head;
            // while(temp.next!=null){
            //     temp=temp.next;
            // }
            // a.next=null;
            // temp.next=a;
            // tail=a;
            // size++;

            //if you have tail variable O(1)
            tail.next=a;
            a.next=null;
            tail=a;
            size++;
        }
    }
    //method to insert at random
    public void insertRandom(int value, int index){
        Node a=new Node(value);
        //if there is no node
        if(head==null && tail==null){
            head=a;
            tail=a;
            size++;
        }
        else{
            Node temp=head;
            for (int i = 0; i < index-1; i++) {
                temp=temp.next;
            }
            a=new Node(value, temp.next);
            temp.next=a;
        }
    }
    //method to delete at beginning
    public int deleteBeginning(){
        int value=head.value;
        head=head.next;
        //if only one node is there
        if(head==tail){
            tail=null;
        }
        size--;
        return value;
    }
    //method to delete at last
    public int deleteLast(){
        Node temp=head;
        Node temp1=head;
        while(temp.next!=null){
            temp1=temp;
            temp=temp.next;
        }
        int value=temp.value;
        temp1.next=null;
        tail=temp1;
        size--;
        //if only one node is there
        if(head==tail){
            tail=null;
        }
        return value;
    }
    //method to delete at random
    public int deleteRan(int index){
        Node temp=head;
        Node temp1=head;
        for (int i = 0; i < index-1; i++) {
            temp1=temp;
            temp=temp.next;
        }
        int value=temp.value;
        temp1.next=temp.next;
        size--;
        if(head==tail){
            tail=null;
        }
        return value;
    }
    //method to get index of given value
    public int get(int value){
        int index=0;
        Node temp=head;
        while(temp.value!=value){
            temp=temp.next;
            index++;
        }
        return index;
    }
    public void display() {
        Node temp=head;
        while(temp.next!=null){
            System.out.print(temp.value + "->");
            temp=temp.next;
        }
        System.out.println(temp.value + "->" + "END");
    }
    private class Node{
        private int value;
        private Node next;
        //constructor
        public Node(int value){
            this.value=value;
        }
        public Node(int value, Node next){
            this.value=value;
            this.next=next;
        }
    }
}
