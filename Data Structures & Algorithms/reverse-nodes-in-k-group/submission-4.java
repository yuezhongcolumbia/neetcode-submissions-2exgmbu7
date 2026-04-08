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
    public ListNode reverseKGroup(ListNode head, int k) {
        // 1. reverse listNode:
        //     1a. what do we need? leftbound, rightbound, prev = null, cur = firstelement
        //     2b. before reverse, we need to cut the listNode, reverse it, link prev with leftbound, originalhead with rightbound
        // 2. keep a counter:
        //     start at 1, start reverse operation, when count % k == 0; 
        ListNode dummy = new ListNode(0, head);
        ListNode curTail = dummy;
        ListNode curHead = head;
        ListNode leftBound = dummy;
        while (curTail != null){
            for (int i = 0; i < k; i++){
                curTail = curTail.next;
                if (curTail == null) break;
            }
            if (curTail == null) break;
            ListNode rightBound = curTail.next;
            //cut
            curTail.next = null;
            leftBound.next = reverse(curHead);
            curHead.next = rightBound;
            leftBound = curHead;
            curTail = curHead;
            curHead = rightBound;

        }
        return dummy.next;
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}
