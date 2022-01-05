class Solution {
    public int ways(int ind, String s, Map<String, Integer> m){
        
        if(ind < s.length() && s.charAt(ind) == '0'){
            return 0;
        }
        if(ind >= s.length()-1){
            return 1;
        }
        
        String str=s.substring(ind);
        if(m.containsKey(str)){
            return m.get(str);
        }
        int x=ways(ind+1, s, m);
        
        int c1=(int)(s.charAt(ind)-'0');
        int c2=(int)(s.charAt(ind+1) -'0');
        int num=c1*10 +c2;
        // System.out.println(num);
        int y=0;
        if(num <= 26){
            y=ways(ind+2, s, m);
        }
        m.put(str, x+y);
        return x+y;
    }
    public int numDecodings(String s) {
        Map<String, Integer> m=new HashMap<>();
        return ways(0, s, m);
    }
}
