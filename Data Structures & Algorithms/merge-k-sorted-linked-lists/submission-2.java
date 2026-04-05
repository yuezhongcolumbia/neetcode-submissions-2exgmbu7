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
        //minheap, push everything
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);
        for (ListNode node: lists){
            if (node != null){
               minHeap.offer(node); 
            }
            
        }
        //prepare res and curr
        ListNode res = new ListNode(0);
        ListNode curr = res;
        //while(loop),poll, link to curr, update curr, update polled node, decide whether
        //to offer
        while (!minHeap.isEmpty()){
            ListNode polled = minHeap.poll();
            curr.next = polled;
            curr = curr.next;
            polled = polled.next;
            if (polled != null){
                minHeap.offer(polled);
            }
        }
        return res.next;
        //return

    }
}
