class Solution{
    public String amendSentence(String s){
        //code here
        int n=s.length();
        
        StringBuilder ans=new StringBuilder();
        StringBuilder str=new StringBuilder();
        
        for(int i=0; i<n; i++){
            
            char c=s.charAt(i);
            
            if(c >= 'a' && c <= 'z'){
                str.append(c);
            }else if(c >= 'A' && c <= 'Z'){
                
                if(str.length() != 0){
                    str.append(' ');
                    ans.append(str);
                }
                
                str=new StringBuilder();
                int x=(int)(c);
                char c1=(char)(x+32);
                str.append(c1);
            }
        }
        ans.append(str);
        
        return ans.toString();
    }
}

