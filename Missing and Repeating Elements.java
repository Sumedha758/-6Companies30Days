public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        Map<Integer, Integer> m=new HashMap<>();
                ArrayList<Integer> l=new ArrayList<>();

        for(int i=1; i<=A.size(); i++){
            m.put(i, 0);
        }
        for(int i=0; i<A.size(); i++){
            if(m.containsKey(A.get(i))){
                int x=m.get(A.get(i));
                x =x+1;
                if(x == 2){
                    l.add(A.get(i));
                }
                m.put(A.get(i), x);
            }
        }
        for(int it:m.keySet()){
            if(m.get(it) == 0){
                l.add(it);
                break;
            }
        }
        return l;
    }
}
