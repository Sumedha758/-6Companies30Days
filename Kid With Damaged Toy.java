//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int K = Integer.parseInt(S[2]);
            
            Solution ob = new Solution();
            System.out.println(ob.findPosition(N,M,K));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int findPosition(int N , int M , int K) {
        // code here
        int cnt=0;
        int ans=0;
        for(int i=K;; i++){
            cnt++;
            if(cnt == M){
                if(i > N && i % N == 0){
                    ans=N % i;
                }else if(i > N && i % N != 0){
                    ans=i % N;
                }else{
                    ans=i;
                }
                break;
            }
        }
        return ans;
    }
};
