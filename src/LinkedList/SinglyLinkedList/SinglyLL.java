package LinkedList.SinglyLinkedList;

import LinkedList.SinglyLinkedList.MergeSort.ListNode;

public class SinglyLL {
    private Node head;
    private Node tail;
    private int size;
    //constructor
    public SinglyLL(){
        this.size=size;
    }
    // insert using recursion
    public void insertRec(int value, int index){
        head=insertRec(value, index, head);
    }
    private Node insertRec(int value, int index, Node node){
        if(index==0){
            Node a=new Node(value, node);
            size++;
            return a;
        }
        node.next=insertRec(value, index-1, node.next);
        return node;
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
        Node head1=head;
        while(temp.next!=null){
            head1=temp;
            temp=temp.next;
        }
        int value=temp.value;
        head1.next=null;
        tail=head1;
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
        Node head1=head;
        for (int i = 0; i < index-1; i++) {
            head1=temp;
            temp=temp.next;
        }
        int value=temp.value;
        head1.next=temp.next;
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
    //method to get node of given index
    public Node getNode(int index){
        Node temp=head;
        while(index!=0){
            temp=temp.next;
            index--;
        }
        return temp;
    }
    public void display() {
        Node temp=head;
        while(temp.next!=null){
            System.out.print(temp.value + "->");
            temp=temp.next;
        }
        System.out.println(temp.value + "->" + "END");
    }
    public class Node{
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
    //questions
    //remove duplicates
    public void removeDuplicates(){
        Node temp=head;
        while(temp.next!=null){
            if (temp.value==temp.next.value) {
                temp.next=temp.next.next;
                size--;
            }else{
                temp=temp.next;
            }
        }
        tail=temp;
        tail.next=null;
    }
    //mid of the LL
    public Node getMid(Node head){
        Node fast=head;
        Node slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    //merge two sorted lists
    public static SinglyLL merge(SinglyLL first, SinglyLL second){
        Node f=first.head;
        Node s=second.head;
        SinglyLL ans=new SinglyLL();
        while(f!=null && s!=null){
            if(f.value<s.value){
                ans.insertLast(f.value);
                f=f.next;
            }
            else{
                ans.insertLast(s.value);
                s=s.next;
            }
        }
        while(f!=null){
            ans.insertLast(f.value);
            f=f.next;
        }
        while(s!=null){
            ans.insertLast(s.value);
            s=s.next;
        }
        return ans;
    }
    //check if LL has cycle
    public boolean hasCycle(Node head) {
        Node fast=head;
        Node slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
    //count the length of the cycle
    public int lengthCycle(Node head) {
        int count=0;
        Node fast=head;
        Node slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                Node temp=slow;
                do{
                    temp=temp.next;
                    count++;
                }
                while(temp!=slow);
                return count;
            }
        }
        return 0;
    }
    // return start of the cycle
    public Node detectCycle(Node head) {
        int length=0;
        Node fast=head;
        Node slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                length=lengthCycle(slow);
                break;
            }
        }
        if (length==0) {
            return null;
        }
        //finding start
        Node first=head;
        Node second=head;
        while(length>0){
            second=second.next;
            length--;
        }
        //move both one ahead by one untill they meet
        while(first!=second){
            first=first.next;
            second=second.next;
        }
        return first;
    }
    //Happy number
    public boolean isHappy(int n) {
        int fast=n;
        int slow=n;
        do{
            slow=square(slow);
            fast=square(square(fast));
        }while(slow!=fast);
        if(slow==1){
            return true;
        }
        else  return false;
    }
    private int square(int n){
        int sum=0;
        while(n!=0){
            int temp=n%10;
            temp=temp*temp;
            sum+=temp;
            n=n/10;
            temp=0;
        }
        return sum;
    }
    //reverse by recursion
    public void rev(Node node){
        if(node==tail){
            head=tail;
            return;
        }
        rev(node.next);
        tail.next=node;
        tail=node;
        node.next=null;
    }
    //in-place reversal of LL
    public Node revInPlace(Node head){
        if(head==null){
            return head;
        }
        Node previous=null;
        Node present=head;
        Node next=head.next;
        while(present!=null){
            present.next=previous;
            previous=present;
            present=next;
            if(next!=null){
                next=next.next;
            }
        }
        head=previous;
        return head;
    }
    //reorder linkedlist
    public void reorderList(Node head) {
        if(head==null || head.next==null){
            return;
        }
        Node headFirst=head;
        Node mid=getMid(head);
        Node temp=null;
        Node secondHead=revInPlace(mid);
        while(headFirst!=null && secondHead!=null){
            temp=headFirst.next;
            headFirst.next=secondHead;
            headFirst=temp;
            temp=secondHead.next;
            secondHead.next=headFirst;
            secondHead=temp;
        }
        if(headFirst!=null){
            headFirst.next=null;
        }
    }
    // Reverse LL between given nodes
    public Node reverseBetween(Node head, int left, int right) {
        if(left==right){
            return head;
        }
        // skip the first left-1 elements
        Node previous=null;
        Node present=head;
        Node next=present.next;
        for (int i = 0; present!=null && i < left-1; i++) {
            previous=present;
            present=present.next;
            next=present.next;
        }
        Node last=previous;
        Node newEnd=present;
        //reverse
        for (int i = 0; present!=null && i < right-left+1; i++) {
            present.next=previous;
            previous=present;
            present=next;
            if(next!=null){
                next=next.next;
            }
        }
        if(last!=null){
            last.next=previous;
        }
        else{
            head=previous;
        }
        newEnd.next=present;
        return head;
    }
    //palindrome linkedlist
    public boolean isPalindrome(Node head) {
        Node mid=getMid(head);
        Node secondHead=revInPlace(mid);
        Node reReverseHead=secondHead;
        //compare both the halfs
        while(head!=null && secondHead!=null){
            if(head.value!=secondHead.value){
                break;
            }
            head=head.next;
            secondHead=secondHead.next;
        }
        revInPlace(reReverseHead);
        if(head==null || secondHead==null){
            return true;
        }
        else{
            return false;
        }
    }
    //rotate list
    public Node rotateRight(Node head, int k) {
        if(k<=0 || head==null){
            return head;
        }
        Node last=head;
        int length=1;
        while(last.next!=null){
            last=last.next;
            length++;
        }
        last.next=head;
        int rotate=k%length;
        int skip=length-rotate;
        Node newLast=head;
        for (int i = 0; i < skip-1; i++) {
            newLast=newLast.next;
        }
        head=newLast.next;
        newLast.next=null;
        return head;
    }
    //bubbleSort
    public void bubble(){
        bubble(size-1, 0);
    }
    private void bubble(int r, int c) {
        if(r==0){
            return;
        }
        if(c<r){
            Node first=getNode(c);
            Node second=getNode(c+1);
            if(first.value>second.value){
                if(first==head){
                    head=second;
                    first.next=second.next;
                    second.next=first;
                }
                else if(second==tail){
                    Node prev=getNode(c-1);
                    prev.next=second;
                    tail=first;
                    first.next=null;
                    second.next=tail;
                }
                else{
                    Node prev=getNode(c-1);
                    prev.next=second;
                    first.next=second.next;
                    second.next=first;
                }
            }
            bubble(r, c+1);
        }
        else{
            bubble(r-1, 0);
        }
    }
    public static void main(String[] args) {
        // SinglyLL list = new SinglyLL();
        // list.insertLast(1);
        // list.insertLast(1);
        // list.insertLast(1);
        // list.insertLast(1);
        // list.insertLast(3);
        // list.insertLast(4);
        // list.display();
        // list.removeDuplicates();
        // list.display();
        SinglyLL LL1 =new SinglyLL();
        SinglyLL LL2 =new SinglyLL();
        LL1.insertLast(1);
        LL1.insertLast(3);
        LL1.insertLast(5);

        LL2.insertLast(1);
        LL2.insertLast(2);
        LL2.insertLast(9);
        LL2.insertLast(14);
        
        SinglyLL ans=SinglyLL.merge(LL1, LL2);
        ans.display();
    }
}
