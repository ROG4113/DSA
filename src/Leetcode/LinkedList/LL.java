package Leetcode.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;

// import LinkedList.SinglyLinkedList.MergeSort.ListNode;

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
    //odd even reorder
    public ListNode oddEvenList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode tail=head;
        ListNode previous=head;
        ListNode present=head.next;
        int size=1;
        while(tail.next!=null){
            tail=tail.next;
            size++;
        }
        int swaps=0;
        while(swaps<size/2){
            tail.next=present;
            previous.next=present.next;
            tail=present;
            tail.next=null;
            present=previous.next.next;
            previous=previous.next;
            swaps++;
        }
        return head;
    }
    //remove nth node from end of the list
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev=new ListNode(0);
        ListNode first=prev, second=prev;
        second.next=head;
        for (int i = 0; i <= n && first.next!=null; i++) {
            first=first.next;
        }
        while(first!=null){
            second=second.next;
            first=first.next;
        }
        second.next=second.next.next;
        return prev.next;
    }
    //delete middle of the linkedlist
    public ListNode deleteMiddle(ListNode head) {
        ListNode fast=head, slow=head, prev=slow;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=prev.next.next;
        return head;
    }
    //partition list
    public ListNode partition(ListNode head, int x) {
        ListNode less=new ListNode(-1);
        ListNode high=new ListNode(-1);
        ListNode temp=head;
        ListNode temp1=less;
        ListNode temp2=high;
        while(temp!=null){
            if(temp.val<x){
                temp1.next=head;
                temp1=temp1.next;
            }
            else{
                temp2.next=head;
                temp2=temp2.next;
            }
            temp=temp.next;
        }
        temp1.next=high.next;
        temp2.next=null;
        return less.next;
    }
    //swapping nodes in linked list
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head==null || head.next==null || head.next.next==null){
            return new int[]{-1, -1};
        }
        ArrayList<Integer> list=new ArrayList<Integer>();
        ListNode prev=head;
        ListNode current=head.next;
        ListNode next=head.next.next;
        int distance=2;
        while(next!=null){
            if(current.val<prev.val && current.val<next.val){
                list.add(distance);
            }
            if(current.val>prev.val && current.val>next.val){
                list.add(distance);
            }
            prev=prev.next;
            current=current.next;
            next=next.next;
            distance++;
        }
        if(list.size()<2){
            return new int[]{-1, -1};
        }
        System.out.println(list);
        int min=minimum(list);
        int max=list.get(list.size()-1)-list.get(0);
        return new int[]{min, max};
    }
    private int minimum(ArrayList<Integer> list) {
        int min=list.get(1)-list.get(0);
        for(int i=1; i<list.size()-1; i++){
            if(list.get(i+1)-list.get(i)<min){
                min=list.get(i+1)-list.get(i);
            }
        }
        return min;
    }
    //Max twin sum
    public int pairSum(ListNode head) {
        ListNode mid=getMid(head);
        ListNode revMid=rev(mid);
        int max=0;
        while(revMid!=null){
            if(head.val+revMid.val>max){
                max=head.val+revMid.val;
            }
            revMid=revMid.next;
            head=head.next;
        }
        return max;
    }
    private ListNode getMid(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    private ListNode rev(ListNode head){
        ListNode prev=null;
        ListNode pres=head;
        ListNode next=head.next;
        while(pres!=null){
            pres.next=prev;
            prev=pres;
            pres=next;
            if(next!=null){
            next=next.next;
            }
        }
        return prev;
    }
    //split list
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] arr=new ListNode[k];
        ListNode temp=head;
        int length=0;
        while(temp!=null){
            if(temp!=null){
                temp=temp.next;
                length++;
            }
        }
        int index=0;
        int n=length/k;
        int extra=length%k;
        ListNode cur=head;
        ListNode prev=null;;
        while(cur!=null){
            int skip=n;
            arr[index]=cur;
            if(index<=skip){
                prev=cur;
                if(cur!=null){
                    cur=cur.next;
                }
            }
            prev.next=null;
        }
        return arr;
    }
    //double the number in linkedlist
    public ListNode doubleIt(ListNode head) {
        ListNode temp=rev(head), newHead=temp, prev=null;
        int carry=0;
        while(temp!=null){
            int sum=0;
            sum=temp.val*2;
            sum+=carry;
            carry=sum/10;
            temp.val=sum%10;
            prev=temp;
            temp=temp.next;
        }
        if(carry!=0){
            prev.next=new ListNode(carry);
        }
        return rev(newHead);
    }
}