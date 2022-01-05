class Solution {
    public boolean isAlphabet(char c){
        if(c >= 'a' && c <= 'z'){
            return true;
        }
        return false;
    }
    public boolean isNumber(char c){
        if(c >= '0' && c <= '9'){
            return true;
        }
        return false;
    }
    public String decodeString(String s) {
        int n=s.length();
        Stack<Character> st=new Stack<>();
        for(int i=0; i<n; i++){
            char c=s.charAt(i);
            if(c == '[' || isAlphabet(c) || isNumber(c)){
                st.push(c);
            }else if(c == ']'){
                ArrayList<Character> l=new ArrayList<>();
                while(isAlphabet(st.peek())){
                    l.add(st.pop());
                }
                st.pop();
                int num=0;
                int factor=1;
                while(!st.isEmpty() && isNumber(st.peek())){
                    int x=(int)(st.pop()-'0');
                    num += factor*x;
                    factor *=10;
                }
                for(int j=0; j<num; j++){
                    for(int k=0; k<l.size(); k++){
                        st.push(l.get(l.size()-k-1));
                    }
                }
            }
        }
        StringBuilder s1=new StringBuilder();
        String ans="";
        while(!st.isEmpty()){
             s1.append(st.pop());
        }
        StringBuilder rev=s1.reverse();
        ans=rev.toString();
        return ans;
    }
}
