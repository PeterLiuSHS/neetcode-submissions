/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode newHead = null;
        if (list1.val >= list2.val) {
            newHead = list2;
            list2 = list2.next;
        } else {
            newHead = list1;
            list1 = list1.next;
        }

        ListNode p = list1;
        ListNode q = list2;
        ListNode x = newHead;

        while (p != null && q != null) {
            if (p.val >= q.val) {
                x.next = q;
                x=x.next;
                q = q.next;
            } else {
                x.next = p;
                x=x.next;
                p = p.next;
            }
        }
        if (p==null && q!=null){
            x.next = q;
        } 
        if (p!=null && q==null){
            x.next = p;
        }
        return newHead;
    }
}