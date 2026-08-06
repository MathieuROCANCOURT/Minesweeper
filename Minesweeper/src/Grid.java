
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
					if (Bumb.isBumb(bombs, indexRow, indexColumn)) {
						System.out.print('B');
					} else {
						System.out.print(nbBumbAround(bombs, indexRow, indexColumn));
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

	private int nbBumbAround(int[][] bombs, int row, int column) {
		int countBumb = 0;
		
		for (int indexRow = row - 1; indexRow <= row + 1; indexRow++) {
			for (int indexColumn = column - 1; indexColumn <= column + 1; indexColumn++) {
				if (Bumb.isBumb(bombs, indexRow, indexColumn)) {
					countBumb++;
				}
			}
		}
		return countBumb;
	}
}
