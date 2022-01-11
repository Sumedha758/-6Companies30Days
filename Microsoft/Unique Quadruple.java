// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        Set<ArrayList<Integer>> s=new LinkedHashSet<>();
        ArrayList<Integer> y=new ArrayList<>();
        Arrays.sort(arr);
        int n=arr.length;
        for(int i=0; i<n; i++){
            int p=arr[i];
            for(int j=i+1; j<n; j++){
                int q=arr[j];
                int l=j+1;
                int h=n-1;
                while(l < h){
                    if(p+q+arr[l]+arr[h] == k){
                        y.add(p);
                        y.add(q);
                        y.add(arr[l]);
                        y.add(arr[h]);
                        s.add(new ArrayList<>(y));
                        y.clear();
                        l++;
                        h--;
                    }else if(p+q+arr[l]+arr[h] < k){
                        l++;
                    }else{
                        h--;
                    }
                }
            }
        }
        for(ArrayList<Integer> it:s){
            ans.add(new ArrayList<>(it));
        }
        return ans;
    }
}
