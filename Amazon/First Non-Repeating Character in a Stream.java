class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
        int n=A.length();
        String ans="";
        ArrayDeque<Character> dq=new ArrayDeque<>();
        Map<Character, Integer> m=new HashMap<>();
        StringBuilder st=new StringBuilder();
        for(int i=0; i<n; i++){
            char c=A.charAt(i);
            dq.add(c);
            if(m.get(c) == null){
                m.put(c, 1);
            }else{
                m.put(c, m.get(c)+1);
            }
            while(!dq.isEmpty()){
                if(m.get(dq.peek()) > 1){
                    dq.remove();
                }else{
                    st.append(dq.peek());
                    break;
                }
            }
            if(dq.isEmpty()){
                st.append('#');
            }
        }
        ans =st.toString();
        return ans;
        
    }
} 
