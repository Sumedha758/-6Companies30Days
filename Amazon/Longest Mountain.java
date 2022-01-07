class Solution {
    public int longestMountain(int[] arr) {
        int n=arr.length;
        if(n < 3){
            return 0;
        }
        ArrayList<Integer> l=new ArrayList<>();
        for(int i=1; i<n-1; i++){
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                l.add(i);
            }
        }
        int max=0;
        for(int i=0; i<l.size(); i++){
            int inc=0;
            int dec=0;
            for(int j=l.get(i); j>0; j--){
                if(arr[j] > arr[j-1]){
                    inc++;
                }else{
                    break;
                }
            }
            for(int j=l.get(i); j<n-1; j++){
                if(arr[j] > arr[j+1]){
                    dec++;
                }else{
                    break;
                }
            }
            // System.out.println(inc+" "+dec);
            int t=inc+dec+1;
            if(max < t){
                max=t;
            }
        }
        // System.out.println(l);
        return max;
    }
}
