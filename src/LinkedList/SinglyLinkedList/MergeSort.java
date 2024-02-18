package LinkedList.SinglyLinkedList;

public class MergeSort {
    public ListNode sort(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode mid=middleNode(head);
        ListNode left=sort(head);
        ListNode right=sort(mid);

        return mergeTwoLists(left, right);
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node=new ListNode(0);
        ListNode temp=node;
        while(list1!=null && list2!=null){
            if(list1.value<list2.value){
                temp.next=list1;
                temp=temp.next;
                list1=list1.next;
            }
            else{
                temp.next=list2;
                temp=temp.next;
                list2=list2.next;
            }
        }
        while(list1!=null){
            temp.next=list1;
            temp=temp.next;
            list1=list1.next;

        }
        while(list2!=null){
            temp.next=list2;
            temp=temp.next;
            list2=list2.next;

        }
        return node.next;
    }
    public ListNode middleNode(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    public class ListNode {
        int value;
        ListNode next;

        ListNode() {
        }

        ListNode(int value) {
            this.value = value;
        }

        ListNode(int value, ListNode next) {
            this.value = value;
            this.next = null;
        }
    }
}
