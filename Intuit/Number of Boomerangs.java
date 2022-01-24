class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n=points.length;
        int cnt=0;
        Map<Double, Integer> m=new HashMap<>();
        
        for(int i=0; i<n; i++){
            m.clear();
            int x[]=points[i];
            for(int j=0; j<n; j++){
                if(points[j]==x)continue;
                double dis=Math.sqrt((x[0]-points[j][0])*(x[0]-points[j][0])+(x[1]-points[j][1])*(x[1]-points[j][1]));
                if(m.get(dis) == null){
                    
                    m.put(dis, 1);
                }else{                 
                    m.put(dis, m.get(dis)+1);
                }
            }
        
            for(double it:m.keySet()){
                int y=m.get(it);
                cnt =cnt +(y*(y-1));
            }
        }
        return cnt;
    }
}
