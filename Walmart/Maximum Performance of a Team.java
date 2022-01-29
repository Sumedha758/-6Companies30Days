class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k){
        int[][] engineers = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            engineers[i][0] = speed[i];
            engineers[i][1] = efficiency[i];
        }
        
        Arrays.sort (engineers, (engineer1, engineer2) -> engineer2[1] - engineer1[1]);
        
        long ss = 0;
        long mp = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<> ();
        
        for (int[] engineer : engineers) {
            if (pq.size () == k) {
                ss -= pq.poll ();
            }
            
            ss += engineer[0];
            pq.offer (engineer[0]);
            mp = Math.max (mp, ss * engineer[1]);
        }
        
        return (int) (mp % 1000000007);
    }
}
