class Solution {
    public StringBuilder t=new StringBuilder();
    public void Combination(int i, String s, int n, ArrayList<ArrayList<Character>> l, List<String> a){
        if(i >= n){
            return;
        }
        int x=(int)(s.charAt(i)-'0');
        for(int j=0; j<l.get(x).size(); j++){
            t.append(l.get(x).get(j));
            Combination(i+1, s, n, l, a);
            if(t.length() == n){
                a.add(t.toString());
            }
            t.deleteCharAt(t.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        int n=digits.length();
        if(n == 0){
            return ans;
        }
        ArrayList<ArrayList<Character>> l=new ArrayList<>();
        char c='a';
        for(int i=0; i<=9; i++){
            ArrayList<Character> ch=new ArrayList<>();
            int y=0;
            if(i >= 2 && i<= 6 || i == 8){
               while(y < 3){
                   ch.add(c);
                   c++;
                   y++;
               }
            }else if(i == 7 || i == 9){
               while(y < 4){
                   ch.add(c);
                   c++;
                   y++;
               }
            }
            l.add(new ArrayList<>(ch));
        }
        Combination(0, digits, n , l, ans);
        return ans;
    }
}
