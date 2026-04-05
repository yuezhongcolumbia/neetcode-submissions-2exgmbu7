class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]>maxHeap = new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]){
                return (b[1]-a[1]);
            }    
            return (b[0]-a[0]);
    });

        for(int i =0; i < arr.length;i++){
            int[]node = new int[]{Math.abs(arr[i]-x),i};
            maxHeap.offer(node);
        }
        while(maxHeap.size()>k){
            maxHeap.poll();
        }
        List<Integer>list = new ArrayList<>();
        while(!maxHeap.isEmpty()){
            int element = arr[maxHeap.poll()[1]];
            list.add(element);
        }
        Collections.sort(list);
        return list;
    }
}