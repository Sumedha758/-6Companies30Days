class Solution {
    public void swap(int g[], int a, int b){
        int temp=g[a];
        g[a]=g[b];
        g[b]=temp;
    }
    
    public int minSwaps(int[][] grid) {
        int n=grid.length;
        ArrayList<Integer> req=new ArrayList<>();
        int x=n-1;
        while(x >= 0){
            req.add(x);
            x--;
        }
        
        int pre[]=new int[n];
        for(int i=0; i<n; i++){
            int cnt=0;
            for(int j=n-1; j>=0; j--){
                if(grid[i][j] == 0){
                    cnt++;
                }else{
                    break;
                }
            }
            pre[i]=cnt;
        }
        
        int c=0;
        for(int i=0; i<req.size(); i++){
            int r=req.get(i);
            if(r <= pre[i]){
                continue;
            }
            
            for(int j=i+1; j<n; j++){
                
                if(r <= pre[j] && i < j){
                    int ind=j;
                    while(ind >= 0 && pre[i] != pre[ind]){
                        swap(pre, ind, ind-1);
                        ind--;
                        c++;
                        
                    }
                    break;
                }
            }
            
            if(pre[i] < r){
                return -1;
            }
            
        }
        return c;
    }
}
