class Tuple{
    int r;
    int c;
    int t;
    Tuple(int _r, int _c, int _t){
        this.r=_r;
        this.c=_c;
        this.t=_t;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
       Queue<Tuple> q=new LinkedList<>();
        int cntOranges=0;
       for(int i=0; i<grid.length; i++){
           for(int j=0; j<grid[0].length; j++){
               if(grid[i][j] == 2){
                   q.add(new Tuple(i, j, 0));
               }
               if(grid[i][j] == 1 || grid[i][j] == 2){
                   cntOranges++;
               }
           }
       }
        
        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};
        int cnt=0;
        int ans=0;
        while(!q.isEmpty()){
            int row=q.peek().r;
            int col=q.peek().c;
            int time=q.peek().t;
            cnt++;
            ans=Math.max(ans, time);
            q.remove();
            for(int i=0; i<4; i++){
                int x=row+dx[i];
                int y=col+dy[i];
                if(x >= 0 && y >= 0 && x<grid.length && y<grid[0].length && grid[x][y] == 1){
                    grid[x][y]=2;
                    q.add(new Tuple(x, y, time+1));
                }
            }
            
        }
        if(cnt == cntOranges){
            return ans;
        }
        return -1;
    }
}
