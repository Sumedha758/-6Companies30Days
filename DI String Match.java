class Solution {
    public int[] diStringMatch(String s) {
        int n=s.length();
        int ans[]=new int[n+1];
        ArrayList<Integer> l=new ArrayList<>();
        for(int i=0; i<=n; i++){
            l.add(i);
        }
        int j=0;
        int a=0;
        int b=l.size()-1;
        for(int i=0; i<n; i++){
            if(s.charAt(i) == 'I'){
                ans[j]=l.get(a);
                a++;
            }else{
                ans[j]=l.get(b);
                b--;
            }
            j++;
        }
        
        ans[j]=l.get(a);
        return ans;
    }
}
