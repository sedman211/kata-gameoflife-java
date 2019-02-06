
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ConwaySim {
// Sedrick Bolden - Simulation of John Conway's game of life in Java, bound to grid edges

	public static void main(String[] args) throws InterruptedException {

		// Read user input to get the number of rows
		Scanner rowRead = new Scanner(System.in);  	
		
		System.out.println("Enter the number of rows: ");
		
		int A = rowRead.nextInt();
		
		// Read user input to get the number of columns
		Scanner colRead = new Scanner(System.in);   
		
		System.out.println("Enter the number of columns: ");
		
		int B = colRead.nextInt();
		
		int[][] frame = new int[A][B];
		
		// Read user input to get a seed for the current generation
		Scanner seedRead = new Scanner(System.in);  
		
		System.out.println("Enter a seed number for the initial state: ");
		
		int seed = seedRead.nextInt();
		
		// Read user input to set continuous generation or not
		Scanner continuousRead = new Scanner(System.in);  	
		
		System.out.println("Continuous generation? (Y/N) ");
		
		char C = continuousRead.next().charAt(0);
		
		//Stop memory leaks from scanners
		rowRead.close();
		colRead.close();
		seedRead.close();
		continuousRead.close();
		
		Random r = new Random();
		
		// Depending on the seed X, random elements will be changed X times to Alive state
		for(int i = 0; i < seed; i++) 
		{
			frame[r.nextInt(A)][r.nextInt(B)] = 1;
		}
		
		// Initial state is displayed
		System.out.println("Current Generation:");
		
		for(int i = 0; i < A; i++)
		{
			for(int j = 0; j < B; j++)
			{
				if (frame[i][j] == 0)
				{
					System.out.print("_");
				}
				else
				{
					System.out.print("O");
				}
				
				if (j == B-1)
				{
					System.out.println();
				}
			}
		}
		
		// Depending on whether Continuous generation is set to 'Y', wait 2 seconds and generate
		TimeUnit.SECONDS.sleep(2);
		frame = nextGen(frame, A, B);
		
		while(C == 'Y')
		{
			TimeUnit.SECONDS.sleep(2);
			frame = nextGen(frame, A, B);
		}
		
	}
	
	// State generator function that considers the grid edges
	static int[][] nextGen(int array[][], int X, int Y) {
		
		int state[][] = new int[X][Y];
		
		for(int k = 0; k < X; k++) 
		{
			for(int l = 0; l < Y; l++) 
			{	
				int neighbors = 0;
				
				// Calculating the number of neighbors for each cell, depending on
				// grid position
			
				// Upper left edge
				if (k == 0 && l == 0) 
				{
					for(int m = 0; m <= 1; m++)
					{
						for(int n = 0; n <= 1; n++)
						{
							neighbors += array[k + m][l + n];					
						}
					}
				}

				// Upper edge
				else if(k == 0 && l != 0 && l != Y-1)
				{
					for(int m = 0; m <= 1; m++)
					{
						for(int n = -1; n <= 1; n++)
						{
							neighbors += array[k + m][l + n];	
						}
					}
				}
				
				// Upper right edge
				else if(k == 0 && l == Y-1)
				{
					for(int m = 0; m <= 1; m++)
					{
						for(int n = 0; n >= -1; n--)
						{
							neighbors += array[k + m][l + n];	
						}
					}
				}
				
				// Right edge
				else if(k != 0 && k != X-1 && l == Y-1)
				{
					for(int m = -1; m <= 1; m++)
					{
						for(int n = -1; n <= 0; n++)
						{
							neighbors += array[k + m][l + n];		
						}
					}
				}
				
				// Bottom right edge
				else if(k == X-1 && l == Y-1)
				{
					for(int m = -1; m <= 0; m++)
					{
						for(int n = -1; n <= 0; n++)
						{
							neighbors += array[k + m][l + n];	
						}
					}
				}
				
				// Bottom edge
				else if(k == X-1 && l != 0 && l != Y-1)
				{
					for(int m = -1; m <= 0; m++)
					{
						for(int n = -1; n <= 1; n++)
						{
							neighbors += array[k + m][l + n];	
						}
					}
				}
				
				// Bottom left edge
				else if(k == X-1 && l == 0)
				{
					for(int m = -1; m <= 0; m++)
					{
						for(int n = 0; n <= 1; n++)
						{
							neighbors += array[k + m][l + n];	
						}
					}
				}
				
				// Left edge
				else if(k != 0 && k != X-1 && l == 0)
				{
					for(int m = -1; m <= 1; m++)
					{
						for(int n = 0; n <= 1; n++)
						{
							neighbors += array[k + m][l + n];	
						}
					}
				}
				
				// All others
				else
				{
					for(int m = -1; m <= 1; m++)
					{
						for(int n = -1; n <= 1; n++)
						{
							neighbors += array[k + m][l + n];	
						}
					}
				}
				
				// Remove the cell itself from neighbor count
				neighbors -= array[k][l];

				// Live cell with fewer than two neighbors dies
				if ((array[k][l] == 1) && (neighbors < 2)) 
				{
				    state[k][l] = 0;
				}

				// Live cell with more than 3 neighbors dies
				else if ((array[k][l] == 1) && (neighbors > 3)) 
				{
				    state[k][l] = 0; 
				}
				// Dead cell with exactly 3 neighbors is brought to life
				else if ((array[k][l] == 0) && (neighbors == 3)) 
				{
				    state[k][l] = 1; 
				}
				// All others are unchanged
				else
				{
				    state[k][l] = array[k][l]; 
				}
				
	        	}
			
	        }
		
		// Display and return the next state of the grid
		System.out.println("Next Generation:");
		
		for(int i = 0; i < X; i++)
		{
			for(int j = 0; j < Y; j++)
			{
				if (state[i][j] == 0)
				{
						System.out.print("_");
				}
				else
				{
						System.out.print("O");
				}
				if (j == Y-1)
				{
					System.out.println();
				}
			}
		}
		return state;	
	}
}
