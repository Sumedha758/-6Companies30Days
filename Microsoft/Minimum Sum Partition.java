class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int sum=0;
	    
	    for(int i=0; i<n; i++){
	        sum += arr[i];
	    }
	    
	    boolean dp[][]=new boolean[n+1][sum+1];
	    
	    for(int i=0; i<n+1; i++){
	        dp[i][0]=true;
	    }
	    for(int i=1; i<sum+1; i++){
	        dp[0][i]=false;
	    }
	    
	    for(int i=1; i<n+1; i++){
	        for(int j=1; j<sum+1; j++){
	            if(arr[i-1] <= j){
	                dp[i][j] =dp[i-1][j-arr[i-1]]|| dp[i-1][j];
	            }else{
	                dp[i][j]=dp[i-1][j];
	            }
	        }
	    }
	    
	    ArrayList<Integer> l=new ArrayList<>();
	    for(int i=0; i<=sum/2; i++){
	        if(dp[n][i] == true){
	            l.add(i);
	        }
	    }
	    
	    int min=Integer.MAX_VALUE;
	    for(int i=0; i<l.size(); i++){
	        int y=sum-2*l.get(i);
	        if(min > y){
	            min=y;
	        }
	    }
	    return min;
	} 
}
