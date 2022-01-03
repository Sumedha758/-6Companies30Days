class RLEncoding
{
   public static void main(String[] args) 
   {
 
      Scanner sc = new Scanner(System.in);
    
	  int T = sc.nextInt();
	  sc.nextLine();
	  while(T>0)
	  {
		  
		String str = sc.nextLine();
		
		GfG g = new GfG();
		System.out.println(g.encode(str));
		
      
        T--;
	  }
   }
}

// } Driver Code Ends


class GfG
 {
	String encode(String str)
	{
          //Your code here
          str=str+'#';
          int n=str.length();
          String ans="";
          int cnt=1;
          Map<Character, Integer> m=new HashMap<>();
          char c1=str.charAt(0);
          int i=0;
          int j=1;
          while(j<n){
              if(str.charAt(i) == str.charAt(j)){
                  cnt++;
                  i++;
                  j++;
              }else{
                  ans += str.charAt(i);
                  char c=(char)(cnt+'0');
                  ans += c;
                  i++;
                  j++;
                  cnt=1;
              }
          }
          return ans;
	}
	
 }
