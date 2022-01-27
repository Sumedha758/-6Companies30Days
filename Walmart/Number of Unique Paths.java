class Solution
{
    //Function to find total number of unique paths
    public static int count(int i, int j, int a, int b, int dp[][]){
        if(i >= a || j >= b){
            return 0;
        }
        if(i == a-1 && j == b-1){
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ch1=count(i, j+1, a, b, dp);
        int ch2=count(i+1, j, a, b, dp);
        
        dp[i][j]=ch1+ch2;
        return dp[i][j];
    }
    public static int NumberOfPath(int a, int b) 
    {
        //Your code here
        int dp[][]=new int[a][b];
        for(int i=0; i<a; i++){
            Arrays.fill(dp[i], -1);
        }
        return count(0, 0, a, b, dp);
    }
}
