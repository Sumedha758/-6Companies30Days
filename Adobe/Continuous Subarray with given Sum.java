class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        ArrayList<Integer> ans=new ArrayList<>();
        int sum=0;
        int j=0;
        for(int i=0; i<n; i++){
            sum += arr[i];
            while(sum > s){
                sum -= arr[j];
                j++;
            }
            if(sum == s){
                ans.add(j+1);
                ans.add(i+1);
                break;
            }
        }
        if(ans.size() == 0){
            ans.add(-1);
        }
        return ans;
    }
}
