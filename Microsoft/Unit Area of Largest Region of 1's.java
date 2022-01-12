class Solution
{
    //Function to find unit area of the largest region of 1s.
    int dy[]={-1,-1,-1,0,1,1,1,0};
    int dx[]={-1,0,1,1,1,0,-1,-1};
    public void maxArea(int i, int j, int g[][], ArrayList<Integer> l, boolean v[][]){
        if(i < 0 || i >= g.length || j < 0 || j >= g[0].length || v[i][j] == true || g[i][j] == 0){
            return;
        }
        v[i][j]=true;
        if(g[i][j] == 1){
            l.add(g[i][j]);
        }
        for(int x=0; x<8; x++){
            maxArea(i+dx[x], j+dy[x], g, l, v);
        }
    }
    public int findMaxArea(int[][] grid)
    {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        boolean v[][]=new boolean[n][m];
        int max=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                ArrayList<Integer> l=new ArrayList<>();
                if(grid[i][j] == 1){
                    maxArea(i, j, grid, l, v);
                }
                if(max < l.size()){
                    max=l.size();
                }
            }
        }
        return max;
    }
}
