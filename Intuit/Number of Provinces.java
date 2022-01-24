class Solution {
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, int vis[]){
        vis[node]=1;
        
        for(int it:adj.get(node)){
            if(vis[it] == 0){
                dfs(it, adj, vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        
        int n=isConnected.length;
        int m=isConnected[0].length;
        
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        
        for(int i=0; i<n+1; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<n; i++){
            ArrayList<Integer> l=adj.get(i+1);
            for(int j=0; j<m; j++){
                if(isConnected[i][j] == 1){
                    l.add(j+1);
                }
            }
        }
        
        int cnt=0;
        int vis[]=new int[n+1];
        
        for(int i=1; i<n+1; i++){
            if(vis[i] == 0){
                cnt++;
                dfs(i, adj, vis);
            }
        }
        
        return cnt;
    }
}
