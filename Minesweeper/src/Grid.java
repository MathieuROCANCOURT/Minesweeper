
/**
 * 
 */

import java.util.Arrays;

/**
 * 
 */
public class Grid {
	public static StateCase[][] initGrid(int nbRow, int nbColumn) {
		StateCase[][] grid = new StateCase[nbRow][nbColumn];
		for (StateCase[] rowGrid : grid) {
			Arrays.fill(rowGrid, StateCase.NO_SELECT);
		}

		return grid;
	}

	public static void displayGrid(StateCase[][] grid, int[][] bombs) {
		System.out.print("  ");
		for (int indexColumn = 0; indexColumn < grid[0].length; indexColumn++) {
			System.out.print(" ");
			System.out.printf("%2d", indexColumn);
		}
		System.out.println();

		int nbLine = 1;
		for (int indexRow = 0; indexRow < grid.length; indexRow++) {
			System.out.printf("%2d", nbLine);
			nbLine++;
			
			for (int indexColumn = 0; indexColumn < grid[0].length; indexColumn++) {
				System.out.print("|");

				switch (grid[indexRow][indexColumn]) {
				case NO_SELECT:
					System.out.printf("%2s", " ");
					break;
				case SELECT:
					if (Bumb.isBumb(bombs, indexRow, indexColumn)) {
						System.out.printf("2%s", 'B');
					} else {
						System.out.printf("2%s", Bumb.nbBumbAround(bombs, indexRow, indexColumn));
					}
					break;
				case POTENTIAL_BOMB:
					System.out.printf("2%s", "!");
				}

			}
			System.out.println("|");
		}
	}

	public void displaySolution(StateCase[][] grid, int[][] bombs) {
		System.out.println("Voici la soluation de la grille:");
		Arrays.fill(grid, StateCase.SELECT);
		displayGrid(grid, bombs);
	}

	public StateCase[][] changeState(StateCase[][] grid, int[] coord, boolean reveal) {
		if (reveal) {
			grid[coord[0]][coord[1]] = StateCase.SELECT;
		} else {
			grid[coord[0]][coord[1]] = StateCase.POTENTIAL_BOMB;
		}

		return grid;
	}
}
