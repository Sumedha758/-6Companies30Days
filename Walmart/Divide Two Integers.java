class Solution
{
    public static long divide(long a, long b)
    {
        //code here
        long dividend=Math.abs(a);
        long divisor=Math.abs(b);
        
        long ans=0;
        
        for(int i=31; i>=0; i--){
            long r=1<<i;
            long n=divisor<<i;
            if(r >= 0 && (dividend-n) >= 0){
                ans += r;
                dividend -= n;
            }
        }
        if((a >= 0 && b >= 0) || (a <= 0 && b <= 0)){
            return ans;
        }
        return -ans;
    }
}
