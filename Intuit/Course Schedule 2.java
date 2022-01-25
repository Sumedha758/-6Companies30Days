class Solution {
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, int vis[], int dfsVis[], Stack<Integer> st){
        vis[node]=1;
        dfsVis[node]=1;
        
        for(int it:adj.get(node)){
            if(vis[it] == 0){
                dfs(it, adj, vis, dfsVis, st);
            }
        }
        
        dfsVis[node]=0;
        st.push(node);
    }
    public boolean checkCycle(int node, ArrayList<ArrayList<Integer>> adj, int vis[], int dfsVis[]){
        vis[node]=1;
        dfsVis[node]=1;
        
        for(int it:adj.get(node)){
            if(vis[it] == 0){
                if(checkCycle(it, adj, vis, dfsVis) == true){
                    return true;
                }
            }else if(dfsVis[it] == 1){
                return true;
            }
        }
        
        dfsVis[node]=0;
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n=prerequisites.length;

        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int it[]:prerequisites){
            adj.get(it[1]).add(it[0]);
        }
        
        int dfsVis[]=new int[numCourses];
        int vis[]=new int[numCourses];
        int vis1[]=new int[numCourses];
        int dfsVis1[]=new int[numCourses];
        Stack<Integer> st=new Stack<>();
        
        for(int i=0; i<numCourses; i++){
            if(vis[i] == 0){
                if(checkCycle(i, adj, vis, dfsVis) == false){
                    dfs(i, adj, vis1, dfsVis1, st);
                }else{
                    return new int[0];
                }
            }
        }
        
        int ans[]=new int[numCourses];
        int i=0;
        while(!st.isEmpty()){
            ans[i]=st.pop();
            i++;
        }
        
        return ans;
    }
}
