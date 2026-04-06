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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // leftbound, rightbound, sublistHead, sublistTail
        ListNode dummy = new ListNode(0, head);
        ListNode leftbound = dummy;
        for (int i = 0; i < left - 1; i ++){
            leftbound = leftbound.next;
        }
        ListNode sublistHead = leftbound.next;
        ListNode sublistTail = sublistHead;
        for (int i = 0; i < right - left ; i++){
            sublistTail = sublistTail.next;
        }
        ListNode rightbound = sublistTail.next;


        //reverse the sublist, the return is now the head of the sublist
        sublistTail.next = null;
        leftbound.next = reverseLinkedList(sublistHead);
        sublistHead.next = rightbound;
        return dummy.next;
        

    }
    public ListNode reverseLinkedList(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null){
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}