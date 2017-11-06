package sudoku;

import java.util.*;


public class Grid 
{
	private int[][]						values;
	

	//
	// DON'T CHANGE THIS.
	//
	// Constructs a Grid instance from a string[] as provided by TestGridSupplier.
	// See TestGridSupplier for examples of input.
	// Dots in input strings represent 0s in values[][].
	//
	public Grid(String[] rows)
	{
		values = new int[9][9];
		for (int j=0; j<9; j++)
		{
			String row = rows[j];
			char[] charray = row.toCharArray();
			for (int i=0; i<9; i++)
			{
				char ch = charray[i];
				if (ch != '.')
					values[j][i] = ch - '0';
			}
		}
	}
	
	
	//
	// DON'T CHANGE THIS.
	//
	public String toString()
	{
		String s = "";
		for (int j=0; j<9; j++)
		{
			for (int i=0; i<9; i++)
			{
				int n = values[j][i];
				if (n == 0)
					s += '.';
				else
					s += (char)('0' + n);
			}
			s += "\n";
		}
		return s;
	}


	//
	// DON'T CHANGE THIS.
	// Copy ctor. Duplicates its source. You’ll call this 9 times in next9Grids.
	//
	Grid(Grid src)
	{
		values = new int[9][9];
		for (int j=0; j<9; j++)
			for (int i=0; i<9; i++)
				values[j][i] = src.values[j][i];
	}
	
	
	//J is row
	//I is column
	// COMPLETE THIS
	//
	//
	// Finds an empty member of values[][]. Returns an array list of 9 grids that look like the current grid,
	// except the empty member contains 1, 2, 3 .... 9. Returns null if the current grid is full. Don’t change
	// this grid. Build 9 new grids.
	// 
	//
	// Example: if this grid = 1........
	//                         .........
	//                         .........
	//                         .........
	//                         .........
	//                         .........
	//                         .........
	//                         .........
	//                         .........
	//
	// Then the returned array list would contain:
	//
	// 11.......          12.......          13.......          14.......    and so on     19.......
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	//
	public ArrayList<Grid> next9Grids()
	{		
		int xOfNextEmptyCell=-1;
		int yOfNextEmptyCell=-1;
		boolean found = false;

		// Find x,y of an empty cell.
		findempty:
		for (int j=0; j<9; j++)
		{
			for (int i=0; i<9; i++)
			{
				int current = values[j][i];
				{
					if(current == 0) {
						found = true;
						xOfNextEmptyCell = j;
						yOfNextEmptyCell = i;
						break findempty;
						
					}
				}
				
			}
		}
		
		//trivial case, the grid is full, no empty spaces found
		if (!found) {
			return null;
		}
		

		// Construct array list to contain 9 new grids.
		ArrayList<Grid> grids = new ArrayList<Grid>();

		if(xOfNextEmptyCell!=-1 && yOfNextEmptyCell!=-1) {
		for(int i=1;i<=9;i++) {
			Grid toAdd = new Grid(this);
			toAdd.values[xOfNextEmptyCell][yOfNextEmptyCell] = i;
			grids.add(toAdd);
			
		}
		}
		// Create 9 new grids as described in the comments above. Add them to grids.

		return grids;
	}
	
	
	
	
	
	
	
	
	
	
	// Returns true if this grid is legal. A grid is legal if no row, column, or
	// 3x3 block contains a repeated 1, 2, 3, 4, 5, 6, 7, 8, or 9.
	//
	public boolean isLegal()
	{
	
		
		// Check every row. If you find an illegal row, return false.
		//Row is 0 
		for(int row=0;row<9;row++) {
			ArrayList<Integer> rowList = new ArrayList<Integer>(9);
			for(int column=0;column<9;column++) {
				if (values[row][column] >= 1 && values[row][column] <= 9){
				rowList.add(new Integer(values[row][column]));
				//System.out.println("added");
				}
			}
			HashSet<Integer> rowSet = new HashSet<Integer>(rowList);
			if(rowSet.size()<rowList.size()) {
				return false;
			}
		}
	

		
		// Check every column. If you find an illegal column, return false.
		
		for(int column=0;column<9;column++) {
			ArrayList<Integer> columnList = new ArrayList<Integer>(9);
			for(int row=0;row<9;row++) {
				if (values[row][column] >= 1 && values[row][column] <= 9){
				columnList.add(new Integer(values[row][column]));
				}
			
			}
			HashSet<Integer> columnSet = new HashSet<Integer>(columnList);
			if(columnSet.size()<columnList.size()) {
				return false;
			}
		}

		// Check every block. If you find an illegal block, return false.
		
		if(!blockValid(0,0) || !blockValid(0,3)|| !blockValid(0,6)||
			!blockValid(3,0) || !blockValid(3,3)|| !blockValid(3,6)||
			!blockValid(6,0) || !blockValid(6,3)|| !blockValid(6,6) )
			return false;
			
		
		

		// All rows/cols/blocks are legal.
		return true;
	}
	
	
	//returns if 3x3 at that starting point is legal or not
	public boolean blockValid(int rowStart, int columnStart){
		
		ArrayList<Integer> blockList = new ArrayList<Integer>(9);//holds all values in block
		
		
		for(int row=rowStart;row<=(rowStart+2);row++) {
			for(int column=columnStart;column<=(columnStart+2);column++) {
				if (values[row][column] >= 1 && values[row][column] <= 9){
				blockList.add(new Integer(values[row][column]));
				}
			}
		}
		
		HashSet<Integer> blockSet = new HashSet<Integer>(blockList);
		if(blockSet.size()<blockList.size()) {
			return false;
		}
		else {
			return true;
		}
		
	
	
	}
	


	
	
	// Returns true if every cell member of values[][] is a digit from 1-9.
	//
	public boolean isFull()
	{
		for(int row=0;row<9;row++) {
			for(int column=0;column<9;column++) {
				int current = values[row][column];
				if(!(current>=1 && current<=9)) 
					return false;
			}
		}
		
		return true;

	}
	

	
	// Returns true if x is a Grid and, for every (i,j), 
	// x.values[i][j] == this.values[i][j].
	//
	public boolean equals(Object x)
	{
		Grid that = (Grid)x;
		
			for(int row=0;row<9;row++) {
				for(int column=0;column<9;column++) {
					if(this.values[row][column]!=that.values[row][column]) {
						return false; //if any value isn't equals, return that it's not equal
					}
				}
			}
		
		
		return true;

	}
	
	
	public static void main(String[] args) {
		Grid g = TestGridSupplier.getPuzzle1();
		Solver solver = new Solver(g);
		solver.solve();
		Grid soln = solver.getSolutions().get(0);
	}
}
