class Solution {
    public String convertToTitle(int columnNumber) {
        int n=columnNumber;
        Map<Integer, Character> m=new HashMap<>();
        int i=0;
        for(char c='A'; c<='Z'; c++){
            i++;
            m.put(i, c);
        }
        Stack<Character> st=new Stack<>();
        while(n > 26){
            int x=0;
            if(n % 26 == 0){
                x=n/26 - 1;
            }else{
                x=n/26;
            }
            while(n > 26){
                n=n%26;
            }
            if(n == 0){
                n=26;
            }
            st.push(m.get(n));
            n=x;
        }
        st.push(m.get(n));
        StringBuilder s=new StringBuilder();
        
        while(!st.isEmpty()){
            s.append(st.pop());
        }
        
        return s.toString();
    }
}
