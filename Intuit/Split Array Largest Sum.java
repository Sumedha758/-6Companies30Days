class Solution {
    public int check(int nums[], int mid){
        int n=nums.length;
        int cnt=0;
        int sum=0;
        for(int i=0; i<n; i++){
            if(sum + nums[i]<= mid){
                sum += nums[i];
            }else{
                sum =nums[i];
                cnt++;
            }
        }
        
        return cnt+1;
    }
    public int splitArray(int[] nums, int m) {
        int n=nums.length;
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            sum += nums[i];
            if(max < nums[i]){
                max=nums[i];
            }
        }
        int lo=max;
        int hi=sum;
        int ans=0;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            
            int x=check(nums, mid);
            if(x <= m){
                ans=mid;
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return ans;
    }
}
