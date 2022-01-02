class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n=arr.length;
        int rem[]=new int[k];
        
        for(int i=0; i<n; i++){
            int x=arr[i]%k;
            x=(x+k)%k;
            rem[x]++;
        }
        if(k % 2 == 0){
            if(rem[k/2] % 2 != 0){
                return false;
            }
        }
        if(rem[0] % 2 != 0){
            return false;
        }
        for(int i=1; i<=k/2; i++){
            if(rem[i] != rem[k-i]){
                return false;
            }
        }
        return true;
    }
}
