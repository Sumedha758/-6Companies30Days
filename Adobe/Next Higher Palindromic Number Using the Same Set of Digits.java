class Solution
{
    public void swap(char c[], int i, int j){
        char temp=c[i];
        c[i]=c[j];
        c[j]=temp;
    }
    public void reverse(char c[], int i, int j){
        while(i <= j){
            swap(c ,i, j);
            i++;
            j--;
        }
    }
    public String nextPalin(String N) 
    { 
        //complete the function here
        int n=N.length();
        char c[]=N.toCharArray();
        int mid=n/2-1;
        int i=mid-1;
        
        while(i >= 0 && c[i] >= c[i+1]){
            i--;
        }
        
        if(i < 0){
            return "-1";
        }
        
        int j=mid;
        
        while(j >= 0 && c[i] >= c[j]){
            j--;
        }
        
        swap(c, i, j);
        swap(c, n-i-1, n-j-1);
        
        reverse(c, i+1, mid);
        
        if(n % 2 == 0){
            reverse(c, mid+1, n-i-2);
        }else{
            reverse(c, mid+2, n-i-2);
        }
        
        String ans=String.valueOf(c);
        return ans;
    }
}
