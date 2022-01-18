class Solution {
    int lengthOfLongestAP(int[] A, int n) {
        // code here
        if(n == 1){
            return 1;
        }
        
        int max=0;
        
        int dp[][]=new int[n][10001];
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                
                int diff=A[j]-A[i];
                
                dp[j][diff]=Math.max(dp[i][diff]+1, 2);
                
                max=Math.max(max, dp[j][diff]);
            }
        }
        
        return max;
    }
}
