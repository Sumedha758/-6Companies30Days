class Solution
{
    int dx[]={-1,0,1,0};
    int dy[]={0,1,0,-1};
    public boolean check(int i, int j, char board[][], String w, int vis[][], int k){
        if(i >= board.length || j >= board[0].length || i < 0 || j < 0 || vis[i][j] ==1){
            return false;
        }
        if(k == w.length()){
            return true;
        }
        if(board[i][j] != w.charAt(k)){
            return false;
        }
        
        vis[i][j]=1;
        boolean f=false;
        for(int x=0; x<4; x++){
            f =f || check(i+dx[x], j+dy[x], board, w, vis, k+1);
        }
        vis[i][j]=0;
        return f;
    }
    public boolean isWordExist(char[][] board, String word)
    {
        // Code here
        int n=board.length;
        int m=board[0].length;
        int vis[][]=new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(check(i, j, board, word, vis, 0)){
                    return true;
                }
            }
        }
        return false;
    }
}
