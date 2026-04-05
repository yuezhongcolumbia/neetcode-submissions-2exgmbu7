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
        int n = intervals.size();
        int[]start = new int[n];
        int[]end = new int[n];
        for(int i =0; i<n ; i++){
            start[i]= intervals.get(i).start;
            end[i]=intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int left = 0;
        int right = 0;

        int res = 0;
        int curr = 0;
        while(left<n){
            if(start[left]<end[right]){
                curr++;
                left++;
            }
            else{
                curr--;
                right++;
            }
            res = Math.max(res,curr);
        }
        return res;
    }
}
