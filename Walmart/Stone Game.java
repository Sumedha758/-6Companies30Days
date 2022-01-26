class Solution {
    public int getComb(int i, int j, int piles[], int dp[][]){
        if(i >= piles.length || j < i){
            return 0;
        }
        if(i == j){
            return piles[i];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ch1=piles[i]+Math.min(getComb(i+2, j, piles, dp), getComb(i+1, j-1, piles, dp));
        int ch2=piles[j]+Math.min(getComb(i+1, j-1, piles, dp), getComb(i, j-2, piles, dp));
        dp[i][j]=Math.max(ch1, ch2);
        return dp[i][j];
    }
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        int sum=0;
        for(int i=0; i<n; i++){
            sum += piles[i];
        }
        
        int dp[][]=new int[n+1][n+1];
        for(int i=0; i<n+1; i++){
            Arrays.fill(dp[i], -1);
        }
        
        int a=getComb(0, n-1, piles, dp);
        int b=sum - a;
        
        if(a > b){
            return true;
        }
        return false;
    }
}
