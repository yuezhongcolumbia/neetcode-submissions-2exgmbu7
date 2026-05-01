class DSU{
    int[] parents;
    int components;
    public DSU(int n){
        parents = new int[n];
        components = n;
        for (int i = 0; i < n; i++){
            parents[i] = i;
        }
    }
    public int find(int x){
        if (parents[x] == x) return x;
        parents[x] = find(parents[x]);
        return parents[x];
    }
    public boolean union(int x, int y){
        int rx = find(x);
        int ry = find(y);
        if (rx == ry) return false;
        components--;
        if (rx <= ry){
            parents[ry] = rx;
        } else {
            parents[rx] = ry;
        }
        return true;
    }
    public boolean isSame(int x, int y){
        return find(x) == find(y);
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        // 1. dsu group them all up
        // 2. n find, 
        int n = isConnected.length;
        DSU dsu = new DSU(n);
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (isConnected[i][j] == 1){
                    dsu.union(i, j);
                }
            }
        }
        
        return dsu.components;

    }
}