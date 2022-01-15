class Solution
{
    int sum=0;
    public int getSum(int i, int nums[], int dp[][]){
        if(i >= nums.length){
            return 0;
        }
        
        if(dp[i][sum] != -1){
            return dp[i][sum];
        }
        
        sum += nums[i];
        int ch1=getSum(i+1, nums, dp);
        sum -= nums[i];
        
        int ch2=getSum(i+1, nums, dp);
        
        dp[i][sum]=sum;
        
        return dp[i][sum];
    }

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int s=0;
	    
	    for(int i=0; i<n; i++){
	        s += arr[i];
	    }
	    
	    int dp[][]=new int[n+1][s+1];
	    
	    for(int i=0; i<n+1; i++){
	        Arrays.fill(dp[i], -1);
	    }
	    int x=getSum(0, arr, dp);
	    
	    int min=Integer.MAX_VALUE;
	    
	    for(int i=0; i<n+1; i++){
	        for(int j=0; j<s+1; j++){
	            if(dp[i][j] == s)continue;
	            int y=s-dp[i][j];
	            int ab=Math.abs(y-dp[i][j]);
	            if(min > ab){
	                min=ab;
	            }
	        }
	    }
	    
	    return min;
	} 
}
