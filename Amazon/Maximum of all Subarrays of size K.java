class Solution {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        // Your code here
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0; i<n; i++){
            if(!dq.isEmpty() && dq.peek() == i-k){
                dq.removeFirst();
            }
            while(!dq.isEmpty() && arr[dq.peekLast()] < arr[i]){
                dq.removeLast();
            }
            dq.add(i);
            if(i >= k-1){
                ans.add(arr[dq.peek()]);
            }
        }
        return ans;
    }
}
