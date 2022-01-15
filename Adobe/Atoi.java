class Solution {
    public int myAtoi(String s) {
        int n=s.length();
        char sn='\0';
        Queue<Integer> q=new LinkedList<>();
        ArrayList<Character> l=new ArrayList<>();
        int f=0;
        for(int i=0; i<n; i++){
            char c=s.charAt(i);
            if(l.size() == 0 && q.size() == 0 && f == 0 && c == '-'){
                sn=c;
                f=1;
            }else if(l.size() == 0 && q.size() == 0 && f ==0 && c == '+'){
                sn=c;
                f=1;
            }else if(l.size() == 0 && c >='0' && c <= '9'){
                int x=(int)(c-'0');
                q.add(x);
            }else if(q.size() != 0){
                if(c >= 'a' && c <= 'z'){
                    break;
                }else if(c >='A' && c <='Z'){
                    break;
                }else if(c =='+' || c=='-'|| c =='.'|| c==' '){
                    break;
                }
            }else if(q.size() == 0){
                if(f == 1 && c =='+'){
                    l.add(c);
                }else if(f == 1 && c =='-'){
                    l.add(c);
                }else if(c >= 'a' && c <='z'){
                    l.add(c);
                }else if(c >='A' && c <='Z'){
                    l.add(c);
                }else if(c =='.'){
                    l.add(c);
                }else if(f == 1 && c ==' '){
                    l.add(c);
                }
            }
        }
        long x=2147483647;
        long y=-2147483648;
        long num=0;
        while(!q.isEmpty()){
            // System.out.println(q.peek());
            if(num > x+1){
                break;
            }
            num =num*10+q.peek();
            q.remove();
        }
      
        if(sn == '-'){
            long ans=-num;
            if(ans < y){
                return (int)y;
            }else if(ans > x){
                return (int)x;
            }else{
                return (int)ans;
            }
        }
      
        if(num < y){
            return (int)y;
        }else if(num > x){
            return (int)x;
        }else{
            return (int)num;
        }
    }
}
