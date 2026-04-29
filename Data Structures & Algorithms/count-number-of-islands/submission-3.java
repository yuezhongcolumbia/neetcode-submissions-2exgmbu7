class DSU{
    int[] parent;
    int[] size;

    public DSU(int n){
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }

    }

    public int find(int x){
        if (parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    public boolean union(int x, int y){
        int rx = find(x);
        int ry = find(y);

        if (rx == ry) return false;
        if (size[rx] >= size[ry]){
            size[rx] += size[ry];
            parent[ry] = rx;
        } else {
            size[ry] += size[rx];
            parent[rx] = ry;
        }
        return true;
    }
}

class Solution {
    
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        DSU dsu = new DSU(rows * cols);
        int islands = rows * cols;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if (grid[r][c] == '0'){
                    islands--;
                }
                else {
                    for (int[] dir: directions){
                        int nr = r + dir[0];
                        int nc = c + dir[1];
                        if (nr >= 0 && nr < rows && nc >= 0 && nc < cols
                            && grid[nr][nc] == '1'
                            && dsu.union(r * cols + c, nr * cols + nc) ){
                                islands--;
                            }
                    }
                }
            }
        }
        return islands;
    }
}
