class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[]price = new int[n];
        Arrays.fill(price,Integer.MAX_VALUE);
        price[src]=0;

        for(int i=0; i <k+1; i ++){
            int[]tmp = Arrays.copyOf(price,n);//copy
            for(int[]edge:flights){
                int source = edge[0];
                int dest = edge[1];
                int cost = edge[2];
                if(price[source]==Integer.MAX_VALUE){
                    continue;
                }
                if(price[source]+cost<tmp[dest]){
                    tmp[dest]=price[source]+ cost;
                }
            }
            price=tmp;
        }
        return (price[dst]==Integer.MAX_VALUE)?-1:price[dst];

    }
}
