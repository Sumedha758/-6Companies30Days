class Pair{
    int r;
    int c;
    Pair(int _r, int _c){
        this.r=_r;
        this.c=_c;
    }
}
class Solution {
   
    public int maxDistance(int[][] grid) {
        int n=grid.length;
        Queue<Pair> q=new LinkedList<>();
        int ans=0;
        int vis[][]=new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    q.add(new Pair(i, j));
                    vis[i][j]=1;
                }
            }
        }
      
        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};
        
        while(!q.isEmpty()){
            Pair p=q.poll();
            int x=p.r;
            int y=p.c;
            int f=0;
            for(int i=0; i<4; i++){ 
                int x1=x+dx[i];
                int y1=y+dy[i];
                if(x1 < 0 || y1 < 0 || x1 >= n || y1 >= n || grid[x1][y1] == 1 || vis[x1][y1] == 1){
                    continue;
                }
                vis[x1][y1]=1;
                grid[x1][y1]=grid[x][y]+1;
                q.add(new Pair(x1, y1));
                ans =Math.max(ans, grid[x1][y1]);
            }
        }
        if(ans == -1){
            return -1;
        }
        return ans-1;
    }
}
