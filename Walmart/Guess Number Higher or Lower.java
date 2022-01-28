class Solution {
    public int getMoney(int lo, int hi, int dp[][]){
        if(lo > hi){
            return 0;
        }
        if(lo == hi){
            return 0;
        }
        if(dp[lo][hi] != -1){
            return dp[lo][hi];
        }
        
        int m=Integer.MAX_VALUE;
        for(int i=lo; i<=hi; i++){
            m=Math.min(m, i+Math.max(getMoney(i+1, hi, dp), getMoney(lo, i-1, dp)));
        }
        
        dp[lo][hi]=m;
        return dp[lo][hi];
    }
    public int getMoneyAmount(int n) {
        int dp[][]=new int[n+1][n+1];
        
        for(int i=0; i<n+1; i++){
            Arrays.fill(dp[i], -1);
        }
        
        return getMoney(1, n, dp);
    }
}
