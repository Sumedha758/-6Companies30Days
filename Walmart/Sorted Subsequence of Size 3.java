class Solution {
    ArrayList<Integer> find3Numbers(ArrayList<Integer> arr, int n) {
        // add code here.
        ArrayList<Integer> ans=new ArrayList<>();
        int small[]=new int[n];
        int large[]=new int[n];
        int min=0;
        small[0] =-1;
        for(int i=0; i<n; i++){
            if(arr.get(i) <= arr.get(min)){
                min=i;
                small[i]=-1;
            }else{
                small[i]=min;
            }
        }
        int max=n-1;
        large[n-1] =-1;
        for(int i=n-2; i>=0; i--){
            if(arr.get(i) >= arr.get(max)){
                max=i;
                large[i]=-1;
            }else{
                large[i]=max;
            }
        }
        
        for(int i=0; i<n; i++){
            if(small[i] != -1 && large[i] != -1){
                ans.add(arr.get(small[i]));
                ans.add(arr.get(i));
                ans.add(arr.get(large[i]));
                break;
            }
        }
        return ans;
    }
}
