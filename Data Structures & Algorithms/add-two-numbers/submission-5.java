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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode new_head = res;
        int carry = 0;
        while(l1!=null || l2!=null || carry!=0){
            int p1 = (l1!=null)?l1.val:0;
            int p2 = (l2!=null)?l2.val:0;

            int sum = p1+p2+carry;
            int val = sum% 10;
           
            res.next = new ListNode(val);
            res = res.next;
            carry = sum / 10;
            if(l1==null&&l2==null){
                break;
            }
            if(l1==null){
                l2 = l2.next;
            }else if(l2==null){
                l1 = l1.next;
            }else{
                l1 = l1.next;
                l2 = l2.next;
            }



        }
        return new_head.next;
    }
}
