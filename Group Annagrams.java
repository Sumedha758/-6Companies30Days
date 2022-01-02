class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n=strs.length;
        List<List<String>> ans=new ArrayList<>();
        Map<String, ArrayList<String>> m=new HashMap<>();
        for(int i=0; i<n; i++){
            char c[]=strs[i].toCharArray();
            Arrays.sort(c);
            String s=new String(c);
            // System.out.println(s);
            if(m.get(s) == null){
                ArrayList<String> l=new ArrayList<>();
                l.add(strs[i]);
                m.put(s, l);
            }else{
                ArrayList<String> l=m.get(s);
                l.add(strs[i]);
                m.put(s, l);
            }
        }
        for(String s:m.keySet()){
            ans.add(new ArrayList<>(m.get(s)));
        }
        return ans;
    }
}
