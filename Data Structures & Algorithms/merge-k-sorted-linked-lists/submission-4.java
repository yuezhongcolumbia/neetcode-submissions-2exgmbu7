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
    public ListNode mergeKLists(ListNode[] lists) {
        // 1. we need to know which one to link up next:
        //     use minHeap, we can pop the right candidate;
        //     after processing,
        //     we increment cur
        //     we increment the poped linkedlist, if not null, put back in
        if (lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);
        for (ListNode node: lists){
            if (node != null){
                minHeap.offer(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!minHeap.isEmpty()){
            ListNode nextNode = minHeap.poll();
            cur.next = nextNode;
            cur = cur.next;
            nextNode = nextNode.next;
            if (nextNode != null){
                minHeap.offer(nextNode);
            }
        }
        return dummy.next;
        
    }
}
