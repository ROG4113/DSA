package Leetcode.LinkedList;

import LinkedList.SinglyLinkedList.MergeSort.ListNode;

public class LL {
    public static ListNode head;
    public class ListNode{  
        int val;
        ListNode next;
        //constructor
        public ListNode(int val){
            this.val=val;
        }
        public ListNode(int val, ListNode next){
            this.val=val;
            this.next=next;
        }
    }
    public void insertLast(int val){
        ListNode a=new ListNode(val);
        //if there is no node
        if(head==null){
            head=a;
        }
        else{
            ListNode temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            a.next=null;
            temp.next=a;
        }
    }
    //display
    public void display() {
        ListNode temp=head;
        while(temp.next!=null){
            System.out.print(temp.val + "->");
            temp=temp.next;
        }
        System.out.println(temp.val + "->" + "END");
    }

    //QUESTIONS

    //Binary to int
    public int binary(ListNode head){
        ListNode temp=head;
        String binary="";
        while(temp!=null){
            binary=binary+Integer.toString(temp.val);
            temp=temp.next;
        }
        return Integer.parseInt(binary, 2);
    }

    //Delete a node
    public void deleteNode(ListNode node) {
        ListNode temp=node;
        ListNode temp1=temp;
        while(temp.next!=null){
            temp1=temp;
            temp.val=temp.next.val;
            temp=temp.next;
        }
        temp1.next=null;
    }

    //intersection point of linked list
    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //     // reversing first
    //     ListNode previous=null;
    //     ListNode present=headA;
    //     ListNode next=headA.next;
    //     while(present!=null){
    //         present.next=previous;
    //         previous=present;
    //         present=next;
    //         next=next.next;
    //     }
    // }

    //remove all the node with given value
    public ListNode removeElements(ListNode head, int val){
        // if(head==null){
        //     return null;
        // }
        // ListNode temp=head;
        // while(temp.next!=null){
        //     if(temp.next.val==val){
        //         temp.next=temp.next.next;
        //     }
        //     else{
        //         temp=temp.next;
        //     }
        // }
        // if(head.val==val){
        //     head=head.next;
        // }
        // return head;
        //using recursion
        if(head==null){
            return null;
        }
        head.next=removeElements(head.next, val);
        if(head.val==val){
            return head.next;
        }
        return head;
    }
}