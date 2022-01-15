class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        // add your code
        String ans[]=new String[2];
        Map<String, Integer> m=new TreeMap<>();
        
        for(int i=0; i<n; i++){
            String s=arr[i];
            if(m.get(s) == null){
                m.put(s, 1);
            }else{
                m.put(s, m.get(s)+1);
            }
        }
      
        int max=0;
        for(String s:m.keySet()){
            int x=m.get(s);
            if(x > max){
                max=x;
            }
        }
      
        String name="";
        for(String s:m.keySet()){
            int x=m.get(s);
            if(x == max){
                name=s;
                break;
            }
        }
      
        ans[0]=name;
        ans[1]=Integer.toString(max);
        
        return ans;
    }
}

