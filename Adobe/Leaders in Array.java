class Solution{
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        ArrayList<Integer> ans=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        
        for(int i=0; i<n; i++){
            if(st.isEmpty()){
                st.push(arr[n-i-1]);
            }else if(!st.isEmpty() && st.peek() <= arr[n-i-1]){
                st.push(arr[n-i-1]);
            }
        }
        
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        
        return ans;
    }
}
