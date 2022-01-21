class Solution {
    public int canEat(int a[], int k){
        int hr=0;
        int n=a.length;
        for(int i=0; i<n; i++){
            if(a[i] <= k){
                hr++;
            }else{
                if(a[i] % k == 0){
                    hr += a[i]/k;
                }else{
                    hr += a[i]/k;
                    hr++;
                }
            }
        }
        return hr;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int max=0;
        for(int i=0; i<n; i++){
            if(max < piles[i]){
                max=piles[i];
            }
        }
        int min=Integer.MAX_VALUE;
        int lo=1;
        int hi=max;
        while(lo <= hi){
            int mid=lo+(hi-lo)/2;
            int x=canEat(piles, mid);
            if(x <= h){
                min=mid;
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return min;
    }
}
