//Tan,Zhixi V00821283
//Running time O(n^2)
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class SortedSumsOfCubics {
	public static void sortedSumsOfCubics(int n){
				
		if(n<=0){
			System.out.println("Error.Should be a non-negative integer.");
			return ;
		}
		
		for(int i=0;i<=n;i++){
			for(int j=0;j<=i;j++){
				int r=i*i*i+j*j*j;
				
				System.out.print(r+" ");
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a non-negative integer:");
		int n=sc.nextInt();
		sc.close();
		sortedSumsOfCubics(n);
		
	}

}
