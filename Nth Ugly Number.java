class Solution {
    
    public int nthUglyNumber(int n) {
        int dp[][]=new int[3][n+1];
        int res=1;
        int a=0, b=0, c=0;
        for(int i=0; i<n-1; i++){
            dp[0][i]=res*2;
            dp[1][i]=res*3;
            dp[2][i]=res*5;
            res =Math.min(dp[0][a], Math.min(dp[1][b], dp[2][c]));
//             System.out.println(res)
            if(res == dp[0][a]){
                a++;
            }
            if(res == dp[1][b]){
                b++;
            }
            if(res == dp[2][c]){
                c++;
            }
        }
        return res;
    }
}
