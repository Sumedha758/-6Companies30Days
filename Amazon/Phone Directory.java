//Simple Brute Force.
//User function Template for Java

class Solution{
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        // code here
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        int m=s.length();
        
        for(int i=0; i<m; i++){
            String x=s.substring(0, i+1);
            ArrayList<String> l=new ArrayList<>();
            for(int j=0; j<n; j++){
                String y=contact[j];
                if(y.startsWith(x)){
                    if(l.contains(y) == false){
                        l.add(y);
                    }
                }
            }
            Collections.sort(l);
            if(l.size()==0){
                l.add("0");
            }
            ans.add(new ArrayList<>(l));
        }
        return ans;
    }
}
