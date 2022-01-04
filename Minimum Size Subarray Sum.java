class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int i=0;
        int j=0;
        int min=Integer.MAX_VALUE;
        int sum=0;
        while(j <n){
            sum += nums[j];
            while(sum >= target){
                int len=j-i+1;
                if(min > len){
                   min=len;
                }
                sum -= nums[i];
                i++;
            }
            j++;
        }
        if(min == Integer.MAX_VALUE){
            return 0;
        }
        return min;
    }
}
