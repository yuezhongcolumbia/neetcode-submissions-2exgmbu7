class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        List<int[]>events = new ArrayList<>();
        for(int i =0; i<intervals.length;i++){
            
            int start = intervals[i][0];
            int end = intervals[i][1];
            int len = end-start+1;
            //start of an interval is added with time ,type
            events.add(new int[]{start,0,len,i});
            //end of an interval is added with time ,type, why i?
            events.add(new int[]{end,2,len,i});
        }
        for(int i =0; i< queries.length;i++){
            events.add(new int[]{queries[i],1,i});
        }
        events.sort((a,b)->a[0]!=b[0]?Integer.compare(a[0],b[0]):Integer.compare(a[1],b[1]));
        PriorityQueue<int[]>minHeap = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        boolean[]inactive = new boolean[intervals.length];
        int[]res = new int[queries.length];
        Arrays.fill(res,-1);
        for(int[]event:events){
            if(event[1]==0){
                minHeap.offer(new int[]{event[2],event[3]});
            }else if(event[1]==2){
                inactive[event[3]]=true;
            }else{
                while(!minHeap.isEmpty()&&inactive[minHeap.peek()[1]]){
                    minHeap.poll();
                }
                if(!minHeap.isEmpty()){
                    res[event[2]]=minHeap.peek()[0];
                }
                
            }
        }
        return res;
    }
}
