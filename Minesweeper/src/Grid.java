
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
		for (StateCase[] lineGrid : grid) {
			System.out.print(nbLine + " ");
			nbLine++;
			for (StateCase stateCase : lineGrid) {
				System.out.print("|");
				
				switch (stateCase) {
				case NO_SELECT:
					System.out.print(" ");
					break;
				case SELECT:
					if (isBomb(bombs)) {
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
}
