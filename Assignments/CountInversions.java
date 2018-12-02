//v00821283 Tan,Zhixi
//CSC225 HW2

import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;
import java.io.File;

public class  CountInversions {

   public static int CountInversions(int[] array) {
	   int count = 0 ;
	   int arrLength = array.length;
	   
	   for (int i=0; i<arrLength-1; i++ ){
		
		    for(int j=i+1; j<arrLength;j++){
			    if (array[j]<array[i]){
			 	     count++;
			     }
		    }
		    
	   }
	
	
	   return count;
   }

public static void main(String[] args){
		Scanner s;
		if (args.length > 0){
			try{
				s = new Scanner(new File(args[0]));
			} catch(java.io.FileNotFoundException e){
				System.out.printf("Unable to open %s\n",args[0]);
				return;
			}
			System.out.printf("Reading input values from %s.\n",args[0]);
		}else{
			s = new Scanner(System.in);
			System.out.printf("Enter a list of non-negative integers. Enter a negative value to end the list.\n");
		}
		Vector<Integer> inputVector = new Vector<Integer>();

		int v;
		while(s.hasNextInt() && (v = s.nextInt()) >= 0)
			inputVector.add(v);

		int[] array = new int[inputVector.size()];

		for (int i = 0; i < array.length; i++)
			array[i] = inputVector.get(i);

		System.out.printf("Read %d values.\n",array.length);


		long startTime = System.currentTimeMillis();

		int counting = CountInversions(array);

		long endTime = System.currentTimeMillis();

		double totalTimeSeconds = (endTime-startTime)/1000.0;

		System.out.printf("The number of inversion is %d\n", counting);
		System.out.printf("Total Time (seconds): %.4f\n",totalTimeSeconds);
	}
}