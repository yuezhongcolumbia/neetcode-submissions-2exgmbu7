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
        ListNode left_node = head;
        ListNode left_bound = new ListNode(0,head);
        ListNode right_node = head;
        ListNode right_bound = right_node.next;
        ListNode res = head; 
        for(int i =1; i<k;i++){
            res = res.next;
        }
        while(right_node!=null&&right_node.next!=null){
            for(int i =1;i<k&&right_node!=null;i++){
                right_node = right_node.next;
                
            }
            if(right_node == null){
                return res;
            }
            right_bound = right_node.next;
            ListNode pre = null;
            ListNode curr = left_node;
            while(curr!=right_bound){
                ListNode next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }
            left_bound.next = pre;
            left_node.next = right_bound;
            left_bound = left_node;
            right_node = right_bound;
            left_node = left_bound.next; 
            

        }
        return res;
    }
}
