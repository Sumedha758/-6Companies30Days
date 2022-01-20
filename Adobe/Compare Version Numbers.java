class Solution {
    public int compareVersion(String version1, String version2) {
        int n=version1.length();
        int m=version2.length();
        
        Queue<Integer> q1=new LinkedList<>();
        Queue<Integer> q2=new LinkedList<>();
        
        int num1=0;
        for(int i=0; i<n; i++){
            char c=version1.charAt(i);
            if(c != '.'){
                int x=(int)(c-'0');
                num1 = num1*10 + x;
            }else if(c == '.'){
                q1.add(num1);
                num1=0;
            }
        }
        q1.add(num1);
        
        
        int num2=0;
        for(int i=0; i<m; i++){
            char c=version2.charAt(i);
            if(c != '.'){
                int x=(int)(c-'0');
                num2 = num2*10 + x;
            }else if(c == '.'){
                q2.add(num2);
                num2=0;
            }
        }
        q2.add(num2);
        
        
        if(q1.size() > q2.size()){
            while(q1.size() != q2.size()){
                q2.add(0);
            }
        }else if(q1.size() < q2.size()){
            while(q1.size() != q2.size()){
                q1.add(0);
            }
        }
        
        while(!q1.isEmpty()){
            
            int v1=q1.poll();
            int v2=q2.poll();
            
            if(v1 > v2){
                return 1;
            }else if(v1 < v2){
                return -1;
            }
        }
        return 0;
    }
}
