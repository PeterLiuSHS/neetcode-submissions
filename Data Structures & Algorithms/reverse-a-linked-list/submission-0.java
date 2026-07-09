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
    public ListNode reverseList(ListNode head) {

        if (head==null){
            return head;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode p = head;

        while (p != null) {
            list.add(p);
            p = p.next;
        }

        for (int i = list.size() - 1; i > 0; i--) {
            list.get(i).next = list.get(i - 1);
        }

        list.get(0).next = null;

        return list.get(list.size() - 1);
    }
}
