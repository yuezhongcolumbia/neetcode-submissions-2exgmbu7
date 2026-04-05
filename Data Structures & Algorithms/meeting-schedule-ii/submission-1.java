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
        PriorityQueue<Integer> room = new PriorityQueue<>();
        intervals.sort((a,b) -> Integer.compare(a.start, b.start));
        for (Interval interval: intervals){
            if (!room.isEmpty() && room.peek() <= interval.start){
                room.poll();
            }
            room.offer(interval.end);
        }
        return room.size();
    }
}
