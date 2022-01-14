// User function Template for Java
class Pair{
    int e1;
    int e2;
    Pair(int _e1, int _e2){
        this.e1=_e1;
        this.e2=_e2;
    }
}
class Solution
{
    //Function to find if the given edge is a bridge in graph.
    static void dfs(int node, int parent, int vis[], int tin[], int low[], ArrayList<ArrayList<Integer>> adj, int timer, ArrayList<Pair> x){
        vis[node]=1;
        tin[node]=low[node]=timer++;
        for(int it:adj.get(node)){
            if(it == parent)continue;
            if(vis[it] == 0){
                dfs(it, node, vis, tin, low, adj, timer, x);
                low[node]=Math.min(low[node], low[it]);
                if(low[it] > tin[node]){
                    x.add(new Pair(it, node));
                }
            }else{
                low[node]=Math.min(low[node], tin[it]);
            }
        }
    }
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        // code here 
        int vis[]=new int[V];
        int tin[]=new int[V];
        int low[]=new int[V];
        ArrayList<Pair> x=new ArrayList<>();
        int t=0;
        for(int i=0; i<V; i++){
            if(vis[i] ==0){
                dfs(i, -1, vis, tin, low, adj, t, x);
            }
        }
        for(int i=0; i<x.size(); i++){
            if(x.get(i).e1 == c && x.get(i).e2 == d){
                return 1;
            }else if(x.get(i).e1 ==d && x.get(i).e2 ==c){
                return 1;
            }
        }
        return 0;
    }
}
