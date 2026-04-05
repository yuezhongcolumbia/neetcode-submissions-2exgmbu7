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
        //l, r
        int l = 0, r = lists.length - 1;
        return divide(lists, l, r);
    }
    public ListNode divide(ListNode[] lists, int l, int r){
        //base condition
        if (l > r){
            return null;
        }
        if (l == r){
            return lists[l];
        }
        //divide left and divide right
        int m = (l + r) / 2;
        ListNode left = divide(lists, l, m);
        ListNode right = divide(lists, m + 1, r);

        return conquer(left, right);

    }
    public ListNode conquer(ListNode l1, ListNode l2){
        //dummy, res, cur
        ListNode res = new ListNode(0);
        ListNode cur = res;
        //while(both not the end)
        while(l1 != null && l2 != null){
            if (l1.val <= l2.val){
                //attach to cur
                cur.next = l1;
                //l1 update
                l1 = l1.next;
            } else {
                //attach l2 to cur
                cur.next = l2;
                //l2 update
                l2 = l2.next;
            }
            //update cur
            cur = cur.next;
        }
        //attach the unfinished part
        if (l1 != null){
            cur.next = l1;
        }else{
            cur.next = l2;
        }
        return res.next;
    }
}
