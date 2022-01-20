class Solution{
    public int kvowelwords(int N,int K){
        // code here
        double dp[][]=new double[N+1][K+1];
        
        for(int i=0; i<=N; i++){
            for(int j=0; j<=K; j++){
                if(i == 0){
                    dp[i][j]=1;
                }else{
                    dp[i][j]=dp[i - 1][K]*21 % 1000000007;
                    
                    if(j > 0){
                        dp[i][j]=(dp[i][j] + dp[i-1][j-1]*5 % 1000000007) % 1000000007;
                    }
                }
            }
        }
        
        return (int)dp[N][K];
    }
}
