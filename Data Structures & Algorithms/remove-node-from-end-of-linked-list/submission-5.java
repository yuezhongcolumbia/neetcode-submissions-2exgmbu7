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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int count = 0;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        int removePreIdx = count - n - 1;
        if (removePreIdx == -1){
            return head.next;
        }
        ListNode start = head;
        for (int i = 0; i <= removePreIdx ; i++){
            if (i == removePreIdx){
                start.next = start.next.next;
                // break;
            }
            start = start.next;
            
        }
        return head;
    }
}
