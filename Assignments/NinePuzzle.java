import java.util.Scanner;
import java.io.File;

public class NinePuzzle{

	public static final int NUM_BOARDS = 362880;
    public static int[][] l = new int[NUM_BOARDS][4];
	public static int[][] discovery = new int[NUM_BOARDS][4];
	public static int[] visited = new int [NUM_BOARDS];
	

	public static void set(int[][]l,int a,int num){
			if ((l[num][0] != a) && (l[num][1] != a) && (l[num][2] != a) && (l[num][3] != a)){
				if (l[num][0] == -1)
					l[num][0] = a;
				else if (l[num][1] == -1)
					l[num][1] = a;
				else if (l[num][2] == -1)
					l[num][2] = a;
				else l[num][3] = a;
				if (l[a][0] == -1)
					l[a][0] = num;
				else if (l[a][1] == -1)
					l[a][1] = num;
				else if (l[a][2] == -1)
					l[a][2] = num;
				else l[a][3] = num;
			}
	}
	
	public static boolean SolveNinePuzzle(int[][] B){
		int [] array = new int [NUM_BOARDS]; 
		int integer =getIndexFromBoard(B);
		for (int  i =0; i < NUM_BOARDS; i++) {
			for (int  j =0; j < 4; j++) {
			l[i][j] = -1;			}
		}
		
		for (int k = 0; k < NUM_BOARDS; k++)  
			G(k);
			
		array = BFS(integer);
		int length=array.length;
		if (visited[0] == 0){
			return false;
		}
		else {
			for (int q =1; q < length; q++){
				int [][] temps = new int [3][3]; 
				temps = getBoardFromIndex(array[q]);
				printBoard(temps);
				if (array[q] == 0){
					break;
				}
			}
		}
		
		return true;
		
	}
	
	
	public static void G(int a){
		int num=a;
		int x=0,y=0;
		int temp=0;
		int[][] boardN= getBoardFromIndex(num);
	  	for (int i =0; i<3; i++){
		  for(int j =0; j<3;j++){
	   			if (boardN[i][j]==0){
	   				x = i;
	   				y = j;
	   			}
		  }
	  	}
	    
		    // case 1:
			if(x+1<=2){
				swap(boardN,x,y,x+1,y);
				
				int index = getIndexFromBoard(boardN);
                  l[num][0]=index;	
			}
			// case 2:
			if(x-1>=0){
				boardN=getBoardFromIndex(num);
				temp = boardN[x-1][y];
				boardN [x-1][y] = 0;
				boardN [x][y] = temp;
				int index = getIndexFromBoard(boardN);
                  l[num][1]=index;	
				  
	   		}
	              // case 3:
				  
			if(y+1<=2){
				boardN=getBoardFromIndex(num);
				temp = boardN[x][y+1];
				boardN [x][y+1] = 0;
				boardN [x][y] = temp;
				int index = getIndexFromBoard(boardN);
                l[num][2]=index;
                  
	        }
	  			  // case 4:
			if(y-1>=0){
				boardN=getBoardFromIndex(num);
				temp = boardN[x][y-1];
				boardN [x][y-1] = 0;
				boardN [x][y] = temp;
				int index = getIndexFromBoard(boardN);
                  l[num][3]=index;	
            }
	  
	  }
	
	
	public static int [] BFS(int i){
		int n = 362880;
		
		for (int j = 0; j < 362880; j++)
			visited[j] = 0;

		visited [i] = 1;
		boolean exist = true;
		for (int b = 1; b < n && exist ; b++) {
			exist = false;
			for (int v = 0; v < n; v++) {
				if (visited[v] == b) {
					if (l[v][0] != -1 && visited[l[v][0]] == 0){
						visited[l[v][0]] = b+1;
						exist = true;
					}
					if (l[v][1] != -1 && visited[l[v][1]] == 0){
						visited[l[v][1]] = b+1;
						exist = true;
					}
					if (l[v][2] != -1 && visited[l[v][2]] == 0){
						visited[l[v][2]] = b+1;
						exist = true;
					}
					if (l[v][3] != -1 && visited[l[v][3]] == 0){
						visited[l[v][3]] = b+1;
						exist = true;
					}
				}
			}
		}
		
		int[] kk = new int[n];
		
		int level = visited[0];
		int temp = 0;
		while (level > 1){
			boolean found = false;
				if (l[temp][0] != -1){
					if (visited[l[temp][0]] < level){
						kk[level] = temp;
						temp = l[temp][0];
						level = visited[temp];
						found = true;
					}
				}
				if (l[temp][1] != -1 && !found){
					if (visited[l[temp][1]] < level){
						kk[level] = temp;
						temp = l[temp][1];
						level = visited[temp];
						found = true;
					}
				}
				if (l[temp][2] != -1 && !found){
					if (visited[l[temp][2]] < level){
						kk[level] = temp;
						temp = l[temp][2];
						level = visited[temp];
						found = true;
					}
				}
				if (l[temp][3] != -1 && !found){
					if (visited[l[temp][3]] < level){
						kk[level] = temp;
						temp = l[temp][3];
						level = visited[temp];
					}
				}
		}
		
		kk[1] = temp;
		return kk;
	}
	
	public static void swap(int[][] array, int i1, int j1, int i2, int j2) {
		int temp = array[i1][j1];
		array[i1][j1] = array[i2][j2];
		array[i2][j2] = temp;
   }
	
	public static boolean isSuccess(int [][]B){
		int ok= getIndexFromBoard(B) ;
		while(ok==0){
			return true;
		}
		return false;
	}
	
	public static void printBoard(int[][] B){
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++)
				System.out.printf("%d ",B[i][j]);
			System.out.println();
		}
		System.out.println();
	}
	
		public static int getIndexFromBoard(int[][] B){
		int i,j,tmp,s,n;
		int[] P = new int[9];
		int[] PI = new int[9];
		for (i = 0; i < 9; i++){
			P[i] = B[i/3][i%3];   
			PI[P[i]] = i;   
		}
		int id = 0;
		int multiplier = 1;
		for(n = 9; n > 1; n--){
			s = P[n-1];
			P[n-1] = P[PI[n-1]];
			P[PI[n-1]] = s;
			
			tmp = PI[s];
			PI[s] = PI[n-1];
			PI[n-1] = tmp;
			id += multiplier*s;
			multiplier *= n;
		}
		return id;
	}
		
	public static int[][] getBoardFromIndex(int id){
		int[] P = new int[9];
		int i,n,tmp;
		for (i = 0; i < 9; i++)
			P[i] = i;
		for (n = 9; n > 0; n--){
			tmp = P[n-1];
			P[n-1] = P[id%n];
			P[id%n] = tmp;
			id /= n;
		}
		int[][] B = new int[3][3];
		for(i = 0; i < 9; i++)
			B[i/3][i%3] = P[i];
		return B;
	}
	

	public static void main(String[] args){
				
		Scanner s;

		if (args.length > 0){
			//If a file argument was provided on the command line, read from the file
			try{
				s = new Scanner(new File(args[0]));
			} catch(java.io.FileNotFoundException e){
				System.out.printf("Unable to open %s\n",args[0]);
				return;
			}
			System.out.printf("Reading input values from %s.\n",args[0]);
		}else{
			//Otherwise, read from standard input
			s = new Scanner(System.in);
			System.out.printf("Reading input values from stdin.\n");
		}
		
		int graphNum = 0;
		double totalTimeSeconds = 0;
		
		while(true){
			graphNum++;
			if(graphNum != 1 && !s.hasNextInt())
				break;
			System.out.printf("Reading board %d\n",graphNum);
			int[][] B = new int[3][3];
			int valuesRead = 0;
			for (int i = 0; i < 3 && s.hasNextInt(); i++){
				for (int j = 0; j < 3 && s.hasNextInt(); j++){
					B[i][j] = s.nextInt();
					valuesRead++;
				}
			}
			if (valuesRead < 9){
				System.out.printf("Board %d contains too few values.\n",graphNum);
				break;
			}
			System.out.printf("Attempting to solve board %d...\n",graphNum);
			long startTime = System.currentTimeMillis();
			boolean isSolvable = SolveNinePuzzle(B);
			long endTime = System.currentTimeMillis();
			totalTimeSeconds += (endTime-startTime)/1000.0;
			
			if (isSolvable)
				System.out.printf("Board %d: Solvable.\n",graphNum);
			else
				System.out.printf("Board %d: Not solvable.\n",graphNum);
		}
		graphNum--;
		System.out.printf("Processed %d board%s.\n Average Time (seconds): %.2f\n",graphNum,(graphNum != 1)?"s":"",(graphNum>1)?totalTimeSeconds/graphNum:0);

	}

}
