//User function Template for Java

class Solution {
    public boolean cycleCheck(int node, ArrayList<ArrayList<Integer>> adj, boolean vis[], boolean dfsVis[]){
        vis[node]=true;
        dfsVis[node]=true;
    
        for(int it:adj.get(node)){
            if(vis[it] == false){
                if(cycleCheck(it, adj, vis, dfsVis)){
                    return true;
                }
            }else if(dfsVis[it] == true){
                return true;
            }
        }
        
        dfsVis[node]=false;
        return false;
    }
    public boolean isPossible(int N, int[][] prerequisites)
    {
        // Your Code goes here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        
        for(int i=0; i<N; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int it[]:prerequisites){
            adj.get(it[1]).add(it[0]);
        }
        
        boolean vis[]=new boolean[N];
        boolean dfsVis[]=new boolean[N];
        
        for(int i=0; i<N; i++){
            if(vis[i] == false){
                if(cycleCheck(i, adj, vis, dfsVis) == true){
                    return false;
                }
            }
        }
        
        return true;
        
    }
    
}
