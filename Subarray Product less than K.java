class Solution {
    public int subArrayProduct(int nums[], int k){
        int n=nums.length;
        int prod=1;
        int ans=0;
        int start=0;
        for(int i=0; i<n; i++){
            prod =prod*nums[i];
            while(start < n && prod >= k){
                prod=prod/nums[start];
                start++;
            }
            ans +=i-start+1;
        }
        
        return ans;
    }
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1){
            return 0;
        }
        return subArrayProduct(nums, k);
    }
}
