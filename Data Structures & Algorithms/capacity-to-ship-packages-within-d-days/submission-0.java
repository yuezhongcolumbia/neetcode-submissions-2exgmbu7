class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left_boundary = 0;
        int right_boundary = 0;
        for(int weight: weights){
            left_boundary = Math.max(left_boundary,weight);
            right_boundary +=weight;
        }    
        while(left_boundary<right_boundary){
            int mid = (left_boundary+right_boundary)/2;
            if(!canShip(weights,days,mid)){
                left_boundary = mid+1;
            }else{
                right_boundary = mid;
            }
        }
        return left_boundary;
    }

    public static boolean canShip(int[]weights, int days, int capacity){
        int curr = 0;
        int day_count = 1;
        for(int weight: weights){
            curr+=weight;
            if(curr>capacity){
                curr = weight;
                day_count++;
            }
        }
        return day_count<=days;
    }


}