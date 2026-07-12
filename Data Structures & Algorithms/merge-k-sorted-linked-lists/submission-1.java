class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int interval = 1;
        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i += interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
                
            }
            interval *= 2;
        }
        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } 
        if (list2 == null) {
            return list1;
        } 

        ListNode dummy = new ListNode(100);
        ListNode tail = dummy;
        while(list1!=null && list2!=null) {
            if (list1.val >= list2.val) {
                tail.next = list2;
                list2 = list2.next;
            } else {
                tail.next = list1;
                list1 = list1.next;
            }
            tail = tail.next;
        }
        if (list1==null){
            tail.next=list2;
        } else {
            tail.next=list1;
        }
        return dummy.next;
    }
}
