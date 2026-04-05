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
        ListNode curr = head;
        List<ListNode>list = new ArrayList<>();
        while(head!=null){
            list.add(head);
            head = head.next;
        }
        int index = list.size()-n;
        if(index == 0){
            return list.get(index).next;
        }
        list.get(index-1).next=list.get(index).next;
        return curr;
    }
}
