class Solution {
    static int lis(int n, ArrayList<Integer> a){
        ArrayList<Integer> l=new ArrayList<>();
        for(int i=0; i<n; i++){
            if(l.size() == 0){
                l.add(a.get(i));
            }else{
                if(l.get(l.size()-1) < a.get(i)){
                    l.add(a.get(i));
                }else{
                    int ind=lowerBound(l, a.get(i));
                    l.set(ind, a.get(i));
                }
            }
        }
        return l.size();
    }
    
    static int lowerBound(ArrayList<Integer> l, int k){
        int lo=0;
        int hi=l.size()-1;
        int lb=0;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(l.get(mid) >= k){
                lb=mid;
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return lb;
    }
    
    static int minInsAndDel(int[] A, int[] B, int N, int M) {
        // code here
        Map<Integer, Integer> m=new HashMap
        
        for(int i=0; i<M; i++){
            m.put(B[i], 1);
        }
        
        ArrayList<Integer> x=new ArrayList<>();
        
        for(int i=0; i<N; i++){
            if(m.get(A[i]) != null){
                x.add(A[i]);
            }
        }
        
        int o=lis(x.size(), x);
        
        return N+M - (2*o);
    }
};
