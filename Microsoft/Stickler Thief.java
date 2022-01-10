class Solution
{
    //Function to find the maximum money the thief can get.
    public int max(int i, int nums[], int dp[]){
        if(i >= nums.length){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int choice1=nums[i]+max(i+2, nums, dp);
        int choice2=max(i+1, nums, dp);
        dp[i]=Math.max(choice1, choice2);
        return dp[i];
    }
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        int dp[]=new int[n];
        Arrays.fill(dp, -1);
        return max(0, arr, dp);
    }
}
