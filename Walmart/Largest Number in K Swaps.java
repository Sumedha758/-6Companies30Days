class Solution
{
    //Function to find the largest number after k swaps
    public static void swap(char a[], int i, int j){
        char temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public static void possibleComb(char a[], int k, String x[]){
        
        if(k == 0){
            return;
        }
        
        for(int i=0; i<a.length-1; i++){
            for(int j=i+1; j<a.length; j++){
                if(a[i] < a[j]){
                    swap(a, i, j);
                    String y=String.valueOf(a);
                    if(x[0].compareTo(y) < 0){
                        x[0]=y;
                    }
                    possibleComb(a, k-1, x);
                    swap(a, i, j);
                }
            }
        }
    }
    public static String findMaximumNum(String str, int k)
    {
            //code here.
            String ans[]=new String[1];
            ans[0]=str;
            
            char a[]=str.toCharArray();
            
            possibleComb(a, k, ans);
            
            return ans[0];
    }
}
