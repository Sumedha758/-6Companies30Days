// { Driver Code Starts
import java.util.*;
import java.lang.String;
import java.lang.Math;
class Main{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			String s=sc.next();
			GfG g=new GfG();
			System.out.println(g.missingNumber(s));
		}
	}
}// } Driver Code Ends


/*Complete the function below*/
class GfG
{

	static int getValue(String str, int i, int m) {
		if (i + m > str.length()) {
			return -1;
		}
		
		int value = 0;
		for (int j = 0; j < m; j++) {
			int c = str.charAt(i + j) - '0';
			if (c < 0 || c > 9) {
				return -1;
			}
			value = value * 10 + c;
		}
		return value;
	}

	static int missingNumber(String str) {
	    
		for (int m = 1; m <= 6; ++m) {
			int n = getValue(str, 0, m);
			if (n == -1) {
				break;
			}
			
			int missingNo=-1;
			boolean fail = false;

			for (int i = m; i != str.length(); i += 1 + Math.log10(n)) {
				if ((missingNo == -1)
						&& (getValue(str, i, (int) (1 + Math.log10(n + 2))) == n + 2)) {
					missingNo = n + 1;
					n += 2;
				} 
				else if (getValue(str, i, (int) (1 + Math.log10(n + 1))) == n + 1) {
					n++;
				} else {
					fail = true;
					break;
				}
			}

			if (!fail) {
				return missingNo;
			}
		}
		return -1;
  }
}