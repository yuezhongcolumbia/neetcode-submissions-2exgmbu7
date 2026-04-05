class Solution {
    public void rotate(int[] nums, int k) {
        Map<Integer,Integer>map = new HashMap<>();
        for(int i =0; i < nums.length; i ++){
            int key = (i+ k%nums.length)%nums.length;
            int value = nums[i];
            map.put(key,value);
        }
        for(int key:map.keySet()){
            nums[key]=map.get(key);
        }
    }
}