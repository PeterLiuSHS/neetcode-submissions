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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode p = slow.next; // 此时的p是后半段的起点
        slow.next=null;
        // 现在执行对p及之后的反转
        ListNode prev = null;
        ListNode cur = p;
        while (p != null) {
            ListNode nxt = p.next;
            p.next = prev;
            prev = p;
            p = nxt;
        }
        ListNode second = prev;
        ListNode first = head;

        while (second != null) {
            ListNode sndNext = second.next;
            ListNode fstNext = first.next;

            first.next = second;
            second.next = fstNext;

            first = fstNext;
            second = sndNext;
        }
    }
}
