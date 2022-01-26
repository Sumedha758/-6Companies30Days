class Solution
{
        
    long power(int N,int R)
    {
        //Your code 
        long x=1;
        int f=0;
        while(f != 40){
            x =(x*N)%(1000000000+7);
            f++;
        }
        long ans=1;
        int cnt=0;
        while(cnt != R){
            if(R-cnt >= 40){
                ans =(ans * x)%(1000000000+7);
                cnt += 40;
            }else{
                ans =(ans*N)%(1000000000+7);
                cnt++;
            }
        }
        
        return ans;
    }

}
