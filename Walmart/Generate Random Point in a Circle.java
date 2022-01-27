class Solution {
    double r;
    double x;
    double y;
    public Solution(double radius, double x_center, double y_center) {
        this.r=radius;
        this.x=x_center;
        this.y=y_center;
    }
    
    public double[] randPoint() {
        double ans[]=new double[2];
        
        double x_min=x-r;
        double x_max=x+r;
        double y_min=y-r;
        double y_max=y+r;
        
        ans[0]=x_min+(Math.random()*(x_max-x_min));
        ans[1]=y_min+(Math.random()*(y_max-y_min));
        
        double a=(x-ans[0])*(x-ans[0]) + (y-ans[1])*(y-ans[1]);
        
        while(a > r*r){
            ans[0]=x_min+(Math.random()*(x_max-x_min));
            ans[1]=y_min+(Math.random()*(y_max-y_min));
            a=(x-ans[0])*(x-ans[0]) + (y-ans[1])*(y-ans[1]);
        }
        
        return ans;
    }
}
