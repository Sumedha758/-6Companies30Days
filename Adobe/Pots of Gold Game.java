class GfG
{
    public static int getMax(int i, int j, int a[], int dp[][]){
        if(i > j){
            return 0;
        }
        if(i == j){
            return a[i];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int ch1=a[i]+Math.min(getMax(i+2, j, a, dp), getMax(i+1, j-1, a, dp));
        int ch2=a[j]+Math.min(getMax(i+1, j-1, a, dp), getMax(i, j-2, a, dp));
        
        dp[i][j]=Math.max(ch1, ch2);
        
        return dp[i][j];
    }
	public static int maxCoins(int A[],int n)
	{
          //add code here.
          int dp[][]=new int[n+1][n+1];
          
          for(int i=0; i<n+1; i++){
              Arrays.fill(dp[i], -1);
          }
          return getMax(0, n-1, A, dp);
    }
}
