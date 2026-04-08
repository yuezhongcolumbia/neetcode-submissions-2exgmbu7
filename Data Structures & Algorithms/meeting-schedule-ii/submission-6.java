/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        // 1. it is asking us max number of interval at any given time;
        // 2. we iterate interval by interval:
        //     if start>= preEnd, no conflict, just update prevEnd
        //     else conflict, count++
        // 3. this doesnt solve the problem, because we forgot all previous interval end.
     
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        intervals.sort((a,b) -> a.start - b.start);
        for (Interval interval: intervals){
            if (!minHeap.isEmpty() && interval.start >= minHeap.peek()){
                minHeap.poll();
            }
            minHeap.offer(interval.end);
            
        }
        return minHeap.size();
    }
}
