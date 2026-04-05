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
        ListNode left_bound = new ListNode(0,head);
        ListNode left_node = head;
        if(left !=1 ){
            for(int i =1; i<left;i++){
                left_bound = left_bound.next;
                left_node = left_node.next;
            }  
        }
        ListNode right_node = head;
        for(int i = 1; i<right;i++){
            right_node = right_node.next;
        }
        ListNode right_bound = right_node.next;

        ListNode curr = left_node;
        ListNode pre = null;
        while(curr!=right_bound){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        left_bound.next = right_node;
        left_node.next = right_bound;
        return left==1?right_node:head;
    }
}