class solve{
    
    //Function to generate binary numbers from 1 to N using a queue.
    static ArrayList<String> generate(int N)
    {
        // Your code here
        ArrayList<String> ans=new ArrayList<>();
        for(int i=1; i<=N; i++){
            StringBuilder s=new StringBuilder();
            int x=i;
            while(x > 0){
                int r=x % 2;
                char c=(char)(r+'0');
                s.append(c);
                x=x/2;
            }
            StringBuilder str=s.reverse();
            ans.add(str.toString());
        }
        return ans;
    }
    
}
