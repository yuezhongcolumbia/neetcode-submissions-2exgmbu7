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
        //set dummy
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        while (true){
            //set right
            ListNode kth = getKth(left, k);
            if (kth == null){
               break;
            }
            ListNode right = kth.next;
            ListNode curr = left.next;
            ListNode prev = right;
            while(curr != right){
                //reverse logic
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
    public ListNode getKth(ListNode left, int k){
        while (left != null && k > 0){
            left = left.next;
            k --;
        }
        return left;
    }
}
