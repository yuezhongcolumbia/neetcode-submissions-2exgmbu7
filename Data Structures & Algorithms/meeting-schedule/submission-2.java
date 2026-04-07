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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() <= 1) return true;
        intervals.sort((a, b) -> a.start - b.start);
        for (int i = 1; i < intervals.size(); i++){
            if (overlap(intervals.get(i -1 ), intervals.get(i))){
                return false;
            }
        }
        return true;
    }
    public boolean overlap(Interval a, Interval b){
        return a.end > b.start;
    }

}
