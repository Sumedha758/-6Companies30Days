class Solution{
    
    static int getSum(int i, int nums[], int sum, int dp[][]){
        if(i >= nums.length){
            return 0;
        }
        if(dp[i][sum] != -1){
            return dp[i][sum];
        }
        
        sum += nums[i];
        int ch1=getSum(i+1, nums, sum, dp);
        sum -= nums[i];
        
        int ch2=getSum(i+1, nums, sum, dp);
        
        dp[i][sum]=sum;
        
        return dp[i][sum];
    }
    static int equalPartition(int N, int arr[])
    {
        // code here
        int s=0;
        for(int i=0; i<N; i++){
            s += arr[i];
        }
        
        int dp[][]=new int[N+1][s+1];
        
        for(int i=0; i<N+1; i++){
            Arrays.fill(dp[i], -1);
        }
        
        int y=getSum(0, arr, 0, dp);
        for(int i=0; i<N+1; i++){
            for(int j=0; j<s+1; j++){
                if(dp[i][j] == s)continue;
                
                int x=s-dp[i][j];
                if(x == dp[i][j]){
                    return 1;
                }
            }
        }
        return 0;
    }
}
