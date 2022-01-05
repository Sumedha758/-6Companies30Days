class Solution
{
    //Function to return k largest elements from an array.
    public static ArrayList<Integer> kLargest(int arr[], int n, int k)
    {
        // code here 
        ArrayList<Integer> l=new ArrayList<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0; i<n; i++){
            pq.add(-arr[i]);
        }
        for(int i=0; i<k; i++){
            l.add(-pq.poll());
        }
        return l;
    }
}
