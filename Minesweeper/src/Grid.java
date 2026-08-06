/**
 * 
 */

import java.util.Arrays;

/**
 * 
 */
public class Grid {
	public StateCase[][] initGrid(int nbRow, int nbColumn) {
		StateCase[][] grid = new StateCase[nbRow][nbColumn];
		Arrays.fill(grid, StateCase.NO_SELECT);
		
		return grid;
	}

}
