class Solution
{
    //Function to count number of ways to reach the nth stair 
    //when order does not matter.
    Long countWays(int m)
    {
        // your code here
        if(m<=2){
            long x=m;
            return x;
        }
        if(m == 3){
            long x=2;
            return x;
        }
        long dp[]=new long[m+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=2;
        for(int i=4; i<=m; i++){
            if(i % 2 == 0){
               dp[i]=dp[1]+dp[i-1];
            }else{
                dp[i]=dp[i-1];
            }
        }
        return dp[m];
    }    
}
