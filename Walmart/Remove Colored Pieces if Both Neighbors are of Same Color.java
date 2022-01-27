class Solution {
    public boolean winnerOfGame(String colors) {
        int n=colors.length();
        int a=0;
        int b=0;
        int cntA=0;
        int cntB=0;
        
        for(int i=0; i<n; i++){
            char c=colors.charAt(i);
            if(c == 'A'){
                cntA++;
            }else{
                if(cntA > 2){
                    a += (cntA-2);
                }
                cntA=0;
            }
        }
        if(cntA > 2){
            a += (cntA-2);
        }
        
         for(int i=0; i<n; i++){
            char c=colors.charAt(i);
            if(c == 'B'){
                cntB++;
            }else{
                if(cntB > 2){
                    b += (cntB-2);
                }
                cntB=0;
            }
        }
        if(cntB > 2){
            b += (cntB-2);
        }
        
        if(a > b){
            return true;
        }
        
        return false;
    }
}
