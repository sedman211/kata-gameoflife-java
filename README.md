# Game of Life Program
A small java representation of John Conway's game of life, built for a job application process. Restricted to the bounds of the grid. Work in progress.

# Instructions
Instructions and general info for running this java simulation.

ConwaySim.java was created using Eclipse IDE, and contains its own main method.
This means that it 'should' work with any decent java compiler that can execute
the program. You should have the java SDK installed, as well as the java PATH set 
up in the computer's environment variables just in case.

The rules for this game of life are as follows:

1. Any live cell with fewer than two live neighbors dies, as if caused by underpopulation. 
2. Any live cell with more than three live neighbors dies, as if by overcrowding. 
3. Any live cell with two or three live neighbors lives on to the next generation. 
4. Any dead cell with exactly three live neighbors becomes a live cell. 
5. A cell’s neighbors are those cells which are horizontally, vertically or diagonally adjacent. 
   Most cells will have eight neighbors. Cells placed on the edge of the grid will have fewer.
   
# More About the Java Program
Each live cell in the game is represented by a 'O', while each dead cell is
represented by a '_' to make it visually simple.

When the program is run, you enter 4 values:

Number of rows,

Number of columns,

Seed number,

Continuous generation (Y/N)

The user can enter any number of rows and columns for the game. The seed value
specifies how many times a random cell in the grid will be changed from '0' (Dead)
to '1' (Alive). I set it up this way because I didn't find a quick way of setting
specific cells to alive in the game. Lastly, continuous generation can be set to either
'Y' or 'N' (In reality, it can be anything other than Y to stop it). This will make 
the game continue once, or generate every 2 seconds until the program is killed by the user. 
All of this is a work-in-progress.
