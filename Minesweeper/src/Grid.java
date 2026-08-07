
/**
 * 
 */

import java.util.ArrayList;
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
			System.out.printf("%2s", indexColumn + 1);
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
						System.out.printf("%2s", "B");
					} else {
						System.out.printf("%2d", Bumb.nbBumbAround(bombs, indexRow, indexColumn));
					}
					break;
				case POTENTIAL_BOMB:
					System.out.printf("%2s", "!");
				}

			}
			System.out.println("|");
		}
	}

	public static void displaySolution(StateCase[][] grid, int[][] bombs) {
		System.out.println("Voici la soluation de la grille:");
		for (StateCase[] rowGrid : grid) {
			Arrays.fill(rowGrid, StateCase.SELECT);
		}
		displayGrid(grid, bombs);
	}

	public static StateCase[][] changeState(StateCase[][] grid, int[] coord, boolean reveal) {
		if (reveal) {
			grid[coord[0]][coord[1]] = StateCase.SELECT;
		} else {
			grid[coord[0]][coord[1]] = StateCase.POTENTIAL_BOMB;
		}

		return grid;
	}

	public static StateCase[][] reveal0Bumb(StateCase[][] grid, int[][] bumbs, int[] coord) {
		if (Bumb.nbBumbAround(bumbs, coord[0], coord[1]) != 0) {
			return Grid.changeState(grid, coord, true);
		}

		ArrayList<Integer> coordProp = new ArrayList<>();
		int[][] coordAround = new int[][] { { coord[0] - 1, coord[1] - 1 }, // 0:Up left
				{ coord[0] - 1, coord[1] }, // 1:Up
				{ coord[0] - 1, coord[1] + 1 }, // 2:Up right
				{ coord[0], coord[1] + 1 }, // 3:Right
				{ coord[0] + 1, coord[1] + 1 }, // 4:Bottom right
				{ coord[0] + 1, coord[1] }, // 5:Bottom
				{ coord[0] + 1, coord[1] - 1 }, // 6:Bottom left
				{ coord[0], coord[1] - 1 } // 7:Left
		};
		coordProp.add(0);
		coordProp.add(1);
		coordProp.add(2);
		coordProp.add(3);
		coordProp.add(4);
		coordProp.add(5);
		coordProp.add(6);
		coordProp.add(7);

		if (coord[0] == 0) {
			coordProp.remove((Integer) 0);
			coordProp.remove((Integer) 1);
			coordProp.remove((Integer) 2);
		} else if (coord[0] == grid.length - 1) {
			coordProp.remove((Integer) 4);
			coordProp.remove((Integer) 5);
			coordProp.remove((Integer) 6);
		}

		if (coord[1] == 0) {
			if (coordProp.contains(0)) {
				coordProp.remove((Integer) 0);
			}
			coordProp.remove((Integer) 7);
			if (coordProp.contains(6)) {
				coordProp.remove((Integer) 6);
			}
		} else if (coord[1] == grid[0].length - 1) {
			if (coordProp.contains(2)) {
				coordProp.remove((Integer) 2);
			}
			coordProp.remove((Integer) 3);
			if (coordProp.contains(4)) {
				coordProp.remove((Integer) 4);
			}
		}

		for (int index : coordProp) {
			int[] coordReveal = coordAround[index];
			System.out.println(coordReveal[0] + ", " + coordReveal[1]);
			
			if (grid[coordReveal[0]][coordReveal[1]] != StateCase.SELECT) {
				grid[coordReveal[0]][coordReveal[1]] = StateCase.SELECT;
				if (Bumb.nbBumbAround(bumbs, coordReveal[0], coordReveal[1]) == 0) {
					grid = Grid.reveal0Bumb(grid, bumbs, coordReveal);
				}
			}
		}

		return grid;
	}
}
