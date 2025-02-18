package sudoku;

import java.util.*;


public class Solver 
{
	private Grid						problem;
	private ArrayList<Grid>				solutions;
	
	
	public Solver(Grid problem)
	{
		this.problem = problem;
	}
	
	
	public void solve()
	{
		solutions = new ArrayList<>();
		solveRecurse(problem);
	}
	
		
	// 
	// FINISH THIS.
	//
	// Standard backtracking recursive solver.
	//
	private void solveRecurse(Grid grid)
	{		
		Evaluation eval = evaluate(grid);
		
		if (eval == Evaluation.ABANDON)
		{
			return;
			// Abandon evaluation of this illegal board.
		}
		else if (eval == Evaluation.ACCEPT)
		{
			solutions.add(grid);
			// A complete and legal solution. Add it to solutions.
		}
		else
		{
			assert eval ==Evaluation.CONTINUE;
			ArrayList<Grid> nextGrids = grid.next9Grids();
			for(Grid nextGrid: nextGrids) {
				solveRecurse(nextGrid);
			}
			// Here if eval == Evaluation.CONTINUE. Generate all 9 possible next grids. Recursively 
			// call solveRecurse() on those grids.
		}
	}
	
	//
	// COMPLETE THIS
	//
	// Returns Evaluation.ABANDON if the grid is illegal. 
	// Returns ACCEPT if the grid is legal and complete.
	// Returns CONTINUE if the grid is legal and incomplete.
	//
	public Evaluation evaluate(Grid grid)
	{
		if(!grid.isLegal())//grid has duplicates
			return Evaluation.ABANDON;
		else if (grid.isFull())
			return Evaluation.ACCEPT;
		else
			return Evaluation.CONTINUE; //grid isn't full


	}

	
	public ArrayList<Grid> getSolutions()
	{
		return solutions;
	}
	
	
	public static void main(String[] args)
	{
		Grid g = TestGridSupplier.getPuzzle1();		// or any other puzzle
		Solver solver = new Solver(g);
		System.out.println("Will solve\n "+ g);
		solver.solve();
		
		// Print out your solution, or test if it equals() the solution in TestGridSupplier.
	}
}
