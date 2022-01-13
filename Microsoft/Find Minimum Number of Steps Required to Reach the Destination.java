class Solution {
    public int reachNumber(int target) {
        if(target < 0){
            target=-target;
        }
        int i=0;
        while(target > 0){
            ++i;
            target=target-i;
        }
        
        if(target % 2 == 0){
            return i;
        }else{
            return i+1+i%2;
        }
    }
}
