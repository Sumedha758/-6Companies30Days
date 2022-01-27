class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        int n=nums.length;
        int g=n-k+1;
        
        Map<Integer, ArrayList<String>> m=new TreeMap<>();
        
        for(int i=0; i<n; i++){
            int len=nums[i].length();
            
            if(m.get(len) == null){
                ArrayList<String> s=new ArrayList<>();
                s.add(nums[i]);
                m.put(len, s);
            }else{
                ArrayList<String> s=m.get(len);
                s.add(nums[i]);
                m.put(len, s);
            }
        }
        
        int x=0;
        String ans="";
        
        for(int it:m.keySet()){
            Collections.sort(m.get(it));
            int len=m.get(it).size();
            if(x < g && x + len >= g){
                int y=x;
                for(int i=0; i<len; i++){
                    ans = m.get(it).get(i);
                    y++;
                    if(y == g){
                        break;
                    }
                }
            }
            if(ans.length() != 0){
                break;
            }
            x += len;
        }
        
        return ans;
    }
}
