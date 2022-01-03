package lists;
import java.util.*;

public class nXn_chessboard {

	public static int getNumberOfSquares(int n) {
		int dp[]=new int[n+1];
		dp[0]=0;
		dp[1]=1;
		for(int i=2; i<=n; i++) {
			dp[i]=(i*i)+dp[i-1];
		}
		return dp[n];
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of a chess-board: ");
		int n=sc.nextInt();
		System.out.println("The number of squares are: "+getNumberOfSquares(n));
	}

}
