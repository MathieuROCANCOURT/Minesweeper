
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

	public void displayGrid(StateCase[][] grid, int[][] bombs) {
		int nbLine = 1;
		for (int indexRow = 0; indexRow < grid.length; indexRow++) {
			System.out.print(nbLine + " ");
			nbLine++;
			for (int indexColumn = 0; indexRow < grid[0].length; indexColumn++) {
				System.out.print("|");
				
				switch (grid[indexRow][indexColumn]) {
				case NO_SELECT:
					System.out.print(" ");
					break;
				case SELECT:
					if (isBomb(bombs, indexRow, indexColumn)) {
						System.out.print('B');
					} else {
						System.out.print(nbBombAround(bombs));
					}
					break;
				case POTENTIAL_BOMB:
					System.out.print("!");
				}
				
				System.out.print("|");
			}
			System.out.println();
		}
	}

	private boolean isBomb(int[][] bombs, int row, int column) {
		for (int[] bomb: bombs) {
			if (bomb[0] == row && bomb[1] == column) {
				return true;
			}
		}
		return false;
	}
}
