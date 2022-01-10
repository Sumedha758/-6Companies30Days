//User function Template for Java

class Solution{
    static char curr;
    static  String ans="";
    static void getBrackets(int i, int j, int brackets[][]){
        if(i == j){
            ans +=curr;
            curr++;
        }else{
            ans += '(';
            getBrackets(i, brackets[i][j], brackets);
            getBrackets(brackets[i][j]+1, j, brackets);
            ans +=')';
        }
    }
    static String matrixChainOrder(int p[], int n){
        // code here
        int u=n-1;
        int dp[][]=new int[u][u];
        for(int i=0; i<u; i++){
            for(int j=0; j<u; j++){
                dp[i][j]=Integer.MAX_VALUE;
                if(i == j){
                    dp[i][j]=0;
                }
            }
        }
        int brkts[][]=new int[u][u];
        for(int len=2; len<=u; len++){
            for(int i=0; i<u-len+1; i++){
                int j=i+len-1;
                for(int k=i; k<j; k++){
                    int val=dp[i][k]+dp[k+1][j]+(p[i]*p[k+1]*p[j+1]);
                    if(val < dp[i][j]){
                        dp[i][j]=val;
                        brkts[i][j]=k;
                    }
                }
            }
        }
        curr='A';
        ans="";
        getBrackets(0, u-1, brkts);
        // System.out.println();
        return ans;
    }
}
