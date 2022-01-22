class Solution {
    public int isPartition(int x, int wt[]){
        int n=wt.length;
        int days=0;
        int sum=0;
        int i=0;
        while(i<n){
            sum += wt[i];
            if(sum > x){
                sum =wt[i];
                days++;
            }
            i++;
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int sum=0;
        int max=0;
        for(int i=0; i<n; i++){
            if(max < weights[i]){
                max=weights[i];
            }
            sum += weights[i];
        }
        
        int lo=max;
        int hi=sum;
        int ans=0;
        while(lo<=hi){
            int m=lo+(hi-lo)/2;
            int y=isPartition(m, weights);
            if(isPartition(m, weights) < days){
                ans=m;
                hi=m-1;
            }else{
                lo=m+1;
            }
        }
        
        return ans;
    }
}
