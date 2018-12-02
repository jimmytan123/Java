//Tan,Zhixi V00821283

import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;
import java.io.File;

public class TripleSum{
	
	public static boolean TripleSum225(int[] A){
	
	//from 0-225
    int size = 225+1;
	boolean[] a = new boolean[size];
	int arrLength = A.length;
	
	for(int i=0;i<=225;i++){
	        a[i]=false;
	}
	
	for(int j=0;j<=225;j++){
		    a[j]=false;
    }
    for(int k=0;k<=225;k++){
			a[k]=false;
	}

	//search for the required range
	//in boolean
	for(int i=0; i<arrLength; i++){
       int rangeNum = A[i];

	   if(rangeNum>=0 && rangeNum<=225){
		a[rangeNum]=true;
	   } 
	}
	
	//check the all required possible cases 
	for(int i=0;i<=225;i++){
		for(int j=0;j<=225;j++){
			for(int k=0;k<=225;k++){
				if(a[i]==true & a[j]==true & a[k]==true){
				   if(i+j+k == 225){
					return true;
                 }
				}
		     }
        }
	}
    return false;
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

		boolean tripleExists = TripleSum225(array);

		long endTime = System.currentTimeMillis();

		double totalTimeSeconds = (endTime-startTime)/1000.0;

		System.out.printf("Array %s a triple of values which add to 225.\n",tripleExists? "contains":"does not contain");
		System.out.printf("Total Time (seconds): %.4f\n",totalTimeSeconds);
	}
}