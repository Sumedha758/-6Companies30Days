class Solution
{
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, boolean vis[]){
        vis[node]=true;
        
        for(int it:adj.get(node)){
            if(vis[it] == false){
                dfs(it, adj, st, vis);
            }
        }
        
        st.push(node);
    }
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        
        for(int i=0; i<K; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<N-1; i++){
            int n=dict[i].length();
            int m=dict[i+1].length();
            
            String word1=dict[i];
            String word2=dict[i+1];
            
            for(int j=0; j<Math.min(n, m); j++){
                char c1=word1.charAt(j);
                char c2=word2.charAt(j);
                if(c1 != c2){
                    int ind1=c1-'a';
                    int ind2=c2-'a';
                    
                    adj.get(ind1).add(ind2);
                    break;
                }
            }
            
        }
        
        StringBuilder ans=new StringBuilder();
        boolean vis[]=new boolean[K];
        Stack<Integer> st=new Stack<>();
        
        for(int i=0; i<K; i++){
            if(vis[i] == false){
                dfs(i, adj, st, vis);
            }
        }
        
        while(!st.isEmpty()){
            ans.append(st.pop()+'a');
        }
        return ans.toString();
    }
}
