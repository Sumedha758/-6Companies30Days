class Solution
{
    static long ways(int n, int num, int x, long dp[][]){
        if(n == 0){
            return 1;
        }
        if(n <= 0 || num <= 0){
            return 0;
        }
        if(dp[n][num] != -1){
            return dp[n][num];
        }
        
        int y = (int)Math.pow(num, x);
        long ch1=ways(n-y, num-1, x, dp);
        
        long ch2=ways(n, num-1, x, dp);
        
        dp[n][num] = (long)(ch1+ch2);
        
        return dp[n][num];
    }
    static long numOfWays(int n, int x)
    {
        // code here
        int maxLimit=(int)Math.pow(n, 1.0/x);
        
        long dp[][]=new long[n+1][maxLimit+1
        
        for(int i=0; i<n+1; i++){
            Arrays.fill(dp[i], -1);
        }
        return ways(n, maxLimit, x, dp);
    }
}
