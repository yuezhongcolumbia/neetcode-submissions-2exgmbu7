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
        //1. bruteforce traverse, find kth, establish left and right border, reverse
        //left border
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        while(true) {
            //right border
            ListNode kth = findKth(left, k);
            if (kth == null){
                break;
            }
            ListNode right = kth.next;
            //reverse logic
            ListNode curr = left.next;
            ListNode prev = right;
            while (curr != right){
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }
            //update left 
            ListNode tmp = left.next;
            left.next = kth;
            left = tmp;

        }
        return dummy.next;
    }
    private ListNode findKth(ListNode start, int k){
        while (start != null && k > 0){
            start = start.next;
            k--;
        }
        return start;
    }

}
