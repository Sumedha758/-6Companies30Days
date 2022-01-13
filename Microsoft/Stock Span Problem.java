class Pair{
    int p;
    int c;
    Pair(int _p, int _c){
        this.p=_p;
        this.c=_c;
    }
}
class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        Stack<Pair> st=new Stack<>();
        int ans[]=new int[n];
        for(int i=0; i<n; i++){
            int cnt=1;
            int a=0;
            while(!st.isEmpty() && st.peek().p <= price[i]){
                int x=st.peek().c;
                st.pop();
                a += x;
            }
            st.push(new Pair(price[i], cnt+a));
            ans[i]=cnt+a;
        }
        return ans;
    }
    
}
