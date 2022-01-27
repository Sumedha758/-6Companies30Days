class Solution{
    static int height(int N){
        // code here
        int ht=0;
        int cnt=1;
        while(N > 0){
            N -= cnt;
            if(N < 0){
                break;
            }
            ht++;
            cnt++;
        }
        return ht;
    }
}
