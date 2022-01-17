class Solution {
    public void generateCombinations(int i, int n, String s, int x, int y, ArrayList<String> l){
        if(i > n){
            return;
        }
        
        if(s.length() == n){
            l.add(s);
        }
        
        if(s.length() != n-1 && x < n/2){
            generateCombinations(i+1, n, s+'(', x+1, y, l);
        }
        
        if(s.length() != 0 && x >= y+1){
            generateCombinations(i+1, n, s+')',x, y+1, l);
        }
    }
    public List<String> AllParenthesis(int n) 
    {
        // Write your code here
        ArrayList<String> ans=new ArrayList<>();
        
        generateCombinations(0, 2*n, "", 0, 0, ans);
        
        return ans;
    }
}
