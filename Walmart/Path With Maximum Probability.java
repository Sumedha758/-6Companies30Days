class Pair{
    int num;
    double wt;
    Pair(int _num, double _wt){
        this.num=_num;
        this.wt=_wt;
    }
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        int j=0;
        for(int it[]:edges){
            adj.get(it[0]).add(new Pair(it[1], succProb[j]));
            adj.get(it[1]).add(new Pair(it[0], succProb[j]));
            j++;
        }
        double arr[]=new double[n];
        Arrays.fill(arr, -1.0);
        arr[start]=1.0;
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int node=q.poll();
            double prob=arr[node];
            for(Pair it:adj.get(node)){
                int nu=it.num;
                double p=it.wt;
                if(prob*p > arr[nu]){
                    arr[nu]=p*prob;
                    q.add(nu);
                }
            }
        }
        if(arr[end] == -1.0){
            return 0;
        }
        
        return arr[end];
    }
}
