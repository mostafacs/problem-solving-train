package com.leetcode.linkedlist;

/**
 * @author Mostafa
 */
public class MergeTwoLists {


public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

    public static void main(String[] args) {
    // [1,2,4]
        //[1,3,4]

//
//[5]
//[1,2,4]
//        ListNode l1 =new ListNode(-9, new ListNode(3)); // new ListNode(1, new ListNode(2, new ListNode(4))); // new ListNode(5); //
//        ListNode l2 =  new ListNode(5, new ListNode(7)); // new ListNode(1, new ListNode(2, new ListNode(4)));

//        [-9,-8]
//[-7,2,2,7,8,8]

        ListNode l1 =new ListNode(-9, new ListNode(-8));
        ListNode l2 =new ListNode(-7, new ListNode(2, new ListNode(2, new ListNode(7, new ListNode(8, new ListNode(8))))));

        ListNode result = new MergeTwoLists().mergeTwoLists(l1, l2);
        System.out.println("");
    }
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode pointer = list1;

        ListNode current = list2;
        while ( current != null  ) {
            ListNode next = current.next;
            if(pointer.val > current.val) {
                pointer  = list1;
            }
            pointer = insert(pointer, current);
            current = next;
        }

        return list1;
    }


    public ListNode insert(ListNode l1, ListNode l2) {
        ListNode current = l1;
        ListNode prev = null;
        while(current != null) {
            if(current.val > l2.val) {

                if(prev == null) {
                    ListNode tempCurrent = new ListNode(current.val, current.next);
                    current.val = l2.val;
                    current.next = tempCurrent;
                    l2 = tempCurrent;
//                    l2.next = current;
                }
                else {
                    prev.next = l2;
                    l2.next = current;
                }

                break;
            }

            prev = current;
            current = current.next;
        }


        if(current == null) {

            if(prev != l2) {
                prev.next = l2;
            }
        }

        return l2;
    }

}
